package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import bean.Book;
import bean.Cart;
import bean.CartItem;
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
		//购物车的整个内容Cart在session中保存
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

	protected void updateAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart = WebUtils.getCart(request);
		String bookId = request.getParameter("id");
		//根据图书id删除
		cart.updateCount(bookId,request.getParameter("count"));
		//返回部分内容，修改的图书项的总金额，购物车的总金额，购物车的总数量
		CartItem item = cart.getItem(bookId);
		//获取购物项的总金额
		double totalPrice = item.getTotalPrice();
		//获取购物车的总数量
		int totalCount = cart.getTotalCount();
		//获取购物车的总金额
		double totalMoney = cart.getTotalMoney();
		Map<String, Object> map = new HashMap<>();
		//将数据封装
		map.put("totalPrice", totalPrice);
		map.put("totalCount", totalCount);
		map.put("totalMoney", totalMoney);
		//将数据转为json字符串返回
		Gson gson = new Gson();
		//响应数据
		String json = gson.toJson(map);
		response.getWriter().write(json);
	}

	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.clear();
		//返回cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	/**
	 * 	使用ajax技术将图书加入购物车
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2bean2(request, new Book());
		//购物车的整个内容Cart在session中保存
		//获取购物车
		Cart cart = WebUtils.getCart(request);
		Book one = bs.getOne(book);
		cart.addBook2Cart(one);
		//将图书加入成功后，只需要返回部分数据（当前购物车图书总量，书名）
		//不需要将书名放在session中，直接返回即可
		//直接返回即可
		
		//将数据会送给浏览器（当前购物车图书总量，书名）
		//当前购物车中所有的书的数量
		int totalCount = cart.getTotalCount();
		//获取刚才添加的图书的书名
		String title = one.getTitle();
		//为了js解析方便，写json格式数据
		//将这两个数据封装对象里，将对象转为json字符串
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("title", title);
		//将map转为json字符串
		Gson gson = new Gson();
		String json = gson.toJson(map);
		//将json字符串写给浏览器
		response.getWriter().write(json);
		
	}
	
	

}
