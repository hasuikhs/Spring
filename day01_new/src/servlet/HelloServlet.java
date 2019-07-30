package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet({ "/Hello", "/hello.do" })// url만 쓴다면 urlPatterns = 생략 가능
//@WebServlet(urlPatterns = { "/Hello", "/hello.do" }, loadOnStartup = 1) // 메모리에 미리 객체를 생성
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() { // 1. 객체생성
		System.out.println("HelloServlet() 객체 생성");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException { // 2. init 메소드 수행
		System.out.println(" HelloServlet => init() 수행");
	}
	
	@Override
	public void doGet(HttpServletRequest request, 
					HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println(" HelloServlet => doGet Service");
		
		PrintWriter out  = response.getWriter();
		out.print("<h1> HelloServlet 페이지입니다. </h1>");
		
		String name = request.getParameter("name");
		if(name != null) {
			out.print("<h3> 당신의 성은 : " + name.charAt(0) + "</h3>");
		}
		String addr = request.getParameter("addr");
		out.print("<h3> 당신의 주소는 : " + addr + "</h3>");
		
		String email = request.getParameter("email");
		out.print("<h3> 당신의 이메일은 : " + email + "</h3>");
	}

	@Override
	public void doPost(HttpServletRequest request,
					HttpServletResponse response) 
					throws ServletException, IOException {
		System.out.println(" HelloServlet => doGet Service"); // 3. 실행
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("HelloServlet => 반납 코드");
	}
}
