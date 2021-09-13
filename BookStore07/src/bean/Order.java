package bean;

import java.sql.Timestamp;

public class Order {

	private String orderId;//订单号 作为主键
//	private LocalDate createDate;//创建日期
	private Timestamp createDate;//创建日期
	private int status;//订单状态 0 未发货 1 已发货 2 交易完成
	private double totalMoney;//订单总额
	private Integer userId;//关联的用户
	public Order() {
	}
	public Order(String orderId, Timestamp createDate, int status, double totalMoney, Integer userId) {
		super();
		this.orderId = orderId;
		this.createDate = createDate;
		this.status = status;
		this.totalMoney = totalMoney;
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp todayLocalDate) {
		this.createDate = todayLocalDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", createDate=" + createDate + ", status=" + status + ", totalMoney="
				+ totalMoney + ", userId=" + userId + "]";
	}
	
}
