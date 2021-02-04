package com.wipro.banking.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.banking.bean.AccountNumberBean;
import com.wipro.banking.bean.BeneficiaryBean;
import com.wipro.banking.bean.CustomerBean;
import com.wipro.banking.bean.MinistatementBean;
import com.wipro.banking.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Please Login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String value = request.getParameter("button");
		
		
		String username = "";
		
		if(value.equals("login"))
		{
			String uname = request.getParameter("uname");
			String password = request.getParameter("password");
			CustomerService customerService = new CustomerService();
			
			System.out.println(uname+" "+password);
			//int status1 = customerService.checkStatus(uname);
			
			
			boolean status2 = customerService.checkLogin(uname,password);
			
		
			//System.out.println("status1="+status1+" "+"status2="+status2);
			if(status2==true)
			{
				Cookie ck = new Cookie("uname",uname);
				response.addCookie(ck);
				
				System.out.println("cookie name --"+ck.getValue());
				int money = -1;
				
				username = uname;
				System.out.println("login username->"+username);
				int status1 = customerService.checkStatus(uname);
				System.out.println("status1="+status1+" "+"status2="+status2);
				if(status1==1)
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					request.setAttribute("val","Your request is pending");
					dispatcher.include(request, response);
				}
				
				if(status1==2)
				{
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
					
					money = customerService.remainingMoney(uname);
					request.setAttribute("val",uname);
					request.setAttribute("balance",money);
					dispatcher.forward(request, response);
				}
				if(status1==3)
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					request.setAttribute("val","Your request has been rejected");
					dispatcher.include(request, response);
				}
			
			}
			if(status2==false)
			{
			
					RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
					request.setAttribute("val","Wrong Username or Password");
					dispatcher.include(request, response);
				
			}
			
			
		}
		
		if(value.equals("registration"))
		{
			String uname = request.getParameter("username");
		
			String password = request.getParameter("psw");
			String accno = request.getParameter("account");
			String address = request.getParameter("address");
			String branch = request.getParameter("branch");
			String state = request.getParameter("state");
			String ifsc = request.getParameter("ifsccode");
			String date = request.getParameter("date");
			String mobile = request.getParameter("mobile");
			
			Date d = Date.valueOf(date);
			CustomerBean bean = new CustomerBean(uname,password,accno,address,branch,
												state,ifsc,d,5000,mobile,1);
			
			CustomerService customerService = new CustomerService();
			
			int result2 = customerService.insertAccount(new AccountNumberBean(accno));
			int result1  = customerService.insertCustomer(bean);
			
			if(result1==1 && result2==1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				request.setAttribute("msg","registration successful");
				
				dispatcher.forward(request, response);
				
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
				request.setAttribute("msg","username or account number already exsists");
				
				dispatcher.include(request, response);
			}
			
			
		}
		
		//add Ben
		if(value.equals("addBen"))
		{
			String accno = request.getParameter("accben");
			String accname = request.getParameter("accname");
			String ifsc = request.getParameter("ifsc");
			
			String uname = "";
			Cookie []cookie = request.getCookies();
			for(Cookie c : cookie)
			{
				if(c.getName().equals("uname"))
				{
					System.out.println("name is in ben forignkey->"+c.getValue());
					uname = c.getValue();
					break;
				}
			}
			BeneficiaryBean bean = new BeneficiaryBean(accno,accname,ifsc,uname);
			CustomerService customerService = new CustomerService();
			
			int result = customerService.addBeneficiary(bean);
			
			System.out.println(result);
			
			int money = -1;
			if(result==1)
			{
				money = customerService.remainingMoney(uname);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
				request.setAttribute("balance",money);
				request.setAttribute("msg","Beneficiary added");
				
				dispatcher.forward(request, response);
			}
			if(result==0)
			{
				money = customerService.remainingMoney(uname);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
				request.setAttribute("balance",money);
				request.setAttribute("msg","Beneficiary already exsists");
				
				dispatcher.include(request, response);
			}
		}
		
		//transfer
		if(value.equals("transfer"))
		{
			Cookie []cookie = request.getCookies();
			String uname="";
			for(Cookie c : cookie)
			{
				if(c.getName().equals("uname"))
				{
					System.out.println("name is in perticular uname "+c.getValue());
					uname = c.getValue();
					break;
					
				}
			}
			CustomerService customerService = new CustomerService();
			
			ArrayList<BeneficiaryBean> arr = new ArrayList<BeneficiaryBean>();
			
			ArrayList<BeneficiaryBean> result = customerService.sendBeneficiary(arr,uname);
			
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/transfer.jsp");
				request.setAttribute("data",result);
				
				//System.out.println("arr is"+result);
				dispatcher.forward(request, response);
			
		}
		if(value.equals("money"))
		{
			//System.out.println("here money");
			CustomerService customerService = new CustomerService();
			String benname = request.getParameter("dropdown");
			
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			System.out.println("ben name->"+benname);
			System.out.println("ben amount->"+amount);
			

			Cookie []cookie = request.getCookies();
		
			int result = -1;
			int money = -1;
			String str = "";
					for(Cookie c : cookie)
					{
						if(c.getName().equals("uname"))
						{
							System.out.println("name is in cookie "+c.getValue());
						
							str = c.getValue();
							result = customerService.updateAmount(c.getValue(),amount);
							money = customerService.remainingMoney(c.getValue());

							break;
						}
					}
					System.out.println("reesult.."+result);
					
					
					
					if(result==0)
					{
						RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
						request.setAttribute("msg","You Have Insufficient Balance");
						request.setAttribute("balance",money);
						dispatcher.include(request, response);	
					}
					if(result==1)
					{
						
						int insertStatus = customerService.insertMini(str,benname,amount);
						
						System.out.println("ministatement status->"+insertStatus);
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("/customer.jsp");
						request.setAttribute("msg","Amount Has Transferred");
						request.setAttribute("uname",str);
						request.setAttribute("balance",money);
						
						dispatcher.include(request, response);
					}
		}
		
		//mini statement
		if(value.equals("mini"))
		{
		
			Cookie []cookie = request.getCookies();
			String name = "";
			for(Cookie c : cookie)
			{
				if(c.getName().equals("uname"))
				{
					//System.out.println("name is in cookie "+c.getValue());
					name = c.getValue();
				}
			}
			CustomerService customerService = new CustomerService();
			
			ArrayList<MinistatementBean> arr = new ArrayList<MinistatementBean>();
			
			ArrayList<MinistatementBean> result  = customerService.showMini(arr,name);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ministatement.jsp");
			
			request.setAttribute("data", result);
			
			dispatcher.forward(request, response);
		
		}
		
		///account
		if(value.equals("account"))
		{
			Cookie []cookie = request.getCookies();
			String name = "";
			for(Cookie c : cookie)
			{
				if(c.getName().equals("uname"))
				{
					//System.out.println("name is in cookie "+c.getValue());
					name = c.getValue();
				}
			}
			CustomerService customerService = new CustomerService();

			ArrayList<CustomerBean> arr = new ArrayList<CustomerBean>();
			
			ArrayList<CustomerBean> result  = customerService.showDetails(arr,name);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/accountdetails.jsp");
			
			request.setAttribute("data", result);
			
			dispatcher.forward(request, response);
			
		}
	}
}
