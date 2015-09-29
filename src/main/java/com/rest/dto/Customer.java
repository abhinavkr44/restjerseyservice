package com.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
	
	public Customer() {
		super();
	}
	private String fname;
	
	private String lname;
	
	private int age;
	
	public Customer(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
