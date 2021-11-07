package i18n;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestI18n {
	@Test
	public void test() {
		//获取默认区域信息zh_CN en_US
		//一个Locale 语言_国家
		/**
		 * 	应用是判断用户是从哪个国家来 request中封装
		 * 	可以通过request对象来动态获取用户的区域信息
		 * 	Locale locale = request.getLocale()
		 */
		Locale default1 = Locale.getDefault();
		System.out.println(default1);
		System.out.println(Locale.US);
		
		DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL,Locale.US);
		DateFormat dateInstance1 = DateFormat.getDateInstance(DateFormat.LONG,Locale.US);
		DateFormat dateInstance2 = DateFormat.getDateInstance(DateFormat.MEDIUM,Locale.US);
		DateFormat dateInstance3 = DateFormat.getDateInstance(DateFormat.SHORT,Locale.US);
		DateFormat dateInstance4 = DateFormat.getDateInstance(DateFormat.DEFAULT,Locale.US);
		String format = dateInstance.format(new Date());
		String format1 = dateInstance1.format(new Date());
		String format2 = dateInstance2.format(new Date());
		String format3 = dateInstance3.format(new Date());
		String format4 = dateInstance4.format(new Date());
		System.out.println(format);
		System.out.println(format1);
		System.out.println(format2);
		System.out.println(format3);
		System.out.println(format4);
	}
	
	@Test
	public void test2() {
		//写资源文件 ResourceBundle来管理的，可以根据不同国家获取不同的值
		//.properties 文件名：基础名_语言_国家.properties
		// i18n_zh_CN.properties
		// i18n_en_US.properties
		//将要显示的信息放在这些文件中，然后通过文件动态获取。这些文件放在类路径下(src)
		ResourceBundle resource1 = ResourceBundle.getBundle("i18n",Locale.CHINA);
		ResourceBundle resource2 = ResourceBundle.getBundle("i18n",Locale.US);
		String string1 = resource1.getString("login");
		String string2 = resource2.getString("login");
		System.out.println(string1);
		System.out.println(string2);
		
		Locale locale = new Locale("zh_CN");
		System.out.println(locale);
		
		Locale locale2 = new Locale("zh","CN");
		System.out.println(locale2);
	}
}
