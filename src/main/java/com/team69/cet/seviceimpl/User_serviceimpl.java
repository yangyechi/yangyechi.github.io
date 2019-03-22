package com.team69.cet.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team69.cet.entity.User;
import com.team69.cet.mapper.User_mapper;
import com.team69.cet.service.User_service;
@Service
public class User_serviceimpl implements User_service{
    @Autowired
    User_mapper user_mapper;
	@Override
	public List<User> findUserInfo() {
		// TODO Auto-generated method stub
		return user_mapper.findUserInfo();
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		  user_mapper.delete(t);
	}

	@Override
	public void UpdateUser(User user) {
		// TODO Auto-generated method stub
	           user_mapper.UpdateUser(user);
	}

	@Override
	public void InsertUser(User user) {
		// TODO Auto-generated method stub
		        user_mapper.InsertUser(user);
	}

	@Override
	public User findbyid(String t) {
		return user_mapper.findbyid(t);
	}

	@Override
	public User findByEmail(String email)
	{
		return 	user_mapper.findByEmail(email);
	}
	
	public User findByNameAndPassword(User user)
	{
		return user_mapper.findByNameAndPassword(user);
	}
}
