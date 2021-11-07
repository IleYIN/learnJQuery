package bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *	购物项 
 *
 */
public class CartItem implements Serializable {
	private static final long serialVersionUID = 1L;
	//代表当前买的是哪本图书
	private Book book;
	//购买数量
	private int count;
	//总金额
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
