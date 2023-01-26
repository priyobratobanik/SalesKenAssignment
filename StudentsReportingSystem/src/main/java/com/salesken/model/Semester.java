package com.salesken.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Semester {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer semId;
	
	private Integer semNumber;
	
	private Integer maths;
	
	private Integer english;
	
	private Integer science;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Student student;

	public Integer getSemId() {
		return semId;
	}

	public void setSemId(Integer semId) {
		this.semId = semId;
	}

	public Integer getSemNumber() {
		return semNumber;
	}

	public void setSemNumber(Integer semNumber) {
		this.semNumber = semNumber;
	}

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getEnglish() {
		return english;
	}

	public void setEnglish(Integer english) {
		this.english = english;
	}

	public Integer getScience() {
		return science;
	}

	public void setScience(Integer science) {
		this.science = science;
	}

	public Semester(Integer semId, Integer semNumber, Integer maths, Integer english, Integer science) {
		super();
		this.semId = semId;
		this.semNumber = semNumber;
		this.maths = maths;
		this.english = english;
		this.science = science;
	}

	public Semester() {
		
	}
	
	
	
}
