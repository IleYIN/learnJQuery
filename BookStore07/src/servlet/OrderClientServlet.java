package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Constants;
import bean.Order;
import bean.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class OrderClientServlet
 */
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
      
	OrderService orderService = new OrderServiceImpl();
	
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//验证用户是否登录 Filter过滤
		//取出session中的用户
//		User loginUser = (User) session.getAttribute("user");
		User loginUser = WebUtils.getLoginUser(request);
//		//登录则结算
//		if(loginUser!=null) {
			//代表用户已经登录
			Cart cart = WebUtils.getCart(request);
			//结算，返回orderId订单号
			String orderId = orderService.checkout(cart, loginUser);
			session.setAttribute("orderId", orderId);
			//用重定向不用转发，因为转发在刷新时会重复请求
			response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
			
//		} else {
//			//否则直接返回登录页面提示用户登录
//			request.setAttribute("msg", "此操作需要登录，请先登录");
//			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
//		}
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User loginUser = WebUtils.getLoginUser(request);
		List<Order> list = null;
		try {
			list = orderService.getMyOrders(loginUser.getId());
		} catch (Exception e) {
			e.printStackTrace();
			//避免loginUser.getId()空指针异常
		}
		//域中保存了该用户的所有订单
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	// 确认收货
	protected void received(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		orderService.updateStatus(orderId, Constants.DELIVERED+"");
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}


}
