package com.webappPrueba.services;
import java.util.ArrayList;
import java.util.List;

import com.webappPrueba.models.Car;
import com.webappPrueba.models.Person;

public class AsignacionService {
	public static AsignacionService instance;
	
	public static AsignacionService getInstance() {
		if(instance == null) {
			instance = new AsignacionService();
		}
		return instance;
	}
	
	public List<Car> carList = new ArrayList<>();
	public List<Person> personDB = new ArrayList<>();
}
