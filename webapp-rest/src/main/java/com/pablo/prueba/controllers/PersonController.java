package com.pablo.prueba.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.prueba.models.AsignacionCarrosPersona;
import com.pablo.prueba.models.Car;
import com.pablo.prueba.models.Person;
import com.pablo.prueba.services.AsignacionService;

@RestController
public class PersonController {
		
	//@Autowired
	//private AsignacionService asignacionService;
	
	AsignacionService asignacionService = new AsignacionService();
	
	@GetMapping("/api/persons")
	public List<Person> allPersons(){
		return AsignacionService.getInstance().personsDB;
	}
	
	@PostMapping("/api/person")
	public Map<Object, Object> addNewPerson(@RequestBody Person person ) {
		Map<Object, Object> mapPerson = new HashMap<Object, Object>();
		AsignacionService.getInstance().personsDB.add(new Person(person.getIdPerson(), person.getName(), person.getAge()));
		mapPerson.put("name ", person.getName());
		mapPerson.put("status ", (person.getAge() > 18 ) ? "es mayor de edad" : "es menor de edad");
		return mapPerson;
	}
	
	@GetMapping("/api/person/{id}")
	public Person findOnePerson(@PathVariable int id ) {
		Person findPerson = AsignacionService.getInstance().personsDB
				.stream()
				.filter(p -> p.getIdPerson() == id )
				.findAny()
				.orElse(null);
		return findPerson;
	}
	
	@DeleteMapping("/api/person/{id}")
	public Map<Object, Object> deletePersonById(@PathVariable int id ) {
		Map<Object, Object> deleteMap = new HashMap<Object, Object>();
		// forma 1
		/* this.personsDB.stream()
			.filter(p -> p.getIdPerson() == id )
			.findFirst()
			.map(per -> {
				this.personsDB.remove(per);
				return per;
			});*/
		
		// forma 2
		Person findPerson = AsignacionService.getInstance().personsDB
				.stream()
				.filter(p -> p.getIdPerson() == id )
				.findAny()
				.orElse(null);
		AsignacionService.getInstance().personsDB.remove(findPerson);
		deleteMap.put("message",  (findPerson != null) ? "se elimino correctamente" : "no se pudo eliminar" );
		deleteMap.put("name",  (findPerson != null) ?  findPerson.getName()  : "no existia una persona con id = " + id );
		return deleteMap;
	}
	
	@PutMapping("/api/person/{id}")
	public Person updatePersonById(@RequestBody Person newPersonData, @PathVariable int id) {
		Person findPerson = AsignacionService.getInstance().personsDB
				.stream()
				.filter(p -> p.getIdPerson() == id )
				.findAny()
				.orElse(null);
		// sobre-escribi las propiedades del objeto
		findPerson.setName(newPersonData.getName());
		findPerson.setAge(newPersonData.getAge());
		return findPerson;
	}
	
	@GetMapping("/api/persons/car")
	public List<AsignacionCarrosPersona> getAllCarsByPerson(){
		List<AsignacionCarrosPersona> asignacionList =  AsignacionService.getInstance().personsDB.stream()
			.map( p -> {
				AsignacionCarrosPersona asignacionCarrosPersona = new AsignacionCarrosPersona();
				asignacionCarrosPersona.person = p;
				asignacionCarrosPersona.cars = this.searchCarsByIdOwner(p.getIdPerson());
			return asignacionCarrosPersona;
		}).collect(Collectors.toList());
		
		return  asignacionList;
	}
	
	// aux method
	public List<Car> searchCarsByIdOwner(int idPerson) {
		List<Car> carsFinded = AsignacionService.getInstance()
				.carsList
				.stream()
				.filter( c -> c.getIdPerson() == idPerson )
				.collect(Collectors.toList());
		return carsFinded;
	}
	
}
