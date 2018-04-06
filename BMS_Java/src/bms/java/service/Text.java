package bms.java.service;

public interface Text {
	
	/*메뉴구성*/
	public static final String MAIN_MENU = "1.로그인 2.회원가입 0.시스템종료";
	public static final String HOST_MENU = "1.회원관리 2.재고관리 3.주문관리 0.로그아웃";
	public static final String HOST_MEMBER_MENU = "1.회원삭제 2.회원상태변경 0.상위메뉴";
	public static final String HOST_MEMBER_EDIT_MENU = "1.정상 2.탈퇴 0.취소";
	public static final String HOST_BOOK_MENU = "1.도서입고 2.도서정보편집 3.도서삭제 0.상위메뉴";
	public static final String HOST_BOOK_EDIT_MENU = "1.도서명 2.저자 3.출판사 4.가격 5.재고수량 6.할인율 7.적립율 0.취소";
	public static final String HOST_ORDER_MENU = "1.결제확인 2.발송처리 3.환불승인 0.상위메뉴";
	public static final String GUEST_MENU = "1.주문 2.장바구니에추가 3.장바구니보기 4.주문내역확인 5.회원탈퇴 0.로그아웃";
	public static final String GUEST_ORDER_MENU = "1.주문취소 2.환불신청 0.상위메뉴";
	public static final String GUEST_CART_MENU = "1.장바구니에서제거 2.장바구니주문 0.상위메뉴";
	
	/*상황별출력메시지*/
	public static final String START_SYSTEM = "도서 관리 시스템을 시작합니다.";
	public static final String INVALID_INPUT = "잘못된 입력입니다.";
	
	// 로그인
	public static final String INPUT_ID = "ID를 입력하세요.";
	public static final String INPUT_PW = "비밀번호를 입력하세요.";
	public static final String INVALID_SIGN = "일치하는 ID가 없거나 비밀번호가 없습니다.";
	public static final String SUCCEED_SIGN = "님 환영합니다.";
	
	// 로그아웃
	public static final String SIGNOUT = "접속을 종료합니다.";
	
	// 회원가입
	public static final String INPUT_REG_ID = "가입할 ID를 입력하세요.";
	public static final String INPUT_REG_PW = "비밀번호를 입력하세요.";
	public static final String INPUT_MNAME = "회원명을 입력하세요.";
	public static final String SIGNUP_ERR_1 = "ID는 4자 이상 입력해야 합니다.";
	public static final String SIGNUP_ERR_2 = "이미 존재하는 ID입니다.";
	public static final String COMPLETE_SIGNUP = "회원가입이 완료되었습니다.";
	
	public static final String THERE_IS_NO_MEMBER = "가입된 회원이 없습니다.";
	public static final String THERE_IS_NO_MEMBERID = "해당하는 회원ID가 존재하지 않습니다.";
	public static final String THERE_IS_NO_BOOK = "입고된 도서가 없습니다.";
	public static final String THERE_IS_NO_BOOKNO = "해당하는 도서가 존재하지 않습니다.";
	public static final String THERE_IS_NO_ORDER = "주문된 내역이 없습니다.";
	public static final String THERE_IS_NO_ORDERNO = "해당하는 주문번호가 존재하지 않습니다.";
	public static final String THERE_IS_NO_CART = "장바구니에 상품이 없습니다.";
	public static final String QUIT_SYSTEM = "시스템을 종료합니다.";
	
	// 회원삭제
	public static final String DELETE_MEMEBERID = "삭제할 회원ID를 입력하세요.";
	public static final String DELETE_MEMBER_ERR = "판매자는 삭제할 수 없습니다.";
	public static final String COMPLETE_DELETE_MEMBER = "입력한 ID의 회원정보가 삭제되었습니다.";
	
	// 회원상태 변경
	public static final String ALTER_MEMBERID = "변경할 회원ID를 입력하세요.";
	public static final String ALTER_MEMBER_ERR = "판매자는 변경할 수 없습니다.";
	public static final String EDIT_STATINFO = "변경할 상태값을 입력하세요.";
	public static final String COMPLETE_ALTER_MEMBERSTAT = "입력한 ID의 회원정보가 변경되었습니다.";
	
	// 회원탈퇴
	public static final String OPTOUT_MEMBER = "개인정보보호를 위해 비밀번호를 입력하세요.";
	public static final String OPTOUT_MEMBER_ERR = "비밀번호가 일치하지 않습니다.";
	public static final String COMPLETE_OPTOUT_MEMBER = "탈퇴되었습니다. 그동안 이용해 주셔서 감사합니다.";
	
	// 도서입고, 도서정보편집 항목
	public static final String BOOK_NAME = "도서명을 입력하세요.";
	public static final String BOOK_AUTHOR = "저자를 입력하세요.";
	public static final String BOOK_PUBLISHER = "출판사를 입력하세요.";
	public static final String BOOK_PRICE = "가격을 입력하세요.";
	public static final String BOOK_QTY = "재고수량을 입력하세요.";
	public static final String BOOK_DISCOUNT = "할인율을 입력하세요.";
	public static final String BOOK_MILEAGE = "적립율을 입력하세요.";
	
	// 도서입고
	public static final String COMPLETE_ADD_BOOK = "도서입고가 완료되었습니다.";
	
	// 도서정보편집
	public static final String EDIT_BOOKNO = "편집할 도서번호를 입력하세요.";
	public static final String EDIT_BOOKINFO = "편집할 도서정보를 선택하세요.";
	
	// 도서삭제
	public static final String DELETE_BOOKNO = "삭제할 도서번호를 입력하세요.";
	
	// 주문
	public static final String ORDER_BOOKNO = "주문할 도서번호를 입력하세요.";
	public static final String ORDER_BOOKQTY = "주문수량을 입력하세요.";
	public static final String ORDER_INVALID_QTY = "주문수량이 재고수량보다 많습니다.";
	public static final String CONFIRM_ORDER_MILEAGE = "적립금 사용하려면 차감할 적립금액을 입력하세요. 사용하지 않을 경우, 0을 입력하세요.";
	public static final String ORDER_INVALID_MILEAGE = "입력된 금액이 현재 적립금보다 많습니다.";
	public static final String COMPLETE_ORDER = "주문이 완료되었습니다.";
	
	// 주문취소
	public static final String CANCEL_ORDER_BOOKNO = "취소할 주문번호를 입력하세요.";
	public static final String ORDER_STAT_1 = "해당 주문건은 이미 취소되었거나 발송되어 취소가 불가하므로 환불요청을 진행해주시기 바랍니다.";
	public static final String COMPLETE_CANCEL_ORDER = "주문이 최소되었습니다.";
	
	// 환불요청
	public static final String REQUEST_REFUNDNO = "환불요청할 주문번호를 입력하세요.";
	public static final String ORDER_STAT_2 = "해당 주문건은 환불요청이 불가합니다.";
	public static final String COMPLETE_REQUEST_REFUND = "환불요청을 완료했으며 승인을 위해 대기중입니다.";
	
	// 결제확인
	public static final String CONFIRM_ORDERNO_1 = "결제확인할 주문번호를 입력하세요.";
	public static final String ORDER_STAT_3 = "해당 주문건은 결제가 완료되지 않았거나 이미 결제확인한 주문입니다.";
	
	// 발송처리
	public static final String CONFIRM_ORDERNO_2 = "발송처리할 주문번호를 입력하세요.";
	public static final String ORDER_STAT_4 = "해당 주문건은 결제확인되지 않았거나 이미 발송처리한 주문입니다.";
	
	// 환불승인
	public static final String ALLOW_REFUNDNO = "환불승인할 주문번호를 입력하세요.";
	public static final String ORDER_STAT_5 = "해당 주문건은 환불요청된 주문이 아닙니다.";
	
	// 장바구니에 추가
	public static final String ADD_CART_BOOKNO = "장바구니에 추가할 도서번호를 입력하세요.";
	public static final String ADD_CART_CQTY = "장바구니에 추가할 도서의 수량을 입력하세요.";
	public static final String CART_INVALID_QTY = "장바구니에 추가하려는 수량이 재고수량보다 많습니다.";
	public static final String COMPLETE_ADD_CART = "선택한 도서를 장바구니에 추가했습니다.";
	
	// 장바구니에서 제거
	public static final String DELETE_CART_BOOKNO = "장바구니에서 제거할 도서번호를 입력하세요.";
	public static final String COMPLETE_DELETE_CART = "선택한 도서를 장바구니에서 제거했습니다.";
	
}
