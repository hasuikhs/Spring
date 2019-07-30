package App;

import java.util.List;

import DAO.BookDAO;
import Service.BookService;
import Service.BookServiceImpl;
import vo.BookVO;

public class BookApp {
	public static void main(String[] args) {
		
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		
		BookVO user = new BookVO("spring", "kim", 7712100);
		try {
			service.addBook(user);
		} catch (Exception e) {
			System.out.println("등록 데이터 확인 필요");
		}
		
		if (service != null) {
			List<BookVO> list = service.bookList();
			list.forEach(i -> System.out.println(i));
		}
		
		
	}
}