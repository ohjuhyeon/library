package library.view;

import java.util.ArrayList;
import java.util.Scanner;

import library.controller.LibraryController;
import library.model.dao.LibraryDao;
import library.model.vo.Book;
import library.model.vo.Customer;
import library.model.vo.Lend;
import library.model.vo.Library;

public class LibraryMenu {

	private Scanner sc;
	private LibraryController lc;

	public LibraryMenu() {
		sc = new Scanner(System.in);
		lc = new LibraryController();
	}

	public void menu() {

		while (true) {

			System.out.println("= = = 책관리 프로그램 = = =");
			System.out.println(" 메인 메뉴");
			System.out.println("1. 책관리");
			System.out.println("2. 회원관리");
			System.out.println("3. 대여관리");
			System.out.print("선택 : ");

			int select = sc.nextInt();
			switch (select) {

			case 1:
				userManage();
				break;
			case 2:
				memberManage();
				break;
			case 3:
				lendManage();
				break;
			default:
				System.out.println("잘못누르셨습니다.");

			}
		}

	}

	public void userManage() {
		System.out.println("==== 책관리 메뉴 ====");
		System.out.println("1. 전체 책 조회");
		System.out.println("2. 책 코드로 조회");
		System.out.println("3. 책 추가하기");
		System.out.println("4. 책 삭제하기");
		System.out.println("5. 메인 메뉴로 이동하기");
		System.out.print("선택 : ");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			lc.selectAllBook();
			break;
		case 2:
			lc.searchCode(this.inputBookNo());
			break;
		case 3:
			lc.insertBook(this.inputBook());
			break;
		case 4:
			lc.deleteBook(this.deleteBookno());
			break;
		case 5:
			menu();
			break;

		}

	}

	public void memberManage() {
		System.out.println("==== 회원 관리 메뉴 ====");
		System.out.println("1. 회원 전체 조회");
		System.out.println("2. 회원 이름으로 조회");
		System.out.println("3. 회원 아이디로 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 탈퇴");
		System.out.println("7. 메인 메뉴로 이동");
		System.out.print("선택 : ");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			lc.selectAllCustomer();
			break;
		case 2:
			lc.searchCustomerName(this.intputCustomerName());
			break;
		case 3:
			lc.searchCustomerId(this.inputCustomerId());
			break;
		case 4:
			lc.insertCustomer(this.inputCustomer());
			break;
		case 5:
			lc.updateCustomer(this.modifyCustomer());
			break;
		case 6:
			lc.deleteCustomer(this.deleteCustomerId());
			break;
		case 7:
			menu();
			break;

		}

	}

	public void lendManage() {
		System.out.println("==== 대여 관리 메뉴 ====");
		System.out.println("1. 대여 관리 전체 조회");
		System.out.println("2. 회원 아이디로 대여 조회");
		System.out.println("3. 책 이름으로 대여 조회");
		System.out.println("4. 대여정보 추가");
		System.out.println("5. 메인 메뉴로 이동하기");
		System.out.print("선택 : ");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			lc.selectAllLend();
			break;
		case 2:
			lc.searchLendId(this.inputCustomerId());
			break;
		case 3:
			lc.searchLendBook(this.inputBookName());
			break;
		case 4:
			lc.insertLendBook(this.inputLendBook());
			break;
		case 5:
			menu();
			break;

		}

	}

	private Library inputLendBook() {
		Library library = new Library();
		System.out.print("대여 번호 : ");
		library.setLeaseNo(sc.nextInt());

		System.out.print("회원 아이디 : ");
		library.setUserID(sc.next());

		System.out.print("책 이름 : ");
		String select = sc.next();
		library.setBookNo(lc.searchLibraryBookname(select));
		
		return library;

	}

	public String inputBookName() {
		System.out.println("찾으실 책이름을 입력해주세요");
		sc.nextLine();
		return sc.nextLine();
	}

	public void displayBookList(ArrayList<Book> bookList) {
		for (Book book : bookList) {
			System.out.println(book.toString());
		}

	}

	public int inputBookNo() {
		System.out.println("책 코드를 입력해주세요");
		return sc.nextInt();
	}

	public void displayBook(Book book) {
		System.out.println(book.toString());

	}

	public void displaySuccess(String message) {
		System.out.println("서비스 요청결과 : " + message);

	}

	public Book inputBook() {
		Book book = new Book();
		System.out.print("책 번호 : ");
		book.setBookNo(sc.nextInt());
		System.out.print("책 제목 : ");
		book.setBookName(sc.next());
		System.out.print("글쓴이 : ");
		book.setBookWriter(sc.next());
		System.out.print("가격 : ");
		book.setBookPrice(sc.nextInt());
		System.out.print("출판사 : ");
		book.setPublisher(sc.next());
		System.out.print("장르 : ");
		book.setgenre(sc.next());

		return book;
	}

	public int deleteBookno() {
		System.out.print("삭제할 책 코드를 입력해주세요");
		return sc.nextInt();
	}

	public void displayCustomerList(ArrayList<Customer> customerList) {
		System.out.println("회원정보입니다.");
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}

	}

	public String intputCustomerName() {
		System.out.println("찾으실 이름을 입력해주세요");
		return sc.next();
	}

	public void displayCustomer(Customer customer) {
		System.out.println(customer.toString());

	}

	public void displayLend(Lend lend) {
		System.out.println(lend.toString());

	}

	public Customer inputCustomer() {
		Customer customer = new Customer();

		System.out.print("고객번호 : ");
		customer.setUserNo(sc.nextInt());

		System.out.print("고객아이디 : ");
		customer.setUserId(sc.next());

		System.out.print("이름 : ");
		customer.setUserName(sc.next());

		System.out.print("나이 : ");
		customer.setUserAge(sc.nextInt());
		sc.nextLine();
		System.out.print("주소 : ");
		customer.setAddr(sc.nextLine());

		System.out.print("성별 : ");
		customer.setGender(sc.next());

		return customer;
	}

	public String inputCustomerId() {
		System.out.println("찾으실 아이디를 입력해주세요");
		return sc.next();
	}

	public Customer modifyCustomer() {

		Customer customer = new Customer();
		System.out.println("  == 회원 수정 ==");

		System.out.println("회원 수정할 아이디 를 입력해주세요");
		customer.setUserId(sc.next());

		System.out.println("이름 : ");
		customer.setUserName(sc.next());

		System.out.println("나이 : ");
		customer.setUserAge(sc.nextInt());
		sc.nextLine();

		System.out.println("주소 : ");
		customer.setAddr(sc.nextLine());

		return customer;
	}

	public String deleteCustomerId() {
		System.out.println("삭제할 아이디를 입력해주세요");
		return sc.next();
	}

	public void displaylendList(ArrayList<Lend> lendList) {
		System.out.println("대여 정보입니다..");
		for (Lend lend : lendList) {
			System.out.println(lend.toString());
		}
	}

}
