package com.capgemini;

import java.util.Scanner;

public class Admin {

	private static Scanner sc = new Scanner(System.in);
	private static StudentSchedular studSch = new StudentSchedular();
	private static final String WRONG_NUMBER_MSG = "Please enter a valid number";
	private static final String TRY_AGAIN_MSG = "Please enter again.";

	public static void main(String[] args) {
		showMenu();
	}

	private static void showMenu() {

		int choice;

		while (true) {
			System.out.println("Main menu");
			System.out.println("1. add student");
			System.out.println("2. show all students");
			System.out.println("3. reports");
			System.out.println("4. exit");

			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				addStudentDetails();
				break;
			case 2:
				showAllStudents();
				break;
			case 3:
				showReports();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Sorry entered wrong choice");

			}

		}

	}

	private static void showReports() {
		int choice;

		while (true) {
			System.out.println("Main menu >> reports");
			System.out.println("1. Individual student report");
			System.out.println("2. count students by course name");
			System.out.println("3. back to main menu");

			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				sowIndividualReport();
				break;
			case 2:
				countStudentsByCourseName();
				break;
			case 3:
				return;
			default:
				System.out.println("Sorry entered wrong choice");

			}

		}
	}

	private static void countStudentsByCourseName() {
		System.out.println("Enter course name");
		String name = sc.next();
		name += sc.nextLine();
		System.out.println("Number of students found in course "+name+" :: "+studSch.getStudentCountByCourse(name));
	}

	private static void sowIndividualReport() {
		System.out.println("Enter roll number");
		int rollNumber;
		while (true) {
			
			try {
				rollNumber = sc.nextInt();
				if(rollNumber>0){
					System.out.println(studSch.showStudentByRollNumber(rollNumber));
					break;
				}
				else{
					System.out.println("Value should be > 0");
					System.out.println(TRY_AGAIN_MSG);
				}
			} catch (Exception e) {
				System.out.println(WRONG_NUMBER_MSG);
				System.out.println(TRY_AGAIN_MSG);
				sc.nextLine();
			}
			
		}
	}

	private static void showAllStudents() {
		studSch.showAllStudents();

	}

	private static void addStudentDetails() {
		System.out.println("Enter roll number");
		int rollNumber;
		while (true) {
			
			try {
				rollNumber = sc.nextInt();
				if(rollNumber>0){
					if(!studSch.isExist(rollNumber))
						break;
					else{
						System.out.println("This roll number is aleardy exist. Please try another one.");
					}
				}
				else{
					System.out.println("Value should be > 0");
					System.out.println(TRY_AGAIN_MSG);
				}
			} catch (Exception e) {
				System.out.println(WRONG_NUMBER_MSG);
				System.out.println(TRY_AGAIN_MSG);
				sc.nextLine();
			}
			
		}
		
		System.out.println("Enter name");
		String name = sc.next();
		name += sc.nextLine();

		System.out.println("Enter number of courses");
		while (true) {
			int courses;
			try {
				courses = sc.nextInt();

				if (courses > 0) {
					String[] courseNames = new String[courses];
					for (int i = 0; i < courses; i++) {
						courseNames[i] = sc.next();
						courseNames[i] += sc.nextLine();
					}
					System.out.println(studSch.addStudent(rollNumber, name, courseNames));
					break;
				} else {
					System.out.println("Value should be > 0");
					System.out.println(TRY_AGAIN_MSG);
				}
			} catch (Exception e) {
				System.out.println(WRONG_NUMBER_MSG);
				System.out.println(TRY_AGAIN_MSG);
				sc.nextLine();
			}
			
		}

	}

}
