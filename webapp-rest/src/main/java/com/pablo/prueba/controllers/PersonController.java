package com.pablo.prueba.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.pablo.prueba.models.Person;

@RestController
public class PersonController {
		
	private List<Person> personsDB = new ArrayList<>();
	
	@GetMapping("/api/persons")
	public List<Person> allPersons(){
		return personsDB;
	}
	
	@PostMapping("/api/person")
	public Map<Object, Object> addNewPerson(@RequestBody Person person ) {
		Map<Object, Object> mapPerson = new HashMap<Object, Object>();
		this.personsDB.add(new Person(person.getIdPerson(), person.getName(), person.getAge()));
		mapPerson.put("name ", person.getName());
		mapPerson.put("status ", (person.getAge() > 18 ) ? "es mayor de edad" : "es menor de edad");
		return mapPerson;
	}
	
	@GetMapping("/api/person/{id}")
	public Person findOnePerson(@PathVariable int id ) {
		Person findPerson = this.personsDB
				.stream()
				.filter(p -> p.getIdPerson() == id )
				.findAny()
				.orElse(null);
		return findPerson;
	}
	
	// @DeleteMapping --- > {id}
	
	// @PutMapping  ----- > {.. body ..}, {id}
	/// algoritmo
	// yo obtengo el body, yo obtengo el id
	// loguarlos
	// yo con el id obtenido obtengo el objeto
	// con ese objeto obtenido yo modifico los campos
}
