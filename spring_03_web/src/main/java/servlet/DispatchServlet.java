package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));

		HandlerMapping mapping = new HandlerMapping();
		Controller controller = mapping.getController(path);
		String result ="/index.jsp";
		
		if(controller != null) {
		  result = controller.handlerRequest(request, response);
		}
		
		request.getRequestDispatcher(result).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
