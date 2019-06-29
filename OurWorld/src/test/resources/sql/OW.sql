SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ow_continent
-- ----------------------------
DROP TABLE IF EXISTS `ow_continent`;
CREATE TABLE `ow_continent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `abbr` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缩写',
  `name_en` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '英文名称',
  `name_cn` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '中文名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='大洲';

-- ----------------------------
-- Records of ow_continent
-- ----------------------------
INSERT INTO `ow_continent` VALUES ('1', 'AF', 'Africa', '非洲');
INSERT INTO `ow_continent` VALUES ('2', 'AN', 'Antarctica', '南极洲');
INSERT INTO `ow_continent` VALUES ('3', 'AS', 'Asia', '亚洲');
INSERT INTO `ow_continent` VALUES ('4', 'EU', 'Europe', '欧洲');
INSERT INTO `ow_continent` VALUES ('5', 'NA', 'North America', '北美洲');
INSERT INTO `ow_continent` VALUES ('6', 'OA', 'Oceania', '大洋州');
INSERT INTO `ow_continent` VALUES ('7', 'SA', 'South America', '南美洲');



SET FOREIGN_KEY_CHECKS=1;