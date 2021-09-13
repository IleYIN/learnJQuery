package bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *	������ 
 *
 */
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//����ǰ������ı�ͼ��
	private Book book;
	//��������
	private int count;
	//�ܽ��
	private double totalPrice;
	public CartItem() {
	}
	
	public CartItem(Book book, int count, double totalPrice) {
		super();
		this.book = book;
		this.count = count;
		this.totalPrice = totalPrice;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public double getTotalPrice() {
		BigDecimal price = new BigDecimal(getBook().getPrice()+"");
		BigDecimal count = new BigDecimal(getCount());
		return price.multiply(count).doubleValue();
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", totalPrice=" + totalPrice + "]";
	}
	
}
