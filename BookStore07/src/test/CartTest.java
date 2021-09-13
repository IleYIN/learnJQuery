package test;

import java.math.BigDecimal;

import org.junit.Test;

import bean.Book;
import bean.Cart;

public class CartTest {
	
	Book book1 = new Book(1,"����1","����1",12.6, 100,100,"");
	Book book2 = new Book(2,"����2","����2",12.2, 100,100,"");
	Book book3 = new Book(3,"����3","����3",12.5, 100,100,"");
	Book book4 = new Book(4,"����4","����4",12.9, 100,100,"");
	Book book5 = new Book(5,"����5","����5",12.7, 100,100,"");
	@Test
	public void test1() {
		Cart cart = new Cart();
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book2);
		cart.addBook2Cart(book3);
		System.out.println("��ǰ�ܼ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼ�"+cart.getTotalMoney());
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());
		
		System.out.println("ɾ��֮�󡣡�");
		cart.deleteItem(book1.getId().toString());
		System.out.println("��ǰ�ܼ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼ�"+cart.getTotalMoney());
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());

		System.out.println("�޸�֮�󡣡�");
		cart.updateCount(book2.getId().toString(), "3");
		System.out.println("��ǰ�ܼ�"+cart.getTotalCount()+"����");
		System.out.println("��ǰ�ܼ�"+cart.getTotalMoney());
		System.out.println("��ǰ���ﳵ�е���Ŀ"+cart.getAllItems());
	}
	
	@Test
	public void test2() {
		//��������������
		int i=1;
		for(int j=1;j<21;j++) {
			i*=j;
		}
		System.out.println(i);
		
		//��������������
		double a=0.01, b=0.06;
		System.out.println(a+b);
		
		//������㾫������BigDecimal
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
