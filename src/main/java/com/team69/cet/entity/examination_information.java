package com.team69.cet.entity;

public class examination_information {
	private String student_number;//学号
	private Integer examination_number;//考号
	private String type;//考试类别
	private String level;//考试等级
	public String getStudent_number() {
		return student_number;
	}
	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}
	public Integer getExamination_number() {
		return examination_number;
	}
	public void setExamination_number(Integer examination_number) {
		this.examination_number = examination_number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	
}
