package dao;

import java.util.List;

import bean.Order;

/**
 * 操作订单
 *
 */
public interface OrderDao {

	/**
	 * 保存订单
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order);
	
	/**
	 * 修改订单状态
	 * @param order
	 * @return
	 */
	public int updateStatus(Order order);
	
	/**
	 * (管理员)获取所有订单
	 * @return
	 */
	public List<Order> getOrderList();
	
	/**
	 * 获取某个用户的订单
	 * @param userId
	 * @return
	 */
	public List<Order> getOrdersByUserId(Integer userId);
}
