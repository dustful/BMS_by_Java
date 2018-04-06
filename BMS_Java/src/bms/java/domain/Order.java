package bms.java.domain;

import java.util.Date;

public class Order {
	
	private int ono; // 주문번호
	private String mid; // 주문자ID
	private int bno; // 도서번호
	private int oqty; // 주문수량
	private Date oregdate; // 주문일자
	private int omileage; // 반영한마일리지
	private int ostat; // 주문상태
	/*
	 * 주문상태 정보
	 * 0 : 주문완료
	 * 1 : 결제확인됨
	 * 2 : 취소된 주문
	 * 3 : 발송처리됨
	 * 4 : 환불요청됨
	 * 5 : 환불승인완료
	 */
	
	public Order() {}
	
	public Order(int ono, String mid, int bno, int oqty, int ostat, Date oregdate, int omileage) {
		this.ono = ono;
		this.mid = mid;
		this.bno = bno;
		this.oqty = oqty;
		this.ostat = ostat;
		this.oregdate = oregdate;
		this.omileage = omileage;
	}
	
	public int getOno() { return ono; }
	public String getMid() { return mid; }
	public int getBno() { return bno; }
	public int getOqty() { return oqty; }
	public int getOstat() { return ostat; }
	public Date getOregdate() { return oregdate; }
	public int getOmileage() { return omileage; }
	
	public void setOno(int ono) { this.ono = ono; }
	public void setMid(String mid) { this.mid = mid; }
	public void setBno(int bno) { this.bno = bno; }
	public void setOqty(int oqty) { this.oqty = oqty; }
	public void setOstat(int ostat) { this.ostat = ostat; }
	public void setOregdate(Date oregdate) { this.oregdate = oregdate; }
	public void setOmileage(int omileage) { this.omileage = omileage; }
	
}
