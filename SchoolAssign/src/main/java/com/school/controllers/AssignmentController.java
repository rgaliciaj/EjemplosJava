package com.school.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.models.Student;

@RestController
public class AssignmentController {

	private List<Student> studentList = new ArrayList<>();
	
	@GetMapping("/assign/hello")
	public String doHello() {
		return "Hola dev...";
	}
	
	
	@PostMapping("/assign/student")
	public String addStudent(@RequestBody Student student ) {
		String result = "";
		Student newStudent = new Student();
		newStudent.setIdStudent(student.getIdStudent());
		newStudent.setName(student.getName());
		this.studentList.add(newStudent);
		return result = "Se agrego correctamente el estudiante " + newStudent.getName();
	}
	
}
