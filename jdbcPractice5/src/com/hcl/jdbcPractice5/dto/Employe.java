package com.hcl.jdbcPractice5.dto;

import java.time.LocalDate;

public class Employe {

	private int id;
	private String name;
	private String profile ; 
	private double sal;
	private LocalDate doj;
	private String company;
	
	public Employe() {	}
	
	Employe(int id , String name,String profile,double sal,LocalDate doj,String company){
		this.id=id;
		this.name=name;
		this.profile=profile;
		this.sal=sal;
		this.doj=doj;
		this.company=company;
	}
	
	public int getId() {return id;}
	public void setId(int id) { this.id=id; }
	
	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getProfile() {return profile;}

	public void setProfile(String profile) {	this.profile = profile;}

	public double getSal() {return sal;}

	public void setSal(double sal) {this.sal = sal;}

	public LocalDate getDoj() {return doj;}

	public void setDoj(LocalDate doj) {this.doj = doj;}

	public String getCompany() {return company;}

	public void setCompany(String company) {this.company = company;}
	
	@Override
	public String toString() {
		
		return "ID  : " + id +"\nName : "+ name + "\nProfile : " +profile+ "\nSal : " +sal+"\nDate-of-Joining :"+doj+"\nCompany : "+company + "\n"; 
	}
}

