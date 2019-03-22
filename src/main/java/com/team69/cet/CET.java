package com.team69.cet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team69.cet.entity.User;
import com.team69.cet.service.User_service;

@SpringBootApplication
public class CET {
    //接口文档 URL：  /swagger-ui.html

	public static void main(String[] args) {
		SpringApplication.run(CET.class, args);
	}
}
