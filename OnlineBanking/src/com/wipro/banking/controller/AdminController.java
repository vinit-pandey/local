package com.wipro.banking.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.banking.bean.ManagerBean;
import com.wipro.banking.service.AdminService;
import com.wipro.banking.service.AdminService;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String value = request.getParameter("button");
		
		if(value.equals("login"))
		{
			String eid1 = request.getParameter("eid");
			String password = request.getParameter("password");
			
			if(eid1.equals("admin007") && password.equals("jamesbond"))
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("value","Welcome");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/adminlogin.jsp");
				request.setAttribute("value","incorrect username or password");
				dispatcher.include(request, response);
			}
		}
		
		//new
		
		if(value.equals("insert"))
		{
			String eid = request.getParameter("eid");
			String branch = request.getParameter("branch");
			String ifsc = request.getParameter("ifsc");
			
			ManagerBean bean = new ManagerBean(eid, "", branch, ifsc);
			
			AdminService adminService = new AdminService();
			
			int result = adminService.inserManager(bean);
			if(result==1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("val","Maneger Added");
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("val","Maneger already exsits");
				dispatcher.include(request, response);
			}
			
			
		}
		if(value.equals("modify"))
		{
			String eid = request.getParameter("eid");
			String branch = request.getParameter("branch");
			String ifsc = request.getParameter("ifsc");
			AdminService adminService = new AdminService();
			
			int result = adminService.modifyManager(eid,branch,ifsc);
			if(result==1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("val","Maneger updated");
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("val","Maneger doesnot exist");
				dispatcher.include(request, response);
			}
		}
		
		if(value.equals("delete"))
		{
			String eid = request.getParameter("eid");
			AdminService adminService = new AdminService();
			
			int result = adminService.deleteManager(eid);
			
			if(result==1)
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("val","Maneger deleted");
				dispatcher.forward(request, response);
			}
			else
			{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
				request.setAttribute("val","Maneger doesnot exist");
				dispatcher.include(request, response);
			}
		}
		
		if(value.equals("view"))
		{
			AdminService adminService = new AdminService();
			 ArrayList<ManagerBean> arr = new ArrayList<ManagerBean>();
			 
			 ArrayList<ManagerBean> result = adminService.viewManager(arr);
			 
			 if(result.isEmpty()!=true)
			 {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/showAllManager.jsp");
					request.setAttribute("mset",result);
					
					System.out.println("arr is"+result);
					dispatcher.forward(request, response);
			 }
			 else
			 {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
					request.setAttribute("val","Table is empty");
					dispatcher.include(request, response);
			 }
		}
		
		if(value.equals("search"))
		{
			String eid = request.getParameter("eid");
			AdminService adminService = new AdminService();
			 ArrayList<ManagerBean> arr = new ArrayList<ManagerBean>();
			 
			 ArrayList<ManagerBean> result = adminService.searchManager(arr,eid);
			 
			 System.out.println("single customer"+result);
			 
			 if(result.isEmpty()!=true)
			 {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/showAllManager.jsp");
					request.setAttribute("mset",result);
					
					System.out.println("arr is"+result);
					dispatcher.forward(request, response);
			 }
			 else
			 {
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
					request.setAttribute("val","Table is empty");
					dispatcher.include(request, response);
			 }
		}
		
		if(value.equals("logout"))
		{
			Cookie ck = new Cookie("logout","You are Loggedout");
			ck.setMaxAge(0);
		response.addCookie(ck);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			
			
			dispatcher.forward(request, response);
		
		}
		

	}

}
