package dao.impl;

import java.util.List;

import bean.Book;
import bean.Page;
import dao.BookDao;
import service.BookService;

/**
 * 	图书业务逻辑实现
 */
public class BookServiceImpl implements BookService {

	private BookDao bd = new BookDaoImpl();
	@Override
	public boolean add(Book book) {
		return bd.addBook(book);
	}

	@Override
	public boolean update(Book book) {
		return bd.updateBook(book);
	}

	@Override
	public boolean delete(Book book) {
		return bd.delBook(book);
	}

	@Override
	public Book getOne(Book book) {
		return bd.getBook(book);
	}

	@Override
	public List<Book> getAll() {
		return bd.getAllBook();
	}

	/**
	 * 	获取分页数据
	 */
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		// 1.将用户传入的数据先封装部分
		Page<Book> page = new Page<Book>();
		//将用户传入的数据转型并封装，设置默认值
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		
		// 2. 因为要使用totalCount当前总记录数，所以还需要查数据库
		// 获取总记录数
		int totalCount = bd.getTotalCount();
		page.setTotalCount(totalCount);
		//注意set的先后顺序 方法关联
		page.setPageSize(ps);
		page.setPageNo(pn);
		
		// 3. 查询数据并封装
		List<Book> list = bd.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		return page;
	}

	/**
	 * 	获取分页数据
	 */
	@Override
	public Page<Book> getPageByPrice(String pageNo, String pageSize, String max, String min) {
		double minPrice = 0.0;
		double maxPrice = Double.MAX_VALUE;
		try {
			minPrice = Double.parseDouble(min);
			maxPrice = Double.parseDouble(max);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		
		Page<Book> page = new Page<Book>();
		//将用户传入的数据转型并封装，设置默认值
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		int count = bd.getTotalCountByPrice(minPrice, maxPrice);
		//将页码以及页面大小设置进page对象
		page.setTotalCount(count);
		page.setPageSize(ps);
		page.setPageNo(pn);

		// 查询数据并封装
		List<Book> list = bd.getPageByPrice(page.getIndex(), page.getPageSize(), minPrice, maxPrice);
		page.setPageData(list);
		return page;
	}
}
