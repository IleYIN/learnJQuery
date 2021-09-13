package test;

import org.junit.Test;

import bean.Book;
import bean.Cart;
import bean.User;
import dao.impl.BookServiceImpl;
import service.BookService;
import service.OrderService;
import service.impl.OrderServiceImpl;

public class OrderServiceTest {
	
	BookService bookService = new BookServiceImpl();
	OrderService orderService = new OrderServiceImpl();
	@Test
	public void test() {
		Book book = new Book();
		book.setId(9);
		Book one = bookService.getOne(book);
		
		Cart cart = new Cart();
		cart.addBook2Cart(one);
		cart.addBook2Cart(one);
		
		orderService.checkout(cart, new User(1, "","",""));
	}
}
