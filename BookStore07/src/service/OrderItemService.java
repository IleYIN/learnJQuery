package service;

import java.util.List;

import bean.OrderItem;

public interface OrderItemService {
	
	/**
	 * 保存订单项
	 * @param orderItem
	 */
	public void saveItems(List<OrderItem> orderItems);
	
	/**
	 * 获取订单的所有订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
}
