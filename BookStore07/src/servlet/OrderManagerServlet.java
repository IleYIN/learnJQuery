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
	 *	�г����ж���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ���ж���
		List<Order> list = orderService.getAllOrder();
		// ���浽����
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request, response);
	}

	/**
	 * 	����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ������
		String orderId = request.getParameter("orderId");
		// �޸Ķ���״̬
		orderService.updateStatus(orderId, Constants.DELIVERING+"");
		// �ص�ҳ��
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
