package com.recipe.service;

import java.util.ArrayList;
import java.util.List;

import com.recipe.dao.PurchaseDAO;
import com.recipe.exception.AddException;
import com.recipe.exception.FindException;
import com.recipe.vo.Purchase;
import com.recipe.vo.Review;

public class PurchaseService {
	PurchaseDAO dao = new PurchaseDAO();
	
	public void buy(Purchase p)  throws AddException{
		dao.insert(p);
	}
	
	
	public List<Purchase> findById(String customerId) throws FindException{
		List<Purchase> list = new ArrayList<>();
		list = dao.selectById(customerId);
		
		return list;
	}

}
