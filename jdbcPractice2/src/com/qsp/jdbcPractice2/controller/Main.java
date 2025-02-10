package com.qsp.jdbcPractice2.controller;

import java.util.Scanner;

import com.qsp.jdbcPractice2.dao.LaptopDao;

public class Main {
	public static void main(String[] args) {
		LaptopDao laptop = new LaptopDao();
		Scanner sc = new Scanner(System.in);
		char option = ' ';

		do {

			System.out.println(
					"1.Display Data  \n2.Insert Data \n3.Update Ram & Processor 	\n4.Update All    \n5.Delete Data \n6.Exit");
			System.out.print("Please enter your choice  : ");
			int c = sc.nextInt();

//======================================================================================================
			if (c == 0 || c > 7) {
				System.out.println("Please chose a correct option.");
				continue;
			}
			switch (c) {
//==============================CASE:1==================================================================		
			case 1:
				System.out.println("*************************You chose Display Data*************************");
				System.out.println("====================================================");
				laptop.displayData();
				break;
//==============================END====================================================================	
//==============================CASE:	2==================================================================
			case 2:
				System.out.println("*************************You chose Inseert Data************************* ");
				System.out.println("Enter :   1.Id  	2.Company	3.Ram		4.Color 	 5.Processor");

				System.out.println("Enter id");
				int id = sc.nextInt();

				System.out.println("Enter Company");
				String company = sc.next();

				System.out.println("Enter Ram");
				int ram = sc.nextInt();

				System.out.println("Enter Color");
				String color = sc.next();

				System.out.println("Enter Processor");
				String processor = sc.next();

				laptop.insertData(id, company, ram, color, processor);

				break;
//==============================END====================================================================
//==============================CASE:3==================================================================
			case 3:
				System.out.println("*************************You chose update Ram& Processor*************************");
				System.out.println("Enter id of Laptop to update");
				int laptop_id = sc.nextInt();

				System.out.println("Enter new ram of laptop");
				int new_ram = sc.nextInt();

				System.out.println("Enter new processor of laptop");
				String new_processor = sc.next();

				laptop.updateData(new_ram, new_processor, laptop_id);

				break;
//==============================END===================================================================
//==============================CASE:4=================================================================			
			case 4:
				System.out.println("*************************You chose update all*************************");
				System.out.print("Enter id of laptop to update :  ");
				int lp_id = sc.nextInt();

				System.out.print("Enter new Company name  : ");
				String lp_comp = sc.next();

				System.out.print("Enter new Ram : ");
				int lp_ram = sc.nextInt();

				System.out.print("Enter new Color : ");
				String lp_color = sc.next();

				System.out.print("Enter new Processor : ");
				String lp_processor = sc.next();

				laptop.updateAll(lp_comp, lp_ram, lp_color, lp_processor, lp_id);

				break;
//==============================END==================================================================
//==============================CASE:5=================================================================			
			case 5:
				System.out.println(
						"*****************************You chose delete data***************************************** ");
				System.out.print("Enter laptop id to delete data :");
				int lap_id = sc.nextInt();

				laptop.deleteData(lap_id);
				break;
//==============================END====================================================================
//==============================Exit from Application=======================================================				
			case 6:
				System.out.println("Exiting...");
				sc.close();
				return;
//==============================Exit from Application=======================================================                
			default:
				System.out.println("Invalid choice please try again");
				break;
			}
			System.out.println("Press Y/y to continue or any other key to exit:  ");
			System.out.print("Enter your choice  :  ");
			 option = sc.next().charAt(0);
		} while (option == 'Y' || option == 'y');

		sc.close();
	}

}
