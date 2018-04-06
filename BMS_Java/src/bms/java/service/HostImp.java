package bms.java.service;

import java.util.Map;

import bms.java.domain.Book;
import bms.java.domain.Member;
import bms.java.domain.Order;
import bms.java.presentation.BookManagement;
import bms.java.presentation.Console;

public class HostImp implements Host {
	
	private Map<String, Member> mi = BookManagement.memberInfo;
	private Map<Integer, Book> bi = BookManagement.bookInfo;
	private Map<Integer, Order> oi = BookManagement.orderInfo;
	
	private MenuImp menuImp = MenuImp.getInstance();
	
	private static HostImp hostImp;
	public static HostImp getInstance() {
		if(hostImp == null) hostImp = new HostImp();
		return hostImp;
	}
	
	// ȸ������
	@Override
	public void deleteMember() {
		System.out.println(Text.DELETE_MEMEBERID);
		String mid = Console.input();
		
		if(mi.containsKey(mid)) {
			if(mi.get(mid).getGrade() == 1) {
				System.out.println(Text.DELETE_MEMBER_ERR);
			} else {
				mi.remove(mid);
				System.out.println(Text.COMPLETE_DELETE_MEMBER);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_MEMBERID);
		}
	}
	
	// ȸ������ ����
	@Override
	public void alterMemberStat() {
		System.out.println(Text.ALTER_MEMBERID);
		String mid = Console.input();
		
		if(mi.containsKey(mid)) {
			if(mi.get(mid).getGrade() == 1) {
				System.out.println(Text.ALTER_MEMBER_ERR);
			} else {
				System.out.println(Text.EDIT_STATINFO);
				System.out.println(Text.HOST_MEMBER_EDIT_MENU);
				
				switch(Console.input()) {
					case "1":
						// ����
						mi.get(mid).setMstat(1);
						break;
					case "2":
						// Ż��
						mi.get(mid).setMstat(2);
						break;
					case "0":
						// ���
						menuImp.menuController(Code.HOST_MEMBER_MENU);
						break;
					default:
						System.out.println(Text.INVALID_INPUT);
						menuImp.menuController(Code.HOST_MEMBER_MENU);
				}
				
				mi.put(mid, (Member) mi.get(mid));
				System.out.println(Text.COMPLETE_ALTER_MEMBERSTAT);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_MEMBERID);
		}
	}
	
	// �����԰�
	@Override
	public void addBook() {
		System.out.println(Text.BOOK_NAME);
		String bname = Console.input();
		
		System.out.println(Text.BOOK_AUTHOR);
		String author = Console.input();
		
		System.out.println(Text.BOOK_PUBLISHER);
		String publisher = Console.input();
		
		System.out.println(Text.BOOK_PRICE);
		int bprice = Integer.parseInt(Console.input());
		
		System.out.println(Text.BOOK_QTY);
		int bqty = Integer.parseInt(Console.input());
		
		System.out.println(Text.BOOK_DISCOUNT);
		float discount = Float.parseFloat(Console.input());
		
		System.out.println(Text.BOOK_MILEAGE);
		float mileage = Float.parseFloat(Console.input());
		
		bi.put(Console.getRandNo(), new Book(Console.getRandNo(), bname, author, publisher, bprice, bqty, discount, mileage));
		System.out.println(Text.COMPLETE_ADD_BOOK);
	}

	// ������������
	@Override
	public void editBook() {
		System.out.println(Text.EDIT_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			System.out.println(Text.EDIT_BOOKINFO);
			System.out.println(Text.HOST_BOOK_EDIT_MENU);
			
			switch(Console.input()) {
				case "1":
					System.out.println(Text.BOOK_NAME + "(���������� : " + bi.get(bno).getBname() + ")");
					String bname = Console.input();
					bi.get(bno).setBname(bname);
					break;
				case "2":
					System.out.println(Text.BOOK_AUTHOR + "(�������� : " + bi.get(bno).getAuthor() + ")");
					String author = Console.input();
					bi.get(bno).setAuthor(author);
					break;
				case "3":
					System.out.println(Text.BOOK_PUBLISHER + "(�������ǻ� : " + bi.get(bno).getPublisher() + ")");
					String publisher = Console.input();
					bi.get(bno).setPublisher(publisher);
					break;
				case "4":
					System.out.printf(Text.BOOK_PRICE + "(�������� : %,d)\n", bi.get(bno).getBprice());
					int bprice = Integer.parseInt(Console.input());
					bi.get(bno).setBprice(bprice);
					break;
				case "5":
					System.out.printf(Text.BOOK_QTY + "(���������� : %,d)\n", bi.get(bno).getBqty());
					int bqty = Integer.parseInt(Console.input());
					bi.get(bno).setBqty(bqty	);
					break;
				case "6":
					System.out.printf(Text.BOOK_DISCOUNT + "(���������� : %3.2f)\n", bi.get(bno).getDiscount());
					float discount = Float.parseFloat(Console.input());
					bi.get(bno).setDiscount(discount);
					break;
				case "7":
					System.out.printf(Text.BOOK_MILEAGE + "(���������� : %3.2f)\n", bi.get(bno).getMileage());
					float mileage = Float.parseFloat(Console.input());
					bi.get(bno).setMileage(mileage);
					break;
				case "0":
					menuImp.menuController(Code.HOST_BOOK_2);
					break;
				default:
					System.out.println(Text.INVALID_INPUT);
					menuImp.menuController(Code.HOST_BOOK_2);
			}
			
			bi.put(bno, (Book) bi.get(bno));
			System.out.println(bno + "�� ������ �������������� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}

	// ��������
	@Override
	public void deleteBook() {
		System.out.println(Text.DELETE_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			bi.remove(bno);
			System.out.println(bno + "�� ������ �����Ǿ����ϴ�.");
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// ����Ȯ��
	@Override
	public void confirmOrder1() {
		System.out.println(Text.CONFIRM_ORDERNO_1);
		int ono = Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// �ֹ����°� �ֹ��Ϸ��� ���
			if(oi.get(ono).getOstat() == 0) {
				// ����Ȯ�� ��������
				oi.get(ono).setOstat(1);
				oi.put(ono, (Order) oi.get(ono));
				System.out.println(ono + "�� �ֹ��� ����Ȯ�εǾ����ϴ�.");
			} else {
				System.out.println(Text.ORDER_STAT_3);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}
	
	// �߼�ó��
	@Override
	public void confirmOrder2() {
		System.out.println(Text.CONFIRM_ORDERNO_2);
		int ono = Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// �ֹ����°� ����Ȯ�ε� ���
			if(oi.get(ono).getOstat() == 1) {
				// 1.�߼�ó�� ��������
				oi.get(ono).setOstat(3);
				oi.put(ono, (Order) oi.get(ono));
				// 2.�ش� ȸ���� ������ �ݿ�
				mi.get(oi.get(ono).getMid()).setMmileage(
					(int) (mi.get(oi.get(ono).getMid()).getMmileage() + (
							(bi.get(oi.get(ono).getBno()).getBprice() * bi.get(oi.get(ono).getBno()).getMileage()) * oi.get(ono).getOqty()
						)
					)
				);
				mi.put(oi.get(ono).getMid(), (Member) mi.get(oi.get(ono).getMid()));
				System.out.println(ono + "�� �ֹ��� �߼�ó���Ǿ����ϴ�.");
			} else {
				System.out.println(Text.ORDER_STAT_4);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}
	
	// ȯ�ҽ���
	@Override
	public void allowRefund() {
		System.out.println(Text.ALLOW_REFUNDNO);
		int ono = Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// �ֹ����°� ȯ�ҿ�û�� ���
			if(oi.get(ono).getOstat() == 4) {
				// ȯ�ҽ��� ��������
				oi.get(ono).setOstat(5);
				oi.put(ono, (Order) oi.get(ono));
				// 1.�������� ȯ�ҿ�û������ŭ ����
				bi.get(oi.get(ono).getBno()).setBqty(bi.get(oi.get(ono).getBno()).getBqty() + oi.get(ono).getOqty());
				// 2.�������� �ݿ�
				bi.put(oi.get(ono).getBno(), (Book) bi.get(oi.get(ono).getBno()));
				// 3.�ش� ȸ���� ������ �ݿ�
				mi.get(oi.get(ono).getMid()).setMmileage(
					(int) (mi.get(oi.get(ono).getMid()).getMmileage() - (
							(bi.get(oi.get(ono).getBno()).getBprice() * bi.get(oi.get(ono).getBno()).getMileage()) * oi.get(ono).getOqty()
						)
					)
				);
				mi.put(oi.get(ono).getMid(), (Member) mi.get(oi.get(ono).getMid()));
				System.out.println(ono + "�� �ֹ��� ȯ�ҽ��εǾ����ϴ�.");
			} else {
				System.out.println(Text.ORDER_STAT_5);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}
	
}
