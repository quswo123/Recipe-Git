package com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.recipe.jdbc.MyConnection;
import com.recipe.vo.RecipeInfo;
import com.recipe.vo.Review;
/**
 * @author Soojeong
 *
 */
public class ReviewDAO {
	
	public static void main(String[] args) {
		//test_review_selectByCode();
		test_review_selectById();
		//test_review_insert();
	}//end method main();
	
	
	/**
	 * 레시피후기목록조회
	 * @param int recipeCode
	 * @return List<Review>
	 */
	public List<Review> selectByCode(int recipeCode) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Review> reviewList = null;

		String selectSQL = "SELECT * "
				+ "	FROM REVIEW "
				+ " WHERE RECIPE_CODE = ? ";
		
		try {
			con = MyConnection.getConnection();
			
		} catch (ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}
		
		try {
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setInt(1, recipeCode);
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<>();
			
			while ( rs.next() ) {
				Review r = new Review();
				r.setCustomerId(rs.getString("CUSTOMER_ID"));
				r.setReviewComment(rs.getString("REVIEW_COMMENT"));
				r.setReviewDate(rs.getDate("REVIEW_DATE"));

				RecipeInfo info = new RecipeInfo();
				info.setRecipeCode(rs.getInt("RECIPE_CODE"));
				r.setRecipeInfo(info);
				
				reviewList.add(r);
			} //end while
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
		return reviewList;
	} // end method selectByCode();

	
	/**
	 * 나의 후기 등록
	 * @param Review r
	 */
	public void insert(Review r) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String insertSQL = "INSERT INTO REVIEW(customer_id,recipe_code,review_comment,review_date)"
				+ " values (?,?,?,sysdate)"; 
		
		try {
			con = MyConnection.getConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.getStackTrace();
		}
		
		try {
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, r.getCustomerId());
			pstmt.setInt(2, r.getRecipeInfo().getRecipeCode());
			pstmt.setString(3, r.getReviewComment());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			MyConnection.close(pstmt, con);
		}
		
	} // end method insert();

	/**
	 * 나의 후기 목록 보기
	 * @param String customerId
	 * @return List<Review>
	 */
	public List<Review> selectById(String customerId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Review> reviewList = null;
		
		try {
			con = MyConnection.getConnection();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.getStackTrace();
			
		}
		
		String selectSQL = "SELECT CUSTOMER_ID, REVIEW_COMMENT, REVIEW_DATE, RECIPE_CODE "
				+ "FROM REVIEW " 
				+ "WHERE CUSTOMER_ID = ?";

		try {
			pstmt = con.prepareStatement(selectSQL);
			pstmt.setString(1, customerId);
			rs = pstmt.executeQuery();
			reviewList = new ArrayList<>();
			
			while ( rs.next() ) {
				Review r = new Review();
				r.setCustomerId(rs.getString("CUSTOMER_ID"));
				r.setReviewComment(rs.getString("REVIEW_COMMENT"));
				r.setReviewDate(rs.getDate("REVIEW_DATE"));

				RecipeInfo info = new RecipeInfo();
				info.setRecipeCode(rs.getInt("RECIPE_CODE"));
				r.setRecipeInfo(info);
				
				reviewList.add(r);
			} //end while
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		return reviewList;
	} // end method selectById();
	
	
	// test_review_selectByCode
	private static void test_review_selectByCode() {
		ReviewDAO dao = new ReviewDAO();
		int recipeCode = 134;
		
		List <Review> reviewList = new ArrayList<>();
		
		try {
			reviewList = dao.selectByCode(recipeCode);
			
			if ( reviewList.size() == 0 ) {
				System.out.println("후기 목록 조회 결과 : 등록된 후기 목록이 없습니다.");
			} 
			
			for ( Review r  : reviewList ) {
				System.out.println("recipeCode: " + r.getRecipeInfo().getRecipeCode());
				System.out.println("customer_ID : " + r.getCustomerId());
				System.out.println("reviewComment : " + r.getReviewComment());
				System.out.println("reviewDate : " + r.getReviewDate());
			}
		} catch ( Exception e ) {
			e.getStackTrace();
		}
	} //end test method 
	
	// test_review_selectByCode
	private static void test_review_selectById() {
		ReviewDAO dao = new ReviewDAO();
		String customerId = "tester";
		List <Review> reviewList = new ArrayList<>();

		try {
			reviewList = dao.selectById(customerId);

			if ( reviewList.size() == 0 ) {
				System.out.println("후기 목록 조회 결과 : 등록된 후기 목록이 없습니다.");
			} 
			
			for ( Review r  : reviewList ) {
				System.out.println("recipeCode: " + r.getRecipeInfo().getRecipeCode());
				System.out.println("customer_ID : " + r.getCustomerId());
				System.out.println("reviewComment : " + r.getReviewComment());
				System.out.println("reviewDate : " + r.getReviewDate());
			}
			
		} catch (Exception e) { 
			e.getStackTrace();
		}
	} //end test method 
	
	// test_review_selectByCode
	private static void test_review_insert() {
		ReviewDAO dao = new ReviewDAO();

		String customerId = "tester";
		String reviewComment = "나물비빔밥 최고에요!";
		int recipeCode = 2;
		
		RecipeInfo info = new RecipeInfo();
		info.setRecipeCode(recipeCode);
		
		Review r = new Review();
		r.setCustomerId(customerId);
		r.setReviewComment(reviewComment);
		r.setRecipeInfo(info);
		
		try {
			dao.insert(r);
			System.out.println("Success : 후기 등록에 성공하였습니다.");
		} catch (Exception e) { 
			System.out.println("Fail : 후기 등록에 실패하였습니다.");
			e.getStackTrace();
		}
	} //end test method 
	
} //end class ReviewDAO
