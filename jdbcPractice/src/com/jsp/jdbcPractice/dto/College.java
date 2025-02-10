package com.jsp.jdbcPractice.dto;

public class College {
	
	int id ;
	String name;
	String email;
	String address;
	String type;
	
	public College() {	}

	public College(int id, String name, String email, String address, String type) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.type = type;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
