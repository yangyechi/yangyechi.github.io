package com.team69.cet.entity;

public class apply_examination {
	private String name;//姓名
	private String sex;//性别
	private String ID_number;//身份证号
	private String  examregistration_number;//准考证号
	private String examination_location;//考试地点
	private Integer examination_number;//考试编号
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getID_number() {
		return ID_number;
	}
	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}
	public String getExamregistration_number() {
		return examregistration_number;
	}
	public void setExamregistration_number(String examregistration_number) {
		this.examregistration_number = examregistration_number;
	}
	public String getExamination_location() {
		return examination_location;
	}
	public void setExamination_location(String examination_location) {
		this.examination_location = examination_location;
	}
	public Integer getExamination_number() {
		return examination_number;
	}
	public void setExamination_number(Integer examination_number) {
		this.examination_number = examination_number;
	}
}
