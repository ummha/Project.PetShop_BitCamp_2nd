package web.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.product.model.ProductService;
import web.domain.Member;
import web.domain.Product;

@WebServlet("/home/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
		ArrayList<Product> list = service.listS();
		request.setAttribute("list", list);

		//로그인 되어있다고 가정
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", new Member("test1@naver.com", "test1", null, 11112, "서울시 마포구 공덕동", "01009876543", 0));

		String view = "home.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
		}
}