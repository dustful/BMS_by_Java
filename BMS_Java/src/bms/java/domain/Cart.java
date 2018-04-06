package bms.java.domain;

public class Cart {
	
	private int bno; // 도서번호
	private String mid; // 회원ID
	private int cqty; // 장바구니에 추가한 수량
	
	public Cart() {}
	
	public Cart(int bno, String mid, int cqty) {
		this.bno = bno;
		this.mid = mid;
		this.cqty = cqty;
	}
	
	public int getBno() { return bno; }
	public String getMid() { return mid; }
	public int getCqty() { return cqty; }
	
	public void setBno(int bno) { this.bno = bno; }
	public void setMid(String mid) { this.mid = mid; }
	public void setCqty(int cqty) { this.cqty = cqty; }

}
