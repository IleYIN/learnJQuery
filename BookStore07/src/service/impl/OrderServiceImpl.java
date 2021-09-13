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
		// 结账操作 把购物车的数据封装并保存
		//1. 封装订单对象
		Order order = new Order();
		order.setCreateDate(Timestamp.valueOf(LocalDateTime.now()));
		//时间戳+用户id 模拟为订单id
		long millis = System.currentTimeMillis();
		String orderId = Long.toString(millis) + user.getId();
		order.setOrderId(orderId);
		order.setTotalMoney(cart.getTotalMoney());
		order.setStatus(0);
		order.setUserId(user.getId());
		//2. 封装订单项对象
		List<CartItem> allItems = cart.getAllItems();
		//封装所有的订单项
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for(CartItem cartItem : allItems) {
			OrderItem item = new OrderItem(cartItem.getBook().getTitle(),
					cartItem.getCount(),cartItem.getBook().getPrice(),
					cartItem.getTotalPrice(),orderId);
			orderItems.add(item);
		}
		//3.保存订单
		orderDao.saveOrder(order);
		//4.保存订单项
		itemService.saveItems(orderItems);
		//5.修改相应库存 改图书 改每一项
		for(CartItem cartItem : allItems) {
			//获取图书详细信息
			//图书的信息应该从数据库得到，实时销量和库存
			Book book = cartItem.getBook();
			Book one = bookService.getOne(book);
			int count = cartItem.getCount();
//			book.setStock(book.getStock()-count);
// 			book.setSales(book.getSales()+count);
			one.setStock(one.getStock()-count);
			one.setSales(one.getSales()+count);
			//更新信息
			bookService.update(one);
			//清空购物车
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
