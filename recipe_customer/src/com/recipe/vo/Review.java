package com.recipe.vo;
import java.util.Date;

public class Review {
	private String customerId; //고객아이디
	private String reviewComment; //후기내용
	private Date reviewDate; //후기작성일자
	private RecipeInfo recipeInfo; //레시피정보
	
	public Review() {}

	public Review(String customerId, String reviewComment, Date reviewDate, RecipeInfo recipeInfo) {
		super();
		this.customerId = customerId;
		this.reviewComment = reviewComment;
		this.reviewDate = reviewDate;
		this.recipeInfo = recipeInfo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public RecipeInfo getRecipeInfo() {
		return recipeInfo;
	}

	public void setRecipeInfo(RecipeInfo recipeInfo) {
		this.recipeInfo = recipeInfo;
	}

	@Override
	public String toString() {
		return "Review [customerId=" + customerId + ", reviewComment=" + reviewComment + ", reviewDate=" + reviewDate
				+ ", recipeInfo=" + recipeInfo + "]";
	}
	
}
