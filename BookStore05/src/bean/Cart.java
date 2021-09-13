package bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *	购物车 实现Serializable钝化
 */
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	private Map<Integer,CartItem> items = new LinkedHashMap<>();
	//总商品数
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	public int getTotalCount() {
		List<CartItem> list = getAllItems();
		int count = 0;
		for(CartItem cartItem : list) {
			count += cartItem.getCount();
		}
		return count;
	}
	public double getTotalMoney() {
		List<CartItem> list = getAllItems();
		//double money = 0.0;
		BigDecimal money = new BigDecimal(0.0+"");
		for(CartItem cartItem : list) {
			//money += cartItem.getTotalPrice();
			BigDecimal totalPrice = new BigDecimal(cartItem.getTotalPrice()+"");
			money = money.add(totalPrice);
		}
		return money.doubleValue();
	}
	public List<CartItem> getAllItems(){
		Collection<CartItem> values = items.values();
		return(new ArrayList<CartItem>(values));
	}
	
	//定义操作购物车的其它方法
	public void addBook2Cart(Book book) {
		CartItem item = items.get(book.getId());
		if(item==null) {
			item = new CartItem();
			item.setBook(book);
			item.setCount(1);
			items.put(book.getId(), item);
		} else {
			item.setCount(item.getCount()+1);
		}
	}
	
	public void deleteItem(String bookId) {
		int id = Integer.parseInt(bookId);
		items.remove(id);
	}

	public void updateCount(String bookId, String count) {
		int id = 0;
		int c = 1;
		try {
			c = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			id = Integer.parseInt(bookId);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		CartItem cartItem = items.get(id);
		if(cartItem!=null) {
			cartItem.setCount(c);
		}
	}
	
	public void clear() {
		items.clear();
	}
}
