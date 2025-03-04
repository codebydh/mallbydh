# 🎮 mallbydh - 게임 콘솔 및 PC 용품 판매 전문 쇼핑몰
(그림)

<br>

## 프로젝트 소개
- 학습한 내용을 가장 잘 녹일 수 있는 쇼핑몰에, 제 취미 중 하나인 게임을 담아 만든 개인 프로젝트입니다.
- 개발기간 : 2024.12.02 ~ 2025.02.28

<br>

## 주요 기능 요약
### 1️⃣ 사용자 페이지
- 메인페이지는 홍보용 배너(Carousel)와 함께 신규 상품 및 임의로 지정한 상품의 목록을 확인할 수 있습니다.
- 회원 가입 시 이메일 인증 작업을 거치고 있습니다.
- 로그인 시 해당 계정의 상태에 따라 로그인을 통과시키거나, 막을 수 있습니다.
- 상단 검색바를 통해 전체 상품에 대한 검색을 수행할 수 있습니다.
- 상품은 각 카테고리 별로 조회가 가능하며, 하단의 버튼을 통해 즉시 장바구니에 담거나 찜 목록에 추가할 수 있습니다.
- 개별 상품에 대해 구매 후기 및 문의를 작성·수정·삭제할 수 있습니다.
- 현재 재고를 파악하여 상품의 구매가 자동으로 비활성화되며, 재고 이상으로 구매 시도 시 경고를 발생시킵니다.
- 결제 방식은 카카오페이 단건결제 및 무통장입금 두 가지를 지원하고 있습니다.
- 마이페이지에서 주문 히스토리 및 주문 취소와 각종 개인 정보를 수정할 수 있습니다.<br>
  또한 찜한 상품 목록, 작성했던 상품리뷰와 문의를 답변과 함께 확인할 수 있으며, 회원탈퇴 기능을 제공합니다.
### 2️⃣ 관리자 페이지
- 모든 관리 사항에 상세기능 검색을 추가하여, 원하는 항목에 대한 적절한 검색 기능을 제공합니다.
- 회원의 상태를 조회하여 직접 수정하거나, 계정을 정지하여 로그인이 되지 않게 할 수 있습니다.
- 도메인을 관리하는 운영자 계정을 추가·수정·정지할 수 있습니다.
- 상품 관리에서는 상품을 직접 추가할 수 있으며, 조회 및 수정 기능 또한 제공하고 있습니다.
- 상품마다 판매여부를 관리하여, 판매여부를 N(숨김)으로 설정할 경우 사용자 페이지에 노출되지 않습니다.
- 상품의 우선순위를 정수 1부터 8까지 지정할 수 있으며, 지정된 상품은 메인페이지 MD'S Pick에 노출됩니다.
- 사용자가 남긴 상품별 리뷰를 수정하거나 삭제할 수 있습니다.
- 사용자가 남긴 상품별 문의를 수정하거나 삭제할 수 있으며, 1개 이상의 답변을 작성할 수 있습니다.
  

<br>

## 개발환경
### 개발도구
<div>
  <img src="https://img.shields.io/badge/STS4-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> 
  <img src="https://img.shields.io/badge/dbeaver-382923?style=for-the-badge&logo=dbeaver&logoColor=white">
</div>

### Frontend
<div>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white"> 
  <img src="https://img.shields.io/badge/bootstrap5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"> 
  <img src="https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white"> 
  <img src="https://img.shields.io/badge/handlebarsdotjs-000000?style=for-the-badge&logo=handlebarsdotjs&logoColor=white"> 
</div>

### Backend
<div>
  <img src="https://img.shields.io/badge/springboot3.4.0-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> 
  <img src="https://img.shields.io/badge/openjdk17-000000?style=for-the-badge&logo=openjdk&logoColor=white"> 
  <img src="https://img.shields.io/badge/mysql8.0.17-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  <img src="https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=MyBatis&logoColor=white">
</div>

### 버전관리
<div>
  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
</div>

### 데이터처리 및 API
<div>
  <img src="https://img.shields.io/badge/kakaopay-FFCD00?style=for-the-badge&logo=kakao&logoColor=black">
  <img src="https://img.shields.io/badge/다음_주소찾기_API-FFCD00?style=for-the-badge&logo=kakao&logoColor=black">
</div>

<br>

## 프로젝트 구조
```
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┃ ┗ 📂mallbydh
 ┃ ┃ ┃ ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂category
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdCategoryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdCategoryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdCategoryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CategoryVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInquiryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInquiryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminInquiryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂manager
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ManagerController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ManagerMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ManagerService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminMemberController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminMemberMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminMemberService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderUpdateDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdProductController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdProductMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdProductService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂review
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminReviewController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminReviewMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminReviewService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂cart
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CartService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CartVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MultipartConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebMvcConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂constants
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Constants.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂interceptor
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInterceptor.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginInterceptor.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderSearchCriteria.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Criteria.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PageMaker.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SearchCriteria.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂delivery
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeliveryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeliveryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜DeliveryVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂header
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HeaderController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HeaderMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜HeaderService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AnswerVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryAnswerVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂kakaopay
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Amount.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApprovedCancelAmount.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApproveRequest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ApproveResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CancelAvailableAmount.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CanceledAmount.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CardInfo.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoCancelRequest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoCancelResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaopayController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaopayProperties.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaopayService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReadyRequest.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ReadyResponse.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginDTO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderDetailVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂payment
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PaymentController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PaymentMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PaymentService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PaymentVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂review
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ReviewVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂wish
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜WishController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜WishMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜WishService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WishVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HomeController.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜MallbydhApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂kakaopay
 ┃ ┃ ┃ ┗ 📜kakaopay.properties
 ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┗ 📜email.properties
 ┃ ┃ ┣ 📂mybatis
 ┃ ┃ ┃ ┗ 📂mapper
 ┃ ┃ ┃ ┃ ┣ 📜AdCategoryMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜AdminInquiryMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜AdminMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜AdminMemberMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜AdminOrderMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜AdminReviewMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜AdProductMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜CartMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜DeliveryMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜HeaderMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜InquiryMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜ManagerMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜MemberMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜OrderMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜PaymentMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜ProductMapper.xml
 ┃ ┃ ┃ ┃ ┣ 📜ReviewMapper.xml
 ┃ ┃ ┃ ┃ ┗ 📜WishMapper.xml
 ┃ ┃ ┣ 📂templates
 ┃ ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┃ ┣ 📂fragments
 ┃ ┃ ┃ ┃ ┃ ┣ 📜aside.html
 ┃ ┃ ┃ ┃ ┃ ┣ 📜footer.html
 ┃ ┃ ┃ ┃ ┃ ┣ 📜nav.html
 ┃ ┃ ┃ ┃ ┃ ┣ 📜plugin_1.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜plugin_2.html
 ┃ ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┃ ┣ 📜answer.html
 ┃ ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┃ ┣ 📜edit_answer.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┃ ┣ 📂layouts
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ad_layout.html
 ┃ ┃ ┃ ┃ ┣ 📂manager
 ┃ ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜member.html
 ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┣ 📜detail.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┃ ┣ 📜pro_edit.html
 ┃ ┃ ┃ ┃ ┃ ┣ 📜pro_insert.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜pro_list.html
 ┃ ┃ ┃ ┃ ┣ 📂review
 ┃ ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┃ ┣ 📜adLogin.html
 ┃ ┃ ┃ ┃ ┣ 📜adMenu.html
 ┃ ┃ ┃ ┃ ┗ 📜adMenu_backup.html
 ┃ ┃ ┃ ┣ 📂cart
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┣ 📂fragments
 ┃ ┃ ┃ ┃ ┣ 📜footer.html
 ┃ ┃ ┃ ┃ ┗ 📜header.html
 ┃ ┃ ┃ ┣ 📂layouts
 ┃ ┃ ┃ ┃ ┣ 📜layout.html
 ┃ ┃ ┃ ┃ ┗ 📜layout_no_header_footer.html
 ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┣ 📜authcode.html
 ┃ ┃ ┃ ┃ ┣ 📜idsearch.html
 ┃ ┃ ┃ ┃ ┣ 📜pwchange.html
 ┃ ┃ ┃ ┃ ┗ 📜pwtemp.html
 ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┗ 📜detail.html
 ┃ ┃ ┃ ┃ ┣ 📜delete.html
 ┃ ┃ ┃ ┃ ┣ 📜join.html
 ┃ ┃ ┃ ┃ ┣ 📜login.html
 ┃ ┃ ┃ ┃ ┣ 📜lostpass.html
 ┃ ┃ ┃ ┃ ┣ 📜modify.html
 ┃ ┃ ┃ ┃ ┣ 📜myinquiry.html
 ┃ ┃ ┃ ┃ ┣ 📜myreview.html
 ┃ ┃ ┃ ┃ ┣ 📜order.html
 ┃ ┃ ┃ ┃ ┣ 📜pwchange.html
 ┃ ┃ ┃ ┃ ┗ 📜wishlist.html
 ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┣ 📜order_form.html
 ┃ ┃ ┃ ┃ ┗ 📜order_result.html
 ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┣ 📜detail.html
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┗ 📜index.html
 ┃ ┃ ┣ 📜application.properties
 ┃ ┃ ┣ 📜log4jdbc.log4j2.properties
 ┃ ┃ ┗ 📜logback-spring.xml
```

## ERD
(그림)

## 주요 기능
