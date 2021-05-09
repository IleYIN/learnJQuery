package test;

import java.util.List;

import org.junit.Test;

import bean.Book;
import bean.Page;
import dao.BookDao;
import dao.impl.BookDaoImpl;
import dao.impl.BookServiceImpl;
import service.BookService;

public class BookDaoTest {

	/**
	 * 	测试获取图书
	 */
	BookDao bd = new BookDaoImpl();
	@Test
	public void test() {
		List<Book> allBook = bd.getAllBook();
		System.out.println(allBook);
	}
	
	/**
	 * 	测试添加图书
	 */
	@Test
	public void test2() {
		Book book = new Book(null,"图书2","作者2",50.12, 0, 200, null);
		boolean b = bd.addBook(book);
		System.out.println(b);
	}
	
	/**
	 * 	测试删除
	 */
	@Test
	public void test3() {
		Book book = new Book();
		book.setId(2);
		boolean b = bd.delBook(book);
		System.out.println(b);
	}
	
	/**
	 * 	测试修改
	 */
	@Test
	public void test4() {
		Book book = new Book(3, "图书22","author2",40.0,2,100,null);
		boolean b = bd.updateBook(book);
		System.out.println(b);
	}

	/**
	 * 	测试获取一本图书
	 */
	@Test
	public void test5() {
		Book book = new Book();
		book.setId(3);
		System.out.println(bd.getBook(book));
	}
	
	@Test
	public void test6() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPage("2", "2");
		//select * from bs_book order by id offset 2 limit 2;
		//select * from bs_book order by id offset (pageNo-1)*pageSize limit pageSize 
		System.out.println(page.getPageData());
	}
	@Test
	public void test7() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPage("1", "2");
		//select * from bs_book order by id offset 0 limit 2;
		System.out.println(page.getPageData());
	}
	@Test
	public void test8() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPage("3", "2");
		//select * from bs_book order by id offset 4 limit 2;
		System.out.println(page.getPageData());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}
	@Test
	public void test9() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPage("0", "2");//和bs.getPage("1", "2")一样
		System.out.println(page.getPageData());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}
	
	@Test
	public void test10() {
		BookService bs = new BookServiceImpl();
		Page<Book> page = bs.getPageByPrice("1", "2", "100", "60");
		System.out.println(page.getPageData());
		System.out.println(page.getPageNo());
		System.out.println(page.getPageSize());
		System.out.println(page.getTotalCount());
		System.out.println(page.getTotalPage());
	}
}
