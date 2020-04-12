package library.model.vo;

public class Lend {

	private int leaseNo;
	private String userID;
	private String userName;
	private String bookName;

	public Lend() {
	}

	public Lend(int leaseNo, String userID, String userName, String bookName) {
		super();
		this.leaseNo = leaseNo;
		this.userID = userID;
		this.userName = userName;
		this.bookName = bookName;
	}

	public int getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return this.leaseNo + " , " + this.userID + " , " + this.userName + " , " + this.bookName;

	}

}
