package com.wipro.banking.bean;

import java.sql.Date;

public class CustomerBean {
	private String uname;
	private String password;
	private String accno;
	private String address;
	private String branch;
	private String state;
	private String ifsc;
	private Date sdate;
	private int amount;
	private String mobile;
	private int status;
	public CustomerBean() {
		super();
	}
	
	
	
	public CustomerBean(String uname, String accno, String address, String branch, String state, String ifsc,
			int amount, String mobile) {
		super();
		this.uname = uname;
		this.accno = accno;
		this.address = address;
		this.branch = branch;
		this.state = state;
		this.ifsc = ifsc;
		this.amount = amount;
		this.mobile = mobile;
	}



	public CustomerBean(String uname, String accno, String branch, int status) {
		super();
		this.uname = uname;
		this.accno = accno;
		this.branch = branch;
		this.status = status;
	}

	public CustomerBean(String uname, String password, String accno, String address, String branch, String state,
			String ifsc, Date sdate, int amount, String mobile, int status) {
		super();
		this.uname = uname;
		this.password = password;
		this.accno = accno;
		this.address = address;
		this.branch = branch;
		this.state = state;
		this.ifsc = ifsc;
		this.sdate = sdate;
		this.amount = amount;
		this.mobile = mobile;
		this.status = status;
	}

	public CustomerBean(String uname, String accno, String branch) {
		super();
		this.uname = uname;
		this.accno = accno;
		this.branch = branch;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}
