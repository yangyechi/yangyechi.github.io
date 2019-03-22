package com.team69.cet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team69.cet.entity.Student_information;

@Mapper
public interface Student_information_mapper {
	public List<Student_information> findStudent_informationInfo();//查询
	public void delete(String t);//删除
	public void UpdateStudent_information(Student_information student_information);//更新
	public void InsertStudent_information(Student_information student_information);//插入数据
	public Student_information findbystduentnumber(String t);//根据学号查询
	public Student_information findByIDNumber(String t);//根据身份证号查询
}
