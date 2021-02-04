package com.wipro.banking.service;

import java.util.ArrayList;

import com.wipro.banking.bean.ManagerBean;
import com.wipro.banking.dao.AdminDAO;

public class AdminService {

	public int inserManager(ManagerBean bean) {
		
		AdminDAO dao = new AdminDAO();
		int result = dao.insertManager(bean);
		return result;
	}

	public int modifyManager(String eid, String branch, String ifsc) {
		
		AdminDAO dao = new AdminDAO();
		int result = dao.modifyManager(eid,branch,ifsc);
		return result;
	}

	public int deleteManager(String eid) {
		AdminDAO dao = new AdminDAO();
		int result = dao.deleteManager(eid);
		return result;
	}

	public ArrayList<ManagerBean> viewManager(ArrayList<ManagerBean> arr) {
		
		AdminDAO dao = new AdminDAO();
		ArrayList<ManagerBean> result = dao.viewManager(arr);
		return result;
	}

	public ArrayList<ManagerBean> searchManager(ArrayList<ManagerBean> arr, String eid) {

		AdminDAO dao = new AdminDAO();
		ArrayList<ManagerBean> result = dao.searchManager(arr,eid);
		return result;
	}

}
