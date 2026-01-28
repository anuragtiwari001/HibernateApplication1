package com.ait.entity;

public class Student {
	
	private Integer sid;
	private String sname; 
	private String gender; 
	private Integer marks;
	
	public void setSid(Integer sid){
		this.sid = sid;
	}
	public Integer getSid() {
		return sid;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSname() {
		return sname;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	public Integer getMarks() {
		return marks;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", gender=" + gender + ", marks=" + marks + "]";
	}
	
	
	
}





