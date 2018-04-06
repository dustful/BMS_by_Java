package bms.java.domain;

import java.util.Date;

public class Order {
	
	private int ono; // �ֹ���ȣ
	private String mid; // �ֹ���ID
	private int bno; // ������ȣ
	private int oqty; // �ֹ�����
	private Date oregdate; // �ֹ�����
	private int omileage; // �ݿ��Ѹ��ϸ���
	private int ostat; // �ֹ�����
	/*
	 * �ֹ����� ����
	 * 0 : �ֹ��Ϸ�
	 * 1 : ����Ȯ�ε�
	 * 2 : ��ҵ� �ֹ�
	 * 3 : �߼�ó����
	 * 4 : ȯ�ҿ�û��
	 * 5 : ȯ�ҽ��οϷ�
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
