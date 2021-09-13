package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import bean.Cart;
import bean.User;

/**
 * 
 * web的相关工具
 *
 */
public class WebUtils {
	/**
	 * 	传入request对象将request中的数据封装成对象
	 * @param <T>
	 * @param request
	 * @param t
	 * @return
	 */
	public static<T> T param2bean(HttpServletRequest request, T t) {
		//1.获取所有声明的属性
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			//获取属性名
			String name = field.getName();
			//在request中获取相应的属性值
			String value = request.getParameter(name);
			//封装对象
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	
	public static<T> T param2bean2(HttpServletRequest request, T t) {
		
		//populate将map中的键值对直接映射到javaBean中
		Map parameterMap = request.getParameterMap();
		try {
			BeanUtils.populate(t, parameterMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static Cart getCart(HttpServletRequest request) {
		//获取购物车
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null) {
			cart = new Cart(); 
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	public static User getLoginUser(HttpServletRequest request) {
		//验证用户是否登录
		HttpSession session = request.getSession();
		//取出session中的用户
		User loginUser = (User) session.getAttribute("user");
		return loginUser;
	}
}
