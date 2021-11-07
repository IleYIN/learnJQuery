package listener.attribute;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("request域中添加属性...");
		//属性名
		String name = srae.getName();
		//属性值
		Object value = srae.getValue();
		System.out.println("key:"+name+",value:"+value);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("request域中移除属性...");
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("key:"+name+",value:"+value);
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request域中替换属性...");
		//修改前的属性值
		String name = srae.getName();
		Object value = srae.getValue();
		System.out.println("key:"+name+",value:"+value);
		//修改后的属性值
		ServletRequest request = srae.getServletRequest();
		Object attribute = request.getAttribute(name);
		System.out.println("newValue:"+attribute);
	}

}
