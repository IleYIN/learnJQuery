package dao;

import java.util.List;

import bean.Book;

public interface BookDao {
	/**
	 * 	��ȡ����ͼ��
	 * @return ����ͼ���list
	 */
	public List<Book> getAllBook();
	
	/**
	 * 	���һ��ͼ��
	 * @param book ����Ҫ��ӵ�ͼ��
	 * @return true ��ӳɹ����
	 */
	public boolean addBook(Book book);

	/**
	 * 	ɾ��һ��ͼ��
	 * @param book Ҫɾ����ͼ�� id
	 * @return
	 */
	public boolean delBook(Book book);
	
	/**
	 * 	�޸�һ��ͼ��
	 * @param book Ҫ�޸ĵ�ͼ�� ��book�޸ĺ������
	 * @return
	 */
	public boolean updateBook(Book book);
	
	/**
	 * 	����ͼ���id������ͼ��
	 * @param book ����ͼ��id
	 * @return
	 */
	public Book getBook(Book book);
	
	/**
	 * 	��ҳ����ͼ��ķ���
	 * @param index
	 * @param size
	 * @return
	 */
	public List<Book> getPageList(int index, int size);
	
	/**
	 * 	��ȡ����ͼ����ܼ�¼��
	 * @return
	 */
	public int getTotalCount();
	
	/**
	 * 	��ȡ�۸�����ļ�¼��
	 * @param minPrice
	 * @param maxPrice
	 * @return
	 */
	public int getTotalCountByPrice(double minPrice, double maxPrice);

	/**
	 * 
	 * @param index
	 * @param size
	 * @param minPrice ��С�۸�
	 * @param maxPrice ���۸�
	 * @return
	 */
	public List<Book> getPageByPrice(int index, int size, double minPrice, double maxPrice);
	
}
