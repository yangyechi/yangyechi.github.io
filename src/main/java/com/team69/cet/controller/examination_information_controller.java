package com.team69.cet.controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
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
import org.springframework.web.bind.annotation.RestController;

import com.team69.cet.entity.Qualification_infomation;
import com.team69.cet.entity.Student_information;
import com.team69.cet.entity.User;
import com.team69.cet.entity.examination_information;
import com.team69.cet.service.examination_information_service;

@CrossOrigin(origins = "*")
@Controller
@EnableAutoConfiguration
@Api(tags = "考试信息api")
@Validated
public class examination_information_controller {
 
	    @Autowired
	    examination_information_service exaService;
	   
		@ApiOperation(value = "提交报考信息")
	    @PostMapping("/submitReistrationInfo")
	    public String useradd(Model model,HttpSession session,HttpServletRequest request)
	    {
			Qualification_infomation qualification_info = 
					(Qualification_infomation)session.getAttribute("qulificationInfo");
			String level = request.getParameter("level");
			String type = request.getParameter("type");
		    //String verification = request.getParameter("verification");
		   		   
			if(qualification_info.getLevel_four().equals("未通过") && level.equals("six"))
			{
				model.addAttribute("error", "四级没通过没有资格报考六级！请重新填写报考信息！");
				return "RegistrationInfo";
			}
			else {
				if(level.equals("four"))
				{
					level = "英语四级";
				}
				else {
					level = "英语六级";
				}
				if(type.equals("mouse"))
				{
					type = "口试";
				}
				else if(type.equals("pen"))
				{
					type = "笔试";
				}
				else {
					type = "口试和笔试";
				}
				examination_information exaInfo = new examination_information();
				exaInfo.setLevel(level);
				exaInfo.setType(type);
				Student_information studentInfo = (Student_information)session.getAttribute("studentInfo");
				exaInfo.setStudent_number(studentInfo.getStudent_number());
				exaService.Updateexamination_information(exaInfo);
				examination_information exa = exaService.findByStudentNumber(studentInfo.getStudent_number());
				session.setAttribute("exaInfo",exa);
				return "payPage";
			}
			
	    }
	
	
	
	
	
	
	
	
	
	/*
	@Autowired
	examination_information_service examination_information_service;
	//查询所有考试信息
	@ApiOperation(value = "查询所有考试信息")
    @GetMapping("/examination_informationfindall")
    public Object examination_informationfindall()
    {
    	Map map=new HashMap();//创建一个哈希表
    	List<examination_information>examination_informations=examination_information_service.findexamination_informationInfo();
    	map.put("examination_informations", examination_informations);
    	return map;
    	
    }
	//添加考试信息
	@ApiOperation(value = "添加考试信息")
    @PostMapping("/examination_informationadd")
    public Object examination_informationadd(@ApiParam(required = true, value = "添加考试信息")@RequestBody @Valid examination_information examination_information)
    {
		Map map=new HashMap();
		examination_information_service.Insertexamination_information(examination_information);;
		map.put("msg", examination_information);
		return  map;
    }
	//删除考试信息
	@ApiOperation(value = "删除考试信息")
    @DeleteMapping("/examination_informationdelete")
    public Object examination_informationdelete(@RequestParam("examination_number")Integer examination_number)
    {
    	 
		Map map=new HashMap();
		examination_information_service.delete(examination_number);
		map.put("msg", "ok");
	    return  map;

    }
	//通过examination_number查询考试信息
    @ApiOperation(value = "通过examination_number查询考试信息")
    @GetMapping("/examination_informationfindbyexamination")
    public Object examination_informationfindbyexamination(@RequestParam("examination_number")Integer examination_number)
    {
    	Map map=new HashMap();
    	examination_information examination_information=examination_information_service.findbyexamination_number(examination_number);
		map.put("msg", examination_information);
	    return  map;
    
    }
    //修改考试信息
  	@ApiOperation(value = "修改考试信息")
  	@PostMapping("/examination_information_change")
  	public Object examination_information_change(@ApiParam(required = true, value = "修改考试信息")@RequestBody @Valid examination_information examination_information)
  	{
  		examination_information_service.Updateexamination_information(examination_information);
  		return "修改成功";
  	}
  	*/
}
