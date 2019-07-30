package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form.do")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) 
						 throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 해결 1
		response.setContentType("text/html;charset=utf-8"); // 한글깨짐 해결 2
		
		PrintWriter out = response.getWriter();
		
		//request.getParameterMap();
		
		String[] hobby = request.getParameterValues("hobby");
		
		out.print("<h1> 당신의 취미는 : </h1>");
		for(String data : hobby) {
			out.print("<h3> "+ data + " </h3>");
		}

	}
}
