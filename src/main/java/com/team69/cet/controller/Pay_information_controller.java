package com.team69.cet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.team69.cet.entity.Qualification_infomation;
import com.team69.cet.entity.User;
import com.team69.cet.service.Pay_information_service;

@CrossOrigin(origins = "*")
@RestController
@EnableAutoConfiguration
@Api(tags = "支付信息api")
@Validated
public class Pay_information_controller {

	@Autowired
	Pay_information_service pay_information_service;
	//查询所有支付信息
	@ApiOperation(value = "查询所有支付信息")
    @GetMapping("/pay_informationfindall")
    public Object pay_informationfindall()
    {
    	Map map=new HashMap();//创建一个哈希表
    	List<Pay_information>Pay_information=pay_information_service.findPay_informationInfo();
    	map.put("Pay_information", Pay_information);//将数据放入哈希表
    	return map;
    	
    }
	//添加支付信息
	@ApiOperation(value = "添加支付信息")
    @PostMapping("/pay_informationadd")
    public Object pay_informationadd(@ApiParam(required = true, value = "添加支付信息")@RequestBody @Valid Pay_information Pay_information)
    {
		Map map=new HashMap();
		pay_information_service.InsertPay_information(Pay_information);
		map.put("msg", Pay_information);
		return  map;
    	
    }
	//删除支付信息
	@ApiOperation(value = "删除支付信息")
    @DeleteMapping("/pay_informationdelete")
    public Object qualification_infomationdelete(@RequestParam("indent_number")String indent_number)
    {
    	 
		Map map=new HashMap();
		pay_information_service.delete(indent_number);
		map.put("msg", "ok");
	    return  map;

    }
	//通过indent_number查询用户信息
	@ApiOperation(value = "通过indent_number查询支付信息")
    @GetMapping("/pay_informationfindbyindent")
    public Object qualification_infomationfindbyindent(@RequestParam("indent_number")String indent_number)
    {
		Map map=new HashMap();
		Pay_information Pay_information=pay_information_service.findbyindent_number(indent_number);
		map.put("msg", Pay_information);
	    return  map;
    
    }
	//修改支付信息
	@ApiOperation(value = "修改支付信息")
	@PostMapping("/pay_information_change")
	public Object pay_information_change(@ApiParam(required = true, value = "修改支付信息")@RequestBody @Valid Pay_information pay_information)
	{
		pay_information_service.UpdatePay_information(pay_information);
		return "修改成功";
	}
}
