package com.team69.cet.service;

import java.util.List;

import com.team69.cet.entity.Student_information;



public interface Student_information_service {
	public List<Student_information> findStudent_informationInfo();//查询
	public void delete(String t);//删除
	public void UpdateStudent_information(Student_information student_information);//更新
	public void InsertStudent_information(Student_information student_information);//插入数据
	public Student_information findbystduentnumber(String t);//查询数据
	public Student_information findByIDNumber(String t);
}
