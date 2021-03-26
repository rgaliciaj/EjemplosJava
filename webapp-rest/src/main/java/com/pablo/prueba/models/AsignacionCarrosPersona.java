package com.pablo.prueba.models;

import java.util.List;

public class AsignacionCarrosPersona {
	public Person person;
	public List<Car> cars;
	
	public AsignacionCarrosPersona() {}
	
	public AsignacionCarrosPersona(Person person, List<Car> cars) {
		this.person = person;
		this.cars = cars;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	

}
