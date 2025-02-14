package com.hcl.jdbcPractice5.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.hcl.jdbcPractice5.dao.EmployeDao;
import com.hcl.jdbcPractice5.dto.Employe;
import com.hcl.jdbcPractice5.service.SortByCompany;
import com.hcl.jdbcPractice5.service.SortByDateOfJoining;
import com.hcl.jdbcPractice5.service.SortByName;
import com.hcl.jdbcPractice5.service.SortBySalary;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmployeDao empdao = new EmployeDao();
		ArrayList<Employe> empList = empdao.getAllData();

		char option;

		do {

			System.out.println(
					"Press 1.InsertData   2.UpdateData  3.DeleteData 4.DisplayData 5.sortByName  6.sortBySalary   7.sortByCompany 8.sortByDateOfJoining");
			System.out.print("Please enter your choice  :  ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("************************You chose InsertData************************");
				System.out.print("Enter ID  : ");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Name  : ");
				String name = sc.nextLine();
				System.out.print("Enter Profile  : ");
				String profile = sc.nextLine();
				System.out.print("Enter Salary  : ");
				double sal = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Date-of-Joining  : ");
				String doj = sc.nextLine();
				LocalDate date = LocalDate.parse(doj, DateTimeFormatter.ISO_LOCAL_DATE);
				System.out.print("Enter Company  : ");
				String company = sc.nextLine();

				empdao.insertData(id, name, profile, sal, date, company);

				break;
			case 2:
				System.out.println("************************You chose UpdateData************************");
				System.out.print("Enter the ID which you want to update : ");
				int eid = sc.nextInt();
				sc.nextLine();

				System.out.println("------------------Enter updated value here--------------------------------");
				System.out.println("Enter Updated name : ");
				String ename = sc.nextLine();

				System.out.println("Enter updated profile : ");
				String eprofile = sc.nextLine();

				System.out.println("Enter updated salary : ");
				double esal = sc.nextDouble();
				sc.nextLine();

				System.out.println("Enter joining date :");
				String dateString = sc.nextLine();
				LocalDate edate = LocalDate.parse(dateString);

				System.out.println("Enter updated company name : ");
				String ecompany = sc.nextLine();

				empdao.updateData(eid, ename, eprofile, esal, edate, ecompany);

				break;
			case 3:
				System.out.println("************************You chose DeleteData************************");

				break;
			case 4:
				System.out.println("************************You chose DisplayData************************");

				empdao.displayData();

				break;
			case 5:
				System.out.println("************************You chose sortByName************************");
				SortByName sbn = new SortByName();
				

			
				Collections.sort(empList, sbn);
				System.out.println(empList);

				break;
			case 6:
				System.out.println("************************You chose sortBySalary************************");
				SortBySalary sbs = new SortBySalary();
				
				Collections.sort(empList,sbs);
				System.out.println(empList);
				

				break;
			case 7:
				System.out.println("************************You chose sortByCompany************************");
				SortByCompany sbc = new SortByCompany();
				
				Collections.sort(empList,sbc);
				System.out.println(empList);

				break;
			case 8:
				System.out.println("************************You chose sortByDateOfJoining************************");
				SortByDateOfJoining sbj = new SortByDateOfJoining();
				
				Collections.sort(empList, sbj);
				System.out.println(empList);

				break;

			case 9:
				System.out.println("************************You chose to Exit************************");
				System.out.println("Exited Successfully........");
				sc.close();

				break;
			default:
				System.out.println("Please enter a valid choice ........");
				break;
			}
			System.out.println("Press Y/y to repeate or press else to exit");
			option = sc.next().charAt(0);

		} while (option == 'y' | option == 'Y');

	}

}
