package service;

import java.util.List;

import bean.Book;
import bean.Page;

/**
 *	ͼ���ҵ���߼� 
 */
public interface BookService {
	public boolean add(Book book);
	public boolean update(Book book);
	public boolean delete(Book book);
	public Book getOne(Book book);
	public List<Book> getAll();
	/**
	 * 	���ط�ҳ����
	 * @return
	 */
	public Page<Book> getPage(String pageNo, String pageSize);
	public Page<Book> getPageByPrice(String pageNo, String pageSize, String max, String min);
}
