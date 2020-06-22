package com.recipe.vo;

public class Favorite {
	private String customerId; //고객ID
	private RecipeInfo recipeInfo; //레시피정보
	
	public Favorite() {}
	public Favorite(String customerId, RecipeInfo recipeInfo) {
		super();
		this.customerId = customerId;
		this.recipeInfo = recipeInfo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public RecipeInfo getRecipeInfo() {
		return recipeInfo;
	}

	public void setRecipeInfo(RecipeInfo recipeInfo) {
		this.recipeInfo = recipeInfo;
	}
	@Override
	public String toString() {
		return "Favorite [customerId=" + customerId + ", recipeInfo=" + recipeInfo + "]";
	}
	
}
