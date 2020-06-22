package com.recipe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.recipe.jdbc.MyConnection;
import com.recipe.vo.Review;

/**
 * @author Soojeong
 *
 */
public class ReviewDAO {
	
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewDAO dao = new ReviewDAO();
		
		try {
			con = MyConnection.getConnection();
			con.setAutoCommit(false); // 자동커밋해제
			// test method 호출
			// dao.insert(new Favorite());
			// dao.selectById(customerId);
			// dao.deleteByIdnCode(null);
			
			con.commit(); // 롤백 커밋 꼭하기!
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
	}//end method main();
	
	//레시피후기목록조회
	public List<Review> selectByCode(int recipeCode) {
		return null;
	}

	//나의 후기 등록
	public void insert(Review r) {
		
	}

	//나의 후기 삭제
	public void deleteByIdnCode(Review r ) {
		
	}
	
	//나의 후기 목록 보기
	public List<Review> selectById(String customerId) {
		return null;
	}
} //end class ReviewDAO
