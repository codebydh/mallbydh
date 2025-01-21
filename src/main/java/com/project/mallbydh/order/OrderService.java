package com.project.mallbydh.order;

import com.project.mallbydh.cart.CartMapper;
import com.project.mallbydh.delivery.DeliveryMapper;
import com.project.mallbydh.delivery.DeliveryVO;
import com.project.mallbydh.payment.PaymentMapper;
import com.project.mallbydh.payment.PaymentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final CartMapper cartMapper;
    private final PaymentMapper paymentMapper;
    private final DeliveryMapper deliveryMapper;

    @Transactional
    public void orderProcess(OrderVO vo, List<Integer> prod_ids, String u_id, String paymentMethod) {
        // 1) 주문 테이블 DB에 추가
        orderMapper.insertOrder(vo);

        // 2) 주문상세 테이블 DB에 추가
        Integer ord_code = vo.getOrd_code();
        List<Map<String, Object>> orderedItems = cartMapper.getCartDetailsByProdIds(prod_ids, u_id);
        for (Map<String, Object> item : orderedItems) {
            OrderDetailVO detailVO = new OrderDetailVO();
            detailVO.setOrd_code(ord_code);
            detailVO.setProd_id((Integer) item.get("prod_id"));
            detailVO.setOrdt_amount((int) item.get("cart_amount"));
            detailVO.setOrdt_price((int) item.get("prod_price"));
            orderMapper.insertOrderDetail(detailVO);
        }

        // 3) 결제 테이블 DB에 추가
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setOrd_code(ord_code);
        paymentVO.setU_id(u_id);
        paymentVO.setPayment_method(paymentMethod);
        paymentVO.setPayment_price(vo.getOrd_price());

        if(paymentMethod.equals("무통장입금")) {
            paymentVO.setPayment_status("입금대기");
        } else {
            paymentVO.setPayment_status("결제완료");
        }

        paymentMapper.insertPayment(paymentVO);

        // 4) 결제한 상품 장바구니에서 제거
        cartMapper.deleteOrderedItems(prod_ids, u_id);

        // 5) 배송 테이블 DB에 추가
        DeliveryVO deliveryVO = new DeliveryVO();
        deliveryVO.setOrd_code(ord_code);
        deliveryVO.setDelivery_zipcode(vo.getOrd_zipcode());
        deliveryVO.setDelivery_addr(vo.getOrd_addr());
        deliveryVO.setDelivery_addr_detail(vo.getOrd_addr_detail());
        deliveryVO.setRecipient_name(vo.getOrd_name());
        deliveryVO.setRecipient_phone(vo.getOrd_phone());
        deliveryMapper.insertDelivery(deliveryVO);
    }
}
