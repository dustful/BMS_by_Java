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
	
	// 회원탈퇴
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

	// 주문
	@Override
	public void orderBook() {
		System.out.println(Text.ORDER_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			System.out.println(Text.ORDER_BOOKQTY);
			int oqty = Integer.parseInt(Console.input());
			
			// 재고수량 대 주문수량 비교
			if(bi.get(bno).getBqty() < oqty) {
				System.out.println(Text.ORDER_INVALID_QTY);
			} else {
				// 적립금 차감 여부 확인
				int mmileage = mi.get(BookManagement.getInstance().getCurrID()).getMmileage();
				int omileage = 0;
				
				if(mmileage > 0) {
					do {
						System.out.println(Text.CONFIRM_ORDER_MILEAGE);
						System.out.printf("(보유 적립금 : %,d)\n", mmileage);
						omileage = Integer.parseInt(Console.input());
						
						if(omileage <= mmileage) {
							mi.get(BookManagement.getInstance().getCurrID()).setMmileage(mmileage - omileage);
							mi.put(BookManagement.getInstance().getCurrID(), (Member) mi.get(BookManagement.getInstance().getCurrID()));
						} else {
							System.out.println(Text.ORDER_INVALID_MILEAGE);
						}
					} while(omileage > mmileage);
				}
				
				// 1.주문정보 생성
				oi.put(Console.getRandNo(), new Order(Console.getRandNo(), BookManagement.getInstance().getCurrID(), bno, oqty, 0, new Date(), omileage));
				// 2.재고수량에서 주문수량만큼 감산
				bi.get(bno).setBqty(bi.get(bno).getBqty() - oqty);
				// 3.감산결과를 반영
				bi.put(bno, (Book) bi.get(bno));
				System.out.println(Text.COMPLETE_ORDER);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// 장바구니에 추가
	@Override
	public void addCart() {
		System.out.println(Text.ADD_CART_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			System.out.println(Text.ADD_CART_CQTY);
			int cqty = Integer.parseInt(Console.input());

			// 재고수량 대 장바구니추가수량 비교
			if(bi.get(bno).getBqty() < cqty) {
				System.out.println(Text.CART_INVALID_QTY);
			} else {
				for(int i = 0, size = ci.size(); i < size; i++) {
					if(ci.get(i).getBno() == bno) {
						// 재고수량 대 장바구니에 이미 추가된 도서의 기존 수량과 추가 수량의 합 비교
						if(ci.get(i).getCqty() + cqty <= bi.get(bno).getBqty()) {
							// 장바구니에 이미 추가한 도서인 경우 기존 수량에 추가
							ci.get(i).setCqty(ci.get(i).getCqty() + cqty);
							// ci.add(i, (Cart) ci.get(i));
							// ci.set(i, ci.get(i).getCqty() + cqty);
							System.out.println(Text.COMPLETE_ADD_CART);
							return;
						} else {
							System.out.println(Text.CART_INVALID_QTY);
						}
					} else {
						// 장바구니에 추가된 적 없는 도서인 경우 새로 추가
						ci.add(new Cart(bno, BookManagement.getInstance().getCurrID(), cqty));
						System.out.println(Text.COMPLETE_ADD_CART);
					}
				}
				
				if(ci.size() == 0) {
					// size가 0인 경우
					ci.add(new Cart(bno, BookManagement.getInstance().getCurrID(), cqty));
					System.out.println(Text.COMPLETE_ADD_CART);
				}
			}
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// 장바구니에서 제거
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
	
	// 장바구니 주문
	@Override
	public void orderCart() {
		// 장바구니항목만큼 반복
		for(int i = 0; i < ci.size(); i++) {
			// 재고수량 대 주문수량 비교
			if(bi.get(ci.get(i).getBno()).getBqty() < ci.get(i).getCqty()) {
				System.out.println(Text.ORDER_INVALID_QTY);
				return;
			} else {
				// 적립금 차감 여부 확인
				int mmileage = mi.get(BookManagement.getInstance().getCurrID()).getMmileage();
				int omileage = 0;
				
				if(mmileage > 0) {
					do {
						System.out.println(Text.CONFIRM_ORDER_MILEAGE);
						System.out.printf("(보유 적립금 : %,d)\n", mmileage);
						omileage = Integer.parseInt(Console.input());
						
						if(omileage <= mmileage) {
							mi.get(BookManagement.getInstance().getCurrID()).setMmileage(mmileage - omileage);
							mi.put(BookManagement.getInstance().getCurrID(), (Member) mi.get(BookManagement.getInstance().getCurrID()));
						} else {
							System.out.println(Text.ORDER_INVALID_MILEAGE);
						}
					} while(omileage > mmileage);
				}
				
				// 1.주문정보 생성
				oi.put(Console.getRandNo(), new Order(Console.getRandNo(), BookManagement.getInstance().getCurrID(), ci.get(i).getBno(), ci.get(i).getCqty(), 0, new Date(), omileage));
				// 2.재고수량에서 주문수량만큼 감산
				bi.get(ci.get(i).getBno()).setBqty(bi.get(ci.get(i).getBno()).getBqty() - ci.get(i).getCqty());
				// 3.감산결과를 반영
				bi.put(ci.get(i).getBno(), (Book) bi.get(ci.get(i).getBno()));
			}
		}
		
		// 4.주문완료된 항목을 장바구니에서 제거
		ci.clear();
		
		if(ci.isEmpty()) System.out.println(Text.COMPLETE_ORDER);
	}

	// 주문취소
	@Override
	public void cancelOrder() {
		System.out.println(Text.CANCEL_ORDER_BOOKNO);
		int ono= Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// 주문상태가 주문완료되었거나 결제확인된 경우
			if(oi.get(ono).getOstat() < 2) {
				// 1.주문취소 상태적용
				oi.get(ono).setOstat(2);
				oi.put(ono, (Order) oi.get(ono));
				// 2.재고수량에 주문취소수량만큼 가산
				bi.get(oi.get(ono).getBno()).setBqty(bi.get(oi.get(ono).getBno()).getBqty() + oi.get(ono).getOqty());
				// 3.가산결과를 반영
				bi.put(oi.get(ono).getBno(), (Book) bi.get(oi.get(ono).getBno()));
				// 4.적립금 반영
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

	// 환불요청
	@Override
	public void requestRefund() {
		System.out.println(Text.REQUEST_REFUNDNO);
		int ono= Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// 주문상태가 발송처리인 경우
			if(oi.get(ono).getOstat() == 3) {
				// 환불요청 상태적용
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
