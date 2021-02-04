package com.wipro.banking.bean;

public class AccountNumberBean {
	
	private String accno;

	public AccountNumberBean() {
		super();
	}

	public AccountNumberBean(String accno) {
		super();
		this.accno = accno;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	@Override
	public String toString() {
		return "AccountNumberBean [accno=" + accno + "]";
	}
	

}
