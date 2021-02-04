package com.wipro.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.banking.bean.AccountNumberBean;
import com.wipro.banking.bean.BeneficiaryBean;
import com.wipro.banking.bean.CustomerBean;
import com.wipro.banking.bean.ManagerBean;
import com.wipro.banking.bean.MinistatementBean;
import com.wipro.banking.util.DBUtil;

public class CustomerDao {
	
	public int insertCustomer(CustomerBean bean)
	{
		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "insert into registration values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,bean.getUname());
			preparedStatement.setString(2,bean.getPassword());
			preparedStatement.setString(3,bean.getAccno());
			preparedStatement.setString(4,bean.getAddress());
			preparedStatement.setString(5,bean.getBranch());
			preparedStatement.setString(6,bean.getState());
			preparedStatement.setString(7,bean.getIfsc());
			preparedStatement.setDate(8,bean.getSdate());
			preparedStatement.setInt(9,5000);
			preparedStatement.setString(10,bean.getMobile());
			preparedStatement.setInt(11,1);
			
			count = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public int insertAccount(AccountNumberBean accountNumberBean) {
		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			String query = "insert into account values(?)";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,accountNumberBean.getAccno());
			count = preparedStatement.executeUpdate();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
		
	}

	public int checkStatus(String uname) {
		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			String query = "select status from registration where uname=?";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,uname);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
				count = rs.getInt("status");
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public boolean checkLogin(String uname, String password) {
		
		boolean status = false;
		try {
			Connection connection = DBUtil.getConnection();
			String query = "select * from registration where uname=? and password=?";
			
			
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,uname);
			preparedStatement.setString(2,password);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			status = rs.next();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}

	public int addBeneficiary(BeneficiaryBean bean) {

		int count = 0;
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "insert into beneficiary values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,bean.getBaacno());
			preparedStatement.setString(2,bean.getBname());
			preparedStatement.setString(3,bean.getBifsc());
			preparedStatement.setInt(4, 0);
			preparedStatement.setString(5,bean.getUname());
			
			count = preparedStatement.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public ArrayList<BeneficiaryBean> sendBeneficiary(ArrayList<BeneficiaryBean> arr, String uname) {

		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select baccno,bname from beneficiary where uname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, uname);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				String accno = rs.getString("baccno");
				String name = rs.getString("bname");
				
				arr.add(new BeneficiaryBean(accno,name));
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public int updateAmount(String uname, int amount) {

		int count = -1;
		int money = -1;
		try {
			Connection connection = DBUtil.getConnection();
			
			String check = "select amount from registration where uname=?";
			String query = "update registration set amount=amount-"+amount+" where uname='"+uname+"'";
			PreparedStatement preparedStatement = connection.prepareStatement(check);
			
			Statement st = connection.createStatement();
			
			
			preparedStatement.setString(1, uname);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
				money = rs.getInt("amount");
			
			System.out.println("money remain.."+money);
			
			if(money<amount)
			{
				return 0;
			}
			
			count = st.executeUpdate(query);
			
			System.out.println("after querry--> "+count);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return count;
	}

	public int remainingMoney(String uname) {
		int money = -1;
		try{
			
			Connection connection = DBUtil.getConnection();
			
			System.out.println("username in jsp "+uname);
			
			String check = "select amount from registration where uname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(check);
			preparedStatement.setString(1, uname);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
				money = rs.getInt("amount");
			
		}catch(Exception e)
		{
			
		}
		return money;
	}

	public int insertMini(String str, String benname, int amount) {
		int count = -1;
		try{
			
			Connection connection = DBUtil.getConnection();
			
			String check = "insert into ministatement values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(check);
			preparedStatement.setString(1, str);
			preparedStatement.setString(2, benname);
			preparedStatement.setInt(3, amount);
			
			count = preparedStatement.executeUpdate();
			
		}catch(Exception e)
		{
			
		}
		return count;
	}

	public ArrayList<MinistatementBean> showMini(ArrayList<MinistatementBean> arr, String name) {

		
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select * from ministatement where uname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				String uname = rs.getString("uname");
				String benname = rs.getString("benname");
				int amount = rs.getInt("amount");
				
				arr.add(new MinistatementBean(uname, benname, amount));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	public ArrayList<CustomerBean> showDetails(ArrayList<CustomerBean> arr, String name) {
		try {
			Connection connection = DBUtil.getConnection();
			
			String query = "select uname,accno,address,branch,state,ifsc,amount,mobile from registration where uname=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				String uname = rs.getString("uname");
				String accno = rs.getString("accno");
				String address = rs.getString("address");
				String branch = rs.getString("branch");
				String state = rs.getString("state");
				String ifsc = rs.getString("ifsc");
				int amount = rs.getInt("amount");
				String mobile = rs.getString("mobile");
				
				arr.add(new CustomerBean(uname,accno,address,branch,state,ifsc,amount,mobile));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return arr;
	}

	

}
