package com.team69.cet.service;

import java.util.List;

import com.team69.cet.entity.apply_examination;

public interface apply_examination_service {
	public List<apply_examination> findapply_examinationInfo();//查询
	public void delete(String t);//删除
	public void Updateapply_examination(apply_examination apply_examination);//更新
	public void Insertapply_examination(apply_examination apply_examination);//插入数据
	public apply_examination findbyexamregistration_number(String t);
	public apply_examination findByIdNumber(String t);
}
