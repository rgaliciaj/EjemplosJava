package com.pablo.prueba.models;

public class Person {
	private int idPerson;
	private String name;
	private int age;
	
	public Person(int idPerson, String name, int age) {
		this.idPerson = idPerson;
		this.name = name;
		this.age = age;
	}
	
	public Person() {}
	
	public int getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
