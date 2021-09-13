package bean;

import java.sql.Timestamp;

public class Order {

	private String orderId;//������ ��Ϊ����
//	private LocalDate createDate;//��������
	private Timestamp createDate;//��������
	private int status;//����״̬ 0 δ���� 1 �ѷ��� 2 �������
	private double totalMoney;//�����ܶ�
	private Integer userId;//�������û�
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
