package com.studcrud;

import java.util.HashMap;

public class StudentModel {
	private String studentid;
	private String studentname;
	private String studentdept;
	private HashMap<String,HashMap<String,HashMap<String,String>>> hmap = new HashMap<String,HashMap<String,HashMap<String,String>>>();	
	public void createStudent(String sess, String id, String name, String dept)
	{
		studentid=id;
		studentname=name;
		studentdept=dept;
		HashMap<String, String> namedept = new HashMap<String,String>();
		namedept.put("name", studentname);
		namedept.put("department",studentdept);
		HashMap<String,HashMap<String,String>> idval;
		if(hmap.get(sess)!=null)
		{
			idval = hmap.get(sess);
		}
		else
		{
			idval = new HashMap<String,HashMap<String,String>>();
		}
		
		idval.put(studentid, namedept);
		hmap.put(sess, idval);		
	}
	
	/*public HashMap<String,HashMap<String,HashMap<String,String>>> readStudentData()
	{
		return hmap;
	}
	public void updateStudent(String sess, String param, String value, String id)
	{
		HashMap<String, String> map = hmap.get(sess).get(id);
		map.put(param, value);
		HashMap<String,HashMap<String, String>> map2 = hmap.get(sess);
		map2.put(id, map);
		hmap.put(sess, map2);
	}*/
	public void deleteStudent(String sess, String id)
	{
		hmap.get(sess).remove(id);
	}
	
	public HashMap<String,HashMap<String,HashMap<String,String>>> getStudent()
	{
		return hmap;
	}
	
	public void setStudentName(String sess, String name, String id)
	{
		HashMap<String, String> map = hmap.get(sess).get(id);
		map.put("name", name);
		HashMap<String,HashMap<String, String>> map2 = hmap.get(sess);
		map2.put(id, map);
		hmap.put(sess, map2);
	}
	public boolean checkIfIdExists(String sess,String id)
	{
		if(hmap.get(sess)!=null)
		if(hmap.get(sess).containsKey(id)==true)
		{
			return true;
		}
		return false;
	}
	public void setStudentDepartment(String sess, String department, String id)
	{
		HashMap<String, String> map = hmap.get(sess).get(id);
		map.put("department", department);
		HashMap<String,HashMap<String, String>> map2 = hmap.get(sess);
		map2.put(id, map);
		hmap.put(sess, map2);
		
	}
}
