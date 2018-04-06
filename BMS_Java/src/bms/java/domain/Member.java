package bms.java.domain;

import java.util.Date;

public class Member {
	
	private String mid; // ID
	private String mpw; // ��й�ȣ
	private String mname; // ȸ����
	private int grade; // ���
	private Date mregdate; // ��������
	private int mmileage; // ������
	private int mstat; // ����
	/*
	 * ���� ����
	 * 0 : ��ȸ��
	 * 1 : ����
	 * 2 : Ż���� ȸ��
	 * 3 : ������Ʈ(����)
	 */
	
	public Member() {}
	
	public Member(String mid, String mpw, String mname, int grade, int mstat, Date mregdate, int mmileage) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.grade = grade;
		this.mstat = mstat;
		this.mregdate = mregdate;
		this.mmileage = mmileage;
	}
	
	public String getMid() { return mid; }
	public String getMpw() { return mpw; }
	public String getMname() { return mname; }
	public int getGrade() { return grade; }
	public int getMstat() { return mstat; }
	public Date getMregdate() { return mregdate; }
	public int getMmileage() { return mmileage; }
	
	public void setMid(String mid) { this.mid = mid; }
	public void setMpw(String mpw) { this.mpw = mpw; }
	public void setMname(String mname) { this.mname = mname; }
	public void setGrade(int grade) { this.grade = grade; }
	public void setMstat(int mstat) { this.mstat = mstat; }
	public void setMregdate(Date mregdate) { this.mregdate = mregdate; }
	public void setMmileage(int mmileage) { this.mmileage = mmileage; }

}
