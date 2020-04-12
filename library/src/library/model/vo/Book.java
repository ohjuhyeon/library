package library.model.vo;

public class Book {

	private int bookNo;
	private String bookName;
	private String bookWriter;
	private int bookPrice;
	private String publisher;
	private String genre;

	public Book() {
	}

	public Book(int bookNo, String bookName, String bookWriter, int bookPrice, String publisher, String genre) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPrice = bookPrice;
		this.publisher = publisher;
		this.genre = genre;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getgenre() {
		return genre;
	}

	public void setgenre(String genre) {
		this.genre = genre;
	}

	
	
	@Override
	public String toString() {
		// 원래 역할은 Object 클래스의 toString() 메소드
		// 객체의 고유값 출력 => 주소값
		// -> 멤버변수 값 출력
		return this.bookNo + " , " + this.bookName + " , " + 
		this.bookWriter + " , " + this.bookPrice + ", "  + 
		this.publisher + " , " + this.genre;
	}

}
