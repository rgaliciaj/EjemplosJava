package com.webappPrueba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webappPrueba.models.Car;
import com.webappPrueba.services.AsignacionService;

@RestController
public class CarController {
	
	//private List<Car> carDB = new ArrayList<>();
	
	@GetMapping("/api/cars")
	public List<Car> allCars(){
		return AsignacionService.getInstance().carList;
	}
	
	@PostMapping("/api/car")
	public Car addCar (@RequestBody Car car) {
		AsignacionService.getInstance().carList.add(new Car(car.getIdCar(), car.getBrand(), car.getIdPerson()));
		return car;
		
	}
	
	@GetMapping("/api/car/{id}")
	public Car findOnePerson(@PathVariable int id) {
		
		Car findCar = AsignacionService.getInstance().carList
				.stream()
				.filter(p -> p.getIdPerson() == id)
				.findAny()
				.orElse(null);
		return findCar;
		
	}
	
	@DeleteMapping("/api/car/{id}")
	public Map<Object, Object> deleteCarById(@PathVariable int id){
		Map<Object, Object> deleteMap = new HashMap<Object, Object>();
		Car findCar = AsignacionService.getInstance().carList
				.stream()
				.filter(c -> c.getIdCar() == id)
				.findAny()
				.orElse(null);
		AsignacionService.getInstance().carList.remove(findCar);
		deleteMap.put("message ", (findCar != null) ? "Se elimino correctamente" : "no se pudo eliminar");
		deleteMap.put("brand", (findCar != null) ? findCar.getBrand() : "no existe carro con id " + id);
		return deleteMap;
		
	}
	
	@PutMapping("/api/car/{id}")
	public Car updateCar(@RequestBody Car newCarData, @PathVariable int id) {
		Car findCar = AsignacionService.getInstance().carList
				.stream()
				.filter(c -> c.getIdCar() ==  id)
				.findAny()
				.orElse(null);
		
		findCar.setBrand(newCarData.getBrand());
		findCar.setIdPerson(newCarData.getIdPerson());
		
		return findCar;
		
	}
}
