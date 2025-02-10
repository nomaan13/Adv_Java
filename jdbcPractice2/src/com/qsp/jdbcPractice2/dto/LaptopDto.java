package com.qsp.jdbcPractice2.dto;

public class LaptopDto {
	
	int id;
	String company;
	int ram;
	String color;
	String processor;
	
	public LaptopDto() {	}

	public LaptopDto(int id, String company, int ram, String color, String processor) {
		super();
		this.id = id;
		this.company = company;
		this.ram = ram;
		this.color = color;
		this.processor = processor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	

}
