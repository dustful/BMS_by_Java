package bms.java.service;

public interface Host {
	/*회원관리*/
	public void deleteMember(); // 회원삭제
	public void alterMemberStat(); // 회원상태 변경
	
	/*재고관리*/
	public void addBook(); // 도서입고
	public void editBook(); // 도서정보편집
	public void deleteBook(); // 도서삭제
	
	/*주문관리*/
	public void confirmOrder1(); // 결제확인
	public void confirmOrder2(); // 발송처리
	public void allowRefund(); // 환불승인
}
