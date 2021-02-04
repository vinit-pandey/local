package com.wipro.banking.bean;

public class BeneficiaryBean {
	
	private String baacno;
	private String bname;
	private String bifsc;
	private int amount;
	private String uname;
	
	public BeneficiaryBean(String baacno, String bname) {
		super();
		this.baacno = baacno;
		this.bname = bname;
	}
	
	public BeneficiaryBean(String baacno, String bname, String bifsc, int amount, String uname) {
		super();
		this.baacno = baacno;
		this.bname = bname;
		this.bifsc = bifsc;
		this.amount = amount;
		this.uname = uname;
	}
	
	
	public BeneficiaryBean(String baacno, String bname, String bifsc, String uname) {
		super();
		this.baacno = baacno;
		this.bname = bname;
		this.bifsc = bifsc;
		this.uname = uname;
	}
	public String getBaacno() {
		return baacno;
	}
	public void setBaacno(String baacno) {
		this.baacno = baacno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBifsc() {
		return bifsc;
	}
	public void setBifsc(String bifsc) {
		this.bifsc = bifsc;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	

}
