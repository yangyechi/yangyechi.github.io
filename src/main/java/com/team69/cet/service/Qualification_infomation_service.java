package com.team69.cet.service;

import java.util.List;

import com.team69.cet.entity.Qualification_infomation;

public interface Qualification_infomation_service {
	public List<Qualification_infomation> findQualification_infomationInfo();//查询
	public void delete(String t);//删除
	public void UpdateQualification_infomation(Qualification_infomation qualification_infomation);//更新
	public void InsertQualification_infomation(Qualification_infomation qualification_infomation);//插入数据
	public Qualification_infomation findbyqualification(String t);
	public Qualification_infomation findByIdNumber(String t);
}
