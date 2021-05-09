package dao.impl;

import java.util.List;

import bean.Book;
import dao.BaseDao;
import dao.BookDao;
/**
 *	²Ù×÷Í¼ÊéµÄDao 
 *
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getAllBook() {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book order by id";
		return getBeanList(sql);
	}

	@Override
	public boolean addBook(Book book) {
		String sql = "insert into bs_book(title,author,price,sales,stock,img_path) values (?,?,?,?,?,?)";
		int update = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
		return update > 0;
	}

	@Override
	public boolean delBook(Book book) {
		String sql = "delete from bs_book where id=?";
		int update = update(sql, book.getId());
		return update > 0;
	}

	@Override
	public boolean updateBook(Book book) {
		String sql = "update bs_book set title=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
		int update = update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
		return update > 0;
	}

	@Override
	public Book getBook(Book book) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where id=?";
		return getBean(sql, book.getId());
	}

	@Override
	public List<Book> getPageList(int index, int size) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book order by id offset ? limit ?";
		return getBeanList(sql,index,size);
	}

	@Override
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where price between ? and ? order by id offset ? limit ?";
		return getBeanList(sql,minPrice,maxPrice,index,size);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from bs_book";
		Object obj = getSingleValue(sql);
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(obj.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return parseInt;
	}

	@Override
	public int getTotalCountByPrice(double minPrice, double maxPrice) {
		String sql = "select count(*) from bs_book where price between ? and ?";
		Object obj = getSingleValue(sql, minPrice, maxPrice);
		int parseInt = 0;
		try {
			parseInt = Integer.parseInt(obj.toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return parseInt;
	}

}
