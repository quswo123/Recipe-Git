package com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.recipe.exception.AddException;
import com.recipe.exception.FindException;
import com.recipe.jdbc.MyConnection;
import com.recipe.vo.Customer;
import com.recipe.vo.Purchase;
import com.recipe.vo.PurchaseDetail;
import com.recipe.vo.RecipeInfo;
import com.recipe.vo.Review;

public class PurchaseDAO {
	/**
	 * 나의 구매내역 보기 및 상세보기
	 * @param customerId
	 * @return list
	 * @throws FindException
	 */
	public List<Purchase> selectById(String customerId) throws FindException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Purchase> list = new ArrayList<>();
		
		try {
			con = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String detailSQL = "select \r\n" + 
				"    p.purchase_date,\r\n" + 
				"    pd.purchase_quantity,\r\n" + 
				"    r.review_comment,\r\n" + 
				"    i.recipe_code,\r\n" + 
				"    i.recipe_name,\r\n" + 
				"    i.recipe_summ,\r\n" + 
				"    i.recipe_price,\r\n" + 
				"    i.recipe_process\r\n" + 
				" from\r\n" + 
				"    purchase p\r\n" + 
				"    join purchase_detail pd on ( p.purchase_code = pd.purchase_code)\r\n" + 
				"    left join review r on ( p.customer_id = r.customer_id and pd.recipe_code = r.recipe_code)\r\n" + 
				"    join recipe_info i on( pd.recipe_code = i.recipe_code ) where p.customer_id=?";
		try {
			ps = con.prepareStatement(detailSQL);
			ps.setString(1,customerId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Purchase p = new Purchase();
				RecipeInfo r = new RecipeInfo();
				PurchaseDetail pd = new PurchaseDetail();
				
				r.setRecipeCode(rs.getInt("recipe_code"));
				r.setRecipeName(rs.getString("recipe_name"));
				r.setRecipeSumm(rs.getString("recipe_summ"));
				r.setRecipePrice(rs.getDouble("recipe_price"));
				r.setRecipeProcess(rs.getString("recipe_process"));
				pd.setRecipeInfo(r);
				
				pd.setPurchaseDetailQuantity(rs.getInt("purchase_quantity"));
				p.setPurchaseDetail(pd);
				
				p.setPurchaseDate(rs.getDate("purchase_date"));
				
				list.add(p);
			}
			if(list.size()==0) {
				throw new FindException("구매내역이 없습니다");
			}
			
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, ps, con);
		}
	}
	
	
	/**
	 * 나의 구매하기
	 * @param p
	 */
	public void insert(Purchase p) throws AddException{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String insertSQL="INSERT INTO PURCHASE VALUES (PURCHASE_SEQ.NEXTVAL,?,SYSDATE)";
		String insertSQL2="INSERT INTO PURCHASE_DETAIL VALUES(PURCHASE_SEQ.CURRVAL,?,?)";
		
		try {
			ps = con.prepareStatement(insertSQL);
			ps = con.prepareStatement(insertSQL2);
			
			ps.setString(1, p.getCustomerId());
			
			ps.setInt(2, p.getPurchaseDetail().getRecipeInfo().getRecipeCode());
			ps.setInt(3, p.getPurchaseDetail().getPurchaseDetailQuantity());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			MyConnection.close(ps, con);
		}
	}
	
	
	public static void main(String[] args) {
		PurchaseDAO d = new PurchaseDAO();
		try {
			List<Purchase> list = d.selectById("tester");
			for(Purchase pp : list) {
				System.out.println(pp.getPurchaseDate());
				System.out.println(pp.getPurchaseDetail().getPurchaseDetailQuantity());
				System.out.println(pp.getPurchaseDetail().getRecipeInfo().getRecipeName());
			}
			
		} catch (FindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
