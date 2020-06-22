package com.recipe.vo;
import java.util.Date;

public class Purchase {
	private int purchaseCode; //구매코드
	private String customerId; //고객ID
	private Date purchaseDate; //구매일자
	private PurchaseDetail purchaseDetail; //구매상세내역
	
	public Purchase() {}

	public Purchase(int purchaseCode, String customerId, Date purchaseDate, PurchaseDetail purchaseDetail) {
		super();
		this.purchaseCode = purchaseCode;
		this.customerId = customerId;
		this.purchaseDate = purchaseDate;
		this.purchaseDetail = purchaseDetail;
	}

	public int getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(int purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PurchaseDetail getPurchaseDetail() {
		return purchaseDetail;
	}

	public void setPurchaseDetail(PurchaseDetail purchaseDetail) {
		this.purchaseDetail = purchaseDetail;
	}

	@Override
	public String toString() {
		return "Purchase [purchaseCode=" + purchaseCode + ", customerId=" + customerId + ", purchaseDate="
				+ purchaseDate + ", purchaseDetail=" + purchaseDetail + "]";
	}
	
}
