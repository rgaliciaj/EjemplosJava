package com.pablo.prueba.models;

public class Car {
	private int idCar; 
	private String brand;
	private int idPerson;
	
	public Car () {}
 	
	public Car(int idCar, String brand, int idPerson) {
		this.idCar = idCar;
		this.brand = brand;
		this.idPerson = idPerson;
	}
	
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getIdPerson() {
		return idPerson;
	}
	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}
}
