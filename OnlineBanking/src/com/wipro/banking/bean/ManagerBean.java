package com.wipro.banking.bean;

public class ManagerBean {
	
	private String eid;
	private String password;
	private String branch;
	private String ifsc;
	public ManagerBean() {
		super();
	}
	
	
	public ManagerBean(String eid, String branch, String ifsc) {
		super();
		this.eid = eid;
		this.branch = branch;
		this.ifsc = ifsc;
	}


	public ManagerBean(String eid, String password, String branch, String ifsc) {
		super();
		this.eid = eid;
		this.password = password;
		this.branch = branch;
		this.ifsc = ifsc;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	@Override
	public String toString() {
		return "ManagerBean [eid=" + eid + ", password=" + password + ", branch=" + branch + ", ifsc=" + ifsc + "]";
	}
	
	
	

}
