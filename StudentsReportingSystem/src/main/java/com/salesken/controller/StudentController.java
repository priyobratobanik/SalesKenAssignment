package com.salesken.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.exception.StudentException;
import com.salesken.model.Student;
import com.salesken.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService sService;
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudentDetailsHandler(@RequestBody Student student) throws StudentException{
		return new ResponseEntity<>(sService.addStudentDetails(student),HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{enterSemester}")
	public ResponseEntity<Double> showAvgPercentageOfClass(@RequestParam Integer id)throws StudentException{
		return new ResponseEntity<Double>(sService.showClassAvg(id),HttpStatus.OK);
	}
	
	@GetMapping("/student/{enterSubject}")
	public ResponseEntity<Double> showAvgPerSubject(@RequestParam String subject)throws StudentException{
		
		return new ResponseEntity<Double>(sService.subWiseAvg(subject),HttpStatus.OK);
	}

}
