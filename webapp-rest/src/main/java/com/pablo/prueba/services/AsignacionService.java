package com.pablo.prueba.services;

import java.util.ArrayList;
import java.util.List;


import com.pablo.prueba.models.Car;
import com.pablo.prueba.models.Person;

public class AsignacionService {
	public static AsignacionService instance;
	
	public static AsignacionService getInstance() {
		if(instance == null ) {
			instance = new AsignacionService();
		}
		return instance;
	}
	
	public List<Car> carsList = new ArrayList<>();
	public List<Person> personsDB = new ArrayList<>();
	
}
