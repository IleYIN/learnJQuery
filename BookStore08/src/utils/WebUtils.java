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
 * web����ع���
 *
 */
public class WebUtils {
	/**
	 * 	����request����request�е����ݷ�װ�ɶ���
	 * @param <T>
	 * @param request
	 * @param t
	 * @return
	 */
	public static<T> T param2bean(HttpServletRequest request, T t) {
		//1.��ȡ��������������
		Field[] fields = t.getClass().getDeclaredFields();
		for (Field field : fields) {
			//��ȡ������
			String name = field.getName();
			//��request�л�ȡ��Ӧ������ֵ
			String value = request.getParameter(name);
			//��װ����
			try {
				BeanUtils.setProperty(t, name, value);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	
	public static<T> T param2bean2(HttpServletRequest request, T t) {
		
		//populate��map�еļ�ֵ��ֱ��ӳ�䵽javaBean��
		Map parameterMap = request.getParameterMap();
		try {
			BeanUtils.populate(t, parameterMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static Cart getCart(HttpServletRequest request) {
		//��ȡ���ﳵ
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart==null) {
			cart = new Cart(); 
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	public static User getLoginUser(HttpServletRequest request) {
		//��֤�û��Ƿ��¼
		HttpSession session = request.getSession();
		//ȡ��session�е��û�
		User loginUser = (User) session.getAttribute("user");
		return loginUser;
	}
}
