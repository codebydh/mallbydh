package com.project.mallbydh.kakaopay;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Service
public class KakaopayService {

    @Value("${readUrl}")
    private String readUrl;

    @Value("${approveUrl}")
    private String approveUrl;

    @Value("${refundUrl}")
    private String refundUrl;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${cid}")
    private String cid;

    @Value("${approval}")
    private String approval;

    @Value("${cancel}")
    private String cancel;

    @Value("${fail}")
    private String fail;

    private String tid;

    private String partner_order_id;

    private String partner_user_id;

    // 1차요청(결제준비요청-ready)
    public ReadyResponse ready(String partner_order_id, String partner_user_id, String item_name,
                               Integer quantity, Integer total_amount, Integer tax_free_amount, HttpSession session)  {

        // 1)Request header
        HttpHeaders headers = getHttpHeaders();

        // 2)Request param
        ReadyRequest readyRequest = ReadyRequest.builder()
                .cid(cid)
                .partner_order_id(partner_order_id)
                .partner_user_id(partner_user_id)
                .item_name(item_name)
                .quantity(quantity)
                .total_amount(total_amount)
                .tax_free_amount(tax_free_amount)
                .approval_url(approval)
                .cancel_url(cancel)
                .fail_url(fail)
                .build();

        // data request. 결제준비요청에 보낼 헤더와파라미터를 가지고 있는 객체작업.
        HttpEntity<ReadyRequest> entityMap = new HttpEntity<>(readyRequest, headers);

        // 결제준비요청.
        ResponseEntity<ReadyResponse> response = new RestTemplate().postForEntity(
                readUrl, entityMap, ReadyResponse.class);

        // 응답데이터
        ReadyResponse readyResponse = response.getBody();

        this.tid = readyResponse.getTid();
        this.partner_order_id = partner_order_id;
        this.partner_user_id = partner_user_id;

        session.setAttribute("tid", readyResponse.getTid());
        session.setAttribute("partner_order_id", partner_order_id);
        session.setAttribute("partner_user_id", partner_user_id);

        return readyResponse;
    }

    public String getTid() {
        return tid;
    }

    // 2차요청(결제승인요청-approve)
    public String approve(String pg_token, String tid, String partner_order_id, String partner_user_id) {

        // 1)Request header
        HttpHeaders headers = getHttpHeaders();

        // 2)Request param
        ApproveRequest approveRequest = ApproveRequest.builder()
                .cid(cid)
                .tid(tid)
                .partner_order_id(partner_order_id)
                .partner_user_id(partner_user_id)
                .pg_token(pg_token)
                .build();

        // data request. 결제승인요청에 보낼 헤더와파라미터를 가지고 있는 객체작업.
        HttpEntity<ApproveRequest> entityMap = new HttpEntity<>(approveRequest, headers);

        ResponseEntity<ApproveResponse> response = new RestTemplate().postForEntity(
                approveUrl, entityMap, ApproveResponse.class);

        // 응답 검증
        if (response.getBody() == null || response.getBody().getAid() == null) {
            throw new RuntimeException("결제 승인 요청이 실패했습니다.");
        }


        return response.getBody().toString();
    }

    public KakaoCancelResponse kakaoCancel(String tid, Integer cancel_amount, Integer cancel_tax_free_amount) {
        HttpHeaders headers = getHttpHeaders();

        KakaoCancelRequest kakaoCancelRequest = KakaoCancelRequest.builder()
                .cid(cid)
                .tid(tid)
                .cancel_amount(cancel_amount)
                .cancel_tax_free_amount(cancel_tax_free_amount)
                .build();

        HttpEntity<KakaoCancelRequest> entityMap = new HttpEntity<>(kakaoCancelRequest, headers);

        ResponseEntity<KakaoCancelResponse> response = new RestTemplate().postForEntity(
                refundUrl, entityMap, KakaoCancelResponse.class
        );

        return response.getBody();
    }

//    public KakaoCancelResponse kakaoCancel(String tid, Integer cancel_amount, Integer cancel_tax_free_amount) {
//        // 카카오페이 요청
//        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
//        parameters.add("cid", cid);
//        parameters.add("tid", tid);
//        parameters.add("cancel_amount", cancel_amount.toString());
//        parameters.add("cancel_tax_free_amount", cancel_tax_free_amount.toString());
//        parameters.add("cancel_vat_amount", "0");
//
//        // 파라미터, 헤더
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHttpHeaders());
//
//        // 외부에 보낼 url
//        RestTemplate restTemplate = new RestTemplate();
//
//        KakaoCancelResponse cancelResponse = restTemplate.postForObject(
//                "https://kapi.kakao.com/v1/payment/cancel",
//                requestEntity,
//                KakaoCancelResponse.class);
//
//        return cancelResponse;
//    }

    public HttpHeaders getHttpHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY " + secretKey);
        headers.set("Content-Type", "application/json;charset=utf-8");

        return headers;
    }

}
