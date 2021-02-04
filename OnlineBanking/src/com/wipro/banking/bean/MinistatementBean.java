package com.wipro.banking.bean;

public class MinistatementBean {
	
	private String uname;
	private String benname;
	private int amount;
	public MinistatementBean(String uname, String benname, int amount) {
		super();
		this.uname = uname;
		this.benname = benname;
		this.amount = amount;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getBenname() {
		return benname;
	}
	public void setBenname(String benname) {
		this.benname = benname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	
}
