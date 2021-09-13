package service;

import java.util.List;

import bean.OrderItem;

public interface OrderItemService {
	
	/**
	 * ���涩����
	 * @param orderItem
	 */
	public void saveItems(List<OrderItem> orderItems);
	
	/**
	 * ��ȡ���������ж�����
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);
}
