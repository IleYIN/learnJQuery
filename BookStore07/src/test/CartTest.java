package test;

import java.math.BigDecimal;

import org.junit.Test;

import bean.Book;
import bean.Cart;

public class CartTest {
	
	Book book1 = new Book(1,"书名1","作者1",12.6, 100,100,"");
	Book book2 = new Book(2,"书名2","作者2",12.2, 100,100,"");
	Book book3 = new Book(3,"书名3","作者3",12.5, 100,100,"");
	Book book4 = new Book(4,"书名4","作者4",12.9, 100,100,"");
	Book book5 = new Book(5,"书名5","作者5",12.7, 100,100,"");
	@Test
	public void test1() {
		Cart cart = new Cart();
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book2);
		cart.addBook2Cart(book3);
		System.out.println("当前总计"+cart.getTotalCount()+"本书");
		System.out.println("当前总价"+cart.getTotalMoney());
		System.out.println("当前购物车中的项目"+cart.getAllItems());
		
		System.out.println("删除之后。。");
		cart.deleteItem(book1.getId().toString());
		System.out.println("当前总计"+cart.getTotalCount()+"本书");
		System.out.println("当前总价"+cart.getTotalMoney());
		System.out.println("当前购物车中的项目"+cart.getAllItems());

		System.out.println("修改之后。。");
		cart.updateCount(book2.getId().toString(), "3");
		System.out.println("当前总计"+cart.getTotalCount()+"本书");
		System.out.println("当前总价"+cart.getTotalMoney());
		System.out.println("当前购物车中的项目"+cart.getAllItems());
	}
	
	@Test
	public void test2() {
		//大整数运算问题
		int i=1;
		for(int j=1;j<21;j++) {
			i*=j;
		}
		System.out.println(i);
		
		//浮点数运算问题
		double a=0.01, b=0.06;
		System.out.println(a+b);
		
		//解决运算精度问题BigDecimal
		BigDecimal bigDecimal = new BigDecimal(1); 
		for(int j=1;j<21;j++) {
			bigDecimal = bigDecimal.multiply(new BigDecimal(j));
		}
		System.out.println(bigDecimal);
		
		BigDecimal a2 = new BigDecimal(a+"");
		BigDecimal b2 = new BigDecimal(b+"");
		System.out.println(a2.add(b2));
	}
}
