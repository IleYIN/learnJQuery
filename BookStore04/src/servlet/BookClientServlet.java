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
	 * 	给用户展示图书的分页数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//用户点击图书管理显示部分数据 页码应该是用户传进来的
    	String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "2");
    	page.setUrl("client/BookClientServlet?method=page");
    	//将第一页数据放到页面显示
    	request.setAttribute("page", page);
    	request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}

	protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("按照价格查询");
		String max = request.getParameter("max");
		String min = request.getParameter("min");
		String pn = request.getParameter("pn");
		Page<Book> page = bookService.getPageByPrice(pn, "2", max, min);
		request.setAttribute("page", page);
		page.setUrl("client/BookClientServlet?method=pageByPrice&min="+min+"&max="+max);
		request.getRequestDispatcher("/pages/book/booklist.jsp").forward(request, response);
	}
}
