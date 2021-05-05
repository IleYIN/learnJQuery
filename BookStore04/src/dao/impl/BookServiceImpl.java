package dao.impl;

import java.util.List;

import bean.Book;
import bean.Page;
import dao.BookDao;
import service.BookService;

/**
 * 	ͼ��ҵ���߼�ʵ��
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
	 * 	��ȡ��ҳ����
	 */
	@Override
	public Page<Book> getPage(String pageNo, String pageSize) {
		// 1.���û�����������ȷ�װ����
		Page<Book> page = new Page<Book>();
		//���û����������ת�Ͳ���װ������Ĭ��ֵ
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		
		// 2. ��ΪҪʹ��totalCount��ǰ�ܼ�¼�������Ի���Ҫ�����ݿ�
		// ��ȡ�ܼ�¼��
		int totalCount = bd.getTotalCount();
		page.setTotalCount(totalCount);
		//ע��set���Ⱥ�˳�� ��������
		page.setPageSize(ps);
		page.setPageNo(pn);
		
		// 3. ��ѯ���ݲ���װ
		List<Book> list = bd.getPageList(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		return page;
	}

	/**
	 * 	��ȡ��ҳ����
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
		//���û����������ת�Ͳ���װ������Ĭ��ֵ
		int pn = 1;
		int ps = page.getPageSize();
		try {
			pn = Integer.parseInt(pageNo);
			ps = Integer.parseInt(pageSize);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		int count = bd.getTotalCountByPrice(minPrice, maxPrice);
		//��ҳ���Լ�ҳ���С���ý�page����
		page.setTotalCount(count);
		page.setPageSize(ps);
		page.setPageNo(pn);

		// ��ѯ���ݲ���װ
		List<Book> list = bd.getPageByPrice(page.getIndex(), page.getPageSize(), minPrice, maxPrice);
		page.setPageData(list);
		return page;
	}
}
