package com.school.models;

public class Student {
	private int idStudent;
	private String name;
	
	public Student(int idStudent, String name) {
		super();
		this.idStudent = idStudent;
		this.name = name;
	}
	
	public Student() {}
	
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
