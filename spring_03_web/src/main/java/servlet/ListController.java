package servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.biz.user.dao.UserDAO;
import spring.biz.user.dao.UserDAO_JDBC;
import spring.biz.user.service.UserService;
import spring.biz.user.service.UserServiceImpl;
import spring.biz.user.vo.UserVO;

public class ListController implements Controller{
    //list.do
	@Override
	public String handlerRequest(HttpServletRequest request, 
			                     HttpServletResponse response) {
		
		UserDAO dao = new UserDAO_JDBC();
		UserService service = new UserServiceImpl(dao);
		List<UserVO> list = service.getUserList();
		request.setAttribute("users", list);

		return "/list.jsp";
	}
}

class LoginController implements Controller{
    //login.do
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		return "/login.jsp";
	}
}

class HomeController implements Controller{
    //home.do
	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
		return "/index.jsp";
	}
}
