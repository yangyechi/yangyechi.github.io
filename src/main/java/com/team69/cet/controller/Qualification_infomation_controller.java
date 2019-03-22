package com.team69.cet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.RestController;

import com.team69.cet.entity.Qualification_infomation;
import com.team69.cet.entity.Student_information;
import com.team69.cet.entity.User;
import com.team69.cet.entity.apply_examination;
import com.team69.cet.entity.examination_information;
import com.team69.cet.service.Qualification_infomation_service;
import com.team69.cet.service.Student_information_service;
import com.team69.cet.service.apply_examination_service;
import com.team69.cet.service.examination_information_service;

@CrossOrigin(origins = "*")
@Controller
@EnableAutoConfiguration
@Api(tags = "资格信息api")
@Validated
public class Qualification_infomation_controller {
	@Autowired
	Qualification_infomation_service qualification_infomation_service;
	
	
	
	@Autowired
	apply_examination_service apply_examination;
	
	
	
	
	@PostMapping("/searchQualificationInfo")
    public String searchQualificationInfo(Model model,HttpSession session)
    {
		
		Qualification_infomation qualification_info = 
				(Qualification_infomation)session.getAttribute("qulificationInfo");
		if(qualification_info != null)
		{
			if(qualification_info.getAbsence().equals("否") || qualification_info.getAbsence().equals("") )
			{
				
				apply_examination apply = apply_examination.findByIdNumber(qualification_info.getID_number());
				
				session.removeAttribute("error");
				session.setAttribute("applyExaminationInfo", apply);
				
				return "RegistrationInfo";
			}
			else {
				//session.removeAttribute("error");
				//session.setAttribute("error", "由于上次缺考，本次不能报考！");						
				return "index";	
			}
		}
		else {		
			    
				return "index";			
		}
    }
	
	
	
	
	
	
	
	/*
	//查询所有资格信息
	@ApiOperation(value = "查询所有资格信息")
    @GetMapping("/qualification_infomation_findall")
    public Object qualification_infomationadd()
    {
    	Map map=new HashMap();//创建一个哈希表
    	List<Qualification_infomation>qualification_infomations=qualification_infomation_service.findQualification_infomationInfo();
    	map.put("qualification_infomations", qualification_infomations);//将数据放入哈希表
    	return map;
    	
    }
	//添加资格信息
	@ApiOperation(value = "添加资格信息")
    @PostMapping("/qualification_infomation_add")
    public Object qualification_infomationadd(@ApiParam(required = true, value = "添加资格信息")@RequestBody @Valid Qualification_infomation qualification_infomation)
    {
		Map map=new HashMap();
		qualification_infomation_service.InsertQualification_infomation(qualification_infomation);;
		map.put("msg", qualification_infomation);
		return  map;
    }
	//删除资格信息
	@ApiOperation(value = "删除资格信息")
    @DeleteMapping("/qualification_infomation_delete")
    public Object qualification_infomationdelete(@RequestParam("qualification")String qualification)
    {
    	 
    	Map map=new HashMap();
    	qualification_infomation_service.delete(qualification);
		map.put("msg", "ok");
	    return  map;

    }
    //通过qualification查询资格信息
  	@ApiOperation(value = "通过qualification查询资格信息")
    @GetMapping("/qualification_infomation_servicefindbyqualification")
    public Object qualification_infomationfindbyqualification(@RequestParam("qualification")String qualification)
    {
  		Map map=new HashMap();
  		Qualification_infomation qualification_infomation=qualification_infomation_service.findbyqualification(qualification);
		map.put("msg", qualification_infomation);
	    return  map;
    
    }
  	
    //修改资格信息
  	@ApiOperation(value = "修改资格信息")
  	@PostMapping("/qualification_infomation_change")
  	public Object qualification_infomation_change(@ApiParam(required = true, value = "修改资格信息")@RequestBody @Valid Qualification_infomation qualification_infomation)
  	{
  		qualification_infomation_service.UpdateQualification_infomation(qualification_infomation);
  		return "修改成功";
  	}
  	*/
}
