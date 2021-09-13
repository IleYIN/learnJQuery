package service;

import java.util.List;

import bean.Cart;
import bean.Order;
import bean.User;

public interface OrderService {
	/**
	 * 结账操作
	 * @param cart
	 * @return 返回订单号
	 */
	public String checkout(Cart cart, User user);

	/**
	 * 修改订单状态
	 * @param orderId
	 * @param status
	 */
	public void updateStatus(String orderId, String status);
	
	/**
	 * （管理员）获取所有订单
	 * @return
	 */
	public List<Order> getAllOrder();
	
	/**
	 * 获取某个用户的所有订单
	 * @param userId
	 * @return
	 */
	public List<Order> getMyOrders(Integer userId);
}
