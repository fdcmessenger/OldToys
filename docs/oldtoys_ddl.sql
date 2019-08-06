/*
Navicat MySQL Data Transfer

Source Server         : local-zip-8
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : oldtoys

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-08-06 21:39:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for demo_single_table
-- ----------------------------
DROP TABLE IF EXISTS `demo_single_table`;
CREATE TABLE `demo_single_table` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `int_field` int(11) DEFAULT NULL,
  `varchar_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `date_field` datetime DEFAULT NULL,
  `select_dict_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `multi_select_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `check_dict_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `redio_dict_field` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `del_flag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for ow_continent
-- ----------------------------
DROP TABLE IF EXISTS `ow_continent`;
CREATE TABLE `ow_continent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `abbr` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缩写',
  `name_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '英文名称',
  `name_cn` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='大洲';

-- ----------------------------
-- Table structure for ow_geo_regions
-- ----------------------------
DROP TABLE IF EXISTS `ow_geo_regions`;
CREATE TABLE `ow_geo_regions` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域编号',
  `name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '英文名称',
  `name_cn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '中文名称',
  `m49_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'M49编码',
  `iso_3_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'ISO三字符编码',
  `iso_2_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'ISO二字符编码',
  `geo_type` int(2) DEFAULT NULL COMMENT '地理区域类型',
  `pid` int(11) DEFAULT NULL COMMENT '父级编号',
  `pids` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '父级路径',
  `useable` int(2) DEFAULT '1' COMMENT '是否使用',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT '30' COMMENT '显示排序',
  `continent` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '所属大洲',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `contient_idx` (`continent`) USING BTREE COMMENT '按照大陆(大洲)索引',
  FULLTEXT KEY `region_fulltext_idx` (`name_en`,`name_cn`,`m49_code`,`iso_3_code`,`iso_2_code`,`remarks`) COMMENT '全文索引' /*!50100 WITH PARSER `ngram` */ 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='世界区域';

-- ----------------------------
-- Table structure for ow_geo_type
-- ----------------------------
DROP TABLE IF EXISTS `ow_geo_type`;
CREATE TABLE `ow_geo_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域类型编号',
  `type_name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '区域类型英文名称',
  `type_name_cn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '区域类型中文名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='区域类型';

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典项ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项名称',
  `type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项关键字',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `dict_type_uk` (`type`) USING BTREE,
  UNIQUE KEY `dict_name_uk` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典表';

-- ----------------------------
-- Table structure for sys_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_item`;
CREATE TABLE `sys_dict_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `value` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项值',
  `label` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '选项标签',
  `dict_id` int(11) NOT NULL COMMENT '字典项ID',
  `dict_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典项关键字',
  `is_disabled` tinyint(1) unsigned DEFAULT '0' COMMENT '是否已经被废弃',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `sort_num` int(11) DEFAULT NULL COMMENT '排序值',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `v_did_uk` (`value`,`dict_id`) USING BTREE,
  UNIQUE KEY `l_did_uk` (`label`,`dict_id`) USING BTREE,
  KEY `dict_fk` (`dict_id`) USING BTREE,
  CONSTRAINT `fk_dict_id` FOREIGN KEY (`dict_id`) REFERENCES `sys_dict` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='字典选择项表';

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `menu_type` tinyint(1) DEFAULT NULL COMMENT '菜单类型,1目录2菜单3按钮',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `pids` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父亲路径',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `useable` tinyint(1) unsigned DEFAULT NULL COMMENT '是否启用',
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网址链接',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图标',
  `is_show` tinyint(1) unsigned DEFAULT NULL COMMENT '是否显示',
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限标识',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `menu_pid_fk` (`pid`) USING BTREE,
  CONSTRAINT `menu_pid_fk` FOREIGN KEY (`pid`) REFERENCES `sys_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统菜单';

-- ----------------------------
-- Table structure for sys_office
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `pid` int(11) DEFAULT NULL COMMENT '父ID',
  `pids` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父亲路径',
  `sort` int(11) NOT NULL DEFAULT '0' COMMENT '排序',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `useable` tinyint(1) unsigned DEFAULT '0' COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `office_pid_fk` (`pid`) USING BTREE,
  CONSTRAINT `office_pid_fk` FOREIGN KEY (`pid`) REFERENCES `sys_office` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='组织部门';

-- ----------------------------
-- Table structure for sys_office_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_office_role`;
CREATE TABLE `sys_office_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `office_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `is_default` tinyint(1) DEFAULT '0' COMMENT '是否为部门默认角色',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门角色';

-- ----------------------------
-- Table structure for sys_office_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_office_user`;
CREATE TABLE `sys_office_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `office_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `inherit_role` tinyint(1) unsigned DEFAULT '1' COMMENT '是否继承部门角色',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `ou_uk` (`office_id`,`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门用户';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `is_admin` tinyint(1) unsigned DEFAULT '0' COMMENT '是否为ADMIN',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `useable` tinyint(1) unsigned DEFAULT '0' COMMENT '是否可用',
  `role_key` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色关键字',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统角色';

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `menu_id` int(11) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单';

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` int(11) DEFAULT NULL COMMENT '角色ID',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `remarks` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT ' 备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色用户';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户登录名',
  `password` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加密过的密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码加密盐',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `mobile` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮件',
  `status` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '用户状态',
  `gender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `usr_unique_idx` (`user_name`) USING BTREE,
  UNIQUE KEY `mobil_unique_idx` (`mobile`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Procedure structure for init_demo_test_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_demo_test_data`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `init_demo_test_data`(IN `cnt` integer)
BEGIN
DECLARE i INT DEFAULT 1;
 WHILE i < cnt  DO
        INSERT INTO `demo_single_table` VALUES ();
        SET i = i + 1;
    END WHILE;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for generateUserName
-- ----------------------------
DROP FUNCTION IF EXISTS `generateUserName`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `generateUserName`() RETURNS varchar(255) CHARSET utf8
    DETERMINISTIC
BEGIN
    DECLARE xing varchar(2056) DEFAULT '赵钱孙李周郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁';

    DECLARE ming varchar(2056) DEFAULT '嘉懿煜城懿轩烨伟苑博伟泽熠彤鸿煊博涛烨霖烨华煜祺智宸正豪昊然明杰诚立轩立辉峻熙弘文熠彤鸿煊烨霖哲瀚鑫鹏致远俊驰雨泽烨磊晟睿天佑文昊修洁黎昕远航旭尧鸿涛伟祺轩越泽浩宇瑾瑜皓轩擎苍擎宇志泽睿渊楷瑞轩弘文哲瀚雨泽鑫磊梦琪忆之桃慕青问兰尔岚元香初夏沛菡傲珊曼文乐菱痴珊恨玉惜文香寒新柔语蓉海安夜蓉涵柏水桃醉蓝春儿语琴从彤傲晴语兰又菱碧彤元霜怜梦紫寒妙彤曼易南莲紫翠雨寒易烟如萱若南寻真晓亦向珊慕灵以蕊寻雁映易雪柳孤岚笑霜海云凝天沛珊寒云冰旋宛儿绿真盼儿晓霜碧凡夏菡曼香若烟半梦雅绿冰蓝灵槐平安书翠翠风香巧代云梦曼幼翠友巧听寒梦柏醉易访旋亦玉凌萱访卉怀亦笑蓝春翠靖柏夜蕾冰夏梦松书雪乐枫念薇靖雁寻春恨山从寒忆香觅波静曼凡旋以亦念露芷蕾千兰新波代真新蕾雁玉冷卉紫山千琴恨天傲芙盼山怀蝶冰兰山柏翠萱乐丹翠柔谷山之瑶冰露尔珍谷雪乐萱涵菡海莲傲蕾青槐冬儿易梦惜雪宛海之柔夏青亦瑶妙菡春竹修杰伟诚建辉晋鹏天磊绍辉泽洋明轩健柏煊昊强伟宸博超君浩子骞明辉鹏涛炎彬鹤轩越彬风华靖琪明诚高格光华国源宇晗昱涵润翰飞翰海昊乾浩博和安弘博鸿朗华奥华灿嘉慕坚秉建明金鑫锦程瑾瑜鹏经赋景同靖琪君昊俊明季同开济凯安康成乐语力勤良哲理群茂彦敏博明达朋义彭泽鹏举濮存溥心璞瑜浦泽奇邃祥荣轩';

    DECLARE I_xing int DEFAULT LENGTH(xing) / 3;
    DECLARE I_ming int DEFAULT LENGTH(ming) / 3;
    DECLARE return_str varchar(2056) DEFAULT '';

    SET return_str = CONCAT(return_str, substring(xing, floor(1 + RAND() * I_xing), 1));
    SET return_str = CONCAT(return_str, substring(ming, floor(1 + RAND() * I_ming), 1));
    IF RAND() > 0.400 THEN
        SET return_str = CONCAT(return_str, substring(ming, floor(1 + RAND() * I_ming), 1));
    END IF;
		

    RETURN return_str;
END
;;
DELIMITER ;
