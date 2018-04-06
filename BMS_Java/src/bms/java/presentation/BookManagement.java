package bms.java.presentation;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bms.java.domain.Book;
import bms.java.domain.Cart;
import bms.java.domain.Member;
import bms.java.domain.Order;
import bms.java.service.Code;
import bms.java.service.MenuImp;
import bms.java.service.Text;

public class BookManagement {
	
	public static Map<String, Member> memberInfo = new HashMap<String, Member>(); // ȸ������
	public static Map<Integer, Book> bookInfo = new HashMap<Integer, Book>(); // ��������
	public static Map<Integer, Order> orderInfo = new HashMap<Integer, Order>(); // �ֹ�����
	// public static Map<Integer, Cart> cartInfo = new HashMap<Integer, Cart>(); // ��ٱ�������
	public static List<Cart> cartInfo = new ArrayList<Cart>(); // ��ٱ�������
	
	private static BookManagement system;
	
	public static BookManagement getInstance() {
		if(system == null) system = new BookManagement();
		return system;
	}
	
	private String currID; // ���� ������ ȸ��ID
	private int currGrade; // ���� ������ ȸ�����

	// ���� ������ ȸ�������� ���� ������
	public String getCurrID() { return currID; }
	public int getCurrGrade() { return currGrade; }
	
	// ���� ������ ȸ�������� ���� ������
	public void setCurrID(String currID) { this.currID = currID; }
	public void setCurrGrade(int currGrade) { this.currGrade = currGrade; }
	
	// �ý��� ����
	public void openSystem() {
		System.out.println(Text.START_SYSTEM);
		
		memberInfo.put("host", new Member("host", "1234", "������", 1, 1, new Date(), 0)); // �Ǹ���

		// ����� ���� ������
		memberInfo.put("guest", new Member("guest", "1234", "��", 2, 1, new Date(), 50000)); // ������
		bookInfo.put(1111, new Book(1111, "test1", "tt1", "ttt1", 12000, 100, 0.1f, 0.05f)); // ��������1
		bookInfo.put(2222, new Book(2222, "test2", "tt2", "ttt2", 25000, 80, 0.1f, 0.05f)); // ��������2
		bookInfo.put(3333, new Book(3333, "test3", "tt3", "ttt3", 33000, 50, 0.1f, 0.05f)); // ��������3
		// cartInfo.add((Cart) new Cart(1111, "guest", 16)); // ��ٱ�������1
		// cartInfo.add((Cart) new Cart(2222, "guest", 24)); // ��ٱ�������2
		
		MenuImp.getInstance().menuController(Code.MAIN_MENU);
	}
	
	// �α���
	public void signIn() {
		System.out.println(Text.INPUT_ID);
		String userID = Console.input();
		System.out.println(Text.INPUT_PW);
		String userPW = Console.input();
		
		// ȸ�������� ���� ���� ó��
		// Ż���� ȸ���� �ƴϸ鼭, ȸ��ID�� �����ϰ� ȸ����й�ȣ�� ��ġ�� ��츸 ���� ����
		if(memberInfo.get(userID).getMstat() == 2 || !memberInfo.containsKey(userID) || !userPW.equals(memberInfo.get(userID).getMpw())) {
			System.out.println(Text.INVALID_SIGN);
			MenuImp.getInstance().menuController(Code.MAIN_MENU);
		} else {
			System.out.println(memberInfo.get(userID).getMname() + Text.SUCCEED_SIGN);
			setCurrID(userID);
			setCurrGrade(memberInfo.get(userID).getGrade());

			if(memberInfo.get(userID).getGrade() == 1) {
				MenuImp.getInstance().menuController(Code.HOST_MENU);
			} else {
				MenuImp.getInstance().menuController(Code.GUEST_MENU);
			}
		}
	}
	
	// ȸ������
	public void signUp() {
		System.out.println(Text.INPUT_REG_ID);
		String userID = Console.input();
		
		// ȸ��ID�� ���̿� ���� ��ȿ�� �˻�(4�� �̻��� ��츸 ��� ����)
		if(userID.length() < 4) {
			System.out.println(Text.SIGNUP_ERR_1);
		} else if(memberInfo.containsKey(userID)) {
			System.out.println(Text.SIGNUP_ERR_2);
		} else {
			System.out.println(Text.INPUT_REG_PW);
			String userPW = Console.input();
			System.out.println(Text.INPUT_MNAME);
			String mname = Console.input();
			memberInfo.put(userID, new Member(userID, userPW, mname, 2, 1, new Date(), 0));
			System.out.println(Text.COMPLETE_SIGNUP);
		}
		
		MenuImp.getInstance().menuController(Code.MAIN_MENU);
	}
	
	// �α׾ƿ�
	public void signOut() {
		setCurrID(null);
		setCurrGrade(0);
	}
	
	// ȸ�����
	public void viewMemberList() {
		int i = 0;
		String mstat = null;
		
		if(!memberInfo.isEmpty()) {
			for(HashMap.Entry<String, Member> m : memberInfo.entrySet()) {
				++i;
				System.out.print("[ȸ��ID : " + m.getKey() + "]");
				System.out.print("[ȸ���� : " + m.getValue().getMname() + "]");
				System.out.printf("[������ : %,d]", m.getValue().getMmileage());
				
				switch(m.getValue().getMstat()) {
				case 1:
					mstat = "����";
					break;
				case 2:
					mstat = "Ż��";
					break;
			}
				
				System.out.print("[���� : " + mstat + "]");
				System.out.println("[�������� : " + m.getValue().getMregdate() + "]");
			}
			
			System.out.println(i + "���� ȸ���� ��ϵǾ��ֽ��ϴ�.");
		} else {
			System.out.println(Text.THERE_IS_NO_MEMBER);
		}
	}
	
	// �����
	public void viewBookList() {
		int i = 0;
		
		if(!bookInfo.isEmpty()) {
			for(HashMap.Entry<Integer, Book> b : bookInfo.entrySet()) {
				++i;
				System.out.print("[������ȣ : " + b.getKey() + "]");
				System.out.print("[������ : " + b.getValue().getBname() + "]");
				System.out.print("[���� : " + b.getValue().getAuthor() + "]");
				System.out.print("[���ǻ� : " + b.getValue().getPublisher() + "]");
				System.out.printf("[���� : %,d]", b.getValue().getBprice());
				System.out.printf("[������ : %,d]", b.getValue().getBqty());
				System.out.printf("[������ : %3.2f]", b.getValue().getDiscount());
				System.out.printf("[������ : %3.2f]\n", b.getValue().getMileage());
			}
			
			System.out.println(i + "���� ������ �԰�Ǿ��ֽ��ϴ�.");
		} else {
			System.out.println(Text.THERE_IS_NO_BOOK);
		}
	}
	
	// �ֹ����
	public void viewOrderList() {
		int i = 0;
		String ostat = null;
		int oprice = 0;
		int sum = 0;
		
		if(!orderInfo.isEmpty()) {
			for(HashMap.Entry<Integer, Order> o : orderInfo.entrySet()) {
				if(o.getValue().getMid().equals(getCurrID()) || getCurrGrade() == 1) {
					++i;
					System.out.print("[�ֹ���ȣ : " + o.getKey() + "]");
					System.out.print("[������ȣ : " + o.getValue().getBno() + "]");
					System.out.print("[������ : " + bookInfo.get(o.getValue().getBno()).getBname() + "]");
					System.out.printf("[���� : %,d]", bookInfo.get(o.getValue().getBno()).getBprice());
					System.out.printf("[������ : %3.2f]", bookInfo.get(o.getValue().getBno()).getDiscount());
					System.out.printf("[������ : %3.2f]", bookInfo.get(o.getValue().getBno()).getMileage());
					System.out.printf("[�ֹ����� : %,d]", o.getValue().getOqty());
					oprice = (int) (bookInfo.get(o.getValue().getBno()).getBprice() - (bookInfo.get(o.getValue().getBno()).getBprice() * bookInfo.get(o.getValue().getBno()).getDiscount())) * o.getValue().getOqty();
					System.out.printf("[�ֹ��ݾ� : %,d]", oprice);
					System.out.print("[�ֹ���ID : " + o.getValue().getMid() + "]");
					System.out.print("[�ֹ����� : " + o.getValue().getOregdate() + "]");
					
					switch(o.getValue().getOstat()) {
						case 0:
							ostat = "�ֹ��Ϸ�";
							break;
						case 1:
							ostat = "����Ȯ�οϷ�";
							break;
						case 2:
							ostat = "��ҵ� �ֹ�";
							break;
						case 3:
							ostat = "�߼ۿϷ�";
							break;
						case 4:
							ostat = "ȯ�Ҵ��";
							break;
						case 5:
							ostat = "ȯ�ҿϷ�";
							break;
					}
					
					System.out.println("[�ֹ����� : " + ostat + "]");
					
					if(o.getValue().getOstat() == 1 || o.getValue().getOstat() == 3 || o.getValue().getOstat() == 4) {
						// ���� �ǸŴ��� = ���� * �ֹ�����
						// sum += (bookInfo.get(o.getValue().getBno()).getBprice() * o.getValue().getOqty());
						// ������ ����� �ǸŴ��� = (���� - (���� * ������)) * ����
						// sum += (bookInfo.get(o.getValue().getBno()).getBprice() - (bookInfo.get(o.getValue().getBno()).getBprice() * bookInfo.get(o.getValue().getBno()).getDiscount())) * o.getValue().getOqty();
						sum += oprice;
					}
				}
			}
			
			System.out.println(i + "���� �ֹ��� �ֽ��ϴ�.");
			
			if(getCurrGrade() == 1) {
				System.out.printf("�ǸŴ��� : %,d\n", sum);
			} else {
				System.out.printf("���� ������ : %,d\n", memberInfo.get(getCurrID()).getMmileage());
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDER);
		}
	}
	
	// ��ٱ��ϸ��
	public void viewCartList() {
		int i = 0;
		int sum = 0;
		
		if(!cartInfo.isEmpty()) {
			for(Cart c : cartInfo) {
				if(c.getMid().equals(getCurrID()) || getCurrGrade() == 1) {
					++i;
					// System.out.print("[��ǰ���� : " + i + "]");
					System.out.print("[������ȣ : " + c.getBno() + "]");
					System.out.print("[������ : " + bookInfo.get(c.getBno()).getBname() + "]");
					System.out.printf("[���� : %,d]", bookInfo.get(c.getBno()).getBprice());
					System.out.printf("[������ : %3.2f]", bookInfo.get(c.getBno()).getDiscount());
					System.out.printf("[������ : %3.2f]", bookInfo.get(c.getBno()).getMileage());
					System.out.printf("[�ֹ� ���� ���� : %,d]\n", c.getCqty());
					// ���� �ֹ� ���� �Ѿ� += ���� * ����
					// sum += bookInfo.get(c.getBno()).getBprice() * c.getCqty();
					// ������ ����� �ֹ� ���� �Ѿ� += (���� - (���� * ������)) * ����
					sum += (bookInfo.get(c.getBno()).getBprice() - (bookInfo.get(c.getBno()).getBprice() * bookInfo.get(c.getBno()).getDiscount())) * c.getCqty();
				}
			}
			
			System.out.println(i + "���� ������ ��ٱ��Ͽ� �ֽ��ϴ�.");
			System.out.printf("�ֹ� ���� �Ѿ� : %,d\n", sum);
		} else {
			System.out.println(Text.THERE_IS_NO_CART);
		}
	}

}
