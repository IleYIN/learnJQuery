package service;

import java.util.List;

import bean.Cart;
import bean.Order;
import bean.User;

public interface OrderService {
	/**
	 * ���˲���
	 * @param cart
	 * @return ���ض�����
	 */
	public String checkout(Cart cart, User user);

	/**
	 * �޸Ķ���״̬
	 * @param orderId
	 * @param status
	 */
	public void updateStatus(String orderId, String status);
	
	/**
	 * ������Ա����ȡ���ж���
	 * @return
	 */
	public List<Order> getAllOrder();
	
	/**
	 * ��ȡĳ���û������ж���
	 * @param userId
	 * @return
	 */
	public List<Order> getMyOrders(Integer userId);
}
