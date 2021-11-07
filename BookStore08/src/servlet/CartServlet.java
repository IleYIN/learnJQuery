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
		//���ﳵ����������Cart��session�б���
		//��ȡ���ﳵ
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
		//refer�������ַ��ֻ��ָ�ϴε�������
		//get �����ַ������������
		//post �����ַ�������������� 
		//Ϊ��refer������������ ������get������post
		//����get�Ḳ��?��Ķ������緽����������Ҫ�ѷ�������������
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		response.sendRedirect(refer);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart = WebUtils.getCart(request);
		//����ͼ��idɾ��
		cart.deleteItem(request.getParameter("id"));
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart = WebUtils.getCart(request);
		//����ͼ��idɾ��
		cart.updateCount(request.getParameter("id"),request.getParameter("count"));
		//����cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	protected void updateAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart = WebUtils.getCart(request);
		String bookId = request.getParameter("id");
		//����ͼ��idɾ��
		cart.updateCount(bookId,request.getParameter("count"));
		//���ز������ݣ��޸ĵ�ͼ������ܽ����ﳵ���ܽ����ﳵ��������
		CartItem item = cart.getItem(bookId);
		//��ȡ��������ܽ��
		double totalPrice = item.getTotalPrice();
		//��ȡ���ﳵ��������
		int totalCount = cart.getTotalCount();
		//��ȡ���ﳵ���ܽ��
		double totalMoney = cart.getTotalMoney();
		Map<String, Object> map = new HashMap<>();
		//�����ݷ�װ
		map.put("totalPrice", totalPrice);
		map.put("totalCount", totalCount);
		map.put("totalMoney", totalMoney);
		//������תΪjson�ַ�������
		Gson gson = new Gson();
		//��Ӧ����
		String json = gson.toJson(map);
		response.getWriter().write(json);
	}

	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart = WebUtils.getCart(request);
		cart.clear();
		//����cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

	/**
	 * 	ʹ��ajax������ͼ����빺�ﳵ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2bean2(request, new Book());
		//���ﳵ����������Cart��session�б���
		//��ȡ���ﳵ
		Cart cart = WebUtils.getCart(request);
		Book one = bs.getOne(book);
		cart.addBook2Cart(one);
		//��ͼ�����ɹ���ֻ��Ҫ���ز������ݣ���ǰ���ﳵͼ��������������
		//����Ҫ����������session�У�ֱ�ӷ��ؼ���
		//ֱ�ӷ��ؼ���
		
		//�����ݻ��͸����������ǰ���ﳵͼ��������������
		//��ǰ���ﳵ�����е��������
		int totalCount = cart.getTotalCount();
		//��ȡ�ղ���ӵ�ͼ�������
		String title = one.getTitle();
		//Ϊ��js�������㣬дjson��ʽ����
		//�����������ݷ�װ�����������תΪjson�ַ���
		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("title", title);
		//��mapתΪjson�ַ���
		Gson gson = new Gson();
		String json = gson.toJson(map);
		//��json�ַ���д�������
		response.getWriter().write(json);
		
	}
	
	

}
