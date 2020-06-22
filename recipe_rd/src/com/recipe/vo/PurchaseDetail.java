package com.recipe.vo;

public class PurchaseDetail {
	private int purchaseCode; //구매코드
	private int purchaseDetailQuantity; //구매수량
	private RecipeInfo recipeInfo; //레시피정보
	
	public PurchaseDetail() {}
	public PurchaseDetail(int purchaseCode, int purchaseDetailQuantity, RecipeInfo recipeInfo) {
		super();
		this.purchaseCode = purchaseCode;
		this.purchaseDetailQuantity = purchaseDetailQuantity;
		this.recipeInfo = recipeInfo;
	}
	public int getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(int purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public int getPurchaseDetailQuantity() {
		return purchaseDetailQuantity;
	}
	public void setPurchaseDetailQuantity(int purchaseDetailQuantity) {
		this.purchaseDetailQuantity = purchaseDetailQuantity;
	}
	public RecipeInfo getRecipeInfo() {
		return recipeInfo;
	}
	public void setRecipeInfo(RecipeInfo recipeInfo) {
		this.recipeInfo = recipeInfo;
	}
	@Override
	public String toString() {
		return "PurchaseDetail [purchaseCode=" + purchaseCode + ", purchaseDetailQuantity=" + purchaseDetailQuantity
				+ ", recipeInfo=" + recipeInfo + "]";
	}
	
	
}
