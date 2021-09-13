package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Constants;
import bean.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderManagerServlet
 */
public class OrderManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	OrderService orderService = new OrderServiceImpl();
	/**
	 *	列出所有订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有订单
		List<Order> list = orderService.getAllOrder();
		// 保存到域中
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}

	/**
	 * 	发货
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取订单号
		String orderId = request.getParameter("orderId");
		// 修改订单状态
		orderService.updateStatus(orderId, Constants.DELIVERING+"");
		// 回到页面
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
