package com.team69.cet.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team69.cet.service.Student_information_service;
import com.team69.cet.entity.Student_information;
import com.team69.cet.mapper.Student_information_mapper;

@Service
public class Student_information_serviceimpl implements Student_information_service{
	@Autowired
	Student_information_mapper student_information_mapper;
	@Override
	public List<Student_information> findStudent_informationInfo() {
		// TODO Auto-generated method stub
		return student_information_mapper.findStudent_informationInfo();
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		 student_information_mapper.delete(t);
	}

	@Override
	public void UpdateStudent_information(
			Student_information student_information) {
		// TODO Auto-generated method stub
		 student_information_mapper.UpdateStudent_information(student_information);
	}

	@Override
	public void InsertStudent_information(
			Student_information student_information) {
		// TODO Auto-generated method stub
		 student_information_mapper.InsertStudent_information(student_information);
	}


	@Override
	public Student_information findbystduentnumber(String t) {
		// TODO Auto-generated method stub
		return student_information_mapper.findbystduentnumber(t);
	}

	public Student_information findByIDNumber(String t)
	{
		return student_information_mapper.findByIDNumber(t);
	}
}
