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
     * 	显示分页数据
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//System.out.println("进入分页逻辑");
    	//用户点击图书管理显示部分数据 页码应该是用户传进来的
    	String pn = request.getParameter("pn");
    	Page<Book> page = bookService.getPage(pn, "2");
    	page.setUrl("manager/BookManagerServlet?method=page");
    	//将第一页数据放到页面显示
    	request.setAttribute("page", page);
    	request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
    }
    
	/**
	 * 	处理显示图书列表的请求
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
//	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//查出所有图书数据并显示
//		List<Book> list = bookService.getAll();
//		//图书查出并交给页面显示book_manager.jsp
//		request.setAttribute("list",list);
//		//交给页面
//		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
//	}
	
	/**
	 * 	图书添加 所有的都在update()方法里处理
	 */
//	protected void add(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("图书添加");
//		//解决乱码，要在还未获取数据之前设置编码
//		//在BaseServlet里面就要解决（使用了method）
//		//request.setCharacterEncoding("UTF-8");
//		//将提交的图书信息封装为Book对象，表单的name应该和对象的属性一一对应（见book_edit.jsp）
//		Book book = WebUtils.param2bean2(request, new Book());
//		//System.out.println(book);
//		//将图书保存到数据库
////		boolean b = bookService.add(book);
//		bookService.add(book);
////		if(b) {
//			//保存成功，显示图书列表，列表显示 http://localhost:8080/BookStore04/manager/BookManagerServlet?method=list
//			//解耦，直接重定向请求，而不是调用list()，避免修改引起问题
//		//保存不论是否成功都重定向
//		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=list");
////		}
//	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("Referer");
		//referer代表从哪个页面过来，代表上一个页面，delete方法里可以用referer获取页数pn代替之前的方法
		//System.out.println(referer);
		//String pn = request.getParameter("pn");
		//封装要删除的book
		Book book = WebUtils.param2bean2(request, new Book());
		//System.out.println(book);
		//调用删除方法
		bookService.delete(book);
		//回到列表显示
		//response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+pn);
		response.sendRedirect(referer);
	}
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("pn:"+request.getParameter("pn"));
		//pn参数由book_manager.jsp修改传过来，再被Servlet转发到book_edit.jsp
		
		//按照id查出某本图书
		Book book = WebUtils.param2bean2(request, new Book());
//		System.out.println(book);
		//获取详细信息
		Book one = bookService.getOne(book);
		//回到编辑页面进行显示
		request.setAttribute("book", one);
		//转发到页面进行显示
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//这里referer是上一个页面，上一次请求，如：http://localhost:8080/BookStore03/manager/BookManagerServlet?method=getBook&id=1&pn=1
		//在update方法里无法使用referer来获取点击修改前的页数，不能替代之前的方法
		//String referer = request.getHeader("Referer");
		//System.out.println(referer);
		String pn = request.getParameter("pn");
		//System.out.println(pn);
		
//		System.out.println("图书修改");
		Book book = WebUtils.param2bean(request, new Book());
		//System.out.println(book);
		//由于添加和修改操作封装出的book.id有差别，所以可以通过id判断是否为添加或修改操作
		if(book.getId()==0) {
			//添加图书
			bookService.add(book);
		}else {
			//修改图书
			bookService.update(book);
		}
//		bookService.update(book);
//		//返回列表页面
		response.sendRedirect(request.getContextPath()+"/manager/BookManagerServlet?method=page&pn="+pn);
	}
}
