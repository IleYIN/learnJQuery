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
		//���ﳵ����������Cart��sesion�б���
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

	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ﳵ
		Cart cart = WebUtils.getCart(request);
		cart.clear();
		//����cart.jsp
		String refer = request.getHeader("referer");
		response.sendRedirect(refer);
	}

}
