package com.school.models;

public class Lesson {
	private int idLesson; 
	private String nameClass;
	private Hour hour;
	
	public Lesson() {}
	
	public Lesson(int idLesson, String nameClass, Hour hour) {
		this.idLesson = idLesson;
		this.nameClass = nameClass;
		this.hour = hour;
	}
	
	public int getIdLesson() {
		return idLesson;
	}
	public void setIdLesson(int idLesson) {
		this.idLesson = idLesson;
	}
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}
	public Hour getHour() {
		return hour;
	}
	public void setHour(Hour hour) {
		this.hour = hour;
	}
	
	
	
}
