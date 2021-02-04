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

import org.apache.tomcat.util.modeler.ManagedBean;

import com.wipro.banking.bean.CustomerBean;
import com.wipro.banking.bean.ManagerBean;
import com.wipro.banking.service.AdminService;
import com.wipro.banking.service.ManagerService;

/**
 * Servlet implementation class ManagerController
 */
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = request.getParameter("button");
		
		
		//login
		if(value.equals("login"))
		{
			String eid = request.getParameter("eid");
			String password = request.getParameter("password");
			
			ManagerService managerService = new ManagerService();
			
			boolean status = managerService.loginManager(eid,password);
			
			if(status==true)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/branchmanager.jsp");
				
				//request.setAttribute("val","Wrong Eid or Password");
				
				dispatcher.forward(request, response);
		
			}
			if(status==false)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/managerlogin.jsp");
				
				request.setAttribute("val","Wrong Eid or Password");
				
				dispatcher.include(request, response);
		
			}
			
			
		}
		
		//update
		if(value.equals("update"))
		{
			String eid = request.getParameter("eid");
			String password = request.getParameter("password");
			
			ManagerService managerService = new ManagerService();
			
			String status1 = managerService.checkManager(eid);
			
			
			System.out.println("status1 "+status1);
			//System.out.println("status2 "+status2);
			
			
			if(status1!=null)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/managerlogin.jsp");
				
				request.setAttribute("val","Password already updated");
				
				dispatcher.include(request, response);
			}
			if(status1==null)
			{
				int status2 = managerService.updateManager(eid,password);
				if(status2==1)
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/managerlogin.jsp");
					
					request.setAttribute("val","Password Updated");
					
					dispatcher.forward(request, response);
				}
				if(status2==0)
				{
					RequestDispatcher dispatcher = request.getRequestDispatcher("/managerUpdatePassword.jsp");
					
					request.setAttribute("val","Wrong Eid");
					
					dispatcher.include(request, response);
				}
			}
			
		}
		
		if(value.equals("pending"))
		{
			String branch = request.getParameter("branch");
			ManagerService managerService = new ManagerService();
			
			ArrayList<CustomerBean> arr = new ArrayList<CustomerBean>();
			
			ArrayList<CustomerBean> result = managerService.viewCustomer(arr,branch);
			
			result.forEach(e->{
				System.out.println(e.getUname()+" "+e.getAccno()+" "+e.getStatus());
			});
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pending.jsp");
			
			request.setAttribute("result",result);
			
			dispatcher.forward(request, response);
			
		}
		ArrayList<CustomerBean> result = new ArrayList<CustomerBean>();
		
		if(value.equals("approve"))
		{
			ManagerService managerService = new ManagerService();
			
			ArrayList<CustomerBean> arr = new ArrayList<CustomerBean>();
			
			//String branch = request.getParameter("branch");
			result = managerService.viewCustomerApp(arr);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/approve_reject.jsp");
			
			request.setAttribute("result",result);
			
			dispatcher.forward(request, response);
		}
		
		if(value.equals("status"))
		{
			//System.out.println("here");
			ManagerService managerService = new ManagerService();
			String temp = "r";
			String []arr = new String[100];
			int k = 0;
			
			for(int i=0;i<100;i++)
			{
				//int  val = i+1;
				String data = request.getParameter(temp+i);
				//System.out.println("data is"+data);
				if(data!=null)
				{
					String []array = data.trim().split(" ");
					
					System.out.println("approve-reject "+array[0]+" "+array[1]);
					
					if(array[0].equals("approve"))
					{
						//2---approve
						managerService.updateStatus(2,array[1]);
					}
					if(array[0].equals("reject"))
					{
						//3----reject
						managerService.updateStatus(3,array[1]);
					}
				}
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/branchmanager.jsp");
			
			
			dispatcher.include(request, response);
		}
		
		
		if(value.equals("newStatus"))
		{
			ManagerService managerService = new ManagerService();
			
			ArrayList<CustomerBean> arr = new ArrayList<CustomerBean>();
			
			String branch = request.getParameter("branch");
			result = managerService.approveRejectCustomer(arr,branch);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pending.jsp");
			
			request.setAttribute("result",result);
			
			dispatcher.forward(request, response);
			
			
		}
		
		
		//serach
		if(value.equals("search"))
		{
			
			String sdate = request.getParameter("sdate");
			String edate = request.getParameter("edate");
			
			Date sd = Date.valueOf(sdate);
			Date ed = Date.valueOf(edate);
			
			ManagerService managerService = new ManagerService();
			
			ArrayList<CustomerBean> arr = new ArrayList<CustomerBean>();
			
			
			result = managerService.searchCustomer(arr,sd,ed);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pending.jsp");
			
			request.setAttribute("result",result);
			
			dispatcher.forward(request, response);
		}
		
		if(value.equals("logout")) {
			
			Cookie ck = new Cookie("logout","You are Loggedout");
			ck.setMaxAge(0);
		response.addCookie(ck);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			
			
			dispatcher.forward(request, response);
		}
		
		
		
		
	}

}
