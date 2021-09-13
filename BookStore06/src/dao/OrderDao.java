package dao;

import java.util.List;

import bean.Order;

/**
 * ��������
 *
 */
public interface OrderDao {

	/**
	 * ���涩��
	 * @param order
	 * @return
	 */
	public int saveOrder(Order order);
	
	/**
	 * �޸Ķ���״̬
	 * @param order
	 * @return
	 */
	public int updateStatus(Order order);
	
	/**
	 * (����Ա)��ȡ���ж���
	 * @return
	 */
	public List<Order> getOrderList();
	
	/**
	 * ��ȡĳ���û��Ķ���
	 * @param userId
	 * @return
	 */
	public List<Order> getOrdersByUserId(Integer userId);
}
