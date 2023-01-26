package com.salesken.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.metamodel.model.domain.IdentifiableDomainType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.exception.StudentException;
import com.salesken.model.Report;
import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.repository.SemesterDao;
import com.salesken.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao stuDao;
	
	@Autowired
	private SemesterDao semDao;

	@Override
	public Student addStudentDetails(Student student) throws StudentException {
		
		
		return stuDao.save(student);
	}



	@Override
	public double showClassAvg(Integer id) throws StudentException {
		
		List<Semester> list=semDao.findTotalStudent(id);
		
		if(list.isEmpty()) {
			throw new StudentException("No student present in this sem");
		}
		double marks=0;
		
		for(Semester s :list) {
			marks+=s.getMaths()+ s.getEnglish() +s.getScience();
		}
		
		double avg=(marks/(list.size()*3));		
		return avg;
	}

	@Override
	public List<Student> topTwoStudents() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double subWiseAvg(String subject) throws StudentException {
		
		List<Student> sList=stuDao.findAll();
		
		int avgMath=0;
		int avgSci=0;
		int avgEng=0;
		int count=0;
		
		if(sList.isEmpty()) {
			
			throw new StudentException("No student present");
		}
		
		for(Student student :sList) {
			List<Semester> sems=student.getSems();
			count=sems.size();
			
			for(Semester sem: sems) {
				
				avgMath+=sem.getMaths();
				avgEng+=sem.getEnglish();
				avgSci+=sem.getScience();
				
			}
		}
		if(subject.equalsIgnoreCase("math")) {
			return avgMath/(sList.size()+count);
		}
		else if (subject.equalsIgnoreCase("english")) {
			return avgEng/(sList.size()+count);
		}
		else if (subject.equalsIgnoreCase("science")) {
			return avgSci/(sList.size()+count);
		}
		else {
			throw new StudentException("enter valod subject");
		}
		
	}

	



}
