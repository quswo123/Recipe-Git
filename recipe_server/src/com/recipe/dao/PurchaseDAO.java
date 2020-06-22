package com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
	 * @param 현재 사용자의 ID를 받아온다
	 * @return 구매리스트 반환
	 * @throws 오류발생시 findException처리
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
		//나의 구매내역을 가져오는 query문
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
			
			//현재 아이디를 받아온다
			ps.setString(1,customerId);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				Purchase p = new Purchase();
				RecipeInfo r = new RecipeInfo();
				PurchaseDetail pd = new PurchaseDetail();
				
				//레시피정보 가져오기
				r.setRecipeCode(rs.getInt("recipe_code"));
				r.setRecipeName(rs.getString("recipe_name"));
				r.setRecipeSumm(rs.getString("recipe_summ"));
				r.setRecipePrice(rs.getDouble("recipe_price"));
				r.setRecipeProcess(rs.getString("recipe_process"));
				
				//Purchasedetail에 recipeInfo담아
				pd.setRecipeInfo(r);
				pd.setPurchaseDetailQuantity(rs.getInt("purchase_quantity"));
				
				//Purchase에 Purchasedetail담고
				p.setPurchaseDetail(pd);
				p.setPurchaseDate(rs.getDate("purchase_date"));
				
				//Purchase list에 담는다
				list.add(p);
			}
			//list가 0일때 예외발생(목록이 없습니다)
			if(list.size()==0) {
				throw new FindException("구매내역이 없습니다");
			}
			
			//purchase list 반환
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
	 * @param 구매테이블에 추가
	 * purchase테이블에 시퀀스를 생성하여 purchase_code는 자동으로 1씩 증가
	 */
	public void insert(Purchase p) throws AddException{
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		//purchase테이블에서 추가
		String insertSQL="INSERT INTO PURCHASE VALUES (PURCHASE_SEQ.NEXTVAL,?,SYSDATE)";
		//purchaseDetail에서 현재 시퀀스로 받아 추가
		String insertSQL2="INSERT INTO PURCHASE_DETAIL VALUES(PURCHASE_SEQ.CURRVAL,?,?)";
		
		try {
			ps = con.prepareStatement(insertSQL);
			
			//현재 사용자ID를 추가
			ps.setString(1, p.getCustomerId());
			
			ps.executeUpdate();
			
			//위 쿼리문을 PurchaseDetail에 추가
			ps = con.prepareStatement(insertSQL2);
			
			ps.setInt(1, p.getPurchaseDetail().getRecipeInfo().getRecipeCode());
			ps.setInt(2, p.getPurchaseDetail().getPurchaseDetailQuantity());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			MyConnection.close(ps, con);
		}
	}
	
}
