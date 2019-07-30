package Service;

import java.util.List;

import vo.BookVO;

public interface BookService {
	List<BookVO> bookList();
	
	int addBook(BookVO vo) throws Exception;
	int removeBook(int bookno);
}