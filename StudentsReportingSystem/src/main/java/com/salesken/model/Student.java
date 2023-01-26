package com.salesken.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Semester> sems=new ArrayList<>(2);

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Semester> getSems() {
		return sems;
	}

	public void setSems(List<Semester> sems) {
		this.sems = sems;
	}

	public Student() {
		
	}

	public Student(Integer sId, String name, List<Semester> sems) {
		super();
		this.sId = sId;
		this.name = name;
		this.sems = sems;
	}
	
	
}
