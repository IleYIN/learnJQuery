package service.impl;

import java.util.List;

import bean.OrderItem;
import dao.OrderItemDao;
import dao.impl.OrderItemDaoImpl;
import service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService {

	OrderItemDao itemDao = new OrderItemDaoImpl();

	@Override
	public List<OrderItem> getOrderItems(String orderid) {
		return itemDao.getOrderItems(orderid);
	}

	@Override
	public void saveItems(List<OrderItem> orderItems) {
//		for(OrderItem item : orderItems) {
//			itemDao.saveOrderItem(item);
//		}
		itemDao.saveBatch(orderItems);
	}

}
