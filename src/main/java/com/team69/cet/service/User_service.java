package com.team69.cet.service;

import java.util.List;
 



import com.team69.cet.entity.User;
 
public interface User_service {
	public List<User> findUserInfo();//查询
	public void delete(String t);//删除
	public void UpdateUser(User user);//更新
	public void InsertUser(User user);//插入数据
	public User findbyid(String t);//查询数据
	public User findByEmail(String email);//查询邮箱
	public User findByNameAndPassword(User user);//登录查询
}
