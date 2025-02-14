package com.jsp.jdbcPractice3.controller;

import java.util.Scanner;

import com.jsp.jdbcPractice3.dao.CricketerDao;

public class Driver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CricketerDao cri = new CricketerDao();

		char option = ' ';

		do {

			System.out.println(
					"Please select an option:   1.Display Data \t2.Insert Data \t3.Update Data \t4.Delete Data \t5.Exit  ");
			System.out.print("Chose an option : ");
			int op = sc.nextInt();

			switch (op) {
			case 1:
				System.out.println("*******************You Chose Display Data*******************");
				cri.displayData();
				System.out.println("==============================================================");
				break;

			case 2:
				System.out.println("*******************You Chose Insert Data*******************");
				System.out.println("Please enter details: ");

				System.out.print("Enter the id: ");
				int id = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Name : ");
				String name = sc.nextLine();

				System.out.print("Enter Age: ");
				int age = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Profile: ");
				String profile = sc.nextLine();

				System.out.print("Enter Team: ");
				String team = sc.nextLine();

				cri.insertData(id, name, age, profile, team);

				System.out.println("==============================================================");
				break;
			case 3:
				System.out.println("*******************You Chose Update Data*******************");
				System.out.print("Please enter id you want to update : ");
				int cid = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new name : ");
				String cname = sc.nextLine();

				System.out.print("Enter new age : ");
				int cage = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter new profile : ");
				String cprofile = sc.nextLine();

				System.out.print("Enter new team : ");
				String cteam = sc.nextLine();

				cri.updateData(cname, cage, cprofile, cteam, cid);

				System.out.println("==============================================================");
				break;
			case 4:
				System.out.println("*******************You Chose Delete Data*******************");
				System.out.print("Enter id of cricketer to delete : ");
				int inId = sc.nextInt();

				cri.deleteData(inId);

				System.out.println("==============================================================");
				break;
			case 5:
				System.out.println("*******************You Chose To Exit*******************");
				System.out.println("Exiting.............................");
				sc.close();
				System.out.println("==============================================================");
				break;

			default:
				System.out.println("Please chose a valid option");
				break;
			}
			System.out.println("Press Y/y to continue or press other key to exit.");
			System.out.print("Select your choice : ");
			option = sc.next().charAt(0);

		} while (option == 'y' || option == 'Y');

		sc.close();
	}
}
