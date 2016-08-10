package com.capgemini;

import java.util.Arrays;

public class Student {
	
	private int rollNumber;
	private String name;
	private String[] courseNames;
	
	public Student(int rollNumber, String name) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
	}
	public Student(int rollNumber, String name, String[] courseNames) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.courseNames = courseNames;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getCourseNames() {
		return courseNames;
	}
	public void setCourseNames(String[] courseNames) {
		this.courseNames = courseNames;
	}
	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", courseNames=" + Arrays.toString(courseNames)
				+ "]";
	}
	
	

}
