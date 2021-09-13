package dao.impl;

import java.util.List;

import bean.Order;
import dao.BaseDao;
import dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

	@Override
	public int saveOrder(Order order) {
		String sql = "insert into bs_order(order_id,create_date,total_money,status,user_id) "
				+ "values(?,?,?,?,?)";
		int update = update(sql, order.getOrderId(), order.getCreateDate(), order.getTotalMoney(), order.getStatus(), order.getUserId());
		return update;
	}

	@Override
	public int updateStatus(Order order) {
		String sql = "update bs_order set status=? where order_id=?";
		int update = update(sql, order.getStatus(), order.getOrderId());
		return update;
	}

	/**
	 * (管理员)获取所有订单
	 */
	@Override
	public List<Order> getOrderList() {
		String sql = "select order_id orderId,create_date createDate,total_money totalMoney,status,user_id userId "
				+ "from bs_order";
		List<Order> beanList = getBeanList(sql);
		return beanList;
	}

	@Override
	public List<Order> getOrdersByUserId(Integer userId) {
		String sql = "select order_id orderId,create_date createDate,total_money totalMoney,status,user_id userId "
				+ "from bs_order where user_id=?";
		List<Order> beanList = getBeanList(sql,userId);
		return beanList;
	}

}
