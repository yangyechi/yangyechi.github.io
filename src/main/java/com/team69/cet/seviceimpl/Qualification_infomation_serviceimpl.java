package com.team69.cet.seviceimpl;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team69.cet.entity.Qualification_infomation;
import com.team69.cet.service.Qualification_infomation_service;
import com.team69.cet.mapper.Qualification_infomation_mapper;

@Service
public class Qualification_infomation_serviceimpl implements Qualification_infomation_service{
	@Autowired
	Qualification_infomation_mapper qualification_infomation_mapper;
	@Override
	public List<Qualification_infomation> findQualification_infomationInfo() {
		// TODO Auto-generated method stub
		return qualification_infomation_mapper.findQualification_infomationInfo();
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		 qualification_infomation_mapper.delete(t);
	}

	@Override
	public void UpdateQualification_infomation(
			Qualification_infomation qualification_infomation) {
		// TODO Auto-generated method stub
		 qualification_infomation_mapper.UpdateQualification_infomation(qualification_infomation);
	}

	@Override
	public void InsertQualification_infomation(
			Qualification_infomation qualification_infomation) {
		// TODO Auto-generated method stub
		 qualification_infomation_mapper.InsertQualification_infomation(qualification_infomation);
	}

	@Override
	public Qualification_infomation findbyqualification(String t) {
		// TODO Auto-generated method stub
		return qualification_infomation_mapper.findbyqualification(t);
	}

	public Qualification_infomation findByIdNumber(String t)
	{
		return qualification_infomation_mapper.findByIdNumber(t);
	}
	
}
