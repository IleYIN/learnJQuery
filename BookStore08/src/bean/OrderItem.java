package bean;

public class OrderItem {
	private Integer id;
	private String title;//���������
	private int count;//���������
	private double price;//ͼ��ĵ���
	private double totalPrice;//ͼ����ܼ�
	
	private String orderId;//�����ĸ�����
	public OrderItem() {
	}
	public Integer getId() {
		return id;
	}
	public OrderItem(String title, int count, double price, double totalPrice, String orderId) {
		super();
		this.title = title;
		this.count = count;
		this.price = price;
		this.totalPrice = totalPrice;
		this.orderId = orderId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", title=" + title + ", count=" + count + ", price=" + price + ", totalPrice="
				+ totalPrice + ", orderId=" + orderId + "]";
	}
}
