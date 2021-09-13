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
		//��֤�û��Ƿ��¼ Filter����
		//ȡ��session�е��û�
//		User loginUser = (User) session.getAttribute("user");
		User loginUser = WebUtils.getLoginUser(request);
//		//��¼�����
//		if(loginUser!=null) {
			//�����û��Ѿ���¼
			Cart cart = WebUtils.getCart(request);
			//���㣬����orderId������
			String orderId = orderService.checkout(cart, loginUser);
			session.setAttribute("orderId", orderId);
			//���ض�����ת������Ϊת����ˢ��ʱ���ظ�����
			response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
			
//		} else {
//			//����ֱ�ӷ��ص�¼ҳ����ʾ�û���¼
//			request.setAttribute("msg", "�˲�����Ҫ��¼�����ȵ�¼");
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
			//����loginUser.getId()��ָ���쳣
		}
		//���б����˸��û������ж���
		request.setAttribute("orders", list);
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	// ȷ���ջ�
	protected void received(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		orderService.updateStatus(orderId, Constants.DELIVERED+"");
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}


}
