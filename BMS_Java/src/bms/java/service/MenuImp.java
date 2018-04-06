package bms.java.service;

import bms.java.presentation.BookManagement;
import bms.java.presentation.Console;

public class MenuImp implements Menu, Code, Text {
	
	private static MenuImp menuImp;
	
	public static MenuImp getInstance() {
		if(menuImp == null) menuImp = new MenuImp();
		return menuImp;
	}
	
	public void menuController(int code) {
		switch(code) {
			case Code.MAIN_MENU:
				mainMenu();
				break;
			case Code.SIGNIN:
				BookManagement.getInstance().signIn();
				break;
			case Code.SIGNOUT:
				BookManagement.getInstance().signOut();
				break;
			case Code.SIGNUP:
				BookManagement.getInstance().signUp();
				break;
			case Code.OPTOUT:
				GuestImp.getInstance().optOut();
				break;
			case Code.HOST_MENU:
				hostMenu();
				break;
			case Code.HOST_MEMBER_MENU:
				hostMemberMenu();
				break;
			case Code.HOST_MEMBER_1:
				HostImp.getInstance().deleteMember();
				break;
			case Code.HOST_MEMBER_2:
				HostImp.getInstance().alterMemberStat();
				break;
			case Code.HOST_BOOK_MENU:
				hostBookMenu();
				break;
			case Code.HOST_BOOK_1:
				HostImp.getInstance().addBook();
				break;
			case Code.HOST_BOOK_2:
				HostImp.getInstance().editBook();
				break;
			case Code.HOST_BOOK_3 :
				HostImp.getInstance().deleteBook();
				break;
			case Code.HOST_ORDER_MENU:
				hostOrderMenu();
				break;
			case Code.HOST_ORDER_1:
				HostImp.getInstance().confirmOrder1();
				break;
			case Code.HOST_ORDER_2:
				HostImp.getInstance().confirmOrder2();
				break;
			case Code.HOST_ORDER_3:
				HostImp.getInstance().allowRefund();
				break;
			case Code.GUEST_MENU:
				guestMenu();
				break;
			case Code.GUEST_ORDER:
				GuestImp.getInstance().orderBook();
				break;
			case Code.GUEST_ADD_CART:
				GuestImp.getInstance().addCart();
				break;
			case Code.GUEST_CART_MENU:
				guestCartMenu();
				break;
			case Code.GUEST_CART_1:
				GuestImp.getInstance().deleteCart();
				break;
			case Code.GUEST_CART_2:
				GuestImp.getInstance().orderCart();
				break;
			case Code.GUEST_ORDER_MENU:
				guestOrderMenu();
				break;
			case Code.GUEST_ORDER_1:
				GuestImp.getInstance().cancelOrder();
				break;
			case Code.GUEST_ORDER_2:
				GuestImp.getInstance().requestRefund();
				break;
		}
	}

	// 주 메뉴
	@Override
	public void mainMenu() {
		System.out.println(Text.MAIN_MENU);
		
		switch(Console.input()) {
			case "1":
				// 로그인
				menuController(Code.SIGNIN);
				break;
			case "2":
				// 회원가입
				menuController(Code.SIGNUP);
				break;
			case "0":
				// 시스템종료
				System.out.println(Text.QUIT_SYSTEM);
				System.exit(0);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.MAIN_MENU);
		}
	}
	
	// 판매자 메뉴
	@Override
	public void hostMenu() {
		System.out.println(Text.HOST_MENU);
		
		switch(Console.input()) {
			case "1":
				// 회원관리 메뉴
				menuController(Code.HOST_MEMBER_MENU);
				break;
			case "2":
				// 재고관리 메뉴
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "3":
				// 주문관리 메뉴
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "0":
				// 로그아웃
				System.out.println(Text.SIGNOUT);
				menuController(Code.SIGNOUT);
				menuController(Code.MAIN_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.HOST_MENU);
		}
	}
	
	// 회원관리 메뉴
	@Override
	public void hostMemberMenu() {
		BookManagement.getInstance().viewMemberList();
		System.out.println(Text.HOST_MEMBER_MENU);
		
		switch(Console.input()) {
			case "1":
				// 회원삭제
				menuController(Code.HOST_MEMBER_1);
				menuController(Code.HOST_MEMBER_MENU);
				break;
			case "2":
				// 회원상태 변경
				menuController(Code.HOST_MEMBER_2);
				menuController(Code.HOST_MEMBER_MENU);
				break;
			case "0":
				menuController(Code.HOST_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.HOST_MEMBER_MENU);
		}
	}

	// 재고관리 메뉴
	@Override
	public void hostBookMenu() {
		BookManagement.getInstance().viewBookList();
		System.out.println(Text.HOST_BOOK_MENU);
		
		switch(Console.input()) {
			case "1":
				// 도서입고
				menuController(Code.HOST_BOOK_1);
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "2":
				// 도서정보편집
				menuController(Code.HOST_BOOK_2);
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "3":
				// 도서삭제
				menuController(Code.HOST_BOOK_3);
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "0":
				menuController(Code.HOST_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.HOST_BOOK_MENU);
		}		
	}

	// 주문관리 메뉴
	@Override
	public void hostOrderMenu() {
		BookManagement.getInstance().viewOrderList();
		System.out.println(Text.HOST_ORDER_MENU);
		
		switch(Console.input()) {
			case "1":
				// 결제확인
				menuController(Code.HOST_ORDER_1);
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "2":
				// 발송처리
				menuController(Code.HOST_ORDER_2);
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "3":
				// 환불승인
				menuController(Code.HOST_ORDER_3);
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "0":
				menuController(Code.HOST_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.HOST_ORDER_MENU);
		}		
	}
	
	// 구매자 메뉴
	@Override
	public void guestMenu() {
		BookManagement.getInstance().viewBookList();
		System.out.println(Text.GUEST_MENU);
		
		switch(Console.input()) {
			case "1":
				// 주문
				menuController(Code.GUEST_ORDER);
				menuController(Code.GUEST_MENU);
				break;
			case "2":
				// 장바구니에 추가
				menuController(Code.GUEST_ADD_CART);
				menuController(Code.GUEST_MENU);
				break;
			case "3":
				// 장바구니 보기 메뉴
				menuController(Code.GUEST_CART_MENU);
				break;
			case "4":
				// 주문내역확인 메뉴
				menuController(Code.GUEST_ORDER_MENU);
				break;
			case "5":
				// 회원탈퇴
				menuController(Code.OPTOUT);
				menuController(Code.GUEST_MENU);
				break;
			case "0":
				// 로그아웃
				System.out.println(Text.SIGNOUT);
				menuController(Code.SIGNOUT);
				menuController(Code.MAIN_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.GUEST_MENU);
		}
	}

	// 주문내역확인 메뉴
	@Override
	public void guestOrderMenu() {
		BookManagement.getInstance().viewOrderList();
		System.out.println(Text.GUEST_ORDER_MENU);
		
		switch(Console.input()) {
			case "1":
				// 주문취소
				menuController(Code.GUEST_ORDER_1);
				menuController(Code.GUEST_ORDER_MENU);
				break;
			case "2":
				// 환불요청
				menuController(Code.GUEST_ORDER_2);
				menuController(Code.GUEST_ORDER_MENU);
				break;
			case "0":
				menuController(Code.GUEST_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.GUEST_ORDER_MENU);
		}
	}
	
	// 장바구니 보기 메뉴
	@Override
	public void guestCartMenu() {
		BookManagement.getInstance().viewCartList();
		System.out.println(Text.GUEST_CART_MENU);
		
		switch(Console.input()) {
			case "1":
				// 장바구니에서 제거
				menuController(Code.GUEST_CART_1);
				menuController(Code.GUEST_CART_MENU);
				break;
			case "2":
				// 장바구니 주문
				menuController(Code.GUEST_CART_2);
				menuController(Code.GUEST_CART_MENU);
				break;
			case "0":
				menuController(Code.GUEST_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.GUEST_CART_MENU);
		}
	}

}
