package com.hcl.jdbcPractice5.service;

import java.util.Comparator;

import com.hcl.jdbcPractice5.dto.Employe;

public class SortByDateOfJoining implements Comparator<Employe> {
	
	@Override
	public int compare(Employe o1, Employe o2) {
		// TODO Auto-generated method stub
		return o1.getDoj().compareTo(o2.getDoj());
	}

}
