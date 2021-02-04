package com.wipro.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wipro.banking.bean.ManagerBean;
import com.wipro.banking.util.DBUtil;

public class AdminDAO {

	public int insertManager(ManagerBean bean) {

		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "insert into manager values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,bean.getEid());
			preparedStatement.setString(2,bean.getPassword());
			preparedStatement.setString(3,bean.getBranch());
			preparedStatement.setString(4,bean.getIfsc());
			
			count = preparedStatement.executeUpdate();
		}catch (Exception e) {
			
		}
		return count;
	}

	public int modifyManager(String eid, String branch, String ifsc) {
		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "update manager set branch=?,ifsc=? where eid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,branch);
			preparedStatement.setString(2,ifsc);
			preparedStatement.setString(3,eid);
			
			count = preparedStatement.executeUpdate();
		}catch (Exception e) {
			
		}
		return count;
		
		
	}

	public int deleteManager(String eid) {
		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "delete from manager where eid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,eid);
			
			count = preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public ArrayList<ManagerBean> viewManager(ArrayList<ManagerBean> arr) {

		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select eid,branch,ifsc from manager";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				String eid = rs.getString("eid");
				String branch = rs.getString("branch");
				String ifsc = rs.getString("ifsc");
				
				arr.add(new ManagerBean(eid,branch,ifsc));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public ArrayList<ManagerBean> searchManager(ArrayList<ManagerBean> arr, String eid) {

		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select eid,branch,ifsc from manager where eid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1,eid);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				String eid1 = rs.getString("eid");
				String branch = rs.getString("branch");
				String ifsc = rs.getString("ifsc");
				
				arr.add(new ManagerBean(eid1,branch,ifsc));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

}
