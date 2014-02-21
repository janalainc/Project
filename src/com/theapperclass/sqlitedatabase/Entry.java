package com.theapperclass.sqlitedatabase;

import java.sql.Date;
import java.util.Calendar;

public class Entry { //added through new->class
	
	public int id;
	public String Name;
	public String Dept;
	public java.util.Date Stamp;

	public int getId() {
		return id;
	}

	public void setId(int _id) {
		this.id = _id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String _Name) {
		Name = _Name;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String _dept) {
		Dept = _dept;
	}

	public java.util.Date getStamp() {
		return Stamp;
	}

	public void setStamp() {
		Stamp = Calendar.getInstance().getTime(); //get system time
	}

	
	public Entry(int _id, String _Name, String _dept, java.util.Date _stamp)  //constructor of the class, same name with the class
	{
		id = _id;
		Name = _Name;
		Dept = _dept;
		Stamp = _stamp;
	}
	
	public Entry(int _id, String _Name, String _dept)  //Overload, Same constructor but accepts different data
	{
		id = _id;
		Name = _Name;
		Dept = _dept;
		Stamp = Calendar.getInstance().getTime();
	}
	
	
	
}
