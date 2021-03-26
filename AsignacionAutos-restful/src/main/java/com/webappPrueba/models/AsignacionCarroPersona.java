package com.webappPrueba.models;

import java.util.List;

public class AsignacionCarroPersona {
	public Person person;
	public List<Car> cars;
	
	public AsignacionCarroPersona() {
		
	}
	
	public AsignacionCarroPersona(Person person, List<Car> cars) {
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
