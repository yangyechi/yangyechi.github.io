package com.team69.cet.service;

import java.util.List;


import com.team69.cet.entity.examination_information;

public interface examination_information_service {
	public List<examination_information> findexamination_informationInfo();//查询
	public void delete(Integer t);//删除
	public void Updateexamination_information(examination_information examination_information);//更新
	public void Insertexamination_information(examination_information examination_information);//插入数据
	public examination_information findbyexamination_number(int t);
	public examination_information findByStudentNumber(String t);
}
