package com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.recipe.exception.FindException;
import com.recipe.jdbc.MyConnection;
import com.recipe.vo.Ingredient;
import com.recipe.vo.Point;
import com.recipe.vo.RecipeInfo;
import com.recipe.vo.RecipeIngredient;

public class RecipeInfoDAO {
	RecipeInfo selectByCode(int recipeCode) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MyConnection.getConnection();

		} catch (ClassNotFoundException | SQLException e) {

		}
		String selectByCodeSQL = "SELECT RI.RECIPE_CODE, RIN.RECIPE_NAME, RIN.RECIPE_SUMM, RIN.RECIPE_PRICE, RI.ing_code, ING.ING_NAME, RIN.recipe_process,PT.LIKE_COUNT, PT.DISLIKE_COUNT\r\n"
				+ "FROM RECIPE_INGREDIENT RI \r\n" + "LEFT JOIN RECIPE_INFO RIN ON RI.recipe_code = RIN.recipe_code\r\n"
				+ "JOIN INGREDIENT ING ON RI.ing_code = ING.ing_code\r\n"
				+ "JOIN POINT PT ON RI.RECIPE_CODE = PT.RECIPE_CODE\r\n" + "WHERE RI.recipe_code = ?";
		List<RecipeIngredient> ingList = new ArrayList<>();
		RecipeInfo recipeInfo = new RecipeInfo();
		int prevCode = 0; //
		try {
			pstmt = con.prepareStatement(selectByCodeSQL);
			pstmt.setInt(1, recipeCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int rCode = rs.getInt("recipe_code");
				int ingCode = rs.getInt("ing_code");
				String ingName = rs.getString("ing_name");
				Ingredient ingredient = new Ingredient(ingCode, ingName);
				RecipeIngredient recipeIng = new RecipeIngredient(ingredient);
				//와인문 돌때마다 재료코드, 이름 -> Ingredient 에 넣고 -> 리스트에 넣어주기
				ingList.add(recipeIng);
				//처음 와일문 돌때만 RecipeInfo에 값 넣어주기
				if (prevCode != rCode) {
					recipeInfo.setRecipeCode(rCode);
					recipeInfo.setRecipeName(rs.getString("recipe_name"));
					recipeInfo.setRecipePrice(rs.getInt("recipe_price"));
					recipeInfo.setRecipeSumm(rs.getString("recipe_summ"));
					recipeInfo.setRecipeProcess(rs.getString("recipe_process"));
					recipeInfo.setIngredients(ingList);
					Point pt = new Point(rCode, rs.getInt("like_count"), rs.getInt("dislike_count"));
					recipeInfo.setPoint(pt);
				}

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, con);
		}

		return recipeInfo;
	}
	List<RecipeInfo> selectByName(String recipeName) throws FindException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeInfo> recipeInfo = new ArrayList<>();
		try {
			con = MyConnection.getConnection();

		} catch (ClassNotFoundException | SQLException e) {
			throw new FindException(e.getMessage());
		}
		String selectByNameSQL = "SELECT RIN.Recipe_code,RIN.RECIPE_NAME, RIN.RECIPE_SUMM, RIN.RECIPE_PRICE, RI.ing_code, ING.ING_NAME, RIN.recipe_process,PT.LIKE_COUNT, PT.DISLIKE_COUNT\r\n" + 
				"FROM RECIPE_INGREDIENT RI \r\n" + 
				"LEFT JOIN RECIPE_INFO RIN ON RI.recipe_code = RIN.recipe_code\r\n" + 
				"LEFT JOIN INGREDIENT ING ON RI.ing_code = ING.ing_code\r\n" + 
				"LEFT JOIN POINT PT ON RIN.RECIPE_CODE = PT.RECIPE_CODE\r\n" + 
				"WHERE rin.recipe_name LIKE ?";
		try {
			pstmt = con.prepareStatement(selectByNameSQL);
			pstmt.setString(1, "%" + recipeName + "%");
			rs = pstmt.executeQuery();
			List<RecipeIngredient> ingList = null;	
			int prevCode = 0;
			while(rs.next()) {				
				int rCode = rs.getInt("recipe_code");
				//레시피코드가 다를때만 RecipeInfo 객체 생성해서 값 넣어주고 재료리스트 참조시키기				
				if (prevCode != rCode) {					
					RecipeInfo recipeInfo2 = new RecipeInfo();
					ingList = new ArrayList<>();
					recipeInfo2.setIngredients(ingList);
					recipeInfo2.setRecipeCode(rCode);
					recipeInfo2.setRecipeName(rs.getString("recipe_name"));
					recipeInfo2.setRecipePrice(rs.getInt("recipe_price"));
					recipeInfo2.setRecipeSumm(rs.getString("recipe_summ"));
					recipeInfo2.setRecipeProcess(rs.getString("recipe_process"));
					recipeInfo2.setIngredients(ingList);					
					Point pt = new Point(rCode, rs.getInt("like_count"), rs.getInt("dislike_count"));
					recipeInfo2.setPoint(pt);
					recipeInfo.add(recipeInfo2);
					//새로 객체 생성할때마다 전코드 값을 새로운값으로 대입해주기
					prevCode = rCode;
				}
				//와인문 돌때마다 재료코드, 이름 -> Ingredient 에 넣고 -> 리스트에 넣어주기
				int ingCode = rs.getInt("ing_code");
				String ingName = rs.getString("ing_name");
				Ingredient ingredient = new Ingredient(ingCode, ingName);
				RecipeIngredient recipeIng = new RecipeIngredient(ingredient);				
				ingList.add(recipeIng);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
		
		return recipeInfo;
	}
	
	public static void main(String[] args) {
		RecipeInfoDAO dao = new RecipeInfoDAO();
//		int code = 134;
//		try {
//			RecipeInfo list = dao.selectByCode(code);
//			System.out.println("code:" + list.getRecipeCode() + "  name:" + list.getRecipeName() + "  summ:"+ list.getRecipeSumm() +"  price:"+ list.getRecipePrice());
//			List<RecipeIngredient> lines = list.getIngredients();
//			Point pt = list.getPoint();
//			System.out.println("like" + pt.getLikeCount() + ":"+ "dislike" + pt.getDisLikeCount());
//			for(RecipeIngredient line : lines) {
//				System.out.print(line.getIngredient().getIngCode() + ":");
//				System.out.print(line.getIngredient().getIngName()+ ", ");
//			}
//		} catch (FindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		String name = "김치";
	
		try {
			List<RecipeInfo> list2 = dao.selectByName(name);
			for(RecipeInfo ri : list2) {
				System.out.println(ri.getRecipeCode() + ri.getRecipeName() + ri.getRecipePrice() + ri.getRecipeProcess() + ri.getRecipeSumm());
				List<RecipeIngredient> lines = ri.getIngredients();
				for(RecipeIngredient ing : lines) {
					System.out.println(ing.getIngredient().getIngName());
				}
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
