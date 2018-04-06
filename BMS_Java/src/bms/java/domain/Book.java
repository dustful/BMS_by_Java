package bms.java.domain;

public class Book {
	
	private int bno; // 도서번호
	private String bname; // 도서명
	private String author; // 저자
	private String publisher; // 출판사
	private int bprice; // 가격
	private int bqty; // 재고수량
	private float discount; // 할인율
	private float mileage; // 적립율
	
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
