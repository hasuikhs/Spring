package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import Service.BookService;
import Service.BookServiceImpl;
import vo.BookVO;

@WebServlet("/insertbook.do")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, 
			       HttpServletResponse response) 
			       throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		//PrintWriter out = response.getWriter();
		// 주석들 기존 코딩 DAO를 바로 사용하는 것은 보안상 좋지 못하다 
		// 그러므로 Service를 이용한다
		//String title = request.getParameter("title");
		//String price = request.getParameter("price");
		//String author = request.getParameter("author");
		
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		//BookVO book = new BookVO(title, author, Integer.parseInt(price));
		BookVO book = new BookVO();
		book.setAuthor(request.getParameter("author"));
		book.setPrice(Integer.parseInt(request.getParameter("price")));
		book.setTitle(request.getParameter("title"));
		
		
		try {
			service.addBook(book);
			//int i = service.addBook(book);
			response.sendRedirect("./list.do"); // 리스트 출력 페이지로 redirect 
			//out.print(i+"개의 row 입력 성공");
		} catch (Exception e) {
			e.printStackTrace();
			//out.print("입력 실패");
		}
	}

}
