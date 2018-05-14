package com.login;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	LoginModel loginmodel = new LoginModel();
	 @RequestMapping(value="/")
	  public ModelAndView redirect(HttpServletRequest request, HttpServletResponse response) throws IOException
	  {
		  return new ModelAndView("loginPage");
	  }
	 
	 @RequestMapping(value="/loginPage",method=RequestMethod.POST)
	 public void login(HttpServletRequest request, HttpServletResponse response) 
		      throws IOException {
		 
		 String sessionName = loginmodel.validate(request.getParameter("name"), request.getParameter("password"));
		 if(!sessionName.equals("false"))
		 {
			 HttpSession session = request.getSession();
			 session.setAttribute("name", sessionName);
			 JSONObject result= new JSONObject();
			 result.put("success", true);			 
			 response.setContentType("application/json");
			 response.getWriter().print(result);
		 }
		 else
		 {    JSONObject result= new JSONObject();
		      result.put("success", false);
		      result.put("message", "invalid credentials");
			 response.setContentType("application/json");
			 response.getWriter().print(result);
		 }
		 
	 }
	 @RequestMapping(value="/logout")
	 public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException
	  {	 
		  request.getSession().invalidate();
		  return "loginPage";
	  }

}
