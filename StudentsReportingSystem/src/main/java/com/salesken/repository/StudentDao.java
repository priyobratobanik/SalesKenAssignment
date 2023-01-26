package com.salesken.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesken.model.Student;

public interface StudentDao extends JpaRepository<Student, Integer>{

//	@Query("from student")
//	public List<Student> findTotalStudent();
}
