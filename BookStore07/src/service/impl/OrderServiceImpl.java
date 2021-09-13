package service.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import bean.Book;
import bean.Cart;
import bean.CartItem;
import bean.Order;
import bean.OrderItem;
import bean.User;
import dao.OrderDao;
import dao.impl.BookServiceImpl;
import dao.impl.OrderDaoImpl;
import service.BookService;
import service.OrderItemService;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao orderDao = new OrderDaoImpl();
	OrderItemService itemService = new OrderItemServiceImpl();
	BookService bookService = new BookServiceImpl();
	@Override
	public String checkout(Cart cart, User user) {
		// ���˲��� �ѹ��ﳵ�����ݷ�װ������
		//1. ��װ��������
		Order order = new Order();
		order.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
		//ʱ���+�û�id ģ��Ϊ����id
		long millis = System.currentTimeMillis();
		String orderId = Long.toString(millis) + user.getId();
		order.setOrderId(orderId);
		order.setTotalMoney(cart.getTotalMoney());
		order.setStatus(0);
		order.setUserId(user.getId());
		//2. ��װ���������
		List<CartItem> allItems = cart.getAllItems();
		//��װ���еĶ�����
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(CartItem cartItem : allItems) {
			OrderItem item = new OrderItem(cartItem.getBook().getTitle(),
					cartItem.getCount(),cartItem.getBook().getPrice(),
					cartItem.getTotalPrice(),orderId);
			orderItems.add(item);
		}
		//3.���涩��
		orderDao.saveOrder(order);
		//4.���涩����
		itemService.saveItems(orderItems);
		//5.�޸���Ӧ��� ��ͼ�� ��ÿһ��
		for(CartItem cartItem : allItems) {
			//��ȡͼ����ϸ��Ϣ
			//ͼ�����ϢӦ�ô����ݿ�õ���ʵʱ�����Ϳ��
			Book book = cartItem.getBook();
			Book one = bookService.getOne(book);
			int count = cartItem.getCount();
//			book.setStock(book.getStock()-count);
// 			book.setSales(book.getSales()+count);
			one.setStock(one.getStock()-count);
			one.setSales(one.getSales()+count);
			//������Ϣ
			bookService.update(one);
			//��չ��ﳵ
			cart.clear();
		}
		return orderId;
	}

	@Override
	public void updateStatus(String orderId, String status) {
		Order order = new Order();
		order.setOrderId(orderId);
		int st = 0;
		try {
			st = Integer.parseInt(status);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		order.setStatus(st);
		orderDao.updateStatus(order);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.getOrderList();
	}

	@Override
	public List<Order> getMyOrders(Integer userId) {
		return orderDao.getOrdersByUserId(userId);
	}

}
