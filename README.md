# 🎮 mallbydh - 게임 콘솔 및 PC 용품 판매 전문 쇼핑몰
![Image](https://github.com/user-attachments/assets/c43dc3da-c576-4779-9e8d-8be628439e6f)

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
- 상품은 각 카테고리 별로 조회가 가능하며, 버튼을 통해 즉시 장바구니에 담거나 찜 목록에 추가할 수 있습니다.
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
  <img src="https://img.shields.io/badge/eclipse-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white"> 
  <img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"> 
  <img src="https://img.shields.io/badge/dbeaver-382923?style=for-the-badge&logo=dbeaver&logoColor=white">
</div>

### Frontend
<div>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jQuery&logoColor=white"> 
  <img src="https://img.shields.io/badge/bootstrap5-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white"> <br>
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
<details>
  <summary>프로젝트 구조 열기</summary>
  
  ```
📦main
 ┣ 📂java
 ┃ ┗ 📂com
 ┃ ┃ ┗ 📂project
 ┃ ┃ ┃ ┗ 📂mallbydh
 ┃ ┃ ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┃ ┃ ┣ 📂category
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdCategoryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdCategoryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdCategoryService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜CategoryVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInquiryController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInquiryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminInquiryService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂manager
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminVO.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ManagerController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ManagerMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ManagerService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminMemberController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminMemberMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminMemberService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderUpdateDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdProductController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdProductMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdProductService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂review
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminReviewController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminReviewMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminReviewService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminMapper.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜AdminService.java
 ┃ ┃ ┃ ┃ ┣ 📂cart
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CartController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CartMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CartService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜CartVO.java
 ┃ ┃ ┃ ┃ ┣ 📂common
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MultipartConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SecurityConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebMvcConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂constants
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Constants.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂interceptor
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminInterceptor.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginInterceptor.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂utils
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AdminOrderSearchCriteria.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Criteria.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FileUtils.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PageMaker.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜SearchCriteria.java
 ┃ ┃ ┃ ┃ ┣ 📂delivery
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DeliveryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜DeliveryService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜DeliveryVO.java
 ┃ ┃ ┃ ┃ ┣ 📂header
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HeaderController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜HeaderMapper.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜HeaderService.java
 ┃ ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┃ ┣ 📜AnswerVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryAnswerVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜InquiryMapper.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜InquiryService.java
 ┃ ┃ ┃ ┃ ┣ 📂kakaopay
 ┃ ┃ ┃ ┃ ┃ ┣ 📜Amount.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ApprovedCancelAmount.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ApproveRequest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ApproveResponse.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CancelAvailableAmount.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CanceledAmount.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜CardInfo.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoCancelRequest.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaoCancelResponse.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaopayController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaopayProperties.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜KakaopayService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ReadyRequest.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ReadyResponse.java
 ┃ ┃ ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜EmailDTO.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜EmailService.java
 ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┣ 📜LoginDTO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberVO.java
 ┃ ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderDetailVO.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜OrderService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜OrderVO.java
 ┃ ┃ ┃ ┃ ┣ 📂payment
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PaymentController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PaymentMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜PaymentService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜PaymentVO.java
 ┃ ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ProductMapper.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductService.java
 ┃ ┃ ┃ ┃ ┣ 📂review
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜ReviewService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜ReviewVO.java
 ┃ ┃ ┃ ┃ ┣ 📂wish
 ┃ ┃ ┃ ┃ ┃ ┣ 📜WishController.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜WishMapper.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📜WishService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜WishVO.java
 ┃ ┃ ┃ ┃ ┣ 📜HomeController.java
 ┃ ┃ ┃ ┃ ┗ 📜MallbydhApplication.java
 ┗ 📂resources
 ┃ ┣ 📂kakaopay
 ┃ ┃ ┗ 📜kakaopay.properties
 ┃ ┣ 📂mail
 ┃ ┃ ┗ 📜email.properties
 ┃ ┣ 📂mybatis
 ┃ ┃ ┗ 📂mapper
 ┃ ┃ ┃ ┣ 📜AdCategoryMapper.xml
 ┃ ┃ ┃ ┣ 📜AdminInquiryMapper.xml
 ┃ ┃ ┃ ┣ 📜AdminMapper.xml
 ┃ ┃ ┃ ┣ 📜AdminMemberMapper.xml
 ┃ ┃ ┃ ┣ 📜AdminOrderMapper.xml
 ┃ ┃ ┃ ┣ 📜AdminReviewMapper.xml
 ┃ ┃ ┃ ┣ 📜AdProductMapper.xml
 ┃ ┃ ┃ ┣ 📜CartMapper.xml
 ┃ ┃ ┃ ┣ 📜DeliveryMapper.xml
 ┃ ┃ ┃ ┣ 📜HeaderMapper.xml
 ┃ ┃ ┃ ┣ 📜InquiryMapper.xml
 ┃ ┃ ┃ ┣ 📜ManagerMapper.xml
 ┃ ┃ ┃ ┣ 📜MemberMapper.xml
 ┃ ┃ ┃ ┣ 📜OrderMapper.xml
 ┃ ┃ ┃ ┣ 📜PaymentMapper.xml
 ┃ ┃ ┃ ┣ 📜ProductMapper.xml
 ┃ ┃ ┃ ┣ 📜ReviewMapper.xml
 ┃ ┃ ┃ ┗ 📜WishMapper.xml
 ┃ ┣ 📂templates
 ┃ ┃ ┣ 📂admin
 ┃ ┃ ┃ ┣ 📂fragments
 ┃ ┃ ┃ ┃ ┣ 📜aside.html
 ┃ ┃ ┃ ┃ ┣ 📜footer.html
 ┃ ┃ ┃ ┃ ┣ 📜nav.html
 ┃ ┃ ┃ ┃ ┣ 📜plugin_1.html
 ┃ ┃ ┃ ┃ ┗ 📜plugin_2.html
 ┃ ┃ ┃ ┣ 📂inquiry
 ┃ ┃ ┃ ┃ ┣ 📜answer.html
 ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┣ 📜edit_answer.html
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┣ 📂layouts
 ┃ ┃ ┃ ┃ ┗ 📜ad_layout.html
 ┃ ┃ ┃ ┣ 📂manager
 ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┗ 📜member.html
 ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┣ 📜detail.html
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┃ ┣ 📜pro_edit.html
 ┃ ┃ ┃ ┃ ┣ 📜pro_insert.html
 ┃ ┃ ┃ ┃ ┗ 📜pro_list.html
 ┃ ┃ ┃ ┣ 📂review
 ┃ ┃ ┃ ┃ ┣ 📜edit.html
 ┃ ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┃ ┣ 📜adLogin.html
 ┃ ┃ ┃ ┣ 📜adMenu.html
 ┃ ┃ ┃ ┗ 📜adMenu_backup.html
 ┃ ┃ ┣ 📂cart
 ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┣ 📂fragments
 ┃ ┃ ┃ ┣ 📜footer.html
 ┃ ┃ ┃ ┗ 📜header.html
 ┃ ┃ ┣ 📂layouts
 ┃ ┃ ┃ ┣ 📜layout.html
 ┃ ┃ ┃ ┗ 📜layout_no_header_footer.html
 ┃ ┃ ┣ 📂mail
 ┃ ┃ ┃ ┣ 📜authcode.html
 ┃ ┃ ┃ ┣ 📜idsearch.html
 ┃ ┃ ┃ ┣ 📜pwchange.html
 ┃ ┃ ┃ ┗ 📜pwtemp.html
 ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┃ ┗ 📜detail.html
 ┃ ┃ ┃ ┣ 📜delete.html
 ┃ ┃ ┃ ┣ 📜join.html
 ┃ ┃ ┃ ┣ 📜login.html
 ┃ ┃ ┃ ┣ 📜lostpass.html
 ┃ ┃ ┃ ┣ 📜modify.html
 ┃ ┃ ┃ ┣ 📜myinquiry.html
 ┃ ┃ ┃ ┣ 📜myreview.html
 ┃ ┃ ┃ ┣ 📜order.html
 ┃ ┃ ┃ ┣ 📜pwchange.html
 ┃ ┃ ┃ ┗ 📜wishlist.html
 ┃ ┃ ┣ 📂order
 ┃ ┃ ┃ ┣ 📜order_form.html
 ┃ ┃ ┃ ┗ 📜order_result.html
 ┃ ┃ ┣ 📂product
 ┃ ┃ ┃ ┣ 📜detail.html
 ┃ ┃ ┃ ┗ 📜list.html
 ┃ ┃ ┗ 📜index.html
 ┃ ┣ 📜application.properties
 ┃ ┣ 📜log4jdbc.log4j2.properties
 ┃ ┗ 📜logback-spring.xml
```
</details>

<br>

## ERD
![Image](https://github.com/user-attachments/assets/314c4861-22b0-454b-967f-5c24461a9417)

<br>

## 페이지별 기능 소개
### 1️⃣ 사용자 페이지 - 메인 & 상품 & 주문
#### 메인페이지
- 상단 Navigation bar를 통해 다양한 기능을 제공합니다.
  - 좌측 로고를 통해 홈으로 이동하거나, 각 카테고리별 상품리스트에 접근 가능
  - 검색을 통한 전체 상품 검색 가능 (상품명 또는 제조사)
  - 로그인 여부에 따른 회원 메뉴 노출 : 비로그인 시(Login, Join) // 로그인 시(Mypage, Cart, Logout)
  
- 메인 배너 하단에 두 종류의 상품 진열이 노출됩니다. (Owl Carousel 사용)
  - New Items : 최근 등록된 상품 순서로 최대 8개의 상품 진열
  - MD's Pick! : 관리자가 '상품 우선순위'에 따라 진열되며, 동순위 중 최근 등록된 상품이 먼저 진열

#### 상품리스트
- 쿼리스트링에 따라 상품이 리스팅 됩니다. (1차카테고리 또는 2차카테고리, 없을 경우 전체)
- 카테고리 또는 검색 결과가 없을 경우 리스팅 대신 적절한 문구가 표시됩니다.
- 상품 하단에 장바구니, 찜하기 버튼을 통해 새로고침 없이 아래의 액션이 취해집니다.
  - 장바구니 버튼 : 클릭 시 장바구니에 추가, 재클릭 시 장바구니 수량 +1 
  - 찜하기 버튼
      1) 클릭 시 찜하기 목록에 추가되며 빨간색 하트로 변함
      2) 이미 찜한 상품이라면 리스트에도 빨간색 하트로 표시
      3) 재클릭 시 찜하기 목록에서 삭제되며 색 없는 하트로 변경

#### 상품상세페이지 - 상단
- 버튼을 통해 구매 수량이 조절되며, 구매 수량에 따른 구매 금액이 자동 계산됩니다.
- '구매하기' 버튼을 통해 구매가 가능하며, 경우에 따라 아래의 액션이 취해집니다.
  - 재고가 없을 경우 문구와 함께 버튼 disabled 처리
  - 재고가 충분할 경우 주문 페이지로 이동. 장바구니에 같은 상품이 있을 경우 합산 구매여부를 확인
  - 재고 이상을 구매할 경우 alert를 띄운 후 수량 조절 (장바구니에 이미 포함된 개수 합산)

#### 상품상세페이지 - 리뷰 및 문의
- 리뷰 또는 문의가 1개라도 있을 경우와 아닐 경우 다른 화면을 표시합니다.
- 리뷰 또는 문의 작성 시 모달 창을 띄워 양식에 맞게 등록할 수 있습니다.
- 작성된 리뷰 또는 문의는 최신순으로 정렬되며, 페이지네이션이 적용됩니다.
- 문의의 경우 관리자의 답변 여부를 확인할 수 있습니다.
  - 답변이 없을 경우 '답변이 아직 등록되지 않았습니다.' 노출
  - 답변이 1개 이상 등록될 시 모두 확인 가능

#### 주문페이지
- 주문페이지로 접근하는 방법은 세 가지가 있으며, 각각에 맞는 구조를 설계하였습니다.
  - 상세페이지에서 주문하는 경우(type=direct)
  - 장바구니에서 특정 상품을 선택하여 주문하는 경우(type=selected)
  - 장바구니의 상품 전체를 주문하는 경우(type=all)
- 주문 시 필요한 정보는 기본적으로 session에서 가져오며, 필요 시 수정이 가능합니다.
- 결제 방식은 카카오페이, 무통장입금 두 방식을 지원하며, <br>
  카카오페이의 경우 [카카오페이 단건결제 API](https://developers.kakaopay.com/docs/payment/online/single-payment)를 도입하였습니다.
- 주문이 완료되면 다음의 절차가 모두 수행됩니다 (Transactional)
  - 주문DB에 정보 저장, 이를 토대로 주문상세·결제·배송DB 에도 정보 저장
  - 주문된 상품의 DB에서 주문 수량만큼 재고 차감 및 누적판매량 증가
  - 주문된 상품을 장바구니에서 제거

<br>

### 2️⃣ 사용자 페이지 - 멤버서비스
#### 로그인페이지
- 입력한 아이디 및 비밀번호로 로그인을 진행하며, 서버의 응답에 따른 절차를 수행합니다.
  - 아이디 또는 비밀번호를 틀린 경우 : "아이디를 확인하세요." 또는 "비밀번호를 확인하세요."
  - 관리자가 해당 계정을 정지한 경우 : "계정이 정지되었습니다. 관리자에게 문의하세요."
  - 사용자가 직접 계정을 탈퇴한 경우 : "탈퇴한 계정입니다. 로그인할 수 없습니다."

 #### 회원가입페이지
 - 회원 테이블 DB에 필요한 정보를 form으로 작성하도록 제공합니다.
   - 서버 조회를 통한 ID 중복 체크 실시
   - 이메일 인증을 수행하며, 사용자가 입력한 이메일로 인증코드를 보내 검증
   - 주소는 [DAUM 주소 API](https://postcode.map.daum.net/guide)의 <iframe을 이용한 레이어 띄우기> 방식 채용
   - 비밀번호는 Spring Security의 암호화를 적용

#### 아이디/비밀번호 찾기
- 아이디 찾기 : 이름, 이메일이 일치하는 아이디를 메일로 전송합니다.
- 임시 비밀번호 발급 : 아이디, 이름, 이메일이 일치하는 계정의 비밀번호를 변경하여 메일로 전송하며, <br>
  변경된 비밀번호를 DB에 저장할 시 Spring Security의 암호화를 적용합니다.

#### 장바구니
- 샤용자가 등록한 장바구니 리스트를 보여줍니다.
- 특정 상품을 선택하여 장바구니에서 제거하거나, 전체 목록을 제거하는 기능을 제공합니다.
- 수량 조절용 스핀 박스를 통해 제품의 수량을 새로고침 없이 수정할 수 있으며, 0 이하의 숫자 입력을 방지합니다.
- 장바구니 내 특정 상품 또는 전체 상품을 주문할 수 있으며, 주문 페이지로 이동하기 전 제품의 재고를 <br>
  체크하여 구매가 불가능한 물품이 1개라도 있을 경우 경고창을 띄웁니다.

#### 마이페이지 - 주문조회
- 해당 사용자가 주문한 주문내역을 조회할 수 있습니다.
  - 주문이름 : 1종의 제품 구매 시 '제품명', n종의 제품 구매 시 '주문의 첫 제품명 외 (n-1)개' 로 표시
  - 주문사진 : 1종의 제품 구매 시 해당 제품의 사진, n종의 제품 구매 시 주문 첫 제품의 사진 표시
- 버튼을 통해 특정 기간의 주문을 검색하거나, 직접 기간을 선택하여 조회할 수도 있습니다.
- 제품 상세 조회 시 주문 취소를 할 수 있으며, 이미 취소된 주문의 경우 disabled 된 버튼이 노출됩니다.

#### 마이페이지 - 정보 수정 및 비밀번호 변경
- 사용자의 정보를 수정할 수 있으며, 수정 시 최근 수정일이 업데이트 됩니다.
- 비밀번호의 경우 수정을 진행할 경우 Spring Security의 암호화를 적용해 DB에 저장되며, <br>
  사용자의 메일로 암호화 전 수정한 비밀번호를 전송합니다.

#### 마이페이지 - 찜한상품
- 사용자가 찜한 상품의 리스트를 조회할 수 있습니다.
- 상품의 이름을 눌러 상품 페이지로 이동하거나, 우측 버튼을 통해 찜 목록에서 삭제할 수 있습니다.

#### 마이페이지 - 나의 상품리뷰
- 사용자가 작성한 상품 리뷰를 카드의 형태로 표시합니다.
- 우측 수정 버튼 클릭 시 팝업되는 모달 창을 통해 내용을 수정할 수 있습니다.
- 우측 삭제 버튼을 통해 리뷰를 삭제(DELETE) 할 수 있습니다.

#### 마이페이지 - 나의 상품문의
- 사용자가 작성한 상품 문의 리스트를 확인할 수 있습니다.
- 좌측 뱃지를 통해 해당 문의의 답변 여부를 확인할 수 있습니다. (답변이 1개라도 등록될 경우 '답변완료' 뱃지)
- 제목을 클릭하면 상품문의의 내용, 답변의 내용을 확인할 수 있습니다.
- 우측 수정 버튼 클릭 시 팝업되는 모달 창을 통해 문의 내용을 수정할 수 있습니다. <br>
  단, 답변이 등록되었을 경우 사용자가 직접 수정할 수 없습니다.
- 우측 삭제 버튼을 통해 등록된 문의를 삭제(DELETE) 할 수 있습니다.

#### 마이페이지 - 회원탈퇴
- 간단한 안내문구를 확인한 뒤, 현재 비밀번호를 입력하면 사용자가 직접 회원탈퇴를 진행할 수 있습니다.
- 회원탈퇴가 진행되면, 회원 DB에서 계정상태가 '사용자정지'로 변경(UPDATE) 됩니다.

<br>

### 3️⃣ 관리자 페이지
#### 회원관리 페이지
- 등록된 회원의 정보를 조회할 수 있으며, 회원 정보를 기반으로 한 상세 검색을 지원합니다.
- 개별 회원의 정보를 조회하여 수정할 수 있습니다.
  - 관리자가 직접 수정할 때에는 이메일 인증을 필요로 하지 않음
  - 비밀번호 변경 시 Spring Security의 암호화를 적용
  - 계정상태를 변경할 수 있으며, '정지'로 변경할 경우 해당 회원의 로그인이 제한됨
- 회원 정보에서 해당 회원의 최근 로그인 시각, 정보 수정일, 누적 구매 금액을 조회할 수 있습니다.

#### 운영자관리 페이지
- 관리자 페이지에 접근 가능한 계정을 조회하거나, 직접 생성할 수 있습니다.
- 관리자 계정 생성에는 많은 정보를 필요로 하지 않기에, 모달 창을 통해 간단히 생성하도록 하였습니다.

#### 상품관리 - 상품조회 및 등록
- 등록된 모든 상품을 최신순으로 조회할 수 있으며, 개별 상품의 정보를 조회 후 수정할 수 있습니다.
- 개별 상품의 수정은 아래와 같은 기능을 지원합니다.
  - 판매여부를 '숨김'으로 지정할 경우, 관리자의 상품조회에는 표시되나 사용자페이지에서는 노출되지 않음
  - 우선순위를 안내사항에 따라 지정할 경우 사용자 메인 페이지의 MD'S Pick!의 정책에 따라 노출
  - 수량 및 누적판매량은 회원의 활동에 따라 자동으로 UPDATE 되지만, 수동으로 지정 가능
  - [CKEditor 텍스트 에디터](https://ckeditor.com/)를 통한 상품 상세 설명 수정 가능
- 상품의 삭제는 리스트에서 체크박스를 통해 삭제하거나, 우측 버튼을 통해 개별적으로 삭제할 수 있습니다.
- 신규 등록 시에는 상품등록 페이지를 통해 상품을 등록할 수 있습니다. (CKEditor 적용)

#### 주문관리
- 주문에 포함된 다양한 정보를 통해 검색할 수 있는 상세검색을 지원합니다.
  - 상세검색 버튼 클릭 시 검색 form이 노출, 주문일·주문상태·결제수단·수령인/주문자정보로 검색 지원
- 개별 주문에 대한 주문 상세 내역을 조회하거나, 수정할 수 있습니다.
- 배송과 관련된 정보(택배사, 송장번호 등)를 해당 페이지에서 입력 후 DB에 저장할 수 있습니다.
  
