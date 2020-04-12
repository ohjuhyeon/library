package library.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Lend;
import library.model.vo.Library;

public class LibraryDao {

	public ArrayList<Book> bookList;
	public ArrayList<Customer> customerList;
	public ArrayList<Library> libraryList;

	public LibraryDao() {

	}

	public ArrayList<Book> selectAllBook() {

		ArrayList<Book> bookList = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOK";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			bookList = new ArrayList<Book>();

			while (rset.next()) {
				Book book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setBookWriter(rset.getString("BOOK_WRITER"));
				book.setBookPrice(rset.getInt("BOOK_PRICE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setgenre(rset.getString("GENRE"));
				bookList.add(book);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return bookList;

	}

	public Book searchCode(int bookno) {
		Book book = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOK WHERE BOOK_NO = '" + bookno + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setBookWriter(rset.getString("BOOK_WRITER"));
				book.setBookPrice(rset.getInt("BOOK_PRICE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setgenre(rset.getString("GENRE"));

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
	}

	public void insertBook(Book book) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;

		String query = "INSERT INTO BOOK VALUES (' " + book.getBookNo() + "' , '" + book.getBookName() + "' , '"
				+ book.getBookWriter() + "' , '" + book.getBookPrice() + "' , '" + book.getPublisher() + "', '"
				+ book.getgenre() + "')";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteBook(int bookno) {

		int result = 0;
		Connection conn = null;
		Statement stmt = null;

		String query = "DELETE FROM BOOK WHERE BOOK_NO = '" + bookno + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Customer> selectAllCustomer() {

		ArrayList<Customer> customerList = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM Customer";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			customerList = new ArrayList<Customer>();

			while (rset.next()) {
				Customer customer = new Customer();
				customer.setUserNo(rset.getInt("USER_NO"));
				customer.setUserId(rset.getString("user_id"));
				customer.setUserName(rset.getString("user_name"));
				customer.setUserAge(rset.getInt("user_age"));
				customer.setAddr(rset.getString("addr"));
				customer.setGender(rset.getString("gender"));
				customer.setEnrollDate(rset.getDate("enroll_date"));
				customerList.add(customer);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return customerList;

	}

	public Customer searchCustomerName(String intputCustomerName) {
		Customer customer = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CUSTOMER WHERE USER_NAME = '" + intputCustomerName + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				customer = new Customer();
				customer.setUserNo(rset.getInt("USER_NO"));
				customer.setUserId(rset.getString("user_id"));
				customer.setUserName(rset.getString("user_name"));
				customer.setUserAge(rset.getInt("user_age"));
				customer.setAddr(rset.getString("addr"));
				customer.setGender(rset.getString("gender"));
				customer.setEnrollDate(rset.getDate("enroll_date"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;

	}

	public Customer searchCustomerId(String inputCustomerId) {

		Customer customer = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM CUSTOMER WHERE USER_ID = '" + inputCustomerId + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				customer = new Customer();
				customer.setUserNo(rset.getInt("USER_NO"));
				customer.setUserId(rset.getString("user_id"));
				customer.setUserName(rset.getString("user_name"));
				customer.setUserAge(rset.getInt("user_age"));
				customer.setAddr(rset.getString("addr"));
				customer.setGender(rset.getString("gender"));
				customer.setEnrollDate(rset.getDate("enroll_date"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customer;

	}

	public void insertcustomer(Customer customer) {

		int result = 0;
		Connection conn = null;
		Statement stmt = null;

		String query = "INSERT INTO CUSTOMER VALUES(" + customer.getUserNo() + "," + "'" + customer.getUserId() + "',"
				+ "'" + customer.getUserName() + "'," + customer.getUserAge() + "," + "'" + customer.getAddr() + "',"
				+ "'" + customer.getGender() + "'," + "SYSDATE)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCustomer(Customer customer) {

		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		String query = "UPDATE CUSTOMER SET USER_NAME = '" + customer.getUserName() + "'," + "USER_AGE = "
				+ customer.getUserAge() + "," + "ADDR = '" + customer.getAddr() + "'" + "WHERE USER_ID ='"
				+ customer.getUserId() + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteCustomer(String customerId) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		String query = "DELETE FROM CUSTOMER WHERE USER_ID = " + "'" + customerId + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
			if (result > 0)
				conn.commit();
			else
				conn.rollback();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Lend> selectAllLend() {

		ArrayList<Lend> LendList = null;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT LEASE_NO , USER_ID , USER_NAME, BOOK_NAME FROM LIBRARY JOIN CUSTOMER USING (USER_ID) JOIN BOOK USING (BOOK_NO)";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			LendList = new ArrayList<Lend>();

			while (rset.next()) {
				Lend lend = new Lend();
				lend.setLeaseNo(rset.getInt("LEASE_NO"));
				lend.setUserID(rset.getString("USER_ID"));
				lend.setUserName(rset.getString("user_name"));
				lend.setBookName(rset.getString("book_name"));
				LendList.add(lend);

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return LendList;
	}

	public Lend searchLendId(String inputCustomerId) {
		Lend lend = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT LEASE_NO , USER_ID , USER_NAME, BOOK_NAME FROM LIBRARY JOIN CUSTOMER USING (USER_ID) JOIN BOOK USING (BOOK_NO)"
				+ "WHERE USER_ID ='" + inputCustomerId + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				lend = new Lend();
				lend.setLeaseNo(rset.getInt("LEASE_NO"));
				lend.setUserID(rset.getString("USER_ID"));
				lend.setUserName(rset.getString("user_name"));
				lend.setBookName(rset.getString("book_name"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lend;
	}

	public Lend searchLendBook(String inputBookName) {
		Lend lend = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT LEASE_NO , USER_ID , USER_NAME, BOOK_NAME FROM LIBRARY JOIN CUSTOMER USING (USER_ID) JOIN BOOK USING (BOOK_NO) WHERE BOOK_NAME ='"
				+ inputBookName + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				lend = new Lend();
				lend.setLeaseNo(rset.getInt("LEASE_NO"));
				lend.setUserID(rset.getString("USER_ID"));
				lend.setUserName(rset.getString("user_name"));
				lend.setBookName(rset.getString("book_name"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lend;

	}

	public Book searchLibraryBookname(String select) {

		Book book = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT BOOK_NO FROM BOOK WHERE BOOK_NAME ='" + select + "'";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;

	}

	public void insertLendBook(Library library) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;

		String query = "INSERT INTO LIBRARY VALUES(" 
				+ library.getLeaseNo() + "," 
				+ library.getBookNo() + ","
				+ "'" + library.getUserID() + "'," 
				+ "SYSDATE, SYSDATE+2)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "LIBRARY", "LIBRARY");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
