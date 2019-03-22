package com.team69.cet.entity;

public class Pay_information {
	 private String indent_number;//订单号
	 private String pay_type;//金额
	 private String money_type;//支付方式
	 private String ID_number;//身份证号
	 public String getIndent_number() {
			return indent_number;
	 }
	 public void setIndent_number(String indent_number) {
			this.indent_number = indent_number;
	 }
	 public String getPay_type() {
			return pay_type;
	 }
	 public void setpay_type(String pay_type) {
			this.pay_type = pay_type;
	 }
	 public String getMoney_type() {
			return money_type;
	 }
	 public void setMoney_type(String money_type) {
			this.money_type = money_type;
	 }
	 public String getID_number() {
			return ID_number;
	 }
	 public void setID_number(String ID_number) {
			this.ID_number = ID_number;
	 }
}
