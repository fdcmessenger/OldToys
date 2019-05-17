/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : oldtoys

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-05-17 14:42:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_single_table
-- ----------------------------
DROP TABLE IF EXISTS `demo_single_table`;
CREATE TABLE `demo_single_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `int_field` int(11) DEFAULT NULL COMMENT '整形字段',
  `bigint_field` bigint(11) DEFAULT NULL COMMENT '大整形字段',
  `bit_one_field` tinyint(1) unsigned DEFAULT '0' COMMENT '一位比特字段',
  `real_field` double(11,0) DEFAULT NULL COMMENT '长浮点数',
  `decimal_field` decimal(11,0) DEFAULT NULL COMMENT '十进制字段',
  `char_field` char(100) DEFAULT '' COMMENT '字符字段',
  `varchar_field` varchar(100) DEFAULT '' COMMENT '字符串字段',
  `date_field` date DEFAULT NULL COMMENT '日期字段',
  `timestamp_field` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT '时间戳',
  `datetime_field` datetime DEFAULT NULL COMMENT '日期时间字段',
  `select_dict_field` varchar(100) DEFAULT '' COMMENT '下拉字典字段',
  `check_dict_field` varchar(100) DEFAULT '' COMMENT 'CHECK字典字段',
  `redio_dict_field` varchar(100) DEFAULT '' COMMENT 'REDIO字典字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gen_scheme
-- ----------------------------
DROP TABLE IF EXISTS `gen_scheme`;
CREATE TABLE `gen_scheme` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '编号',
  `name` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '名称',
  `category` varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '分类',
  `package_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成包路径',
  `module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成模块名',
  `sub_module_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成子模块名',
  `function_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成功能名',
  `function_name_simple` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成功能名（简写）',
  `function_author` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成功能作者',
  `gen_table_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '生成表编号',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='生成方案';

-- ----------------------------
-- Table structure for gen_table
-- ----------------------------
DROP TABLE IF EXISTS `gen_table`;
CREATE TABLE `gen_table` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `comments` varchar(500) DEFAULT NULL COMMENT '描述',
  `class_name` varchar(100) DEFAULT NULL COMMENT '实体类名称',
  `parent_table` varchar(200) DEFAULT NULL COMMENT '关联父表',
  `parent_table_fk` varchar(100) DEFAULT '' COMMENT '关联父表外键',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gen_table_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表';

-- ----------------------------
-- Table structure for gen_table_column
-- ----------------------------
DROP TABLE IF EXISTS `gen_table_column`;
CREATE TABLE `gen_table_column` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `gen_table_id` varchar(32) NOT NULL COMMENT '归属表编号',
  `name` varchar(200) DEFAULT NULL COMMENT '名称',
  `comments` varchar(500) DEFAULT NULL COMMENT '描述',
  `jdbc_type` varchar(100) DEFAULT NULL COMMENT '列的数据类型的字节长度',
  `java_type` varchar(500) DEFAULT NULL COMMENT 'JAVA类型',
  `java_field` varchar(200) DEFAULT NULL COMMENT 'JAVA字段名',
  `is_pk` tinyint(1) unsigned DEFAULT '0' COMMENT '是否主键',
  `is_null` tinyint(1) unsigned DEFAULT '0' COMMENT '是否可为空',
  `is_insert` tinyint(1) unsigned DEFAULT '0' COMMENT '是否为插入字段',
  `is_edit` tinyint(1) unsigned DEFAULT '0' COMMENT '是否编辑字段',
  `is_list` tinyint(1) unsigned DEFAULT '0' COMMENT '是否列表字段',
  `is_query` tinyint(1) unsigned DEFAULT '0' COMMENT '是否查询字段',
  `query_type` varchar(200) DEFAULT NULL COMMENT '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）',
  `show_type` varchar(200) DEFAULT NULL COMMENT '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）',
  `dict_type` varchar(200) DEFAULT NULL COMMENT '字典类型',
  `settings` varchar(2000) DEFAULT NULL COMMENT '其它设置（扩展字段JSON）',
  `sort` int(11) DEFAULT NULL COMMENT '排序（升序）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  KEY `gen_table_column_table_id` (`gen_table_id`),
  KEY `gen_table_column_name` (`name`),
  KEY `gen_table_column_sort` (`sort`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务表字段';
