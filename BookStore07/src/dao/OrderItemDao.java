package dao;

import java.util.List;

import bean.OrderItem;

/**
 * ����������
 *
 */
public interface OrderItemDao {
	/**
	 * ��ȡĳ�����������ж�����
	 * @return
	 */
	public List<OrderItem> getOrderItems(String orderId);

	/**
	 * ����ĳ��������
	 * @return
	 */
	public int saveOrderItem(OrderItem item);
	
	/**
	 * 	ִ����������
	 * @param params
	 * @return
	 */
	public int saveBatch(List<OrderItem> params);
}
