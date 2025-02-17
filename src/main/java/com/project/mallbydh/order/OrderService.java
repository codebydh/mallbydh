package com.project.mallbydh.order;

import com.project.mallbydh.cart.CartMapper;
import com.project.mallbydh.common.utils.SearchCriteria;
import com.project.mallbydh.delivery.DeliveryMapper;
import com.project.mallbydh.delivery.DeliveryVO;
import com.project.mallbydh.payment.PaymentMapper;
import com.project.mallbydh.payment.PaymentVO;
import com.project.mallbydh.product.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderMapper orderMapper;
    private final CartMapper cartMapper;
    private final PaymentMapper paymentMapper;
    private final DeliveryMapper deliveryMapper;

    public String generateOrderName(List<Map<String, Object>> orderedItems) {
        List<String> prod_names = new ArrayList<>();
        for (Map<String, Object> item : orderedItems) {
            String prod_name = (String) item.get("prod_name");
            prod_names.add(prod_name);
        }

        if(prod_names.size() == 1) {
            return prod_names.get(0);
        } else {
            return prod_names.get(0) + " 외 " + (prod_names.size() - 1) + "개";
        }
    }

    @Transactional
    public void orderProcess(OrderVO vo, List<Integer> prod_ids, String u_id, String paymentMethod, String deposit_name, String account_info) {
        // 1) 주문 테이블 DB에 추가
        List<Map<String, Object>> orderedItems = cartMapper.getCartDetailsByProdIds(prod_ids, u_id);
        String ord_name = generateOrderName(orderedItems);
        vo.setOrd_name(ord_name);
        if(paymentMethod.equals("무통장입금")) {
            vo.setOrd_status("입금대기");
        } else {
            vo.setOrd_status("결제완료");
        }
        orderMapper.insertOrder(vo);

        // 2) 주문상세 테이블 DB에 추가
        Integer ord_code = vo.getOrd_code();
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
            paymentVO.setDeposit_name(deposit_name);
            paymentVO.setAccount_info(account_info);
        } else {
            paymentVO.setPayment_status("결제완료");
        }

        paymentMapper.insertPayment(paymentVO);

        // 4) 결제한 상품 장바구니에서 제거
        cartMapper.deleteOrderedItems(prod_ids, u_id);

        // 5) 배송 테이블 DB에 추가
        DeliveryVO deliveryVO = new DeliveryVO();
        deliveryVO.setOrd_code(ord_code);
        deliveryVO.setDelivery_zipcode(vo.getDelivery_zipcode());
        deliveryVO.setDelivery_addr(vo.getDelivery_addr());
        deliveryVO.setDelivery_addr_detail(vo.getDelivery_addr_detail());
        deliveryVO.setDelivery_message(vo.getDelivery_message());
        deliveryVO.setRecipient_name(vo.getRecipient_name());
        deliveryVO.setRecipient_phone(vo.getRecipient_phone());
        deliveryMapper.insertDelivery(deliveryVO);
    }

    public Integer getOrderByOrderCode(Integer ord_code) {
        return orderMapper.getOrderByOrdCode(ord_code);
    }

    // 사용자 마이페이지 - 주문내역 조회
    public List<OrderVO> getOrdersByUserId(String u_id, SearchCriteria cri) {
        return orderMapper.getOrdersByUserId(u_id, cri);
    }

    public int getOrderCountByUserId(String u_id, SearchCriteria cri) {
        return orderMapper.getOrderCountByUserId(u_id, cri);
    }

    public List<Map<String, Object>> getOrderDetailInfo(Integer ord_code) {
        return orderMapper.getOrderDetailInfo(ord_code);
    }

    public void cancelOrder(Integer ord_code) {
        orderMapper.cancelOrder(ord_code);
    }

    public Integer userTotalAmount(String u_id) throws Exception {
        return orderMapper.userTotalAmount(u_id);
    }
}
