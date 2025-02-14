package com.jsp.jdbcPractice3.dto;

public class Cricketers {
	
	int id ;
	String name;
	int age;
	String profile;
	String team;
	
	public Cricketers() {	}

	public Cricketers(int id, String name, int age, String profile, String team) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.profile = profile;
		this.team = team;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	
	
	
	

}
