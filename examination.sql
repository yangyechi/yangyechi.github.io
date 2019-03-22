/*
Navicat MySQL Data Transfer

Source Server         : 115.159.226.88
Source Server Version : 50639
Source Host           : 115.159.226.88:3306
Source Database       : examination

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-05-27 23:08:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for apply_examination
-- ----------------------------
DROP TABLE IF EXISTS `apply_examination`;
CREATE TABLE `apply_examination` (
  `name` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `sex` varchar(3) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `ID_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `examregistration_number` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '准考证编号',
  `examination_location` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '考场地点编号',
  `examination_number` int(10) NOT NULL COMMENT '考试编号',
  PRIMARY KEY (`examregistration_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of apply_examination
-- ----------------------------
INSERT INTO `apply_examination` VALUES ('李正瑶', '女', '650102199611101926', '1110199601', '5037096', '11100001');
INSERT INTO `apply_examination` VALUES ('黄伟', '男', '510601199612310547', '1110199602', '4743123', '11100002');
INSERT INTO `apply_examination` VALUES ('龚洪涛', '男', '513822199711116356', '1110199603', '4743024', '11100003');
INSERT INTO `apply_examination` VALUES ('王春鹏', '男', '650102199702242638', '1110199604', '4743024', '11100004');
INSERT INTO `apply_examination` VALUES ('邓盼', '女', '421223199810056723', '1110199605', '4743005', '11100005');
INSERT INTO `apply_examination` VALUES ('向春梅', '女', '511133199801071226', '1110199606', '4743001', '11100006');
INSERT INTO `apply_examination` VALUES ('郭友宝', '男', '500101199705222035', '1110199607', '4743110', '11100007');
INSERT INTO `apply_examination` VALUES ('杨野驰', '男', '510502199610128011', '1110199608', '4743111', '11100008');

-- ----------------------------
-- Table structure for examination_information
-- ----------------------------
DROP TABLE IF EXISTS `examination_information`;
CREATE TABLE `examination_information` (
  `student_number` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '学号',
  `examination_number` int(10) NOT NULL COMMENT '考号',
  `type` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '笔试' COMMENT '报考类型（口试、笔试）',
  `level` varchar(15) COLLATE utf8_bin NOT NULL DEFAULT '英语四级' COMMENT '报考级别(四级或六级)',
  PRIMARY KEY (`examination_number`),
  KEY `student_number` (`student_number`),
  CONSTRAINT `student_number` FOREIGN KEY (`student_number`) REFERENCES `Student_information` (`student_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of examination_information
-- ----------------------------
INSERT INTO `examination_information` VALUES ('2015012065', '11100001', '口试和笔试', '英语六级');
INSERT INTO `examination_information` VALUES ('5120152526', '11100002', '笔试', '英语四级');
INSERT INTO `examination_information` VALUES ('5120152588', '11100003', '口试', '英语四级');
INSERT INTO `examination_information` VALUES ('5120150429', '11100004', '口试和笔试', '英语四级');
INSERT INTO `examination_information` VALUES ('5120167178', '11100005', '口试', '英语四级');
INSERT INTO `examination_information` VALUES ('5120173493', '11100006', '口试', '英语四级');
INSERT INTO `examination_information` VALUES ('5120166177', '11100007', '口试和笔试', '英语四级');
INSERT INTO `examination_information` VALUES ('5120152516', '11100008', '口试和笔试', '英语六级');

-- ----------------------------
-- Table structure for Pay_information
-- ----------------------------
DROP TABLE IF EXISTS `Pay_information`;
CREATE TABLE `Pay_information` (
  `indent_number` varchar(9) COLLATE utf8_bin NOT NULL COMMENT '订单编号',
  `pay_type` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '支付方式:可选"支付宝支付"或"微信支付"',
  `money_type` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '支付金额:可选“四级笔试金额”，“四级口试金额”，“四级笔试和口试金额”，“六级笔试金额”，“六级口试金额”，“六级笔试和口试金额”',
  `ID_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  PRIMARY KEY (`indent_number`),
  KEY `ID_number1` (`ID_number`),
  CONSTRAINT `ID_number1` FOREIGN KEY (`ID_number`) REFERENCES `User` (`ID_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Pay_information
-- ----------------------------
INSERT INTO `Pay_information` VALUES ('111096001', '支付宝支付', '四级笔试金额', '650102199611101926');
INSERT INTO `Pay_information` VALUES ('111096002', '微信支付', '六级笔试金额', '510601199612310547');
INSERT INTO `Pay_information` VALUES ('111096003', '微信支付', '四级口试金额', '513822199711116356');
INSERT INTO `Pay_information` VALUES ('111096004', '微信支付', '六级笔试金额', '650102199702242638');
INSERT INTO `Pay_information` VALUES ('111096005', '微信支付', '六级口试金额', '421223199810056723');
INSERT INTO `Pay_information` VALUES ('111096006', '支付宝支付', '四级笔试和口试金额', '511133199801071226');
INSERT INTO `Pay_information` VALUES ('111096007', '微信支付', '六级笔试和口试金额', '500101199705222035');

-- ----------------------------
-- Table structure for Qualification_infomation
-- ----------------------------
DROP TABLE IF EXISTS `Qualification_infomation`;
CREATE TABLE `Qualification_infomation` (
  `qualification` varchar(9) COLLATE utf8_bin NOT NULL COMMENT '资格编号',
  `ID_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `level_six` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '六级考试情况:可填写"通过","未通过",若无记录为空',
  `level_four` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '四级考试情况:可填写"通过","未通过",若无记录为空',
  `absence` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '可缺考情况:填写"上次缺考"，“非上次缺考”,若无缺考记录为空',
  PRIMARY KEY (`qualification`) USING BTREE,
  KEY `ID_number2` (`ID_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Qualification_infomation
-- ----------------------------
INSERT INTO `Qualification_infomation` VALUES ('021011241', '421223199810056723', '通过', '通过', '否');
INSERT INTO `Qualification_infomation` VALUES ('021011242', '500101199705222035', '未通过', '未通过', '否');
INSERT INTO `Qualification_infomation` VALUES ('021011243', '510601199612310547', '未通过', '未通过', '是');
INSERT INTO `Qualification_infomation` VALUES ('021011244', '511133199801071226', '未通过', '未通过', '是');
INSERT INTO `Qualification_infomation` VALUES ('021011245', '513822199711116356', '未通过', '未通过', '是');
INSERT INTO `Qualification_infomation` VALUES ('021011246', '650102199611101926', '通过', '通过', '否');
INSERT INTO `Qualification_infomation` VALUES ('021011247', '650102199702242638', '未通过', '未通过', '否');
INSERT INTO `Qualification_infomation` VALUES ('021011248', '510502199610128011', '未通过', '通过', '否');

-- ----------------------------
-- Table structure for Student_information
-- ----------------------------
DROP TABLE IF EXISTS `Student_information`;
CREATE TABLE `Student_information` (
  `ID_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `class_name` varchar(9) COLLATE utf8_bin NOT NULL COMMENT '班级',
  `name` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `student_number` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '学号',
  `professional` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '专业',
  `university` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '学校',
  `college` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '学院',
  PRIMARY KEY (`student_number`),
  KEY `ID_number` (`ID_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of Student_information
-- ----------------------------
INSERT INTO `Student_information` VALUES ('650102199611101926', '大气1502', '李正瑶', '2015012065', '大气科学', '成都信息工程大学', '大气科学学院');
INSERT INTO `Student_information` VALUES ('650102199702242638', '软件1502', '王春鹏', '5120150429', '软件工程', '西南科技大学', '计算机科学与技术');
INSERT INTO `Student_information` VALUES ('510502199610128011', '软件1502班', '杨野驰', '5120152516', '软件工程', '西南科技大学', '计算机科学与技术学院');
INSERT INTO `Student_information` VALUES ('510601199612310547', '汉语1502', '黄伟', '5120152526', '汉语言文学', '西南科技大学', '文艺学院');
INSERT INTO `Student_information` VALUES ('513822199711116356', '软件1502', '龚洪涛', '5120152588', '软件工程', '西南科技大学', '计算机科学与技术学院');
INSERT INTO `Student_information` VALUES ('500101199705222035', '软件1607', '郭友宝', '5120166177', '软件工程', '西南科技大学', '计算机科学与技术学院');
INSERT INTO `Student_information` VALUES ('421223199810056723', '软件1602', '邓盼', '5120167178', '软件工程', '西南科技大学', '计算机科学与技术学院');
INSERT INTO `Student_information` VALUES ('511133199801071226', '软件1704', '向春梅', '5120173493', '软件工程', '西南科技大学', '计算机科学与技术学院');

-- ----------------------------
-- Table structure for User
-- ----------------------------
DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `name` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `sex` varchar(3) COLLATE utf8_bin NOT NULL COMMENT '性别',
  `ID_number` varchar(18) COLLATE utf8_bin NOT NULL COMMENT '身份证号',
  `user_name` varchar(35) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '密码',
  PRIMARY KEY (`ID_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of User
-- ----------------------------
INSERT INTO `User` VALUES ('小明', '1', '150922199904190013', '1033433740@qq.com', 'test123456');
INSERT INTO `User` VALUES ('邓盼', '女', '421223199810056723', '252706249@qq.com', 'dp12345600000');
INSERT INTO `User` VALUES ('郭友宝', '男', '500101199705222035', '1332787477@qq.com', 'gyb123456');
INSERT INTO `User` VALUES ('史云翔', '1', '510105199702281010', '1419153408@qq.com', '123456abc');
INSERT INTO `User` VALUES ('杨野驰', '1', '510502199610128011', 'yangyechi@foxmail.com', 'yyc123456');
INSERT INTO `User` VALUES ('黄伟', '男', '510601199612310547', '738412540@qq.com', 'hw123456');
INSERT INTO `User` VALUES ('向春梅', '女', '511133199801071226', '2523635855@qq.com', 'xcm123456');
INSERT INTO `User` VALUES ('龚洪涛', '男', '513822199711116356', '1059752368@qq.com', 'ght123456');
INSERT INTO `User` VALUES ('李正瑶', '女', '650102199611101926', '573303040@qq.com', 'lzy123456');
INSERT INTO `User` VALUES ('王春鹏', '男', '650102199702242638', '2234275528@qq.com', 'wcp123456');
