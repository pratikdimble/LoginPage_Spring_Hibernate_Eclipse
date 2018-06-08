package com.app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.delegate.Login_BD;
import com.app.errors.InsertOperationProblemException;
import com.app.errors.InternalProblemException;

@Controller
public class HomeController {
	
	@RequestMapping("/show")
		public ModelAndView showDate()
		{
		ModelAndView mv=new ModelAndView();
			mv.setViewName("home");
		return mv;
		
		}
	@RequestMapping(value="login")
	public ModelAndView showData(HttpServletRequest req,HttpServletResponse res)
	{
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		String role=req.getParameter("role");
		 String designation=null,empUsername=null,empPassword=null;
		//use Delegagate
		Login_BD delegate=null;
	String 	insertResult=null;
	 RequestDispatcher rd=null;
  	  delegate=new Login_BD();
  	ModelAndView mv=new ModelAndView();
  	  try{
  	  insertResult=delegate.addEmployee(designation,empUsername,empPassword);
//  	req.setAttribute("insertMsg",insertResult);
//        	rd=req.getRequestDispatcher("/emp_ack.jsp");
//				rd.forward(req,res);

  	  }//try close

  	  catch(Exception e){
  		  req.setAttribute("errMsg",e.getMessage());

  	  }//catch
  	mv.setViewName("display");
	mv.addObject("insertResult",insertResult);
	return mv;
	
	}

}
