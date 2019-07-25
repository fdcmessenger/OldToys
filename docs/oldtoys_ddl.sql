/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : oldtoys

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 25/07/2019 17:57:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo_single_table
-- ----------------------------
DROP TABLE IF EXISTS `demo_single_table`;
CREATE TABLE `demo_single_table`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `int_field` int(11) NULL DEFAULT NULL,
  `varchar_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date_field` datetime(0) NULL DEFAULT NULL,
  `select_dict_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `multi_select_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `check_dict_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `redio_dict_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ow_continent
-- ----------------------------
DROP TABLE IF EXISTS `ow_continent`;
CREATE TABLE `ow_continent`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `abbr` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缩写',
  `name_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名称',
  `name_cn` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '大洲' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ow_geo_regions
-- ----------------------------
DROP TABLE IF EXISTS `ow_geo_regions`;
CREATE TABLE `ow_geo_regions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域编号',
  `name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '英文名称',
  `name_cn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '中文名称',
  `m49_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'M49编码',
  `iso_3_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ISO三字符编码',
  `iso_2_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ISO二字符编码',
  `geo_type` int(2) NULL DEFAULT NULL COMMENT '地理区域类型',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级编号',
  `pids` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级路径',
  `useable` int(2) NULL DEFAULT 1 COMMENT '是否使用',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  `sort` int(11) NULL DEFAULT 30 COMMENT '显示排序',
  `continent` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所属大洲',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `contient_idx`(`continent`) USING BTREE COMMENT '按照大陆(大洲)索引',
  FULLTEXT INDEX `region_fulltext_idx`(`name_en`, `name_cn`, `m49_code`, `iso_3_code`, `iso_2_code`, `remarks`) WITH PARSER `ngram` COMMENT '全文索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '世界区域' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ow_geo_type
-- ----------------------------
DROP TABLE IF EXISTS `ow_geo_type`;
CREATE TABLE `ow_geo_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域类型编号',
  `type_name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区域类型英文名称',
  `type_name_cn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区域类型中文名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '区域类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典项ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项名称',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项关键字',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type_uk`(`type`) USING BTREE,
  UNIQUE INDEX `dict_name_uk`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项标签',
  `dict_id` int(11) NOT NULL COMMENT '字典项ID',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项关键字',
  `is_disabled` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否已经被废弃',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sort_num` int(11) NULL DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `v_did_uk`(`value`, `dict_id`) USING BTREE,
  UNIQUE INDEX `l_did_uk`(`label`, `dict_id`) USING BTREE,
  INDEX `dict_fk`(`dict_id`) USING BTREE,
  CONSTRAINT `fk_dict_id` FOREIGN KEY (`dict_id`) REFERENCES `sys_dict` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典选择项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `pids` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父亲路径',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `useable` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否启用',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网址链接',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `is_show` tinyint(1) UNSIGNED NULL DEFAULT NULL COMMENT '是否显示',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `menu_pid_fk`(`pid`) USING BTREE,
  CONSTRAINT `menu_pid_fk` FOREIGN KEY (`pid`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `pids` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父亲路径',
  `sort` int(11) NOT NULL DEFAULT 0 COMMENT '排序',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `useable` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `office_pid_fk`(`pid`) USING BTREE,
  CONSTRAINT `office_pid_fk` FOREIGN KEY (`pid`) REFERENCES `sys_office` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织部门' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_office_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_office_role`;
CREATE TABLE `sys_office_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `office_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `is_default` tinyint(1) NULL DEFAULT 0 COMMENT '是否为部门默认角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_office_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_office_user`;
CREATE TABLE `sys_office_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `office_id` int(11) NULL DEFAULT NULL COMMENT '部门ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `inherit_role` tinyint(1) UNSIGNED NULL DEFAULT 1 COMMENT '是否继承部门角色',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `ou_uk`(`office_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `is_admin` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否为ADMIN',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `useable` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '是否可用',
  `role_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色关键字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色ID',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT ' 备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密过的密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码加密盐',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `status` tinyint(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '用户状态',
  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `usr_unique_idx`(`user_name`) USING BTREE,
  UNIQUE INDEX `mobil_unique_idx`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
