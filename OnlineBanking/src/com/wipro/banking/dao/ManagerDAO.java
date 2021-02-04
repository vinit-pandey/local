package com.wipro.banking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.wipro.banking.bean.CustomerBean;
import com.wipro.banking.bean.ManagerBean;
import com.wipro.banking.util.DBUtil;

public class ManagerDAO {

	public ArrayList<CustomerBean> viewCustomer(ArrayList<CustomerBean> arr, String br) {

		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select uname,accno,branch,status from registration where status=? and branch=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, br);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			CustomerBean bean = new CustomerBean();
			
			
			while(rs.next())
			{
				String uname = rs.getString("uname");
				String accno = rs.getString("accno");
				String branch = rs.getString("branch");
				int status = rs.getInt("status");
				
				arr.add(new CustomerBean(uname,accno,branch,status));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}
	

	public void updateStatus(int status, String uname) {
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "update registration set status=? where uname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, status);
			preparedStatement.setString(2, uname);
			
			int c = preparedStatement.executeUpdate();

		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}


	public ArrayList<CustomerBean> approveRejectCustomer(ArrayList<CustomerBean> arr, String br) {
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select temp.uname,temp.accno,temp.branch,temp.status from (select uname,accno,branch,status from registration where "
					+ "branch=?)temp where temp.status=? or temp.status=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, br);
			preparedStatement.setInt(2, 2);
			preparedStatement.setInt(3, 3);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			CustomerBean bean = new CustomerBean();
			
			
			while(rs.next())
			{
				String uname = rs.getString("uname");
				String accno = rs.getString("accno");
				String branch = rs.getString("branch");
				int status = rs.getInt("status");
				
				arr.add(new CustomerBean(uname,accno,branch,status));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}


	public ArrayList<CustomerBean> searchCustomer(ArrayList<CustomerBean> arr, Date sd, Date ed) {
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select uname,accno,branch,status from registration where sdate between ? and ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setDate(1, sd);
			preparedStatement.setDate(2, ed);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			CustomerBean bean = new CustomerBean();
			
			
			while(rs.next())
			{
				String uname = rs.getString("uname");
				String accno = rs.getString("accno");
				String branch = rs.getString("branch");
				int status = rs.getInt("status");
				
				arr.add(new CustomerBean(uname,accno,branch,status));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}


	public boolean loginManager(String eid, String password) {
		boolean status = false;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select * from manager where eid=? and  password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, eid);
			preparedStatement.setString(2, password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status = rs.next();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}


	public int updateManager(String eid, String password) {

		int status=0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "update manager set password=? where eid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, eid);
			
			status = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}


	public String checkManager(String eid) {
		String status="";
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select password from manager where eid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			
			preparedStatement.setString(1, eid);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				status = rs.getString("password");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return status;

	}


	public ArrayList<CustomerBean> viewCustomerApp(ArrayList<CustomerBean> arr) {
		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select uname,accno,branch,status from registration where status=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, 1);
			
			
			ResultSet rs = preparedStatement.executeQuery();
			
			CustomerBean bean = new CustomerBean();
			
			
			while(rs.next())
			{
				String uname = rs.getString("uname");
				String accno = rs.getString("accno");
				String branch = rs.getString("branch");
				int status = rs.getInt("status");
				
				arr.add(new CustomerBean(uname,accno,branch,status));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}


	

}
