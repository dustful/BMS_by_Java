package bms.java.service;

public interface Guest {
	
	/*개인정보*/
	public void optOut(); // 회원탈퇴
	
	/*주문*/
	public void orderBook(); // 주문
	
	/*장바구니*/
	public void addCart(); // 장바구니에 추가
	public void deleteCart(); // 장바구니에서 제거
	public void orderCart(); // 장바구니 주문
	
	/*주문내역확인*/
	public void cancelOrder(); // 주문취소
	public void requestRefund(); // 환불요청

}
