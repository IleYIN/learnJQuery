package dao.impl;

import java.util.List;

import bean.OrderItem;
import dao.BaseDao;
import dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	/**
	 * 获取某个订单的所有订单项
	 */
	@Override
	public List<OrderItem> getOrderItems(String orderId) {
		String sql = "select id,title,count,price,total_price totalPrice,order_id orderId "
				+ "from bs_order_item where order_id=?";
		return getBeanList(sql, orderId);
	}

	@Override
	public int saveOrderItem(OrderItem item) {
		String sql = "insert into bs_order_item(title,count,price,total_price,order_id) "
				+ "values(?,?,?,?,?)";
		return update(sql, item.getTitle(),item.getCount(),item.getPrice(),item.getTotalPrice(),item.getOrderId());
		/**
		 * BaseDao里面update方法每次获取连接关闭连接浪费时间和资源
		 * 所以希望将多条sql语句一起执行，即 批处理
		 */
	}
	
	/**
	 * 	执行批量保存
	 * @param params
	 * @return
	 */
	@Override
	public int saveBatch(List<OrderItem> params) {
		String sql="insert into bs_order_item(title,count,price,total_price,order_id) " + 
				"values(?,?,?,?,?)";
		/**
		 * 	Object[][] params
		 *	第一位代表sql的执行次数，第二位专门用来存放sql执行要用的可变参数
		 */
		Object[][] objs = new Object[params.size()][5];
		int count = 0;
		for(OrderItem item : params) {
			objs[count++] = new Object[] {item.getTitle(), item.getCount(),
					item.getPrice(), item.getTotalPrice(), item.getOrderId()};
		}
		batch(sql, objs);
		return 1;
	}

}
