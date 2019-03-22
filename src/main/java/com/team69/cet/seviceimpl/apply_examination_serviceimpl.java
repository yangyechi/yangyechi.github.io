package com.team69.cet.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team69.cet.entity.apply_examination;
import com.team69.cet.mapper.apply_examination_mapper;
import com.team69.cet.service.apply_examination_service;
@Service
public class apply_examination_serviceimpl implements apply_examination_service{
    @Autowired
    apply_examination_mapper apply_examination_mapper;
	@Override
	public List<apply_examination> findapply_examinationInfo() {
		// TODO Auto-generated method stub
		return apply_examination_mapper.findapply_examinationInfo();
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		 apply_examination_mapper.delete(t);
	}

	@Override
	public void Updateapply_examination(apply_examination apply_examination) {
		// TODO Auto-generated method stub
		 apply_examination_mapper.Updateapply_examination(apply_examination);
	}

	@Override
	public void Insertapply_examination(apply_examination apply_examination) {
		// TODO Auto-generated method stub
		 apply_examination_mapper.Insertapply_examination(apply_examination);
	}

	@Override
	public apply_examination findbyexamregistration_number(String t) {
		// TODO Auto-generated method stub
		return apply_examination_mapper.findbyexamregistration_number(t);
	}

	public apply_examination findByIdNumber(String t)
	{
		return apply_examination_mapper.findByIdNumber(t);
	}
}
