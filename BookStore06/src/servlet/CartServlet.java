package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import bean.Cart;
import dao.impl.BookServiceImpl;
import service.BookService;
import utils.WebUtils;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	BookService bs = new BookServiceImpl();
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2bean2(request, new Book());
		//购物车的整个内容Cart在sesion中保存
		//获取购物车
		HttpSession session = request.getSession(); 
		/*
		 * Cart cart = (Cart)
		 * session.getAttribute("cart"); if(cart==null) { cart = new Cart();
		 * session.setAttribute("cart", cart); }
		 */
		Cart cart = WebUtils.getCart(request);
		Book one = bs.getOne(book);
		cart.addBook2Cart(one);
		session.setAttribute("title", one.getTitle());
		String refer = request.getHeader("referer");
		//refer（请求地址）只是指上次的请求行
		//get 请求地址包括请求数据
		//post 请求地址不包括请求数据 
		//为了refer带上请求数据 可以用get而不是post
		//但是get会覆盖?后的东西（如方法），所以要把方法放隐藏域中
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		response.sendRedirect(refer);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart = WebUtils.getCart(request);
		//根据图书id删除
		cart.deleteItem(request.getParameter("id"));
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart = WebUtils.getCart(request);
		//根据图书id删除
		cart.updateCount(request.getParameter("id"),request.getParameter("count"));
		//返回cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.clear();
		//返回cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
