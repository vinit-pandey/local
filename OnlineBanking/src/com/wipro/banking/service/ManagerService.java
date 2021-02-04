package com.wipro.banking.service;

import java.sql.Date;
import java.util.ArrayList;

import com.wipro.banking.bean.CustomerBean;
import com.wipro.banking.dao.ManagerDAO;

public class ManagerService {

	public ArrayList<CustomerBean> viewCustomer(ArrayList<CustomerBean> arr, String branch) {
		
		ManagerDAO dao = new ManagerDAO();
		ArrayList<CustomerBean> result = dao.viewCustomer(arr,branch);
		return result;
	}

	public void updateStatus(int status, String uname) {

		ManagerDAO dao = new ManagerDAO();
		
		dao.updateStatus(status,uname);
		
	}

	public ArrayList<CustomerBean> approveRejectCustomer(ArrayList<CustomerBean> arr, String branch) {
		ManagerDAO dao = new ManagerDAO();
		ArrayList<CustomerBean> result = dao.approveRejectCustomer(arr,branch);
		return result;
	}



	public ArrayList<CustomerBean> searchCustomer(ArrayList<CustomerBean> arr, Date sd, Date ed) {

		ManagerDAO dao = new ManagerDAO();
		ArrayList<CustomerBean> result = dao.searchCustomer(arr,sd,ed);
		return result;
	}

	public boolean loginManager(String eid, String password) {
		
		ManagerDAO dao = new ManagerDAO();
		boolean status = dao.loginManager(eid,password);
		return status;
	}

	public int updateManager(String eid, String password) {
		ManagerDAO dao = new ManagerDAO();
		
		int status = dao.updateManager(eid,password);
		return status;
	}

	public String checkManager(String eid) {
		ManagerDAO dao = new ManagerDAO();
		
		String status = dao.checkManager(eid);
		return status;
	}

	public ArrayList<CustomerBean> viewCustomerApp(ArrayList<CustomerBean> arr) {
		ManagerDAO dao = new ManagerDAO();
		ArrayList<CustomerBean> result = dao.viewCustomerApp(arr);
		return result;
	}

}
