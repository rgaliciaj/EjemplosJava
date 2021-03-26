package com.webappPrueba.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webappPrueba.models.AsignacionCarroPersona;
import com.webappPrueba.models.Car;
import com.webappPrueba.models.Person;
import com.webappPrueba.services.AsignacionService;

@RestController
public class controllers {
	
	AsignacionService asignacionService = new AsignacionService();
	
	
	@GetMapping("/api/persons")
	public List<Person> personList(){
		return AsignacionService.getInstance().personDB;
	}	
	
	@PostMapping("/api/person")
	//forma 1
	public Person addPerson(@RequestBody Person person) {
		Person per = new Person(person.getIdPerson(), person.getName());
		AsignacionService.getInstance().personDB.add(per);
		return per;
		
	}
	//forma 2
	/*public Map<Object, Object> addPerson(@RequestBody Person person){
		Map<Object, Object> mapPerson = new HashMap<Object, Object>();
		this.personDB.add(new Person(person.getIdPerson(), person.getName()));
		mapPerson.put("datos ingresados", personDB);
		return mapPerson;
	}*/
	
	@GetMapping("/api/person/{id}")
	public Person findOnePerson(@PathVariable int id) {
		
		Person findPerson = AsignacionService.getInstance().personDB
				.stream()
				.filter(p -> p.getIdPerson() == id)
				.findAny()
				.orElse(null);
		return findPerson;
	}
	
	@DeleteMapping("/api/person/{id}")
	public Map<Object, Object> deletePersonById(@PathVariable int id){
		Map<Object, Object> deleteMap = new HashMap<Object, Object>();
		
		Person findPerson = asignacionService.getInstance().personDB
				.stream()
				.filter(p -> p.getIdPerson() == id)
				.findAny()
				.orElse(null);
		asignacionService.getInstance().personDB.remove(findPerson);
		deleteMap.put("message", (findPerson != null) ? "se elimino correctamente " : "no se pudo eliminar");
		deleteMap.put("name", (findPerson != null) ? findPerson.getName() : "no existe persona con id= " + id );
		return deleteMap;
	}
	
	@PutMapping("/api/person/{id}")
	public Person updatePersonById(@RequestBody Person newPersonData, @PathVariable int id) {
		Person findPerson = asignacionService.getInstance().personDB
				.stream()
				.filter(p -> p.getIdPerson() == id)
				.findAny()
				.orElse(null);
		
		findPerson.setName(newPersonData.getName());
		 
		return findPerson;
	}
	
	@GetMapping("/api/getcar")
	public List<AsignacionCarroPersona> getAllCarsByPerson(){
		List<AsignacionCarroPersona> asignacionList = AsignacionService.getInstance().personDB
				.stream()
				.map(p -> {
					AsignacionCarroPersona asignacionCarroPersona =  new AsignacionCarroPersona();
					asignacionCarroPersona.person = p;
					asignacionCarroPersona.cars = this.searchCarsByIdOwner(p.getIdPerson());
					return asignacionCarroPersona;
				}).collect(Collectors.toList());
		
		return asignacionList;
		
	}
	
	//aux method
	public List<Car> searchCarsByIdOwner(int idPerson){
		List<Car> carsFinded = AsignacionService.getInstance()
				.carList
				.stream()
				.filter( c -> c.getIdPerson() == idPerson)
				.collect(Collectors.toList());
		return carsFinded;
	}
	
}