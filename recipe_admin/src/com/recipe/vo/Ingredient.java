package com.recipe.vo;

public class Ingredient {
	private int ingCode; //재료코드
	private String ingName; //재료이름
	
	public Ingredient() {}

	public Ingredient(int ingCode, String ingName) {
		super();
		this.ingCode = ingCode;
		this.ingName = ingName;
	}

	public int getIngCode() {
		return ingCode;
	}

	public void setIngCode(int ingCode) {
		this.ingCode = ingCode;
	}

	public String getIngName() {
		return ingName;
	}

	public void setIngName(String ingName) {
		this.ingName = ingName;
	}

	@Override
	public String toString() {
		return "Ingredient [ingCode=" + ingCode + ", ingName=" + ingName + "]";
	}
	
}
