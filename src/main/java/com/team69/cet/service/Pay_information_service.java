package com.team69.cet.service;

import java.util.List;

import com.team69.cet.entity.Pay_information;

public interface Pay_information_service {
	public List<Pay_information> findPay_informationInfo();//查询
	public void delete(String t);//删除
	public void UpdatePay_information(Pay_information pay_information);//更新
	public void InsertPay_information(Pay_information pay_information);//插入数据
	public Pay_information findbyindent_number(String t);
}
