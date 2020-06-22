package com.recipe.vo;

public class Point {
	int recipeCode; //레시피코드
	int likeCount; //좋아요개수
	int disLikeCount; //싫어요개수
	
	public Point() {}

	public Point(int recipeCode, int likeCount, int disLikeCount) {
		super();
		this.recipeCode = recipeCode;
		this.likeCount = likeCount;
		this.disLikeCount = disLikeCount;
	}

	public int getRecipeCode() {
		return recipeCode;
	}

	public void setRecipeCode(int recipeCode) {
		this.recipeCode = recipeCode;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getDisLikeCount() {
		return disLikeCount;
	}

	public void setDisLikeCount(int disLikeCount) {
		this.disLikeCount = disLikeCount;
	}

	@Override
	public String toString() {
		return "Point [recipeCode=" + recipeCode + ", likeCount=" + likeCount + ", disLikeCount=" + disLikeCount + "]";
	}
	
}
