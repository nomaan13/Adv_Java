package com.jsp.jdbcPractice4.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.jsp.jdbcPractice4.dao.FootballDao;
import com.jsp.jdbcPractice4.dto.Football;
import com.jsp.jdbcPractice4.service.SortByJersy;
import com.jsp.jdbcPractice4.service.SortByName;
import com.jsp.jdbcPractice4.service.SortByNation;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FootballDao fd = new FootballDao();

		char ch ;
		do {
			System.out.print(
					"Press:-	1.InsertData 		2.DisplayData 	3.Display Data by Sorted Name 	4.Display Data by Sorted Jersy 	5.Display Data by Sorted Nation 	7.Exit"
							+ "\nENter your choice : ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println(
						"**************************You chose Insert Data*********************************************");

				System.out.print("Enter footbaler ID : ");

				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter footbaler Name : ");
				String name = sc.nextLine();

				System.out.print("Enter footbaler Club : ");
				String club = sc.nextLine();

				System.out.print("Enter footbaler Nation : ");
				String nation = sc.nextLine();

				System.out.print("Enter footbaler Jersy : ");
				int jersy = sc.nextInt();

				fd.insertData(id, name, club, nation, jersy);

				break;
			case 2:
				System.out.println(
						"**************************You chose Display Data*********************************************");
				fd.displayData();

				break;
			case 3:
				System.out.println(
						"**************************Display Data by Sorted Name*********************************************");
				SortByName sbname = new SortByName();
				ArrayList<Football> a3 = fd.getAllData();

				Collections.sort(a3, sbname);

				for (Football fb : a3) {
					System.out.print("ID : " + fb.getId());
					System.out.print("| Name: " + fb.getName());
					System.out.print("| Club: " + fb.getClub());
					System.out.print("| Nation: " + fb.getNation());
					System.out.print("| Jersey: " + fb.getJersy());
					System.out.println("\n_______________________________________________________________________");
				}
				break;
			case 4:
				System.out.println(
						"**************************Display Data by Sorted Jersy*********************************************");
				SortByJersy sbj = new SortByJersy();
				ArrayList<Football> a4 = fd.getAllData();
				Collections.sort(a4, sbj);
				System.out.println(a4);

				break;
			case 5:
				System.out.println(
						"**************************Display Data by Sorted Nation*********************************************");
				SortByNation sbn = new SortByNation();
				ArrayList<Football> a5 = fd.getAllData();
				Collections.sort(a5, sbn);
				System.out.println(a5);

				break;
			case 6:
				System.out.println(
						"**************************You chose to Exit*********************************************");
				System.out.println("Successfully exit from application");
				sc.close();

				break;

			default:
				System.out.println("Please chose a valid option.");
				break;

			}
			System.out.println("Press Y/y to continue or other key to exit");
			System.out.print("Please select your choice :  ");
			ch = sc.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');

	}

}
