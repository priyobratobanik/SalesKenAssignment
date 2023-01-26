package com.salesken.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesken.model.Semester;

public interface SemesterDao extends JpaRepository<Semester, Integer>{
    
	public List<Semester> findByStudent(Integer sid);
	
	
	@Query("from Semester where semester = :id")
	public List<Semester> findTotalStudent(@Param("id") Integer sid);
	
//	@Query("from semester")
//	public List<Semester> avgOfMarksInSub(String subject);
}
