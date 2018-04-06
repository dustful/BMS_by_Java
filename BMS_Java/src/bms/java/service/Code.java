package bms.java.service;

public interface Code {
	
	public static final int MAIN_MENU = 0; // 주 메뉴
	public static final int SIGNIN = 91; // 로그인
	public static final int SIGNOUT = 92; // 로그아웃
	public static final int SIGNUP = 93; // 회원가입
	public static final int OPTOUT = 94; // 회원탈퇴

	public static final int HOST_MENU = 1; // 판매자 메뉴
	public static final int HOST_MEMBER_MENU = 11; // 회원관리 메뉴
	public static final int HOST_MEMBER_1 = 111; // 회원삭제
	public static final int HOST_MEMBER_2 = 112; // 회원상태 변경
	public static final int HOST_BOOK_MENU = 12; // 재고관리 메뉴
	public static final int HOST_BOOK_1 = 121; // 도서입고
	public static final int HOST_BOOK_2 = 122; // 도서정보편집
	public static final int HOST_BOOK_3 = 123; // 도서삭제
	public static final int HOST_ORDER_MENU = 13; // 주문관리 메뉴
	public static final int HOST_ORDER_1 = 131; // 결제확인
	public static final int HOST_ORDER_2 = 132; // 발송처리
	public static final int HOST_ORDER_3 = 133; // 환불승인
	
	public static final int GUEST_MENU = 2; // 구매자 메뉴
	public static final int GUEST_ORDER = 21; // 주문
	public static final int GUEST_ADD_CART = 22; // 장바구니에 추가
	public static final int GUEST_CART_MENU = 23; // 장바구니 보기 메뉴
	public static final int GUEST_CART_1 = 231; // 장바구니에서 제거
	public static final int GUEST_CART_2 = 232; // 장바구니 주문
	public static final int GUEST_ORDER_MENU = 24; // 주문내역확인 메뉴
	public static final int GUEST_ORDER_1 = 241; // 주문취소
	public static final int GUEST_ORDER_2 = 242; // 환불신청

}
