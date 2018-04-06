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
	
	// 회원삭제
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
	
	// 회원상태 변경
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
						// 정상
						mi.get(mid).setMstat(1);
						break;
					case "2":
						// 탈퇴
						mi.get(mid).setMstat(2);
						break;
					case "0":
						// 취소
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
	
	// 도서입고
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

	// 도서정보편집
	@Override
	public void editBook() {
		System.out.println(Text.EDIT_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			System.out.println(Text.EDIT_BOOKINFO);
			System.out.println(Text.HOST_BOOK_EDIT_MENU);
			
			switch(Console.input()) {
				case "1":
					System.out.println(Text.BOOK_NAME + "(기존도서명 : " + bi.get(bno).getBname() + ")");
					String bname = Console.input();
					bi.get(bno).setBname(bname);
					break;
				case "2":
					System.out.println(Text.BOOK_AUTHOR + "(기존저자 : " + bi.get(bno).getAuthor() + ")");
					String author = Console.input();
					bi.get(bno).setAuthor(author);
					break;
				case "3":
					System.out.println(Text.BOOK_PUBLISHER + "(기존출판사 : " + bi.get(bno).getPublisher() + ")");
					String publisher = Console.input();
					bi.get(bno).setPublisher(publisher);
					break;
				case "4":
					System.out.printf(Text.BOOK_PRICE + "(기존가격 : %,d)\n", bi.get(bno).getBprice());
					int bprice = Integer.parseInt(Console.input());
					bi.get(bno).setBprice(bprice);
					break;
				case "5":
					System.out.printf(Text.BOOK_QTY + "(기존재고수량 : %,d)\n", bi.get(bno).getBqty());
					int bqty = Integer.parseInt(Console.input());
					bi.get(bno).setBqty(bqty	);
					break;
				case "6":
					System.out.printf(Text.BOOK_DISCOUNT + "(기존할인율 : %3.2f)\n", bi.get(bno).getDiscount());
					float discount = Float.parseFloat(Console.input());
					bi.get(bno).setDiscount(discount);
					break;
				case "7":
					System.out.printf(Text.BOOK_MILEAGE + "(기존적립율 : %3.2f)\n", bi.get(bno).getMileage());
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
			System.out.println(bno + "번 도서의 도서정보편집이 완료되었습니다.");
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}

	// 도서삭제
	@Override
	public void deleteBook() {
		System.out.println(Text.DELETE_BOOKNO);
		int bno = Integer.parseInt(Console.input());
		
		if(bi.containsKey(bno)) {
			bi.remove(bno);
			System.out.println(bno + "번 도서가 삭제되었습니다.");
		} else {
			System.out.println(Text.THERE_IS_NO_BOOKNO);
		}
	}
	
	// 결제확인
	@Override
	public void confirmOrder1() {
		System.out.println(Text.CONFIRM_ORDERNO_1);
		int ono = Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// 주문상태가 주문완료인 경우
			if(oi.get(ono).getOstat() == 0) {
				// 결제확인 상태적용
				oi.get(ono).setOstat(1);
				oi.put(ono, (Order) oi.get(ono));
				System.out.println(ono + "번 주문이 결제확인되었습니다.");
			} else {
				System.out.println(Text.ORDER_STAT_3);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}
	
	// 발송처리
	@Override
	public void confirmOrder2() {
		System.out.println(Text.CONFIRM_ORDERNO_2);
		int ono = Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// 주문상태가 결제확인된 경우
			if(oi.get(ono).getOstat() == 1) {
				// 1.발송처리 상태적용
				oi.get(ono).setOstat(3);
				oi.put(ono, (Order) oi.get(ono));
				// 2.해당 회원에 적립금 반영
				mi.get(oi.get(ono).getMid()).setMmileage(
					(int) (mi.get(oi.get(ono).getMid()).getMmileage() + (
							(bi.get(oi.get(ono).getBno()).getBprice() * bi.get(oi.get(ono).getBno()).getMileage()) * oi.get(ono).getOqty()
						)
					)
				);
				mi.put(oi.get(ono).getMid(), (Member) mi.get(oi.get(ono).getMid()));
				System.out.println(ono + "번 주문이 발송처리되었습니다.");
			} else {
				System.out.println(Text.ORDER_STAT_4);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}
	
	// 환불승인
	@Override
	public void allowRefund() {
		System.out.println(Text.ALLOW_REFUNDNO);
		int ono = Integer.parseInt(Console.input());
		
		if(oi.containsKey(ono)) {
			// 주문상태가 환불요청된 경우
			if(oi.get(ono).getOstat() == 4) {
				// 환불승인 상태적용
				oi.get(ono).setOstat(5);
				oi.put(ono, (Order) oi.get(ono));
				// 1.재고수량에 환불요청수량만큼 가산
				bi.get(oi.get(ono).getBno()).setBqty(bi.get(oi.get(ono).getBno()).getBqty() + oi.get(ono).getOqty());
				// 2.가산결과를 반영
				bi.put(oi.get(ono).getBno(), (Book) bi.get(oi.get(ono).getBno()));
				// 3.해당 회원에 적립금 반영
				mi.get(oi.get(ono).getMid()).setMmileage(
					(int) (mi.get(oi.get(ono).getMid()).getMmileage() - (
							(bi.get(oi.get(ono).getBno()).getBprice() * bi.get(oi.get(ono).getBno()).getMileage()) * oi.get(ono).getOqty()
						)
					)
				);
				mi.put(oi.get(ono).getMid(), (Member) mi.get(oi.get(ono).getMid()));
				System.out.println(ono + "번 주문이 환불승인되었습니다.");
			} else {
				System.out.println(Text.ORDER_STAT_5);
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDERNO);
		}
	}
	
}
