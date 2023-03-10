package com.assignment.salesken.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollNumber;
	
	private String name;
	
	private String gender;
	
	private String address;
	
	private String email;
	
	@ElementCollection
	private List<Semester> semesters=new ArrayList<>();


	public Student(int rollNumber, String name, String gender, String address, String email) {
		
		this.rollNumber=rollNumber;
		this.name=name;
		this.gender=gender;
		this.address=address;
		this.email=email;
	}


}
