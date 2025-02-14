package com.hcl.jdbcPractice5.service;

import java.util.Comparator;

import com.hcl.jdbcPractice5.dto.Employe;

public class SortByCompany implements Comparator<Employe> {
	@Override
	public int compare(Employe o1, Employe o2) {

		return o1.getCompany().compareTo(o2.getCompany());
	}

}
