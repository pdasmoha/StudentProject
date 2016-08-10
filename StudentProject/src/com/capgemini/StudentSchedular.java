package com.capgemini;

public class StudentSchedular {
	
	private Student[] students = new Student[10];
	private int counterStudent=0;
	
	public String addStudent(int rollNumber,String name, String[] courseNames)
	{
		
		students[counterStudent++]=new Student(rollNumber,name, courseNames);
		return "Student added successfully";
		
	}
	
	public void showAllStudents()
	{
		for (int i = 0; i < counterStudent; i++) {
			System.out.println(students[i]);
		}
	}
	
	public String showStudentByRollNumber(int rollNumber)
	{
		for (int i = 0; i < counterStudent; i++) {
			if(rollNumber==students[i].getRollNumber()){
				return students[i].toString();
			}
		}
		return "No student found..";
	}
	
	public boolean isExist(int rollNumber){
		for (int i = 0; i < counterStudent; i++) {
			if(rollNumber==students[i].getRollNumber()){
				return true;
			}
		}
		return false;
	}
	
	public int getStudentCountByCourse(String courseName){
		int studentCount=0;
		for (int i = 0; i < counterStudent; i++) {
			inner:
			for (int j = 0; j < students[i].getCourseNames().length; j++) {
				if(courseName.equalsIgnoreCase(students[i].getCourseNames()[j])){
					studentCount++;
					break inner;
				}
			}
		}
		return studentCount;
	}

}
