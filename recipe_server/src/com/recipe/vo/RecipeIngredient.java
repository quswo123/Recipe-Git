package com.recipe.vo;

public class RecipeIngredient {
	private Ingredient ingredient; //레시피재료정보
	
	public RecipeIngredient() {}

	public RecipeIngredient(Ingredient ingredient) {
		super();
		this.ingredient = ingredient;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "RecipeIngredient [ingredient=" + ingredient + "]";
	}
	
}
