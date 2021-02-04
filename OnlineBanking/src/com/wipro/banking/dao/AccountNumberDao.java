package com.wipro.banking.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.wipro.banking.bean.AccountNumberBean;
import com.wipro.banking.util.DBUtil;

public class AccountNumberDao {
	
	int insertAccountNumber(AccountNumberBean bean)
	{
		try {
			Connection connection = DBUtil.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getClass().getName());
		}
		return 0;

	}

}
