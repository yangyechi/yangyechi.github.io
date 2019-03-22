package com.team69.cet.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;







import com.team69.cet.entity.Qualification_infomation;
import com.team69.cet.entity.Student_information;
import com.team69.cet.entity.User;
import com.team69.cet.service.Qualification_infomation_service;
import com.team69.cet.service.Student_information_service;
import com.team69.cet.service.User_service;
@CrossOrigin(origins = "*")
@Controller
@EnableAutoConfiguration
@Api(tags = "用户信息API")
@Validated
public class User_controller {
	@Autowired
	User_service user_service;
	
	@Autowired
	Student_information_service student_information_service;
	
	@Autowired
	Qualification_infomation_service qualification_infomation_service;
	
	@GetMapping("/")
	public String defualtPage() {
		return "index";
	}

	@GetMapping("/Home/{variable}")
	public String loginGet(@PathVariable("variable") String str,HttpSession session) {
		//System.out.println(str);
		/*
		if(str.equals("signUp"))
		{
			if(session.getAttribute("user")!=null)
			{
				return "QualificationInfo";	
			}
		}
	    */
		return str;
	}
	
	
	
	
	//注册
	@ApiOperation(value = "注册用户")
    @PostMapping("/doRegiste")
    public String useradd(@Valid User user, Model model)
    {
		User user1 =  user_service.findByEmail(user.getUser_name());
		
		if(user1 != null)
		{
			model.addAttribute("error", "该邮箱已被注册！");
			return "register";
		}
		else {
			user_service.InsertUser(user);
			return "signUp";
		}
    }
	
	//登录
	@PostMapping("/dologin")
	public String loginPost(@Valid User user, Model model, HttpSession httpSession) {
		User user1 = user_service.findByNameAndPassword(user);
		if (user1 != null) {
			 httpSession.setAttribute("user", user1);
			 Student_information student = student_information_service.findByIDNumber(user1.getID_number());
			 Qualification_infomation qulification = qualification_infomation_service.findByIdNumber(user1.getID_number());
			 if(student != null)
			 {
				    httpSession.setAttribute("studentInfo", student);
			    	httpSession.setAttribute("qulificationInfo", qulification);
			    	if(qulification.getAbsence().equals("是"))
			    	{
			    		httpSession.setAttribute("error", "由于上次缺考，本次不能报考！");
			    	}
			    	//model.addAttribute("studentInfo", student);
			    	else
			    	  httpSession.removeAttribute("error");
			 }
			 else {			    			
			    	httpSession.setAttribute("error", "没有你的学籍信息，请与相关老师联系!");
			    	httpSession.removeAttribute("studentInfo");
			    	httpSession.removeAttribute("qulificationInfo");
		     }
			 return "Protocol_Info";
		} else {
			   model.addAttribute("error", "用户名或密码错误，请重新登录！");
			   return "signUp";
		}
	}
	
	
	
	/*
	//查询所有用户信息
		@ApiOperation(value = "查询所有用户信息")
	    @GetMapping("/user_findall")
	    public Object userfindall()
	    {
	    	Map map=new HashMap();//创建一个哈希表
	    	List<User>users=user_service.findUserInfo();//创建一个users对象，用于存放从数据库中查询到的数据
	    	map.put("users", users);//将数据放入哈希表
	    	return map;
	    	
	    }
	//删除用户信息
	@ApiOperation(value = "删除用户信息")
    @DeleteMapping("/user_delete")
    public Object userdelete(@RequestParam("ID_number")String ID_number)
    {
		Map map=new HashMap();
    	user_service.delete(ID_number);
		map.put("msg", "ok");
	    return  map;

    }
	//通过ID_number查询用户信息
	@ApiOperation(value = "通过ID_number查询用户信息")
    @GetMapping("/user_findbyid")
    public Object userfindbyid(@RequestParam("ID_number")String ID_number)
    {
		Map map=new HashMap();
		User user=user_service.findbyid(ID_number);
		map.put("msg", user);
	    return  map;
    
    }
	
	//修改用户信息
	@ApiOperation(value = "修改用户信息")
	@PostMapping("/user_change")
	public Object user_change(@ApiParam(required = true, value = "修改用户信息")@RequestBody @Valid User user)
	{
		user_service.UpdateUser(user);
		return "修改成功";
	}
   */  
}
