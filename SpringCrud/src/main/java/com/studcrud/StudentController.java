package com.studcrud;

import java.io.IOException;
import org.json.simple.JSONObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class StudentController {

	public StudentModel modelobj=new StudentModel();
/*  @RequestMapping(value="/loginPage",method=RequestMethod.POST)
  public ModelAndView login(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {     
	  String id = request.getParameter("loginid");
	  String passwd = request.getParameter("password");
	  if(id.equals("100")&&passwd.equals("admin"))
	  {
		  HttpSession session = request.getSession();
		  session.setAttribute("name", "admin1");
		  return new ModelAndView("home");
	  }
	  if(id.equals("101")&&passwd.equals("admin"))
	  {
		  HttpSession session = request.getSession();
		  session.setAttribute("name", "admin2");
		  return new ModelAndView("home");
	  }
	  response.getWriter().println("Username or password incorrect");	  
	  return new ModelAndView("loginPage"); 
  }
  */
 
  @RequestMapping(value="/login/createStudent",method=RequestMethod.POST)
  public void create(@RequestParam String id,@RequestParam String name, @RequestParam String department, HttpServletRequest request, HttpServletResponse response) throws IOException
  {
	  JSONObject result= new JSONObject();
	  String sess = request.getSession().getAttribute("name").toString();
	  if(modelobj.checkIfIdExists(sess,id)==true)
	  {
		  result.put("message", "Id already exists");
		  response.setContentType("application/json");
		  response.getWriter().print(result);
		  		  
	  }
	  else		  
	  {
		  modelobj.createStudent(sess,id,name,department);
		  result.put("message", "Id has been added");
		  response.setContentType("application/json");
		  response.getWriter().println(result);
	  }
	 
  }
  @RequestMapping(value="/login/updateStudent")
  public void update(@RequestParam String id,@RequestParam String value, @RequestParam String respectiveinput,HttpServletRequest request, HttpServletResponse response) throws IOException
  {
	 
	  String sess = request.getSession().getAttribute("name").toString();
	  JSONObject result= new JSONObject();
	  if(modelobj.checkIfIdExists(sess, id)==false)
	  {
		  result.put("message","Entered Id does not exist");
		  response.getWriter().println(result);
		  response.setContentType("application/json");
		  		  
	  }
	  else {
		  if(value.equals("name"))
		  {
			  modelobj.setStudentName(sess, respectiveinput, id);
		  }
		  else
		  {
			  modelobj.setStudentDepartment(sess, respectiveinput, id);
		  }
		  result.put("message","The data has been updated");
		  response.getWriter().println(result);		  
	  }
	  
	  
  }
  @RequestMapping(value="/login/deleteStudent")
  public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
	  String id = request.getParameter("id");
	  String sess = request.getSession().getAttribute("name").toString();
	  JSONObject result= new JSONObject();
	  if(modelobj.checkIfIdExists(sess, id)==false)
	  {
		  
		  result.put("message", "Id doesn't exist");
		  response.setContentType("application/json");
		  response.getWriter().print(result);
	  }
	  else
	  {
		  result.put("message", "Id has been deleted");
		  response.setContentType("application/json");
		  response.getWriter().print(result);
	  }
	  	 		  
  }
  @RequestMapping(value="/login/readStudent")
  public ModelAndView read(HttpServletRequest request, HttpServletResponse response) throws IOException
  {	  	  
	  	
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("read");
		  mv.addObject("studentdata", modelobj.getStudent());
		  return mv;
		  	  
  }
  @RequestMapping(value="/login/logoutServlet")
  public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
  {	 
	  request.getSession().invalidate();
	  response.sendRedirect("/loginPage.jsp"); 
  }
  
  
 
}