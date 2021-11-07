package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import bean.Page;
import dao.impl.BookServiceImpl;
import service.BookService;

/**
 * Servlet implementation class BookClientServlet
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bookService = new BookServiceImpl();

	/**
	 * 	���û�չʾͼ��ķ�ҳ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�û����ͼ�������ʾ�������� ҳ��Ӧ�����û���������
    	String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "2");
    	page.setUrl("client/BookClientServlet?method=page");
    	//����һҳ���ݷŵ�ҳ����ʾ
    	request.setAttribute("page", page);
    	request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("���ռ۸��ѯ");
		String max = request.getParameter("max");
		String min = request.getParameter("min");
		String pn = request.getParameter("pn");
		Page<Book> page = bookService.getPageByPrice(pn, "2", max, min);
		request.setAttribute("page", page);
		page.setUrl("client/BookClientServlet?method=pageByPrice&min="+min+"&max="+max);
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}
}
