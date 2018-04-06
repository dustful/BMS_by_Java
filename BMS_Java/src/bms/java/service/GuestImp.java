package bms.java.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import bms.java.domain.Book;
import bms.java.domain.Cart;
import bms.java.domain.Member;
import bms.java.domain.Order;
import bms.java.presentation.BookManagement;
import bms.java.presentation.Console;

public class GuestImp implements Guest {
	
	public Map<String, Member> mi = BookManagement.memberInfo;
	public Map<Integer, Book> bi = BookManagement.bookInfo;
	public Map<Integer, Order> oi = BookManagement.orderInfo;
	public List<Cart> ci = BookManagement.cartInfo;
	
	public MenuImp menuImp = MenuImp.getInstance();
	
	private static GuestImp guestImp;
	public static GuestImp getInstance() {
		if(guestImp == null) guestImp = new GuestImp();
		return guestImp;
	}
	
	// ȸ��Ż��
	@Override
	public void optOut() {
		System.out.println(Text.OPTOUT_MEMBER);
		String userPW = Console.input();
		
		if(mi.get(BookManagement.getInstance().getCurrID()).getMpw().equals(userPW)) {
			// mi.remove(BookManagement.getInstance().getCurrID());
			mi.get(BookManagement.getInstance().getCurrID()).setMstat(2);
			mi.put(BookManagement.getInstance().getCurrID(), (Member) mi.get(BookManagement.getInstance().getCurrID()));
			System.out.println(Text.COMPLETE_OPTOUT_MEMBER);
			menuImp.mainMenu();
		} else {
			System.out.println(Text.OPTOUT_MEMBER_ERR);
		}
	}

	// �ֹ�
	@Override
	public void orderBook() {
		System.out.println(Text.ORDER_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			System.out.println(Text.ORDER_BOOKQTY);
			int oqty = Integer.parseInt(Console.input());
			
			// ������ �� �ֹ����� ��
			if(bi.get(bno).getBqty() < oqty) {
				System.out.println(Text.ORDER_INVALID_QTY);
			} else {
				// ������ ���� ���� Ȯ��
				int mmileage = mi.get(BookManagement.getInstance().getCurrID()).getMmileage();
				int omileage = 0;
				
				if(mmileage > 0) {
					do {
						System.out.println(Text.CONFIRM_ORDER_MILEAGE);
						System.out.printf("(���� ������ : %,d)\n", mmileage);
						omileage = Integer.parseInt(Console.input());
						
						if(omileage <= mmileage) {
							mi.get(BookManagement.getInstance().getCurrID()).setMmileage(mmileage - omileage);
							mi.put(BookManagement.getInstance().getCurrID(), (Member) mi.get(BookManagement.getInstance().getCurrID()));
						} else {
							System.out.println(Text.ORDER_INVALID_MILEAGE);
						}
					} while(omileage > mmileage);
				}
				
				// 1.�ֹ����� ����
				oi.put(Console.getRandNo(), new Order(Console.getRandNo(), BookManagement.getInstance().getCurrID(), bno, oqty, 0, new Date(), omileage));
				// 2.���������� �ֹ�������ŭ ����
				bi.get(bno).setBqty(bi.get(bno).getBqty() - oqty);
				// 3.�������� �ݿ�
				bi.put(bno, (Book) bi.get(bno));
				System.out.println(Text.COMPLETE_ORDER);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// ��ٱ��Ͽ� �߰�
	@Override
	public void addCart() {
		System.out.println(Text.ADD_CART_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			System.out.println(Text.ADD_CART_CQTY);
			int cqty = Integer.parseInt(Console.input());

			// ������ �� ��ٱ����߰����� ��
			if(bi.get(bno).getBqty() < cqty) {
				System.out.println(Text.CART_INVALID_QTY);
			} else {
				for(int i = 0, size = ci.size(); i < size; i++) {
					if(ci.get(i).getBno() == bno) {
						// ������ �� ��ٱ��Ͽ� �̹� �߰��� ������ ���� ������ �߰� ������ �� ��
						if(ci.get(i).getCqty() + cqty <= bi.get(bno).getBqty()) {
							// ��ٱ��Ͽ� �̹� �߰��� ������ ��� ���� ������ �߰�
							ci.get(i).setCqty(ci.get(i).getCqty() + cqty);
							// ci.add(i, (Cart) ci.get(i));
							// ci.set(i, ci.get(i).getCqty() + cqty);
							System.out.println(Text.COMPLETE_ADD_CART);
							return;
						} else {
							System.out.println(Text.CART_INVALID_QTY);
						}
					} else {
						// ��ٱ��Ͽ� �߰��� �� ���� ������ ��� ���� �߰�
						ci.add(new Cart(bno, BookManagement.getInstance().getCurrID(), cqty));
						System.out.println(Text.COMPLETE_ADD_CART);
					}
				}
				
				if(ci.size() == 0) {
					// size�� 0�� ���
					ci.add(new Cart(bno, BookManagement.getInstance().getCurrID(), cqty));
					System.out.println(Text.COMPLETE_ADD_CART);
				}
			}
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// ��ٱ��Ͽ��� ����
	@Override
	public void deleteCart() {
		System.out.println(Text.DELETE_CART_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		for(int i = 0, size = ci.size(); i < size; i++) {
			if(ci.get(i).getBno() == bno) {
				ci.remove(i);
				System.out.println(Text.COMPLETE_DELETE_CART);
				return;
			}
			// System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// ��ٱ��� �ֹ�
	@Override
	public void orderCart() {
		// ��ٱ����׸�ŭ �ݺ�
		for(int i = 0; i < ci.size(); i++) {
			// ������ �� �ֹ����� ��
			if(bi.get(ci.get(i).getBno()).getBqty() < ci.get(i).getCqty()) {
				System.out.println(Text.ORDER_INVALID_QTY);
				return;
			} else {
				// ������ ���� ���� Ȯ��
				int mmileage = mi.get(BookManagement.getInstance().getCurrID()).getMmileage();
				int omileage = 0;
				
				if(mmileage > 0) {
					do {
						System.out.println(Text.CONFIRM_ORDER_MILEAGE);
						System.out.printf("(���� ������ : %,d)\n", mmileage);
						omileage = Integer.parseInt(Console.input());
						
						if(omileage <= mmileage) {
							mi.get(BookManagement.getInstance().getCurrID()).setMmileage(mmileage - omileage);
							mi.put(BookManagement.getInstance().getCurrID(), (Member) mi.get(BookManagement.getInstance().getCurrID()));
						} else {
							System.out.println(Text.ORDER_INVALID_MILEAGE);
						}
					} while(omileage > mmileage);
				}
				
				// 1.�ֹ����� ����
				oi.put(Console.getRandNo(), new Order(Console.getRandNo(), BookManagement.getInstance().getCurrID(), ci.get(i).getBno(), ci.get(i).getCqty(), 0, new Date(), omileage));
				// 2.���������� �ֹ�������ŭ ����
				bi.get(ci.get(i).getBno()).setBqty(bi.get(ci.get(i).getBno()).getBqty() - ci.get(i).getCqty());
				// 3.�������� �ݿ�
				bi.put(ci.get(i).getBno(), (Book) bi.get(ci.get(i).getBno()));
			}
		}
		
		// 4.�ֹ��Ϸ�� �׸��� ��ٱ��Ͽ��� ����
		ci.clear();
		
		if(ci.isEmpty()) System.out.println(Text.COMPLETE_ORDER);
	}

	// �ֹ����
	@Override
	public void cancelOrder() {
		System.out.println(Text.CANCEL_ORDER_BOOKNO);
		int ono= Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// �ֹ����°� �ֹ��Ϸ�Ǿ��ų� ����Ȯ�ε� ���
			if(oi.get(ono).getOstat() < 2) {
				// 1.�ֹ���� ��������
				oi.get(ono).setOstat(2);
				oi.put(ono, (Order) oi.get(ono));
				// 2.�������� �ֹ���Ҽ�����ŭ ����
				bi.get(oi.get(ono).getBno()).setBqty(bi.get(oi.get(ono).getBno()).getBqty() + oi.get(ono).getOqty());
				// 3.�������� �ݿ�
				bi.put(oi.get(ono).getBno(), (Book) bi.get(oi.get(ono).getBno()));
				// 4.������ �ݿ�
				mi.get(oi.get(ono).getMid()).setMmileage(mi.get(oi.get(ono).getMid()).getMmileage() + oi.get(ono).getOmileage());
				mi.put(oi.get(ono).getMid(), (Member) mi.get(oi.get(ono).getMid()));
				System.out.println(Text.COMPLETE_CANCEL_ORDER);
			} else {
				System.out.println(Text.ORDER_STAT_1);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}

	// ȯ�ҿ�û
	@Override
	public void requestRefund() {
		System.out.println(Text.REQUEST_REFUNDNO);
		int ono= Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// �ֹ����°� �߼�ó���� ���
			if(oi.get(ono).getOstat() == 3) {
				// ȯ�ҿ�û ��������
				oi.get(ono).setOstat(4);
				oi.put(ono, (Order) oi.get(ono));
				System.out.println(Text.COMPLETE_REQUEST_REFUND);
			} else {
				System.out.println(Text.ORDER_STAT_2);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}		
	}
	
}
