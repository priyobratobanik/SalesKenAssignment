package com.salesken.service;

import java.util.List;

import com.salesken.exception.StudentException;
import com.salesken.model.Report;
import com.salesken.model.Student;

public interface StudentService {

	
	public Student addStudentDetails(Student student) throws StudentException;
	
	public double showClassAvg(Integer id) throws StudentException;
	
	public double subWiseAvg(String subject)throws StudentException;
	
	public List<Student> topTwoStudents();
	
	
	
}
