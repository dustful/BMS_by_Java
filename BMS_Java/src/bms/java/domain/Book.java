package bms.java.domain;

public class Book {
	
	private int bno; // ������ȣ
	private String bname; // ������
	private String author; // ����
	private String publisher; // ���ǻ�
	private int bprice; // ����
	private int bqty; // ������
	private float discount; // ������
	private float mileage; // ������
	
	public Book() {}
	
	public Book(int bno, String bname, String author, String publisher, int bprice, int bqty, float discount, float mileage) {
		this.bno = bno;
		this.bname = bname;
		this.author = author;
		this.publisher = publisher;
		this.bprice = bprice;
		this.bqty = bqty;
		this.discount = discount;
		this.mileage = mileage;
	}
	
	public int getBno() { return bno; }
	public String getBname() { return bname; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	public int getBprice() { return bprice; }
	public int getBqty() { return bqty; }
	public float getDiscount() { return discount; }
	public float getMileage() { return mileage; }
	
	public void setBno(int bno) { this.bno = bno; }
	public void setBname(String bname) { this.bname = bname; }
	public void setAuthor(String author) { this.author = author; }
	public void setPublisher(String publisher) { this.publisher = publisher; }
	public void setBprice(int bprice) { this.bprice = bprice; }
	public void setBqty(int bqty) { this.bqty = bqty; }
	public void setDiscount(float discount) { this.discount = discount; }
	public void setMileage(float mileage) { this.mileage = mileage; }
	
}
