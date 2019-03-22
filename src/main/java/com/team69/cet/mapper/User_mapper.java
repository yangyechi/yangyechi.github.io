package com.team69.cet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.team69.cet.entity.User;

@Mapper
public interface User_mapper {

	public List<User> findUserInfo();//查询
	public void delete(String t);//删除
	public void UpdateUser(User user);//更新
	public void InsertUser(User user);//插入数据
	public User findbyid(String t);//查询数据
	public User findByEmail(String email);//查询邮箱
	public User findByNameAndPassword(User user);//登录查询
}
