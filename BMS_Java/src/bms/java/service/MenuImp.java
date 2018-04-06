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

	// �� �޴�
	@Override
	public void mainMenu() {
		System.out.println(Text.MAIN_MENU);
		
		switch(Console.input()) {
			case "1":
				// �α���
				menuController(Code.SIGNIN);
				break;
			case "2":
				// ȸ������
				menuController(Code.SIGNUP);
				break;
			case "0":
				// �ý�������
				System.out.println(Text.QUIT_SYSTEM);
				System.exit(0);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.MAIN_MENU);
		}
	}
	
	// �Ǹ��� �޴�
	@Override
	public void hostMenu() {
		System.out.println(Text.HOST_MENU);
		
		switch(Console.input()) {
			case "1":
				// ȸ������ �޴�
				menuController(Code.HOST_MEMBER_MENU);
				break;
			case "2":
				// ������ �޴�
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "3":
				// �ֹ����� �޴�
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "0":
				// �α׾ƿ�
				System.out.println(Text.SIGNOUT);
				menuController(Code.SIGNOUT);
				menuController(Code.MAIN_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.HOST_MENU);
		}
	}
	
	// ȸ������ �޴�
	@Override
	public void hostMemberMenu() {
		BookManagement.getInstance().viewMemberList();
		System.out.println(Text.HOST_MEMBER_MENU);
		
		switch(Console.input()) {
			case "1":
				// ȸ������
				menuController(Code.HOST_MEMBER_1);
				menuController(Code.HOST_MEMBER_MENU);
				break;
			case "2":
				// ȸ������ ����
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

	// ������ �޴�
	@Override
	public void hostBookMenu() {
		BookManagement.getInstance().viewBookList();
		System.out.println(Text.HOST_BOOK_MENU);
		
		switch(Console.input()) {
			case "1":
				// �����԰�
				menuController(Code.HOST_BOOK_1);
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "2":
				// ������������
				menuController(Code.HOST_BOOK_2);
				menuController(Code.HOST_BOOK_MENU);
				break;
			case "3":
				// ��������
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

	// �ֹ����� �޴�
	@Override
	public void hostOrderMenu() {
		BookManagement.getInstance().viewOrderList();
		System.out.println(Text.HOST_ORDER_MENU);
		
		switch(Console.input()) {
			case "1":
				// ����Ȯ��
				menuController(Code.HOST_ORDER_1);
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "2":
				// �߼�ó��
				menuController(Code.HOST_ORDER_2);
				menuController(Code.HOST_ORDER_MENU);
				break;
			case "3":
				// ȯ�ҽ���
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
	
	// ������ �޴�
	@Override
	public void guestMenu() {
		BookManagement.getInstance().viewBookList();
		System.out.println(Text.GUEST_MENU);
		
		switch(Console.input()) {
			case "1":
				// �ֹ�
				menuController(Code.GUEST_ORDER);
				menuController(Code.GUEST_MENU);
				break;
			case "2":
				// ��ٱ��Ͽ� �߰�
				menuController(Code.GUEST_ADD_CART);
				menuController(Code.GUEST_MENU);
				break;
			case "3":
				// ��ٱ��� ���� �޴�
				menuController(Code.GUEST_CART_MENU);
				break;
			case "4":
				// �ֹ�����Ȯ�� �޴�
				menuController(Code.GUEST_ORDER_MENU);
				break;
			case "5":
				// ȸ��Ż��
				menuController(Code.OPTOUT);
				menuController(Code.GUEST_MENU);
				break;
			case "0":
				// �α׾ƿ�
				System.out.println(Text.SIGNOUT);
				menuController(Code.SIGNOUT);
				menuController(Code.MAIN_MENU);
				break;
			default:
				System.out.println(Text.INVALID_INPUT);
				menuController(Code.GUEST_MENU);
		}
	}

	// �ֹ�����Ȯ�� �޴�
	@Override
	public void guestOrderMenu() {
		BookManagement.getInstance().viewOrderList();
		System.out.println(Text.GUEST_ORDER_MENU);
		
		switch(Console.input()) {
			case "1":
				// �ֹ����
				menuController(Code.GUEST_ORDER_1);
				menuController(Code.GUEST_ORDER_MENU);
				break;
			case "2":
				// ȯ�ҿ�û
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
	
	// ��ٱ��� ���� �޴�
	@Override
	public void guestCartMenu() {
		BookManagement.getInstance().viewCartList();
		System.out.println(Text.GUEST_CART_MENU);
		
		switch(Console.input()) {
			case "1":
				// ��ٱ��Ͽ��� ����
				menuController(Code.GUEST_CART_1);
				menuController(Code.GUEST_CART_MENU);
				break;
			case "2":
				// ��ٱ��� �ֹ�
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
