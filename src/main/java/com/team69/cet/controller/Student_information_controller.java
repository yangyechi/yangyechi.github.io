package com.team69.cet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.team69.cet.entity.Student_information;
import com.team69.cet.entity.User;
import com.team69.cet.service.Student_information_service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@CrossOrigin(origins = "*")
@RestController
@EnableAutoConfiguration
@Api(tags = "报考学生信息api")
@Validated
public class Student_information_controller {
	@Autowired
	Student_information_service student_information_service;
	//查询所有学生信息
	@ApiOperation(value = "查询所有学生信息")
    @GetMapping("/student_information_findall")
    public Object student_informationfindall()
    {
    	Map map=new HashMap();//创建一个哈希表
    	List<Student_information>student_information=student_information_service.findStudent_informationInfo();
    	map.put("student_information", student_information);//将数据放入哈希表
    	return map;
    	
    }
	//增加学生信息
	@ApiOperation(value = "添加学生信息")
    @PostMapping("/student_information_add")
    public Object student_informationadd(@ApiParam(required = true, value = "添加学生信息")@RequestBody @Valid Student_information student_information)
    {
		Map map=new HashMap();
		student_information_service.InsertStudent_information(student_information);
		map.put("msg", student_information);
		return  map;
    	
    }
	//删除学生信息
	@ApiOperation(value = "删除学生信息")
    @DeleteMapping("/student_information_delete")
    public Object student_informationdelete(@RequestParam("student_number")String student_number)
    {
		Map map=new HashMap(); 
		student_information_service.delete(student_number);
		map.put("msg", "ok");
	    return  map;

    }
	//通过student_number来查询学生信息
	@ApiOperation(value = "通过student_number来查询学生信息")
    @GetMapping("/student_information_findbystudent")
    public Object student_informationfindbystudent(@RequestParam("student_number")String student_number)
    {
    	
		Map map=new HashMap();
		Student_information student_information=student_information_service.findbystduentnumber(student_number);
		map.put("msg", student_information);
	    return  map;
    
    }
	//修改学生信息
	@ApiOperation(value = "修改学生信息")
	@PostMapping("/student_information_change")
	public Object student_information_change(@ApiParam(required = true, value = "修改学生信息")@RequestBody @Valid Student_information student_information)
	{
		student_information_service.UpdateStudent_information(student_information);
		return "修改成功";
	}
    
    
   
   
}
