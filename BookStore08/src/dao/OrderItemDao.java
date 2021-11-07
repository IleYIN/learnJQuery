package dao;

import java.util.List;

import bean.OrderItem;

/**
 * 操作订单项
 *
 */
public interface OrderItemDao {
	/**
	 * 获取某个订单的所有订单项
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);

	/**
	 * 保存某个订单项
	 * @return
	 */
	public int saveOrderItem(OrderItem item);
	
	/**
	 * 	执行批量保存
	 * @param params
	 * @return
	 */
	public int saveBatch(List<OrderItem> params);
}
