package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		if(id == null || pw == null || id.length() == 0 || pw.length() == 0) {
			response.sendRedirect("/login.html"); // 실패시 로그인창으로 리턴
			return;
		}
		if(id.equals("scott") && pw.equals("1aA!")){
			session.setAttribute("id", id);
			response.sendRedirect("/index.jsp");
		}else {
			response.sendRedirect("/login.html");
		}
	}

}