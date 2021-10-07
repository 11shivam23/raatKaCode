//package com.examly.spring.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="user")
//public class OrderModel {
//	@Id
//	@Column(name="order_Id")
//	private String orderId;
//	
//	@Column(name="user_id")
//	private String userId;
//	
//	@Column(name="product_name")
// 	private String productName;
//	
//	@Column(name="qunatity")
//	private int quantity;
//	
//	@Column(name="total_price")
//	private String totalPrice;
//	
//	@Column(name="status")
//	private String status;
//	
//	@Column(name="price")
//	private String price;
//	
//	public OrderModel() {
//		
//	}
//	
//	public OrderModel(String orderId, String userId, String productName, int quantity, String totalPrice, String status,
//			String price) {
//		super();
//		this.orderId = orderId;
//		this.userId = userId;
//		this.productName = productName;
//		this.quantity = quantity;
//		this.totalPrice = totalPrice;
//		this.status = status;
//		this.price = price;
//	}
//	
//	public String getOrderId() {
//		return orderId;
//	}
//	public void setOrderId(String orderId) {
//		this.orderId = orderId;
//	}
//	public String getUserId() {
//		return userId;
//	}
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}
//	public String getProductName() {
//		return productName;
//	}
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public String getTotalPrice() {
//		return totalPrice;
//	}
//	public void setTotalPrice(String totalPrice) {
//		this.totalPrice = totalPrice;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
//	public String getPrice() {
//		return price;
//	}
//	public void setPrice(String price) {
//		this.price = price;
//	}
//	
//	
//}
