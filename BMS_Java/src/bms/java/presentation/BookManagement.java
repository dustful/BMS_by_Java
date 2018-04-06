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
	
	public static Map<String, Member> memberInfo = new HashMap<String, Member>(); // 회원정보
	public static Map<Integer, Book> bookInfo = new HashMap<Integer, Book>(); // 도서정보
	public static Map<Integer, Order> orderInfo = new HashMap<Integer, Order>(); // 주문정보
	// public static Map<Integer, Cart> cartInfo = new HashMap<Integer, Cart>(); // 장바구니정보
	public static List<Cart> cartInfo = new ArrayList<Cart>(); // 장바구니정보
	
	private static BookManagement system;
	
	public static BookManagement getInstance() {
		if(system == null) system = new BookManagement();
		return system;
	}
	
	private String currID; // 현재 접속한 회원ID
	private int currGrade; // 현재 접속한 회원등급

	// 현재 접속한 회원정보에 대한 접근자
	public String getCurrID() { return currID; }
	public int getCurrGrade() { return currGrade; }
	
	// 현재 접속한 회원정보에 대한 설정자
	public void setCurrID(String currID) { this.currID = currID; }
	public void setCurrGrade(int currGrade) { this.currGrade = currGrade; }
	
	// 시스템 시작
	public void openSystem() {
		System.out.println(Text.START_SYSTEM);
		
		memberInfo.put("host", new Member("host", "1234", "관리자", 1, 1, new Date(), 0)); // 판매자

		// 시험용 더미 데이터
		memberInfo.put("guest", new Member("guest", "1234", "고객", 2, 1, new Date(), 50000)); // 구매자
		bookInfo.put(1111, new Book(1111, "test1", "tt1", "ttt1", 12000, 100, 0.1f, 0.05f)); // 도서정보1
		bookInfo.put(2222, new Book(2222, "test2", "tt2", "ttt2", 25000, 80, 0.1f, 0.05f)); // 도서정보2
		bookInfo.put(3333, new Book(3333, "test3", "tt3", "ttt3", 33000, 50, 0.1f, 0.05f)); // 도서정보3
		// cartInfo.add((Cart) new Cart(1111, "guest", 16)); // 장바구니정보1
		// cartInfo.add((Cart) new Cart(2222, "guest", 24)); // 장바구니정보2
		
		MenuImp.getInstance().menuController(Code.MAIN_MENU);
	}
	
	// 로그인
	public void signIn() {
		System.out.println(Text.INPUT_ID);
		String userID = Console.input();
		System.out.println(Text.INPUT_PW);
		String userPW = Console.input();
		
		// 회원정보에 대한 인증 처리
		// 탈퇴한 회원이 아니면서, 회원ID가 존재하고 회원비밀번호가 일치한 경우만 접속 가능
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
	
	// 회원가입
	public void signUp() {
		System.out.println(Text.INPUT_REG_ID);
		String userID = Console.input();
		
		// 회원ID의 길이에 대한 유효성 검사(4자 이상인 경우만 등록 가능)
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
	
	// 로그아웃
	public void signOut() {
		setCurrID(null);
		setCurrGrade(0);
	}
	
	// 회원목록
	public void viewMemberList() {
		int i = 0;
		String mstat = null;
		
		if(!memberInfo.isEmpty()) {
			for(HashMap.Entry<String, Member> m : memberInfo.entrySet()) {
				++i;
				System.out.print("[회원ID : " + m.getKey() + "]");
				System.out.print("[회원명 : " + m.getValue().getMname() + "]");
				System.out.printf("[적립금 : %,d]", m.getValue().getMmileage());
				
				switch(m.getValue().getMstat()) {
				case 1:
					mstat = "정상";
					break;
				case 2:
					mstat = "탈퇴";
					break;
			}
				
				System.out.print("[상태 : " + mstat + "]");
				System.out.println("[가입일자 : " + m.getValue().getMregdate() + "]");
			}
			
			System.out.println(i + "명의 회원이 등록되어있습니다.");
		} else {
			System.out.println(Text.THERE_IS_NO_MEMBER);
		}
	}
	
	// 재고목록
	public void viewBookList() {
		int i = 0;
		
		if(!bookInfo.isEmpty()) {
			for(HashMap.Entry<Integer, Book> b : bookInfo.entrySet()) {
				++i;
				System.out.print("[도서번호 : " + b.getKey() + "]");
				System.out.print("[도서명 : " + b.getValue().getBname() + "]");
				System.out.print("[저자 : " + b.getValue().getAuthor() + "]");
				System.out.print("[출판사 : " + b.getValue().getPublisher() + "]");
				System.out.printf("[가격 : %,d]", b.getValue().getBprice());
				System.out.printf("[재고수량 : %,d]", b.getValue().getBqty());
				System.out.printf("[할인율 : %3.2f]", b.getValue().getDiscount());
				System.out.printf("[적립율 : %3.2f]\n", b.getValue().getMileage());
			}
			
			System.out.println(i + "건의 도서가 입고되어있습니다.");
		} else {
			System.out.println(Text.THERE_IS_NO_BOOK);
		}
	}
	
	// 주문목록
	public void viewOrderList() {
		int i = 0;
		String ostat = null;
		int oprice = 0;
		int sum = 0;
		
		if(!orderInfo.isEmpty()) {
			for(HashMap.Entry<Integer, Order> o : orderInfo.entrySet()) {
				if(o.getValue().getMid().equals(getCurrID()) || getCurrGrade() == 1) {
					++i;
					System.out.print("[주문번호 : " + o.getKey() + "]");
					System.out.print("[도서번호 : " + o.getValue().getBno() + "]");
					System.out.print("[도서명 : " + bookInfo.get(o.getValue().getBno()).getBname() + "]");
					System.out.printf("[가격 : %,d]", bookInfo.get(o.getValue().getBno()).getBprice());
					System.out.printf("[할인율 : %3.2f]", bookInfo.get(o.getValue().getBno()).getDiscount());
					System.out.printf("[적립율 : %3.2f]", bookInfo.get(o.getValue().getBno()).getMileage());
					System.out.printf("[주문수량 : %,d]", o.getValue().getOqty());
					oprice = (int) (bookInfo.get(o.getValue().getBno()).getBprice() - (bookInfo.get(o.getValue().getBno()).getBprice() * bookInfo.get(o.getValue().getBno()).getDiscount())) * o.getValue().getOqty();
					System.out.printf("[주문금액 : %,d]", oprice);
					System.out.print("[주문자ID : " + o.getValue().getMid() + "]");
					System.out.print("[주문일자 : " + o.getValue().getOregdate() + "]");
					
					switch(o.getValue().getOstat()) {
						case 0:
							ostat = "주문완료";
							break;
						case 1:
							ostat = "결제확인완료";
							break;
						case 2:
							ostat = "취소된 주문";
							break;
						case 3:
							ostat = "발송완료";
							break;
						case 4:
							ostat = "환불대기";
							break;
						case 5:
							ostat = "환불완료";
							break;
					}
					
					System.out.println("[주문상태 : " + ostat + "]");
					
					if(o.getValue().getOstat() == 1 || o.getValue().getOstat() == 3 || o.getValue().getOstat() == 4) {
						// 기존 판매누계 = 가격 * 주문수량
						// sum += (bookInfo.get(o.getValue().getBno()).getBprice() * o.getValue().getOqty());
						// 할인이 적용된 판매누계 = (가격 - (가격 * 할인율)) * 수량
						// sum += (bookInfo.get(o.getValue().getBno()).getBprice() - (bookInfo.get(o.getValue().getBno()).getBprice() * bookInfo.get(o.getValue().getBno()).getDiscount())) * o.getValue().getOqty();
						sum += oprice;
					}
				}
			}
			
			System.out.println(i + "건의 주문이 있습니다.");
			
			if(getCurrGrade() == 1) {
				System.out.printf("판매누계 : %,d\n", sum);
			} else {
				System.out.printf("나의 적립금 : %,d\n", memberInfo.get(getCurrID()).getMmileage());
			}
		} else {
			System.out.println(Text.THERE_IS_NO_ORDER);
		}
	}
	
	// 장바구니목록
	public void viewCartList() {
		int i = 0;
		int sum = 0;
		
		if(!cartInfo.isEmpty()) {
			for(Cart c : cartInfo) {
				if(c.getMid().equals(getCurrID()) || getCurrGrade() == 1) {
					++i;
					// System.out.print("[상품순번 : " + i + "]");
					System.out.print("[도서번호 : " + c.getBno() + "]");
					System.out.print("[도서명 : " + bookInfo.get(c.getBno()).getBname() + "]");
					System.out.printf("[가격 : %,d]", bookInfo.get(c.getBno()).getBprice());
					System.out.printf("[할인율 : %3.2f]", bookInfo.get(c.getBno()).getDiscount());
					System.out.printf("[적립율 : %3.2f]", bookInfo.get(c.getBno()).getMileage());
					System.out.printf("[주문 예정 수량 : %,d]\n", c.getCqty());
					// 기존 주문 예정 총액 += 가격 * 수량
					// sum += bookInfo.get(c.getBno()).getBprice() * c.getCqty();
					// 할인이 적용된 주문 예정 총액 += (가격 - (가격 * 할인율)) * 수량
					sum += (bookInfo.get(c.getBno()).getBprice() - (bookInfo.get(c.getBno()).getBprice() * bookInfo.get(c.getBno()).getDiscount())) * c.getCqty();
				}
			}
			
			System.out.println(i + "건의 도서가 장바구니에 있습니다.");
			System.out.printf("주문 예정 총액 : %,d\n", sum);
		} else {
			System.out.println(Text.THERE_IS_NO_CART);
		}
	}

}
