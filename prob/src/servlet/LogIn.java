package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet({"/login.do", "/logout.do"})
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id == null || pw == null || id.length() == 0 || pw.length() == 0) {
			//response.sendRedirect("/login.jsp"); // 실패시 로그인창으로 리턴
			RequestDispatcher rd = null; // 디스패쳐는 request객체 공유 됨
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			return;
		}
		if(id.equals("scott") && pw.equals("1aA!")){
			
			HttpSession session = request.getSession();
			session.setAttribute("login", "scott");
			
			RequestDispatcher rd = null; // 디스패쳐는 request객체 공유 됨
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			//response.sendRedirect("./index.jsp");
		}else {
			request.setAttribute("msg", "로그인 정보를 다시 입력하세요");
			//response.sendRedirect("./login.html"); // request 객체 공유 안됨
			RequestDispatcher rd = null; // 디스패쳐는 request객체 공유 됨
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate(); // 세션 삭제
		}
		
		response.sendRedirect("./index.jsp");
	}

}