package dao.impl;

import java.util.List;

import bean.OrderItem;
import dao.BaseDao;
import dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao {

	/**
	 * ��ȡĳ�����������ж�����
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
		 * BaseDao����update����ÿ�λ�ȡ���ӹر������˷�ʱ�����Դ
		 * ����ϣ��������sql���һ��ִ�У��� ������
		 */
	}
	
	/**
	 * 	ִ����������
	 * @param params
	 * @return
	 */
	@Override
	public int saveBatch(List<OrderItem> params) {
		String sql="insert into bs_order_item(title,count,price,total_price,order_id) " + 
				"values(?,?,?,?,?)";
		/**
		 * 	Object[][] params
		 *	��һλ����sql��ִ�д������ڶ�λר���������sqlִ��Ҫ�õĿɱ����
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
