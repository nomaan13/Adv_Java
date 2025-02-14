package com.jsp.jdbcPractice4.service;

import java.util.Comparator;

import com.jsp.jdbcPractice4.dto.Football;

public class SortByName implements Comparator<Football> {

	@Override
	public int compare(Football o1, Football o2) {

		return o1.getName().compareTo(o2.getName());
	}

}
