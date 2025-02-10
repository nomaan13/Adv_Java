package com.jsp.jdbcPractice.controller;

import java.util.Scanner;

import com.jsp.jdbcPractice.dao.DisplayData;
import com.jsp.jdbcPractice.dao.InsertData;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Available Options : ");

		System.out.println("1.Insert Data \n2.Update College-Name by id \n3.Delete Data	\n4.Display Data");

		System.out.print("Please enter your choice :  ");
		int s = sc.nextInt();

		if (s == 0 && s > 4) {
			System.out.println("Please chose correct option..");
		}

		switch (s) {
		case 1:
			System.out.println("You Chose Insert Data");

			System.out.println("Enter :  Id    College-Name    College-Email    City    type");
			System.out.println("Enter college id");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter college Name");
			String clg_name = sc.nextLine();
			System.out.println("Enter college email");
			String clg_email = sc.nextLine();
			System.out.println("Enter college Address");
			String clg_city = sc.nextLine();
			System.out.println("Enter college Type");
			String clg_type = sc.nextLine();

			// call method insertData of class InsertData
			InsertData.insertData(id, clg_name, clg_name, clg_email, clg_city, clg_type);

			System.out.println("Data Inserted successfully");
			break;
		case 2:
			System.out.println("You chose Update data ");

			break;
		case 4:
			System.out.println("You chose Display data ");
			DisplayData.displayData();

			System.out.println("All data displayed");
			break;
		}

	}
}
