package com.team69.cet.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team69.cet.entity.Pay_information;

@Mapper
public interface Pay_information_mapper {
	public List<Pay_information> findPay_informationInfo();//查询
	public void delete(String t);//删除
	public void UpdatePay_information(Pay_information pay_information);//更新
	public void InsertPay_information(Pay_information pay_information);//插入数据
	public Pay_information findbyindent_number(String t);
}
