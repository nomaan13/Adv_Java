package com.hcl.jdbcPractice5.service;

import java.util.Comparator;

import com.hcl.jdbcPractice5.dto.Employe;

public class SortBySalary implements Comparator<Employe> {
	
	@Override
	public int compare(Employe o1, Employe o2) {
		
		return (int) ( o2.getSal()-o1.getSal());
		
	}

}
