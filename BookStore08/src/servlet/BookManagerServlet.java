package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Page;
import dao.impl.BookServiceImpl;
import service.BookService;
import utils.WebUtils;

/**
 * Servlet implementation class BookManagerServlet
 */
public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
    private BookService bookService = new BookServiceImpl();
	
    /**
     * 	��ʾ��ҳ����
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//System.out.println("�����ҳ�߼�");
    	//�û����ͼ�������ʾ�������� ҳ��Ӧ�����û���������
    	String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "2");
    	page.setUrl("manager/BookManagerServlet?method=page");
    	//����һҳ���ݷŵ�ҳ����ʾ
    	request.setAttribute("page", page);
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    
	/**
	 * 	������ʾͼ���б������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
//	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//�������ͼ�����ݲ���ʾ
//		List<Book> list = bookService.getAll();
//		//ͼ����������ҳ����ʾbook_manager.jsp
//		request.setAttribute("list",list);
//		//����ҳ��
//		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
//	}
	
	/**
	 * 	ͼ����� ���еĶ���update()�����ﴦ��
	 */
//	protected void add(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("ͼ�����");
//		//������룬Ҫ�ڻ�δ��ȡ����֮ǰ���ñ���
//		//��BaseServlet�����Ҫ�����ʹ����method��
//		//request.setCharacterEncoding("UTF-8");
//		//���ύ��ͼ����Ϣ��װΪBook���󣬱���nameӦ�úͶ��������һһ��Ӧ����book_edit.jsp��
//		Book book = WebUtils.param2bean2(request, new Book());
//		//System.out.println(book);
//		//��ͼ�鱣�浽���ݿ�
////		boolean b = bookService.add(book);
//		bookService.add(book);
////		if(b) {
//			//����ɹ�����ʾͼ���б��б���ʾ http://localhost:8080/BookStore04/manager/BookManagerServlet?method=list
//			//���ֱ���ض������󣬶����ǵ���list()�������޸���������
//		//���治���Ƿ�ɹ����ض���
//		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=list");
////		}
//	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("Referer");
		//referer������ĸ�ҳ�������������һ��ҳ�棬delete�����������referer��ȡҳ��pn����֮ǰ�ķ���
		//System.out.println(referer);
		//String pn = request.getParameter("pn");
		//��װҪɾ����book
		Book book = WebUtils.param2bean2(request, new Book());
		//System.out.println(book);
		//����ɾ������
		bookService.delete(book);
		//�ص��б���ʾ
		//response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+pn);
		response.sendRedirect(referer);
	}
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("pn:"+request.getParameter("pn"));
		//pn������book_manager.jsp�޸Ĵ��������ٱ�Servletת����book_edit.jsp
		
		//����id���ĳ��ͼ��
		Book book = WebUtils.param2bean2(request, new Book());
//		System.out.println(book);
		//��ȡ��ϸ��Ϣ
		Book one = bookService.getOne(book);
		//�ص��༭ҳ�������ʾ
		request.setAttribute("book", one);
		//ת����ҳ�������ʾ
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����referer����һ��ҳ�棬��һ�������磺http://localhost:8080/BookStore03/manager/BookManagerServlet?method=getBook&id=1&pn=1
		//��update�������޷�ʹ��referer����ȡ����޸�ǰ��ҳ�����������֮ǰ�ķ���
		//String referer = request.getHeader("Referer");
		//System.out.println(referer);
		String pn = request.getParameter("pn");
		//System.out.println(pn);
		
//		System.out.println("ͼ���޸�");
		Book book = WebUtils.param2bean(request, new Book());
		//System.out.println(book);
		//������Ӻ��޸Ĳ�����װ����book.id�в�����Կ���ͨ��id�ж��Ƿ�Ϊ��ӻ��޸Ĳ���
		if(book.getId()==0) {
			//���ͼ��
			bookService.add(book);
		}else {
			//�޸�ͼ��
			bookService.update(book);
		}
//		bookService.update(book);
//		//�����б�ҳ��
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+pn);
	}
}
