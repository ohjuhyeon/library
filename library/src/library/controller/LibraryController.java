package library.controller;

import java.util.ArrayList;

import library.model.dao.LibraryDao;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Lend;
import library.model.vo.Library;
import library.view.LibraryMenu;

public class LibraryController {

	public void selectAllBook() {
		LibraryMenu menu = new LibraryMenu();
		ArrayList<Book> bookList = new LibraryDao().selectAllBook();
		if (!bookList.isEmpty()) {
			menu.displayBookList(bookList);
		}

	}

	public void searchCode(int bookno) {
		LibraryMenu menu = new LibraryMenu();
		Book book = new LibraryDao().searchCode(bookno);
		if (book != null)
			menu.displayBook(book);
	}

	public void insertBook(Book inputBook) {

		new LibraryDao().insertBook(inputBook);

	}

	public void deleteBook(int bookno) {

		new LibraryDao().deleteBook(bookno);
	}

	public void selectAllCustomer() {
		LibraryMenu menu = new LibraryMenu();
		ArrayList<Customer> customerList = new LibraryDao().selectAllCustomer();
		if (customerList != null) {
			menu.displayCustomerList(customerList);
		}

	}

	public void searchCustomerName(String intputCustomerName) {

		LibraryMenu menu = new LibraryMenu();
		Customer customer = new LibraryDao().searchCustomerName(intputCustomerName);
		menu.displayCustomer(customer);

	}

	public void searchCustomerId(String inputCustomerId) {
		LibraryMenu menu = new LibraryMenu();
		Customer customer = new LibraryDao().searchCustomerId(inputCustomerId);
		menu.displayCustomer(customer);
	}
	
	public void searchLendId(String inputCustomerId) {
		LibraryMenu menu = new LibraryMenu();
		Lend lend = new LibraryDao().searchLendId(inputCustomerId);
		menu.displayLend(lend);
	}
	
	public void searchLendBook(String inputBookName) {
		LibraryMenu menu = new LibraryMenu();
		Lend lend = new LibraryDao().searchLendBook(inputBookName);
		menu.displayLend(lend);
		
	}



	public void updateCustomer(Customer customer) {
		new LibraryDao().updateCustomer(customer);

	}

	public void deleteCustomer(String customerId) {
		new LibraryDao().deleteCustomer(customerId);
	}

	public void selectAllLend() {
		LibraryMenu menu = new LibraryMenu();
		ArrayList<Lend> lendList = new LibraryDao().selectAllLend();
		if (!lendList.isEmpty()) {
			menu.displaylendList(lendList);
		}
	}

	public int searchLibraryBookname(String select) {
		Book book = new LibraryDao().searchLibraryBookname(select);
		return book.getBookNo();
		
	}

	public void insertLendBook(Library inputLendBook) {
		System.out.println(inputLendBook.toString());
		new LibraryDao().insertLendBook(inputLendBook);
	}
	
	public void insertCustomer(Customer customer) {
		System.out.println(customer.toString());
		new LibraryDao().insertcustomer(customer);

	}


}
