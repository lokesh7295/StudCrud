package com.login;

public class LoginModel {
	
	public String validate(String id, String password)
	{
		if(id.equals("100")&&password.equals("admin"))
		{
			return "admin1";
		}
		if(id.equals("101")&&password.equals("admin"))
		{
			return "admin2";
		}
		
		return "false";
	}

}
