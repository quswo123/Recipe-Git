package com.recipe.vo;

public class Customer {
	private String customerId; //고객ID
	private String customerPwd; //고객비밀번호
	private String customerName; //고객이름
	private String customerEmail; //고객이메일
	private String customerPhone; //고객전화번호
	private Postal postal; //우편번호
	private String customerAddr; //고객상세주소
	
	public Customer() {}
	public Customer(String customerId, String customerPwd, String customerName, String customerEmail,
			String customerPhone, Postal postal, String customerAddr) {
		super();
		this.customerId = customerId;
		this.customerPwd = customerPwd;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.postal = postal;
		this.customerAddr = customerAddr;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerPwd() {
		return customerPwd;
	}
	public void setCustomerPwd(String customerPwd) {
		this.customerPwd = customerPwd;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public Postal getPostal() {
		return postal;
	}
	public void setPostal(Postal postal) {
		this.postal = postal;
	}
	public String getCustomerAddr() {
		return customerAddr;
	}
	public void setCustomerAddr(String customerAddr) {
		this.customerAddr = customerAddr;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerPwd=" + customerPwd + ", customerName=" + customerName
				+ ", customerEmail=" + customerEmail + ", customerPhone=" + customerPhone + ", postal=" + postal
				+ ", customerAddr=" + customerAddr + "]";
	}
	
}
