package com.wipro.banking.service;

import java.util.ArrayList;

import com.wipro.banking.bean.AccountNumberBean;
import com.wipro.banking.bean.BeneficiaryBean;
import com.wipro.banking.bean.CustomerBean;
import com.wipro.banking.bean.MinistatementBean;
import com.wipro.banking.dao.CustomerDao;

public class CustomerService {

	public int insertCustomer(CustomerBean bean) {
		
		CustomerDao customerDao = new CustomerDao();
		int val = customerDao.insertCustomer(bean);
		
		if(val==1)
			return 1;
		else
		return 0;
	}

	public int insertAccount(AccountNumberBean accountNumberBean) {
		
		
		CustomerDao customerDao = new CustomerDao();
		int val = customerDao.insertAccount(accountNumberBean);
		
		if(val==1)
			return 1;
		else
		return 0;
	}

	public int checkStatus(String uname) {
		CustomerDao customerDao = new CustomerDao();
		int val = customerDao.checkStatus(uname);
		return val;
	}

	public boolean checkLogin(String uname, String password) {
		CustomerDao customerDao = new CustomerDao();
		
		boolean result = customerDao.checkLogin(uname,password);
		return result;
	}

	public int addBeneficiary(BeneficiaryBean bean) {
		
		CustomerDao customerDao = new CustomerDao();
		
		int result = customerDao.addBeneficiary(bean);
		
		return result;
	}

	public ArrayList<BeneficiaryBean> sendBeneficiary(ArrayList<BeneficiaryBean> arr, String uname) {
		
		CustomerDao customerDao = new CustomerDao();
		ArrayList<BeneficiaryBean> result = customerDao.sendBeneficiary(arr,uname);
		return result;
	}

	public int updateAmount(String uname, int amount) {
		
		CustomerDao customerDao = new CustomerDao();
		
		int result = customerDao.updateAmount(uname,amount);
		
		return result;
	}

	public int remainingMoney(String uname) {
		CustomerDao customerDao = new CustomerDao();
		
		int result = customerDao.remainingMoney(uname);
		
		return result;
	}

	public int insertMini(String str, String benname, int amount) {
		CustomerDao customerDao = new CustomerDao();
		
		int result = customerDao.insertMini(str,benname,amount);
		
		return result;
	}

	public ArrayList<MinistatementBean> showMini(ArrayList<MinistatementBean> arr, String name) {
		CustomerDao customerDao = new CustomerDao();
		ArrayList<MinistatementBean> result =  customerDao.showMini(arr,name);
		return result;
	}

	public ArrayList<CustomerBean> showDetails(ArrayList<CustomerBean> arr, String name) {

		CustomerDao customerDao = new CustomerDao();
		ArrayList<CustomerBean> result =  customerDao.showDetails(arr,name);
		return result;
	}
	
	

}
