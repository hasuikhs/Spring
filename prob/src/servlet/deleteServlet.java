package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BookDAO;
import Service.BookService;
import Service.BookServiceImpl;

@WebServlet("/deleteServlet.do")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		PrintWriter out = response.getWriter();
		
		BookDAO dao = new BookDAO();
		BookService service = new BookServiceImpl(dao);
		
		String[] del = request.getParameterValues("delete");
		
		try {
			for(int i = 0; i < del.length; i++) {
				out.print(del[i]);
				int booknum = Integer.parseInt(del[i]);
				service.removeBook(booknum);
				response.sendRedirect("./list.do");
			}
		} catch (Exception e){
			request.setAttribute("exception", e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
