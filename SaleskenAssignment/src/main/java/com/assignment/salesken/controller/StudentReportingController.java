package com.assignment.salesken.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assignment.salesken.model.MarksReportDTO;
import com.assignment.salesken.model.Semester;
import com.assignment.salesken.model.Student;
import com.assignment.salesken.services.StudentService;

@Controller
public class StudentReportingController {

	@Autowired
	private StudentService sService;

	@PostMapping("/add-students")
	public ResponseEntity<Student> saveStudentHandler(@RequestBody Student student) {

		Student saveStudent = sService.createStudent(student);

		return new ResponseEntity<Student>(saveStudent, HttpStatus.CREATED);
	}

	@PutMapping("/add-marks/{studentId}")
	public ResponseEntity<String> saveMarksHandler(@PathVariable("studentId") Integer studentId,
			@RequestBody Semester semester) {
		sService.setMarks(studentId, semester);
		return new ResponseEntity<String>("student marks added succesfully", HttpStatus.OK);
	}

	@GetMapping("/students/{semesterId}")
	public ResponseEntity<MarksReportDTO> showMarksHandler(@PathVariable("semesterId") Integer semId) {

		MarksReportDTO saveReportDTO = sService.averageReports(semId);
		return new ResponseEntity<MarksReportDTO>(saveReportDTO, HttpStatus.OK);
	}

	@GetMapping("/topstudents")
	public ResponseEntity<List<Student>> showTopStudentHandler() {

		List<Student> students = sService.topTwoStudents();

		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}

}
