package com.recipe.vo;

import java.util.List;

public class RecipeInfo {
	private int recipeCode; //레시피코드
	private String recipeName; //레시피이름
	private String recipeSumm; //레시피요약
	private double recipePrice; //레시피가격
	private String recipeProcess; //레시피조리과정
	private Point point; //좋아요
	private List<RecipeIngredient> ingredients; //레시피재료
	
	public RecipeInfo() {}

	public RecipeInfo(int recipeCode, String recipeName, String recipeSumm, double recipePrice, String recipeProcess,
			Point point, List<RecipeIngredient> ingredients) {
		super();
		this.recipeCode = recipeCode;
		this.recipeName = recipeName;
		this.recipeSumm = recipeSumm;
		this.recipePrice = recipePrice;
		this.recipeProcess = recipeProcess;
		this.point = point;
		this.ingredients = ingredients;
	}

	public int getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getRecipeSumm() {
		return recipeSumm;
	}

	public void setRecipeSumm(String recipeSumm) {
		this.recipeSumm = recipeSumm;
	}

	public double getRecipePrice() {
		return recipePrice;
	}

	public void setRecipePrice(double recipePrice) {
		this.recipePrice = recipePrice;
	}

	public String getRecipeProcess() {
		return recipeProcess;
	}

	public void setRecipeProcess(String recipeProcess) {
		this.recipeProcess = recipeProcess;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "RecipeInfo [recipeCode=" + recipeCode + ", recipeName=" + recipeName + ", recipeSumm=" + recipeSumm
				+ ", recipePrice=" + recipePrice + ", recipeProcess=" + recipeProcess + ", point=" + point
				+ ", ingredients=" + ingredients + "]";
	}
	
}
