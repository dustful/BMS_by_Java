package bms.java.domain;

public class Cart {
	
	private int bno; // ������ȣ
	private String mid; // ȸ��ID
	private int cqty; // ��ٱ��Ͽ� �߰��� ����
	
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
