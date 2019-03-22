package com.team69.cet.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team69.cet.entity.examination_information;
import com.team69.cet.mapper.examination_information_mapper;
import com.team69.cet.service.examination_information_service;


@Service
public class examination_information_serviceimpl implements examination_information_service{

	@Autowired
	examination_information_mapper examination_information_mapper;
	@Override
	public List<examination_information> findexamination_informationInfo() {
		// TODO Auto-generated method stub
		return examination_information_mapper.findexamination_informationInfo();
	}

	

	@Override
	public void Updateexamination_information(
			examination_information examination_information) {
		// TODO Auto-generated method stub
		 examination_information_mapper.Updateexamination_information(examination_information);
	}

	@Override
	public void Insertexamination_information(
			examination_information examination_information) {
		// TODO Auto-generated method stub
		 examination_information_mapper.Insertexamination_information(examination_information);
	}

	@Override
	public examination_information findbyexamination_number(int t) {
		// TODO Auto-generated method stub
		return examination_information_mapper.findbyexamination_number(t);
	}

	@Override
	public void delete(Integer t) {
		// TODO Auto-generated method stub
		examination_information_mapper.delete(t);
	}

	public examination_information findByStudentNumber(String t)
	{
		return examination_information_mapper.findByStudentNumber(t);
	}
}
