package com.jsp.jdbcPractice4.dto;

public class Football {
	
	private int id;
	private String name;
	private String club;
	private String nation;
	private int jersy;
	
	
	public Football() {	}
	
	public Football(int id , String name, String club,String nation,int jersy ) {
		this.id=id;
		this.name=name;
		this.nation=nation;
		this.jersy=jersy;
		
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
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public int getJersy() {
		return jersy;
	}
	public void setJersy(int jersy) {
		this.jersy = jersy;
	}
	
	@Override
	public String toString() {
		
		return "ID : "  + id + "\tName : " + name +"\tClub : " + club +"\tNation : " + nation + " \tJersy : " + jersy + "\n";
	}
	
	
	

}
