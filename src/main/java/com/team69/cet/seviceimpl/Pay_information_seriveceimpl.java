package com.team69.cet.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team69.cet.entity.Pay_information;
import com.team69.cet.service.Pay_information_service;
import com.team69.cet.mapper.Pay_information_mapper;

@Service
public class Pay_information_seriveceimpl implements Pay_information_service{
	@Autowired
	Pay_information_mapper pay_information_mapper;
	@Override
	public List<Pay_information> findPay_informationInfo() {
		// TODO Auto-generated method stub
		return pay_information_mapper.findPay_informationInfo();
	}

	@Override
	public void delete(String t) {
		// TODO Auto-generated method stub
		 pay_information_mapper.delete(t);
	}

	@Override
	public void UpdatePay_information(Pay_information pay_information) {
		// TODO Auto-generated method stub
		 pay_information_mapper.UpdatePay_information(pay_information);
	}

	@Override
	public void InsertPay_information(Pay_information pay_information) {
		// TODO Auto-generated method stub
		 pay_information_mapper.InsertPay_information(pay_information);
	}

	@Override
	public Pay_information findbyindent_number(String t) {
		// TODO Auto-generated method stub
		return pay_information_mapper.findbyindent_number(t);
	}

}
