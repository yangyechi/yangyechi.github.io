package com.team69.cet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationTemp;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team69.cet.entity.Pay_information;
import com.team69.cet.entity.User;
import com.team69.cet.entity.apply_examination;
import com.team69.cet.service.apply_examination_service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@CrossOrigin(origins = "*")
@RestController
@EnableAutoConfiguration
@Api(tags = "报名信息api")
@Validated
public class apply_examination_controller {

	@Autowired
	apply_examination_service apply_examination_service;
	//查询所有报名信息
	@ApiOperation(value = "查询所有报名信息")
    @GetMapping("/apply_examinationfindall")
    public Object apply_examinationfindall()
    {
    	Map map=new HashMap();//创建一个哈希表
    	List<apply_examination>apply_examinations=apply_examination_service.findapply_examinationInfo();
    	map.put("apply_examinations", apply_examinations);//将数据放入哈希表
    	return map;
    	
    }
	
	//添加报名信息
	@ApiOperation(value = "添加报名信息")
    @PostMapping("/apply_examinationadd")
    public Object apply_examinationadd(@ApiParam(required = true, value = "添加报名信息")@RequestBody @Valid apply_examination apply_examination)
    {
		Map map=new HashMap();
		apply_examination_service.Insertapply_examination(apply_examination);;
		map.put("msg", apply_examination);
		return  map;
    }
	//删除报名信息
	@ApiOperation(value = "删除报名信息")
    @DeleteMapping("/apply_examinationdelete")
    public Object apply_examinationdelete(@RequestParam("examregistration_number")String examregistration_number)
    {
    	 
		Map map=new HashMap();
		apply_examination_service.delete(examregistration_number);
		map.put("msg", "ok");
	    return  map;

    }
	//通过examregistration_number查询报名信息
	@ApiOperation(value = "通过examregistration_number查询报名信息")
    @GetMapping("/apply_examinationfindbyexamregistration")
    public Object apply_examinationfindbyexamregistration(@RequestParam("examregistration_number")String examregistration_number)
    {
		Map map=new HashMap();
		apply_examination apply_examination=apply_examination_service.findbyexamregistration_number(examregistration_number);
		map.put("msg", apply_examination);
	    return  map;
    
    }
	//修改报名信息
	@ApiOperation(value = "修改报名信息")
	@PostMapping("/apply_examination_change")
	public Object apply_examination_change(@ApiParam(required = true, value = "修改报名信息")@RequestBody @Valid apply_examination apply_examination)
	{
		apply_examination_service.Updateapply_examination(apply_examination);
		return "修改成功";
	}
}
