package com.pablo.prueba.controllers;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.prueba.models.Car;
import com.pablo.prueba.services.AsignacionService;

@RestController
public class CarController {
	

	//@Autowired
	//private AsignacionService asignacionService;
	
	// add car
	@PostMapping("/api/car")
	public Car addNewCar(@RequestBody Car car) {
		AsignacionService.getInstance().carsList.add( new Car(car.getIdCar(), car.getBrand(), car.getIdPerson()));
		return car;
	}
	
	// list cars
	@GetMapping("/api/cars")
	public List<Car> allCars() {
		return AsignacionService.getInstance().carsList;
	}
	
}
