package library.model.vo;

import java.sql.Date;

public class Library {

	private int leaseNo;
	private int bookNo;
	private String userID;
	private Date leaseDate;
	private Date returnDate;

	public Library() {
	}

	public Library(int leaseNo, int bookNo, String userID, Date leaseDate, Date returnDate) {
		super();
		this.leaseNo = leaseNo;
		this.bookNo = bookNo;
		this.userID = userID;
		this.leaseDate = leaseDate;
		this.returnDate = returnDate;
	}

	public int getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public Date getLeaseDate() {
		return leaseDate;
	}

	public void setLeaseDate(Date leaseDate) {
		this.leaseDate = leaseDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return this.leaseNo + " , " + this.bookNo + " , " + this.userID + " , " + this.leaseDate + " , "
				+ this.returnDate;

	}


}
