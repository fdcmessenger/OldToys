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

 Date: 01/07/2019 15:33:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for geo_regions
-- ----------------------------
DROP TABLE IF EXISTS `geo_regions`;
CREATE TABLE `geo_regions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域编号',
  `name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '英文名称',
  `name_cn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '中文名称',
  `m49_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'M49编码',
  `iso_3_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ISO三字符编码',
  `iso_2_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ISO二字符编码',
  `iso_num` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'ISO NUM',
  `geo_type` int(2) NULL DEFAULT NULL COMMENT '地理区域类型',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级编号',
  `pids` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父级路径',
  `useable` int(2) NULL DEFAULT 1 COMMENT '是否使用',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of geo_regions
-- ----------------------------
INSERT INTO `geo_regions` VALUES (1, 'World', '世界', '001', NULL, NULL, NULL, 1, 0, '0,', 1, 'World');
INSERT INTO `geo_regions` VALUES (2, 'Africa', '非洲', '002', NULL, NULL, NULL, 2, 1, '0,1,', 1, 'Africa');
INSERT INTO `geo_regions` VALUES (3, 'Americas', '美洲', '019', NULL, NULL, NULL, 2, 1, '0,1,', 1, 'Americas');
INSERT INTO `geo_regions` VALUES (4, 'Asia', '亚洲', '142', NULL, NULL, NULL, 2, 1, '0,1,', 1, 'Asia');
INSERT INTO `geo_regions` VALUES (5, 'Europe', '欧洲', '150', NULL, NULL, NULL, 2, 1, '0,1,', 1, 'Europe');
INSERT INTO `geo_regions` VALUES (6, 'Oceania', '大洋洲', '009', NULL, NULL, NULL, 2, 1, '0,1,', 1, 'Oceania');
INSERT INTO `geo_regions` VALUES (9, 'Northern Africa', '北非', '015', NULL, NULL, NULL, 3, 2, '0,1,2,', 1, 'Northern Africa');
INSERT INTO `geo_regions` VALUES (10, 'Sub-Saharan Africa', '撒哈拉以南非洲', '202', NULL, NULL, NULL, 3, 2, '0,1,2,', 1, 'Sub-Saharan Africa');
INSERT INTO `geo_regions` VALUES (11, 'Latin America and the Caribbean', '拉丁美洲和加勒比', '419', NULL, NULL, NULL, 3, 3, '0,1,3,', 1, 'Latin America and the Caribbean');
INSERT INTO `geo_regions` VALUES (12, 'Northern America', '北美', '021', NULL, NULL, NULL, 3, 3, '0,1,3,', 1, 'Northern America');
INSERT INTO `geo_regions` VALUES (13, 'Central Asia', '中亚', '143', NULL, NULL, NULL, 3, 4, '0,1,4,', 1, 'Central Asia');
INSERT INTO `geo_regions` VALUES (14, 'Eastern Asia', '东亚', '030', NULL, NULL, NULL, 3, 4, '0,1,4,', 1, 'Eastern Asia');
INSERT INTO `geo_regions` VALUES (15, 'South-eastern Asia', '东南亚', '035', NULL, NULL, NULL, 3, 4, '0,1,4,', 1, 'South-eastern Asia');
INSERT INTO `geo_regions` VALUES (16, 'Southern Asia', '南亚', '034', NULL, NULL, NULL, 3, 4, '0,1,4,', 1, 'Southern Asia');
INSERT INTO `geo_regions` VALUES (17, 'Western Asia', '西亚', '145', NULL, NULL, NULL, 3, 4, '0,1,4,', 1, 'Western Asia');
INSERT INTO `geo_regions` VALUES (18, 'Eastern Europe', '东欧', '151', NULL, NULL, NULL, 3, 5, '0,1,5,', 1, 'Eastern Europe');
INSERT INTO `geo_regions` VALUES (19, 'Northern Europe', '北欧', '154', NULL, NULL, NULL, 3, 5, '0,1,5,', 1, 'Northern Europe');
INSERT INTO `geo_regions` VALUES (20, 'Southern Europe', '南欧', '039', NULL, NULL, NULL, 3, 5, '0,1,5,', 1, 'Southern Europe');
INSERT INTO `geo_regions` VALUES (21, 'Western Europe', '西欧', '155', NULL, NULL, NULL, 3, 5, '0,1,5,', 1, 'Western Europe');
INSERT INTO `geo_regions` VALUES (22, 'Australia and New Zealand', '澳大利亚和新西兰', '053', NULL, NULL, NULL, 3, 6, '0,1,6,', 1, 'Australia and New Zealand');
INSERT INTO `geo_regions` VALUES (23, 'Melanesia', '美拉尼西亚', '054', NULL, NULL, NULL, 3, 6, '0,1,6,', 1, 'Melanesia');
INSERT INTO `geo_regions` VALUES (24, 'Micronesia', '密克罗尼西亚', '057', NULL, NULL, NULL, 3, 6, '0,1,6,', 1, 'Micronesia');
INSERT INTO `geo_regions` VALUES (25, 'Polynesia', '波利尼西亚', '061', NULL, NULL, NULL, 3, 6, '0,1,6,', 1, 'Polynesia');
INSERT INTO `geo_regions` VALUES (40, 'Eastern Africa', '东非', '014', NULL, NULL, NULL, 4, 10, '0,1,2,10,', 1, 'Eastern Africa');
INSERT INTO `geo_regions` VALUES (41, 'Middle Africa', '中非', '017', NULL, NULL, NULL, 4, 10, '0,1,2,10,', 1, 'Middle Africa');
INSERT INTO `geo_regions` VALUES (42, 'Southern Africa', '南部非洲', '018', NULL, NULL, NULL, 4, 10, '0,1,2,10,', 1, 'Southern Africa');
INSERT INTO `geo_regions` VALUES (43, 'Western Africa', '西非', '011', NULL, NULL, NULL, 4, 10, '0,1,2,10,', 1, 'Western Africa');
INSERT INTO `geo_regions` VALUES (44, 'Caribbean', '加勒比', '029', NULL, NULL, NULL, 4, 11, '0,1,3,11,', 1, 'Caribbean');
INSERT INTO `geo_regions` VALUES (45, 'Central America', '中美洲', '013', NULL, NULL, NULL, 4, 11, '0,1,3,11,', 1, 'Central America');
INSERT INTO `geo_regions` VALUES (46, 'South America', '南美洲', '005', NULL, NULL, NULL, 4, 11, '0,1,3,11,', 1, 'South America');
INSERT INTO `geo_regions` VALUES (47, 'Channel Islands', '海峡群岛', '830', NULL, NULL, NULL, 4, 19, '0,1,5,19,', 1, 'Channel Islands');
INSERT INTO `geo_regions` VALUES (55, 'British Indian Ocean Territory', '英属印度洋领土', '086', 'IOT', 'IO', '086', 5, 40, '0,1,2,10,40,', 1, 'British Indian Ocean Territory');
INSERT INTO `geo_regions` VALUES (56, 'Burundi', '布隆迪', '108', 'BDI', 'BI', '108', 5, 40, '0,1,2,10,40,', 1, 'Burundi');
INSERT INTO `geo_regions` VALUES (57, 'Comoros', '科摩罗', '174', 'COM', 'KM', '174', 5, 40, '0,1,2,10,40,', 1, 'Comoros');
INSERT INTO `geo_regions` VALUES (58, 'Djibouti', '吉布提', '262', 'DJI', 'DJ', '262', 5, 40, '0,1,2,10,40,', 1, 'Djibouti');
INSERT INTO `geo_regions` VALUES (59, 'Eritrea', '厄立特里亚', '232', 'ERI', 'ER', '232', 5, 40, '0,1,2,10,40,', 1, 'Eritrea');
INSERT INTO `geo_regions` VALUES (60, 'Ethiopia', '埃塞俄比亚', '231', 'ETH', 'ET', '231', 5, 40, '0,1,2,10,40,', 1, 'Ethiopia');
INSERT INTO `geo_regions` VALUES (61, 'French Southern Territories', '法属南方领地', '260', 'ATF', 'TF', '260', 5, 40, '0,1,2,10,40,', 1, 'French Southern Territories');
INSERT INTO `geo_regions` VALUES (62, 'Kenya', '肯尼亚', '404', 'KEN', 'KE', '404', 5, 40, '0,1,2,10,40,', 1, 'Kenya');
INSERT INTO `geo_regions` VALUES (63, 'Madagascar', '马达加斯加', '450', 'MDG', 'MG', '450', 5, 40, '0,1,2,10,40,', 1, 'Madagascar');
INSERT INTO `geo_regions` VALUES (64, 'Malawi', '马拉维', '454', 'MWI', 'MW', '454', 5, 40, '0,1,2,10,40,', 1, 'Malawi');
INSERT INTO `geo_regions` VALUES (65, 'Mauritius', '毛里求斯', '480', 'MUS', 'MU', '480', 5, 40, '0,1,2,10,40,', 1, 'Mauritius');
INSERT INTO `geo_regions` VALUES (66, 'Mayotte', '马约特', '175', 'MYT', 'YT', '175', 5, 40, '0,1,2,10,40,', 1, 'Mayotte');
INSERT INTO `geo_regions` VALUES (67, 'Mozambique', '莫桑比克', '508', 'MOZ', 'MZ', '508', 5, 40, '0,1,2,10,40,', 1, 'Mozambique');
INSERT INTO `geo_regions` VALUES (68, 'Réunion', '留尼汪', '638', 'REU', 'RE', '638', 5, 40, '0,1,2,10,40,', 1, 'Réunion');
INSERT INTO `geo_regions` VALUES (69, 'Rwanda', '卢旺达', '646', 'RWA', 'RW', '646', 5, 40, '0,1,2,10,40,', 1, 'Rwanda');
INSERT INTO `geo_regions` VALUES (70, 'Seychelles', '塞舌尔', '690', 'SYC', 'SC', '690', 5, 40, '0,1,2,10,40,', 1, 'Seychelles');
INSERT INTO `geo_regions` VALUES (71, 'Somalia', '索马里', '706', 'SOM', 'SO', '706', 5, 40, '0,1,2,10,40,', 1, 'Somalia');
INSERT INTO `geo_regions` VALUES (72, 'South Sudan', '南苏丹', '728', 'SSD', 'SS', '728', 5, 40, '0,1,2,10,40,', 1, 'South Sudan');
INSERT INTO `geo_regions` VALUES (73, 'Uganda', '乌干达', '800', 'UGA', 'UG', '800', 5, 40, '0,1,2,10,40,', 1, 'Uganda');
INSERT INTO `geo_regions` VALUES (74, 'United Republic of Tanzania', '坦桑尼亚联合共和国', '834', 'TZA', 'TZ', '834', 5, 40, '0,1,2,10,40,', 1, 'United Republic of Tanzania');
INSERT INTO `geo_regions` VALUES (75, 'Zambia', '赞比亚', '894', 'ZMB', 'ZM', '894', 5, 40, '0,1,2,10,40,', 1, 'Zambia');
INSERT INTO `geo_regions` VALUES (76, 'Zimbabwe', '津巴布韦', '716', 'ZWE', 'ZW', '716', 5, 40, '0,1,2,10,40,', 1, 'Zimbabwe');
INSERT INTO `geo_regions` VALUES (77, 'Angola', '安哥拉', '024', 'AGO', 'AO', '024', 5, 41, '0,1,2,10,41,', 1, 'Angola');
INSERT INTO `geo_regions` VALUES (78, 'Cameroon', '喀麦隆', '120', 'CMR', 'CM', '120', 5, 41, '0,1,2,10,41,', 1, 'Cameroon');
INSERT INTO `geo_regions` VALUES (79, 'Central African Republic', '中非共和国', '140', 'CAF', 'CF', '140', 5, 41, '0,1,2,10,41,', 1, 'Central African Republic');
INSERT INTO `geo_regions` VALUES (80, 'Chad', '乍得', '148', 'TCD', 'TD', '148', 5, 41, '0,1,2,10,41,', 1, 'Chad');
INSERT INTO `geo_regions` VALUES (81, 'Congo', '刚果', '178', 'COG', 'CG', '178', 5, 41, '0,1,2,10,41,', 1, 'Congo');
INSERT INTO `geo_regions` VALUES (82, 'Democratic Republic of the Congo', '刚果民主共和国', '180', 'COD', 'CD', '180', 5, 41, '0,1,2,10,41,', 1, 'Democratic Republic of the Congo');
INSERT INTO `geo_regions` VALUES (83, 'Equatorial Guinea', '赤道几内亚', '226', 'GNQ', 'GQ', '226', 5, 41, '0,1,2,10,41,', 1, 'Equatorial Guinea');
INSERT INTO `geo_regions` VALUES (84, 'Gabon', '加蓬', '266', 'GAB', 'GA', '266', 5, 41, '0,1,2,10,41,', 1, 'Gabon');
INSERT INTO `geo_regions` VALUES (85, 'Sao Tome and Principe', '圣多美和普林西比', '678', 'STP', 'ST', '678', 5, 41, '0,1,2,10,41,', 1, 'Sao Tome and Principe');
INSERT INTO `geo_regions` VALUES (86, 'Botswana', '博茨瓦纳', '072', 'BWA', 'BW', '072', 5, 42, '0,1,2,10,42,', 1, 'Botswana');
INSERT INTO `geo_regions` VALUES (87, 'Eswatini', '斯威士兰', '748', 'SWZ', 'SZ', '748', 5, 42, '0,1,2,10,42,', 1, 'Eswatini');
INSERT INTO `geo_regions` VALUES (88, 'Lesotho', '莱索托', '426', 'LSO', 'LS', '426', 5, 42, '0,1,2,10,42,', 1, 'Lesotho');
INSERT INTO `geo_regions` VALUES (89, 'Namibia', '纳米比亚', '516', 'NAM', 'NA', '516', 5, 42, '0,1,2,10,42,', 1, 'Namibia');
INSERT INTO `geo_regions` VALUES (90, 'South Africa', '南非', '710', 'ZAF', 'ZA', '710', 5, 42, '0,1,2,10,42,', 1, 'South Africa');
INSERT INTO `geo_regions` VALUES (91, 'Benin', '贝宁', '204', 'BEN', 'BJ', '204', 5, 43, '0,1,2,10,43,', 1, 'Benin');
INSERT INTO `geo_regions` VALUES (92, 'Burkina Faso', '布基纳法索', '854', 'BFA', 'BF', '854', 5, 43, '0,1,2,10,43,', 1, 'Burkina Faso');
INSERT INTO `geo_regions` VALUES (93, 'Cabo Verde', '佛得角', '132', 'CPV', 'CV', '132', 5, 43, '0,1,2,10,43,', 1, 'Cabo Verde');
INSERT INTO `geo_regions` VALUES (94, 'Côte d’Ivoire', '科特迪瓦', '384', 'CIV', 'CI', '384', 5, 43, '0,1,2,10,43,', 1, 'Côte d’Ivoire');
INSERT INTO `geo_regions` VALUES (95, 'Gambia', '冈比亚', '270', 'GMB', 'GM', '270', 5, 43, '0,1,2,10,43,', 1, 'Gambia');
INSERT INTO `geo_regions` VALUES (96, 'Ghana', '加纳', '288', 'GHA', 'GH', '288', 5, 43, '0,1,2,10,43,', 1, 'Ghana');
INSERT INTO `geo_regions` VALUES (97, 'Guinea', '几内亚', '324', 'GIN', 'GN', '324', 5, 43, '0,1,2,10,43,', 1, 'Guinea');
INSERT INTO `geo_regions` VALUES (98, 'Guinea-Bissau', '几内亚比绍', '624', 'GNB', 'GW', '624', 5, 43, '0,1,2,10,43,', 1, 'Guinea-Bissau');
INSERT INTO `geo_regions` VALUES (99, 'Liberia', '利比里亚', '430', 'LBR', 'LR', '430', 5, 43, '0,1,2,10,43,', 1, 'Liberia');
INSERT INTO `geo_regions` VALUES (100, 'Mali', '马里', '466', 'MLI', 'ML', '466', 5, 43, '0,1,2,10,43,', 1, 'Mali');
INSERT INTO `geo_regions` VALUES (101, 'Mauritania', '毛里塔尼亚', '478', 'MRT', 'MR', '478', 5, 43, '0,1,2,10,43,', 1, 'Mauritania');
INSERT INTO `geo_regions` VALUES (102, 'Niger', '尼日尔', '562', 'NER', 'NE', '562', 5, 43, '0,1,2,10,43,', 1, 'Niger');
INSERT INTO `geo_regions` VALUES (103, 'Nigeria', '尼日利亚', '566', 'NGA', 'NG', '566', 5, 43, '0,1,2,10,43,', 1, 'Nigeria');
INSERT INTO `geo_regions` VALUES (104, 'Saint Helena', '圣赫勒拿', '654', 'SHN', 'SH', '654', 5, 43, '0,1,2,10,43,', 1, 'Saint Helena');
INSERT INTO `geo_regions` VALUES (105, 'Senegal', '塞内加尔', '686', 'SEN', 'SN', '686', 5, 43, '0,1,2,10,43,', 1, 'Senegal');
INSERT INTO `geo_regions` VALUES (106, 'Sierra Leone', '塞拉利昂', '694', 'SLE', 'SL', '694', 5, 43, '0,1,2,10,43,', 1, 'Sierra Leone');
INSERT INTO `geo_regions` VALUES (107, 'Togo', '多哥', '768', 'TGO', 'TG', '768', 5, 43, '0,1,2,10,43,', 1, 'Togo');
INSERT INTO `geo_regions` VALUES (108, 'Anguilla', '安圭拉', '660', 'AIA', 'AI', '660', 5, 44, '0,1,3,11,44,', 1, 'Anguilla');
INSERT INTO `geo_regions` VALUES (109, 'Antigua and Barbuda', '安提瓜和巴布达', '028', 'ATG', 'AG', '028', 5, 44, '0,1,3,11,44,', 1, 'Antigua and Barbuda');
INSERT INTO `geo_regions` VALUES (110, 'Aruba', '阿鲁巴', '533', 'ABW', 'AW', '553', 5, 44, '0,1,3,11,44,', 1, 'Aruba');
INSERT INTO `geo_regions` VALUES (111, 'Bahamas', '巴哈马', '044', 'BHS', 'BS', '044', 5, 44, '0,1,3,11,44,', 1, 'Bahamas');
INSERT INTO `geo_regions` VALUES (112, 'Barbados', '巴巴多斯', '052', 'BRB', 'BB', '052', 5, 44, '0,1,3,11,44,', 1, 'Barbados');
INSERT INTO `geo_regions` VALUES (113, 'Bonaire, Sint Eustatius and Saba', '博纳尔，圣俄斯塔休斯和萨巴', '535', 'BES', 'BQ', '535', 5, 44, '0,1,3,11,44,', 1, 'Bonaire, Sint Eustatius and Saba');
INSERT INTO `geo_regions` VALUES (114, 'British Virgin Islands', '英属维尔京群岛', '092', 'VGB', 'VG', '092', 5, 44, '0,1,3,11,44,', 1, 'British Virgin Islands');
INSERT INTO `geo_regions` VALUES (115, 'Cayman Islands', '开曼群岛', '136', 'CYM', 'KY', '136', 5, 44, '0,1,3,11,44,', 1, 'Cayman Islands');
INSERT INTO `geo_regions` VALUES (116, 'Cuba', '古巴', '192', 'CUB', 'CU', '192', 5, 44, '0,1,3,11,44,', 1, 'Cuba');
INSERT INTO `geo_regions` VALUES (117, 'Curaçao', '库拉索', '531', 'CUW', 'CW', '531', 5, 44, '0,1,3,11,44,', 1, 'Curaçao');
INSERT INTO `geo_regions` VALUES (118, 'Dominica', '多米尼克', '212', 'DMA', 'DM', '212', 5, 44, '0,1,3,11,44,', 1, 'Dominica');
INSERT INTO `geo_regions` VALUES (119, 'Dominican Republic', '多米尼加', '214', 'DOM', 'DO', '214', 5, 44, '0,1,3,11,44,', 1, 'Dominican Republic');
INSERT INTO `geo_regions` VALUES (120, 'Grenada', '格林纳达', '308', 'GRD', 'GD', '308', 5, 44, '0,1,3,11,44,', 1, 'Grenada');
INSERT INTO `geo_regions` VALUES (121, 'Guadeloupe', '瓜德罗普', '312', 'GLP', 'GP', '312', 5, 44, '0,1,3,11,44,', 1, 'Guadeloupe');
INSERT INTO `geo_regions` VALUES (122, 'Haiti', '海地', '332', 'HTI', 'HT', '332', 5, 44, '0,1,3,11,44,', 1, 'Haiti');
INSERT INTO `geo_regions` VALUES (123, 'Jamaica', '牙买加', '388', 'JAM', 'JM', '388', 5, 44, '0,1,3,11,44,', 1, 'Jamaica');
INSERT INTO `geo_regions` VALUES (124, 'Martinique', '马提尼克', '474', 'MTQ', 'MQ', '474', 5, 44, '0,1,3,11,44,', 1, 'Martinique');
INSERT INTO `geo_regions` VALUES (125, 'Montserrat', '蒙特塞拉特', '500', 'MSR', 'MS', '500', 5, 44, '0,1,3,11,44,', 1, 'Montserrat');
INSERT INTO `geo_regions` VALUES (126, 'Puerto Rico', '波多黎各', '630', 'PRI', 'PR', '630', 5, 44, '0,1,3,11,44,', 1, 'Puerto Rico');
INSERT INTO `geo_regions` VALUES (127, 'Saint Barthélemy', '圣巴泰勒米', '652', 'BLM', 'BL', '652', 5, 44, '0,1,3,11,44,', 1, 'Saint Barthélemy');
INSERT INTO `geo_regions` VALUES (128, 'Saint Kitts and Nevis', '圣基茨和尼维斯', '659', 'KNA', 'KN', '659', 5, 44, '0,1,3,11,44,', 1, 'Saint Kitts and Nevis');
INSERT INTO `geo_regions` VALUES (129, 'Saint Lucia', '圣卢西亚', '662', 'LCA', 'LC', '662', 5, 44, '0,1,3,11,44,', 1, 'Saint Lucia');
INSERT INTO `geo_regions` VALUES (130, 'Saint Martin (French Part)', '圣马丁（法属）', '663', 'MAF', 'MF', '663', 5, 44, '0,1,3,11,44,', 1, 'Saint Martin (French Part)');
INSERT INTO `geo_regions` VALUES (131, 'Saint Vincent and the Grenadines', '圣文森特和格林纳丁斯', '670', 'VCT', 'VC', '670', 5, 44, '0,1,3,11,44,', 1, 'Saint Vincent and the Grenadines');
INSERT INTO `geo_regions` VALUES (132, 'Sint Maarten (Dutch part)', '圣马丁（荷属）', '534', 'SXM', 'SX', '534', 5, 44, '0,1,3,11,44,', 1, 'Sint Maarten (Dutch part)');
INSERT INTO `geo_regions` VALUES (133, 'Trinidad and Tobago', '特立尼达和多巴哥', '780', 'TTO', 'TT', '780', 5, 44, '0,1,3,11,44,', 1, 'Trinidad and Tobago');
INSERT INTO `geo_regions` VALUES (134, 'Turks and Caicos Islands', '特克斯和凯科斯群岛', '796', 'TCA', 'TC', '796', 5, 44, '0,1,3,11,44,', 1, 'Turks and Caicos Islands');
INSERT INTO `geo_regions` VALUES (135, 'United States Virgin Islands', '美属维尔京群岛', '850', 'VIR', 'VI', '850', 5, 44, '0,1,3,11,44,', 1, 'United States Virgin Islands');
INSERT INTO `geo_regions` VALUES (136, 'Belize', '伯利兹', '084', 'BLZ', 'BZ', '084', 5, 45, '0,1,3,11,45,', 1, 'Belize');
INSERT INTO `geo_regions` VALUES (137, 'Costa Rica', '哥斯达黎加', '188', 'CRI', 'CR', '188', 5, 45, '0,1,3,11,45,', 1, 'Costa Rica');
INSERT INTO `geo_regions` VALUES (138, 'El Salvador', '萨尔瓦多', '222', 'SLV', 'SV', '222', 5, 45, '0,1,3,11,45,', 1, 'El Salvador');
INSERT INTO `geo_regions` VALUES (139, 'Guatemala', '危地马拉', '320', 'GTM', 'GT', '320', 5, 45, '0,1,3,11,45,', 1, 'Guatemala');
INSERT INTO `geo_regions` VALUES (140, 'Honduras', '洪都拉斯', '340', 'HND', 'HN', '340', 5, 45, '0,1,3,11,45,', 1, 'Honduras');
INSERT INTO `geo_regions` VALUES (141, 'Mexico', '墨西哥', '484', 'MEX', 'MX', '484', 5, 45, '0,1,3,11,45,', 1, 'Mexico');
INSERT INTO `geo_regions` VALUES (142, 'Nicaragua', '尼加拉瓜', '558', 'NIC', 'NI', '558', 5, 45, '0,1,3,11,45,', 1, 'Nicaragua');
INSERT INTO `geo_regions` VALUES (143, 'Panama', '巴拿马', '591', 'PAN', 'PA', '591', 5, 45, '0,1,3,11,45,', 1, 'Panama');
INSERT INTO `geo_regions` VALUES (144, 'Argentina', '阿根廷', '032', 'ARG', 'AR', '032', 5, 46, '0,1,3,11,46,', 1, 'Argentina');
INSERT INTO `geo_regions` VALUES (145, 'Bolivia (Plurinational State of)', '多民族玻利维亚国', '068', 'BOL', 'BO', '068', 5, 46, '0,1,3,11,46,', 1, 'Bolivia (Plurinational State of)');
INSERT INTO `geo_regions` VALUES (146, 'Bouvet Island', '布维岛', '074', 'BVT', 'BV', '074', 5, 46, '0,1,3,11,46,', 1, 'Bouvet Island');
INSERT INTO `geo_regions` VALUES (147, 'Brazil', '巴西', '076', 'BRA', 'BR', '076', 5, 46, '0,1,3,11,46,', 1, 'Brazil');
INSERT INTO `geo_regions` VALUES (148, 'Chile', '智利', '152', 'CHL', 'CL', '152', 5, 46, '0,1,3,11,46,', 1, 'Chile');
INSERT INTO `geo_regions` VALUES (149, 'Colombia', '哥伦比亚', '170', 'COL', 'CO', '170', 5, 46, '0,1,3,11,46,', 1, 'Colombia');
INSERT INTO `geo_regions` VALUES (150, 'Ecuador', '厄瓜多尔', '218', 'ECU', 'EC', '218', 5, 46, '0,1,3,11,46,', 1, 'Ecuador');
INSERT INTO `geo_regions` VALUES (151, 'Falkland Islands (Malvinas)', '福克兰群岛（马尔维纳斯）', '238', 'FLK', 'FK', '238', 5, 46, '0,1,3,11,46,', 1, 'Falkland Islands (Malvinas)');
INSERT INTO `geo_regions` VALUES (152, 'French Guiana', '法属圭亚那', '254', 'GUF', 'GF', '254', 5, 46, '0,1,3,11,46,', 1, 'French Guiana');
INSERT INTO `geo_regions` VALUES (153, 'Guyana', '圭亚那', '328', 'GUY', 'GY', '328', 5, 46, '0,1,3,11,46,', 1, 'Guyana');
INSERT INTO `geo_regions` VALUES (154, 'Paraguay', '巴拉圭', '600', 'PRY', 'PY', '600', 5, 46, '0,1,3,11,46,', 1, 'Paraguay');
INSERT INTO `geo_regions` VALUES (155, 'Peru', '秘鲁', '604', 'PER', 'PE', '604', 5, 46, '0,1,3,11,46,', 1, 'Peru');
INSERT INTO `geo_regions` VALUES (156, 'South Georgia and the South Sandwich Islands', '南乔治亚岛和南桑德韦奇岛', '239', 'SGS', 'GS', '239', 5, 46, '0,1,3,11,46,', 1, 'South Georgia and the South Sandwich Islands');
INSERT INTO `geo_regions` VALUES (157, 'Suriname', '苏里南', '740', 'SUR', 'SR', '740', 5, 46, '0,1,3,11,46,', 1, 'Suriname');
INSERT INTO `geo_regions` VALUES (158, 'Uruguay', '乌拉圭', '858', 'URY', 'UY', '858', 5, 46, '0,1,3,11,46,', 1, 'Uruguay');
INSERT INTO `geo_regions` VALUES (159, 'Venezuela (Bolivarian Republic of)', '委内瑞拉玻利瓦尔共和国', '862', 'VEN', 'VE', '862', 5, 46, '0,1,3,11,46,', 1, 'Venezuela (Bolivarian Republic of)');
INSERT INTO `geo_regions` VALUES (160, 'Guernsey', '格恩西', '831', 'GGY', 'GG', '831', 5, 47, '0,1,5,19,47,', 1, 'Guernsey');
INSERT INTO `geo_regions` VALUES (161, 'Jersey', '泽西', '832', 'JEY', 'JE', '832', 5, 47, '0,1,5,19,47,', 1, 'Jersey');
INSERT INTO `geo_regions` VALUES (162, 'Sark', '萨克', '680', NULL, NULL, NULL, 5, 47, '0,1,5,19,47,', 1, 'Sark');
INSERT INTO `geo_regions` VALUES (182, 'Algeria', '阿尔及利亚', '012', 'DZA', 'DZ', '012', 5, 9, '0,1,2,9,', 1, 'Algeria');
INSERT INTO `geo_regions` VALUES (183, 'Egypt', '埃及', '818', 'EGY', 'EG', '818', 5, 9, '0,1,2,9,', 1, 'Egypt');
INSERT INTO `geo_regions` VALUES (184, 'Libya', '利比亚', '434', 'LBY', 'LY', '434', 5, 9, '0,1,2,9,', 1, 'Libya');
INSERT INTO `geo_regions` VALUES (185, 'Morocco', '摩洛哥', '504', 'MAR', 'MA', '504', 5, 9, '0,1,2,9,', 1, 'Morocco');
INSERT INTO `geo_regions` VALUES (186, 'Sudan', '苏丹', '729', 'SDN', 'SD', '729', 5, 9, '0,1,2,9,', 1, 'Sudan');
INSERT INTO `geo_regions` VALUES (187, 'Tunisia', '突尼斯', '788', 'TUN', 'TN', '788', 5, 9, '0,1,2,9,', 1, 'Tunisia');
INSERT INTO `geo_regions` VALUES (188, 'Western Sahara', '西撒哈拉', '732', 'ESH', 'EH', '732', 5, 9, '0,1,2,9,', 1, 'Western Sahara');
INSERT INTO `geo_regions` VALUES (189, 'Bermuda', '百慕大', '060', 'BMU', 'BM', '060', 5, 12, '0,1,3,12,', 1, 'Bermuda');
INSERT INTO `geo_regions` VALUES (190, 'Canada', '加拿大', '124', 'CAN', 'CA', '124', 5, 12, '0,1,3,12,', 1, 'Canada');
INSERT INTO `geo_regions` VALUES (191, 'Greenland', '格陵兰', '304', 'GRL', 'GL', '304', 5, 12, '0,1,3,12,', 1, 'Greenland');
INSERT INTO `geo_regions` VALUES (192, 'Saint Pierre and Miquelon', '圣皮埃尔和密克隆', '666', 'SPM', 'PM', '666', 5, 12, '0,1,3,12,', 1, 'Saint Pierre and Miquelon');
INSERT INTO `geo_regions` VALUES (193, 'United States of America', '美利坚合众国', '840', 'USA', 'US', '840', 5, 12, '0,1,3,12,', 1, 'United States of America');
INSERT INTO `geo_regions` VALUES (194, 'Kazakhstan', '哈萨克斯坦', '398', 'KAZ', 'KZ', '398', 5, 13, '0,1,4,13,', 1, 'Kazakhstan');
INSERT INTO `geo_regions` VALUES (195, 'Kyrgyzstan', '吉尔吉斯斯坦', '417', 'KGZ', 'KG', '417', 5, 13, '0,1,4,13,', 1, 'Kyrgyzstan');
INSERT INTO `geo_regions` VALUES (196, 'Tajikistan', '塔吉克斯坦', '762', 'TJK', 'TJ', '762', 5, 13, '0,1,4,13,', 1, 'Tajikistan');
INSERT INTO `geo_regions` VALUES (197, 'Turkmenistan', '土库曼斯坦', '795', 'TKM', 'TM', '795', 5, 13, '0,1,4,13,', 1, 'Turkmenistan');
INSERT INTO `geo_regions` VALUES (198, 'Uzbekistan', '乌兹别克斯坦', '860', 'UZB', 'UZ', '860', 5, 13, '0,1,4,13,', 1, 'Uzbekistan');
INSERT INTO `geo_regions` VALUES (199, 'China', '中国', '156', 'CHN', 'CN', '156', 5, 14, '0,1,4,14,', 1, 'China');
INSERT INTO `geo_regions` VALUES (200, 'China, Hong Kong Special Administrative Region', '中国香港特别行政区', '344', 'HKG', 'HK', '344', 5, 14, '0,1,4,14,', 1, 'China, Hong Kong Special Administrative Region');
INSERT INTO `geo_regions` VALUES (201, 'China, Macao Special Administrative Region', '中国澳门特别行政区', '446', 'MAC', 'MO', '446', 5, 14, '0,1,4,14,', 1, 'China, Macao Special Administrative Region');
INSERT INTO `geo_regions` VALUES (202, 'Democratic People\'s Republic of Korea', '朝鲜民主主义人民共和国', '408', 'PRK', 'KP', '408', 5, 14, '0,1,4,14,', 1, 'Democratic People\'s Republic of Korea');
INSERT INTO `geo_regions` VALUES (203, 'Japan', '日本', '392', 'JPN', 'JP', '392', 5, 14, '0,1,4,14,', 1, 'Japan');
INSERT INTO `geo_regions` VALUES (204, 'Mongolia', '蒙古', '496', 'MNG', 'MN', '496', 5, 14, '0,1,4,14,', 1, 'Mongolia');
INSERT INTO `geo_regions` VALUES (205, 'Republic of Korea', '大韩民国', '410', 'KOR', 'KR', '410', 5, 14, '0,1,4,14,', 1, 'Republic of Korea');
INSERT INTO `geo_regions` VALUES (206, 'Brunei Darussalam', '文莱达鲁萨兰国', '096', 'BRN', 'BN', '096', 5, 15, '0,1,4,15,', 1, 'Brunei Darussalam');
INSERT INTO `geo_regions` VALUES (207, 'Cambodia', '柬埔寨', '116', 'KHM', 'KH', '116', 5, 15, '0,1,4,15,', 1, 'Cambodia');
INSERT INTO `geo_regions` VALUES (208, 'Indonesia', '印度尼西亚', '360', 'IDN', 'ID', '360', 5, 15, '0,1,4,15,', 1, 'Indonesia');
INSERT INTO `geo_regions` VALUES (209, 'Lao People\'s Democratic Republic', '老挝人民民主共和国', '418', 'LAO', 'LA', '418', 5, 15, '0,1,4,15,', 1, 'Lao People\'s Democratic Republic');
INSERT INTO `geo_regions` VALUES (210, 'Malaysia', '马来西亚', '458', 'MYS', 'MY', '458', 5, 15, '0,1,4,15,', 1, 'Malaysia');
INSERT INTO `geo_regions` VALUES (211, 'Myanmar', '缅甸', '104', 'MMR', 'MM', '104', 5, 15, '0,1,4,15,', 1, 'Myanmar');
INSERT INTO `geo_regions` VALUES (212, 'Philippines', '菲律宾', '608', 'PHL', 'PH', '608', 5, 15, '0,1,4,15,', 1, 'Philippines');
INSERT INTO `geo_regions` VALUES (213, 'Singapore', '新加坡', '702', 'SGP', 'SG', '702', 5, 15, '0,1,4,15,', 1, 'Singapore');
INSERT INTO `geo_regions` VALUES (214, 'Thailand', '泰国', '764', 'THA', 'TH', '764', 5, 15, '0,1,4,15,', 1, 'Thailand');
INSERT INTO `geo_regions` VALUES (215, 'Timor-Leste', '东帝汶', '626', 'TLS', 'TL', '626', 5, 15, '0,1,4,15,', 1, 'Timor-Leste');
INSERT INTO `geo_regions` VALUES (216, 'Viet Nam', '越南', '704', 'VNM', 'VN', '704', 5, 15, '0,1,4,15,', 1, 'Viet Nam');
INSERT INTO `geo_regions` VALUES (217, 'Afghanistan', '阿富汗', '004', 'AFG', 'AF', '004', 5, 16, '0,1,4,16,', 1, 'Afghanistan');
INSERT INTO `geo_regions` VALUES (218, 'Bangladesh', '孟加拉国', '050', 'BGD', 'BD', '050', 5, 16, '0,1,4,16,', 1, 'Bangladesh');
INSERT INTO `geo_regions` VALUES (219, 'Bhutan', '不丹', '064', 'BTN', 'BT', '064', 5, 16, '0,1,4,16,', 1, 'Bhutan');
INSERT INTO `geo_regions` VALUES (220, 'India', '印度', '356', 'IND', 'IN', '356', 5, 16, '0,1,4,16,', 1, 'India');
INSERT INTO `geo_regions` VALUES (221, 'Iran (Islamic Republic of)', '伊朗伊斯兰共和国', '364', 'IRN', 'IR', '364', 5, 16, '0,1,4,16,', 1, 'Iran (Islamic Republic of)');
INSERT INTO `geo_regions` VALUES (222, 'Maldives', '马尔代夫', '462', 'MDV', 'MV', '462', 5, 16, '0,1,4,16,', 1, 'Maldives');
INSERT INTO `geo_regions` VALUES (223, 'Nepal', '尼泊尔', '524', 'NPL', 'NP', '524', 5, 16, '0,1,4,16,', 1, 'Nepal');
INSERT INTO `geo_regions` VALUES (224, 'Pakistan', '巴基斯坦', '586', 'PAK', 'PK', '586', 5, 16, '0,1,4,16,', 1, 'Pakistan');
INSERT INTO `geo_regions` VALUES (225, 'Sri Lanka', '斯里兰卡', '144', 'LKA', 'LK', '144', 5, 16, '0,1,4,16,', 1, 'Sri Lanka');
INSERT INTO `geo_regions` VALUES (226, 'Armenia', '亚美尼亚', '051', 'ARM', 'AM', '051', 5, 17, '0,1,4,17,', 1, 'Armenia');
INSERT INTO `geo_regions` VALUES (227, 'Azerbaijan', '阿塞拜疆', '031', 'AZE', 'AZ', '031', 5, 17, '0,1,4,17,', 1, 'Azerbaijan');
INSERT INTO `geo_regions` VALUES (228, 'Bahrain', '巴林', '048', 'BHR', 'BH', '048', 5, 17, '0,1,4,17,', 1, 'Bahrain');
INSERT INTO `geo_regions` VALUES (229, 'Cyprus', '塞浦路斯', '196', 'CYP', 'CY', '196', 5, 17, '0,1,4,17,', 1, 'Cyprus');
INSERT INTO `geo_regions` VALUES (230, 'Georgia', '格鲁吉亚', '268', 'GEO', 'GE', '268', 5, 17, '0,1,4,17,', 1, 'Georgia');
INSERT INTO `geo_regions` VALUES (231, 'Iraq', '伊拉克', '368', 'IRQ', 'IQ', '368', 5, 17, '0,1,4,17,', 1, 'Iraq');
INSERT INTO `geo_regions` VALUES (232, 'Israel', '以色列', '376', 'ISR', 'IL', '376', 5, 17, '0,1,4,17,', 1, 'Israel');
INSERT INTO `geo_regions` VALUES (233, 'Jordan', '约旦', '400', 'JOR', 'JO', '400', 5, 17, '0,1,4,17,', 1, 'Jordan');
INSERT INTO `geo_regions` VALUES (234, 'Kuwait', '科威特', '414', 'KWT', 'KW', '414', 5, 17, '0,1,4,17,', 1, 'Kuwait');
INSERT INTO `geo_regions` VALUES (235, 'Lebanon', '黎巴嫩', '422', 'LBN', 'LB', '422', 5, 17, '0,1,4,17,', 1, 'Lebanon');
INSERT INTO `geo_regions` VALUES (236, 'Oman', '阿曼', '512', 'OMN', 'OM', '512', 5, 17, '0,1,4,17,', 1, 'Oman');
INSERT INTO `geo_regions` VALUES (237, 'Qatar', '卡塔尔', '634', 'QAT', 'QA', '634', 5, 17, '0,1,4,17,', 1, 'Qatar');
INSERT INTO `geo_regions` VALUES (238, 'Saudi Arabia', '沙特阿拉伯', '682', 'SAU', 'SA', '682', 5, 17, '0,1,4,17,', 1, 'Saudi Arabia');
INSERT INTO `geo_regions` VALUES (239, 'State of Palestine', '巴勒斯坦国', '275', 'PSE', 'PS', '275', 5, 17, '0,1,4,17,', 1, 'State of Palestine');
INSERT INTO `geo_regions` VALUES (240, 'Syrian Arab Republic', '阿拉伯叙利亚共和国', '760', 'SYR', 'SY', '760', 5, 17, '0,1,4,17,', 1, 'Syrian Arab Republic');
INSERT INTO `geo_regions` VALUES (241, 'Turkey', '土耳其', '792', 'TUR', 'TR', '792', 5, 17, '0,1,4,17,', 1, 'Turkey');
INSERT INTO `geo_regions` VALUES (242, 'United Arab Emirates', '阿拉伯联合酋长国', '784', 'ARE', 'AE', '784', 5, 17, '0,1,4,17,', 1, 'United Arab Emirates');
INSERT INTO `geo_regions` VALUES (243, 'Yemen', '也门', '887', 'YEM', 'YE', '887', 5, 17, '0,1,4,17,', 1, 'Yemen');
INSERT INTO `geo_regions` VALUES (244, 'Belarus', '白俄罗斯', '112', 'BLR', 'BY', '112', 5, 18, '0,1,5,18,', 1, 'Belarus');
INSERT INTO `geo_regions` VALUES (245, 'Bulgaria', '保加利亚', '100', 'BGR', 'BG', '100', 5, 18, '0,1,5,18,', 1, 'Bulgaria');
INSERT INTO `geo_regions` VALUES (246, 'Czechia', '捷克', '203', 'CZE', 'CZ', '203	', 5, 18, '0,1,5,18,', 1, 'Czechia');
INSERT INTO `geo_regions` VALUES (247, 'Hungary', '匈牙利', '348', 'HUN', 'HU', '348', 5, 18, '0,1,5,18,', 1, 'Hungary');
INSERT INTO `geo_regions` VALUES (248, 'Poland', '波兰', '616', 'POL', 'PL', '616', 5, 18, '0,1,5,18,', 1, 'Poland');
INSERT INTO `geo_regions` VALUES (249, 'Republic of Moldova', '摩尔多瓦共和国', '498', 'MDA', 'MD', '498', 5, 18, '0,1,5,18,', 1, 'Republic of Moldova');
INSERT INTO `geo_regions` VALUES (250, 'Romania', '罗马尼亚', '642', 'ROU', 'RO', '642', 5, 18, '0,1,5,18,', 1, 'Romania');
INSERT INTO `geo_regions` VALUES (251, 'Russian Federation', '俄罗斯联邦', '643', 'RUS', 'RU', '643', 5, 18, '0,1,5,18,', 1, 'Russian Federation');
INSERT INTO `geo_regions` VALUES (252, 'Slovakia', '斯洛伐克', '703', 'SVK', 'SK', '703', 5, 18, '0,1,5,18,', 1, 'Slovakia');
INSERT INTO `geo_regions` VALUES (253, 'Ukraine', '乌克兰', '804', 'UKR', 'UA', '804', 5, 18, '0,1,5,18,', 1, 'Ukraine');
INSERT INTO `geo_regions` VALUES (254, 'Åland Islands', '奥兰群岛', '248', 'ALA', 'AX', '248', 5, 19, '0,1,5,19,', 1, 'Åland Islands');
INSERT INTO `geo_regions` VALUES (255, 'Denmark', '丹麦', '208', 'DNK', 'DK', '208', 5, 19, '0,1,5,19,', 1, 'Denmark');
INSERT INTO `geo_regions` VALUES (256, 'Estonia', '爱沙尼亚', '233', 'EST', 'EE', '233', 5, 19, '0,1,5,19,', 1, 'Estonia');
INSERT INTO `geo_regions` VALUES (257, 'Faroe Islands', '法罗群岛', '234', 'FRO', 'FO', '234', 5, 19, '0,1,5,19,', 1, 'Faroe Islands');
INSERT INTO `geo_regions` VALUES (258, 'Finland', '芬兰', '246', 'FIN', 'FI', '246', 5, 19, '0,1,5,19,', 1, 'Finland');
INSERT INTO `geo_regions` VALUES (259, 'Iceland', '冰岛', '352', 'ISL', 'IS', '352', 5, 19, '0,1,5,19,', 1, 'Iceland');
INSERT INTO `geo_regions` VALUES (260, 'Ireland', '爱尔兰', '372', 'IRL', 'IE', '372', 5, 19, '0,1,5,19,', 1, 'Ireland');
INSERT INTO `geo_regions` VALUES (261, 'Isle of Man', '马恩岛', '833', 'IMN', 'IM', '833', 5, 19, '0,1,5,19,', 1, 'Isle of Man');
INSERT INTO `geo_regions` VALUES (262, 'Latvia', '拉脱维亚', '428', 'LVA', 'LV', '428', 5, 19, '0,1,5,19,', 1, 'Latvia');
INSERT INTO `geo_regions` VALUES (263, 'Lithuania', '立陶宛', '440', 'LTU', 'LT', '440', 5, 19, '0,1,5,19,', 1, 'Lithuania');
INSERT INTO `geo_regions` VALUES (264, 'Norway', '挪威', '578', 'NOR', 'NO', '578', 5, 19, '0,1,5,19,', 1, 'Norway');
INSERT INTO `geo_regions` VALUES (265, 'Svalbard and Jan Mayen Islands', '斯瓦尔巴群岛和扬马延岛', '744', 'SJM', 'SJ', '744', 5, 19, '0,1,5,19,', 1, 'Svalbard and Jan Mayen Islands');
INSERT INTO `geo_regions` VALUES (266, 'Sweden', '瑞典', '752', 'SWE', 'SE', '752', 5, 19, '0,1,5,19,', 1, 'Sweden');
INSERT INTO `geo_regions` VALUES (267, 'United Kingdom of Great Britain and Northern Ireland', '大不列颠及北爱尔兰联合王国', '826', 'GBR', 'GB', '826', 5, 19, '0,1,5,19,', 1, 'United Kingdom of Great Britain and Northern Ireland');
INSERT INTO `geo_regions` VALUES (268, 'Albania', '阿尔巴尼亚', '008', 'ALB', 'AL', '008', 5, 20, '0,1,5,20,', 1, 'Albania');
INSERT INTO `geo_regions` VALUES (269, 'Andorra', '安道尔', '020', 'AND', 'AD', '020', 5, 20, '0,1,5,20,', 1, 'Andorra');
INSERT INTO `geo_regions` VALUES (270, 'Bosnia and Herzegovina', '波斯尼亚和黑塞哥维那', '070', 'BIH', 'BA', '070', 5, 20, '0,1,5,20,', 1, 'Bosnia and Herzegovina');
INSERT INTO `geo_regions` VALUES (271, 'Croatia', '克罗地亚', '191', 'HRV', 'HR', '191', 5, 20, '0,1,5,20,', 1, 'Croatia');
INSERT INTO `geo_regions` VALUES (272, 'Gibraltar', '直布罗陀', '292', 'GIB', 'GI', '292', 5, 20, '0,1,5,20,', 1, 'Gibraltar');
INSERT INTO `geo_regions` VALUES (273, 'Greece', '希腊', '300', 'GRC', 'GR', '300', 5, 20, '0,1,5,20,', 1, 'Greece');
INSERT INTO `geo_regions` VALUES (274, 'Holy See', '教廷', '336', 'VAT', 'VA', '336', 5, 20, '0,1,5,20,', 1, 'Holy See');
INSERT INTO `geo_regions` VALUES (275, 'Italy', '意大利', '380', 'ITA', 'IT', '380', 5, 20, '0,1,5,20,', 1, 'Italy');
INSERT INTO `geo_regions` VALUES (276, 'Malta', '马耳他', '470', 'MLT', 'MT', '470', 5, 20, '0,1,5,20,', 1, 'Malta');
INSERT INTO `geo_regions` VALUES (277, 'Montenegro', '黑山', '499', 'MNE', 'ME', '499', 5, 20, '0,1,5,20,', 1, 'Montenegro');
INSERT INTO `geo_regions` VALUES (278, 'North Macedonia', '北马其顿', '807', 'MKD', 'MK', '807', 5, 20, '0,1,5,20,', 1, 'North Macedonia');
INSERT INTO `geo_regions` VALUES (279, 'Portugal', '葡萄牙', '620', 'PRT', 'PT', '620', 5, 20, '0,1,5,20,', 1, 'Portugal');
INSERT INTO `geo_regions` VALUES (280, 'San Marino', '圣马力诺', '674', 'SMR', 'SM', '674', 5, 20, '0,1,5,20,', 1, 'San Marino');
INSERT INTO `geo_regions` VALUES (281, 'Serbia', '塞尔维亚', '688', 'SRB', 'RS', '688', 5, 20, '0,1,5,20,', 1, 'Serbia');
INSERT INTO `geo_regions` VALUES (282, 'Slovenia', '斯洛文尼亚', '705', 'SVN', 'SI', '705', 5, 20, '0,1,5,20,', 1, 'Slovenia');
INSERT INTO `geo_regions` VALUES (283, 'Spain', '西班牙', '724', 'ESP', 'ES', '724', 5, 20, '0,1,5,20,', 1, 'Spain');
INSERT INTO `geo_regions` VALUES (284, 'Austria', '奥地利', '040', 'AUT', 'AT', '040', 5, 21, '0,1,5,21,', 1, 'Austria');
INSERT INTO `geo_regions` VALUES (285, 'Belgium', '比利时', '056', 'BEL', 'BE', '056', 5, 21, '0,1,5,21,', 1, 'Belgium');
INSERT INTO `geo_regions` VALUES (286, 'France', '法国', '250', 'FRA', 'FR', '250', 5, 21, '0,1,5,21,', 1, 'France');
INSERT INTO `geo_regions` VALUES (287, 'Germany', '德国', '276', 'DEU', 'DE', '276', 5, 21, '0,1,5,21,', 1, 'Germany');
INSERT INTO `geo_regions` VALUES (288, 'Liechtenstein', '列支敦士登', '438', 'LIE', 'LI', '438', 5, 21, '0,1,5,21,', 1, 'Liechtenstein');
INSERT INTO `geo_regions` VALUES (289, 'Luxembourg', '卢森堡', '442', 'LUX', 'LU', '442', 5, 21, '0,1,5,21,', 1, 'Luxembourg');
INSERT INTO `geo_regions` VALUES (290, 'Monaco', '摩纳哥', '492', 'MCO', 'MC', '492', 5, 21, '0,1,5,21,', 1, 'Monaco');
INSERT INTO `geo_regions` VALUES (291, 'Netherlands', '荷兰', '528', 'NLD', 'NL', '528', 5, 21, '0,1,5,21,', 1, 'Netherlands');
INSERT INTO `geo_regions` VALUES (292, 'Switzerland', '瑞士', '756', 'CHE', 'CH', '756', 5, 21, '0,1,5,21,', 1, 'Switzerland');
INSERT INTO `geo_regions` VALUES (293, 'Australia', '澳大利亚', '036', 'AUS', 'AU', '036', 5, 22, '0,1,6,22,', 1, 'Australia');
INSERT INTO `geo_regions` VALUES (294, 'Christmas Island', '圣诞岛', '162', 'CXR', 'CX', '162', 5, 22, '0,1,6,22,', 1, 'Christmas Island');
INSERT INTO `geo_regions` VALUES (295, 'Cocos (Keeling) Islands', '科科斯（基林）群岛', '166', 'CCK', 'CC', '166', 5, 22, '0,1,6,22,', 1, 'Cocos (Keeling) Islands');
INSERT INTO `geo_regions` VALUES (296, 'Heard Island and McDonald Islands', '赫德岛和麦克唐纳岛', '334', 'HMD', 'HM', '334', 5, 22, '0,1,6,22,', 1, 'Heard Island and McDonald Islands');
INSERT INTO `geo_regions` VALUES (297, 'New Zealand', '新西兰', '554', 'NZL', 'NZ', '554', 5, 22, '0,1,6,22,', 1, 'New Zealand');
INSERT INTO `geo_regions` VALUES (298, 'Norfolk Island', '诺福克岛', '574', 'NFK', 'NF', '574', 5, 22, '0,1,6,22,', 1, 'Norfolk Island');
INSERT INTO `geo_regions` VALUES (299, 'Fiji', '斐济', '242', 'FJI', 'FJ', '242', 5, 23, '0,1,6,23,', 1, 'Fiji');
INSERT INTO `geo_regions` VALUES (300, 'New Caledonia', '新喀里多尼亚', '540', 'NCL', 'NC', '540', 5, 23, '0,1,6,23,', 1, 'New Caledonia');
INSERT INTO `geo_regions` VALUES (301, 'Papua New Guinea', '巴布亚新几内亚', '598', 'PNG', 'PG', '598', 5, 23, '0,1,6,23,', 1, 'Papua New Guinea');
INSERT INTO `geo_regions` VALUES (302, 'Solomon Islands', '所罗门群岛', '090', 'SLB', 'SB', '090', 5, 23, '0,1,6,23,', 1, 'Solomon Islands');
INSERT INTO `geo_regions` VALUES (303, 'Vanuatu', '瓦努阿图', '548', 'VUT', 'VU', '548', 5, 23, '0,1,6,23,', 1, 'Vanuatu');
INSERT INTO `geo_regions` VALUES (304, 'Guam', '关岛', '316', 'GUM', 'GU', '316', 5, 24, '0,1,6,24,', 1, 'Guam');
INSERT INTO `geo_regions` VALUES (305, 'Kiribati', '基里巴斯', '296', 'KIR', 'KI', '296', 5, 24, '0,1,6,24,', 1, 'Kiribati');
INSERT INTO `geo_regions` VALUES (306, 'Marshall Islands', '马绍尔群岛', '584', 'MHL', 'MH', '485', 5, 24, '0,1,6,24,', 1, 'Marshall Islands');
INSERT INTO `geo_regions` VALUES (307, 'Micronesia (Federated States of)', '密克罗尼西亚联邦', '583', 'FSM', 'FM', '583', 5, 24, '0,1,6,24,', 1, 'Micronesia (Federated States of)');
INSERT INTO `geo_regions` VALUES (308, 'Nauru', '瑙鲁', '520', 'NRU', 'NR', '520', 5, 24, '0,1,6,24,', 1, 'Nauru');
INSERT INTO `geo_regions` VALUES (309, 'Northern Mariana Islands', '北马里亚纳群岛', '580', 'MNP', 'MP', '580', 5, 24, '0,1,6,24,', 1, 'Northern Mariana Islands');
INSERT INTO `geo_regions` VALUES (310, 'Palau', '帕劳', '585', 'PLW', 'PW', '585', 5, 24, '0,1,6,24,', 1, 'Palau');
INSERT INTO `geo_regions` VALUES (311, 'United States Minor Outlying Islands', '美国本土外小岛屿', '581', 'UMI', 'UM', '581', 5, 24, '0,1,6,24,', 1, 'United States Minor Outlying Islands');
INSERT INTO `geo_regions` VALUES (312, 'American Samoa', '美属萨摩亚', '016', 'ASM', 'AS', '016', 5, 25, '0,1,6,25,', 1, 'American Samoa');
INSERT INTO `geo_regions` VALUES (313, 'Cook Islands', '库克群岛', '184', 'COK', 'CK', '184', 5, 25, '0,1,6,25,', 1, 'Cook Islands');
INSERT INTO `geo_regions` VALUES (314, 'French Polynesia', '法属波利尼西亚', '258', 'PYF', 'PF', '258', 5, 25, '0,1,6,25,', 1, 'French Polynesia');
INSERT INTO `geo_regions` VALUES (315, 'Niue', '纽埃', '570', 'NIU', 'NU', '570', 5, 25, '0,1,6,25,', 1, 'Niue');
INSERT INTO `geo_regions` VALUES (316, 'Pitcairn', '皮特凯恩', '612', 'PCN', 'PN', '612', 5, 25, '0,1,6,25,', 1, 'Pitcairn');
INSERT INTO `geo_regions` VALUES (317, 'Samoa', '萨摩亚', '882', 'WSM', 'WS', '882', 5, 25, '0,1,6,25,', 1, 'Samoa');
INSERT INTO `geo_regions` VALUES (318, 'Tokelau', '托克劳', '772', 'TKL', 'TK', '772', 5, 25, '0,1,6,25,', 1, 'Tokelau');
INSERT INTO `geo_regions` VALUES (319, 'Tonga', '汤加', '776', 'TON', 'TO', '776', 5, 25, '0,1,6,25,', 1, 'Tonga');
INSERT INTO `geo_regions` VALUES (320, 'Tuvalu', '图瓦卢', '798', 'TUV', 'TV', '798', 5, 25, '0,1,6,25,', 1, 'Tuvalu');
INSERT INTO `geo_regions` VALUES (321, 'Wallis and Futuna Islands', '瓦利斯群岛和富图纳群岛', '876', 'WLF', 'WF', '876', 5, 25, '0,1,6,25,', 1, 'Wallis and Futuna Islands');
INSERT INTO `geo_regions` VALUES (437, 'Antarctica', '南极洲', '010', 'ATA', 'AQ', '010', 5, 1, '0,1,', 1, 'Antarctica');

-- ----------------------------
-- Table structure for geo_type
-- ----------------------------
DROP TABLE IF EXISTS `geo_type`;
CREATE TABLE `geo_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '区域类型编号',
  `type_name_en` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区域类型英文名称',
  `type_name_cn` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '区域类型中文名称',
  `remarks` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '区域类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of geo_type
-- ----------------------------
INSERT INTO `geo_type` VALUES (1, 'Global', '全球', '全球范围');
INSERT INTO `geo_type` VALUES (2, 'Region', '区域', '大区域，大洲级别');
INSERT INTO `geo_type` VALUES (3, 'Sub-Region', '次级区域', '次级区域，如东非，西非');
INSERT INTO `geo_type` VALUES (4, 'Intermediate Region', '地域性区域', '地域性区域');
INSERT INTO `geo_type` VALUES (5, 'Country or Area', '国家或地区', '国家或者独立区域');

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
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '大洲' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ow_continent
-- ----------------------------
INSERT INTO `ow_continent` VALUES (1, 'AF', 'Africa', '非洲');
INSERT INTO `ow_continent` VALUES (2, 'AN', 'Antarctica', '南极洲');
INSERT INTO `ow_continent` VALUES (3, 'AS', 'Asia', '亚洲');
INSERT INTO `ow_continent` VALUES (4, 'EU', 'Europe', '欧洲');
INSERT INTO `ow_continent` VALUES (5, 'NA', 'North America', '北美洲');
INSERT INTO `ow_continent` VALUES (6, 'OA', 'Oceania', '大洋州');
INSERT INTO `ow_continent` VALUES (7, 'SA', 'South America', '南美洲');

-- ----------------------------
-- Function structure for generateUserName
-- ----------------------------
DROP FUNCTION IF EXISTS `generateUserName`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `generateUserName`( ) RETURNS varchar(255) CHARSET utf8
    DETERMINISTIC
BEGIN
DECLARE
		xing VARCHAR ( 2056 ) DEFAULT '赵钱孙李周郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁';
	DECLARE
		ming VARCHAR ( 2056 ) DEFAULT '嘉懿煜城懿轩烨伟苑博伟泽熠彤鸿煊博涛烨霖烨华煜纯洁祺智宸正豪昊然明杰诚立轩立辉峻熙弘文熠彤鸿煊烨霖哲瀚鑫鹏致远俊驰雨泽烨党磊晟睿天佑文昊修洁黎昕远航旭尧鸿涛伟祺轩越泽浩宇瑾瑜皓轩擎苍擎宇志泽睿渊楷瑞轩弘文哲瀚雨泽鑫磊梦琪忆之桃慕青问兰尔岚元香初夏沛菡傲珊曼文乐菱痴珊恨玉惜文香寒新柔语蓉海安夜蓉涵柏水桃醉蓝春儿语琴从彤傲晴语兰又菱碧彤元霜怜梦紫寒妙彤曼易南莲紫翠雨寒易烟如萱若南寻真晓亦向珊慕灵以蕊寻雁映易雪柳孤岚笑霜海云凝天沛珊寒云冰旋宛儿绿真盼儿晓霜碧凡夏菡曼香若烟半梦雅绿冰蓝灵槐平安书翠翠风香巧代云梦曼幼翠友巧听寒梦柏醉易访旋亦玉凌萱访卉怀亦笑蓝春翠靖柏夜蕾冰夏梦松书雪乐枫念薇靖雁寻春恨山从寒忆香觅波静曼凡旋以亦念露芷蕾千兰新波代真新蕾雁玉冷卉紫山千琴恨天傲芙盼山怀蝶冰兰山柏翠萱乐丹翠柔谷山之瑶冰露尔珍谷雪乐萱涵菡海莲傲蕾青槐冬儿易梦惜雪宛海之柔夏青亦瑶妙菡春竹修杰伟诚建辉晋鹏天磊绍辉泽洋明轩健柏煊昊强伟宸博超君浩子骞明辉鹏涛炎彬鹤轩越彬风华靖琪明诚高格光华国源宇晗昱涵润翰飞翰海昊乾浩博和安弘博鸿朗华奥华灿嘉慕坚秉建明金鑫锦程瑾瑜鹏经赋景同靖琪君昊俊明季同开济凯安康成乐语力勤良哲理群茂彦敏博明达朋义彭泽鹏举濮存溥心璞瑜浦泽奇邃祥荣轩';
	DECLARE
		I_xing INT DEFAULT LENGTH( xing ) / 3;
	DECLARE
		I_ming INT DEFAULT LENGTH( ming ) / 3;
	DECLARE
		return_str VARCHAR ( 2056 ) DEFAULT '';
	
	SET return_str = CONCAT( return_str, substring( xing, floor( 1 + RAND( ) * I_xing ), 1 ) );
	
	SET return_str = CONCAT( return_str, substring( ming, floor( 1 + RAND( ) * I_ming ), 1 ) );
	IF
		RAND( ) > 0.400 THEN
			
			SET return_str = CONCAT( return_str, substring( ming, floor( 1 + RAND( ) * I_ming ), 1 ) );
		
	END IF;
	RETURN return_str;
	
	END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for init_demo_test_data
-- ----------------------------
DROP PROCEDURE IF EXISTS `init_demo_test_data`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `init_demo_test_data`( IN `cnt` INTEGER )
BEGIN
	DECLARE
		i INT DEFAULT 0;
	DECLARE
		j INT DEFAULT 0;
	DECLARE
		asql Text;
	DECLARE
		vfd VARCHAR ( 100 );
	DECLARE
		ifd INT;
	DECLARE
		dfd date;
	DECLARE
		sfd VARCHAR ( 30 );
	DECLARE
		msfd VARCHAR ( 30 );
	DECLARE
		cfd VARCHAR ( 30 );
	DECLARE
		rfd VARCHAR ( 30 );
	DECLARE
		delflag INT;
	WHILE
			i <= cnt DO
			
			SET j = 0;
		
		SET asql = 'INSERT INTO `demo_single_table` ( int_field, varchar_field, date_field, select_dict_field, multi_select_field, check_dict_field, del_flag, redio_dict_field )
		VALUES ';
		WHILE
				j < 1000 DO
				SET j = j + 1;
			SET ifd = ( 20+ floor( rand( ) * 51 ) );
			SET vfd = generateUserName ( );
			SET dfd = (
				ADDDATE(
					MAKEDATE( 2018, FLOOR( 305 + RAND( ) * 30 ) ),-- 1-30号
					INTERVAL MAKETIME(
						FLOOR( RAND( ) * 24 ),-- 0-23点
						FLOOR( RAND( ) * 60 ),-- 0-59分
						FLOOR( RAND( ) * 60 ) -- 0-59秒
						
					) HOUR_SECOND 
				) 
			);
			SET sfd = ( floor( rand( ) * 3 ) );
			SET msfd = (
				CASE
						floor( rand( ) * 7 ) 
						WHEN 0 THEN
						'0' 
						WHEN 1 THEN
						'1' 
						WHEN 2 THEN
						'2' 
						WHEN 3 THEN
						'0,1' 
						WHEN 4 THEN
						'0,2' 
						WHEN 5 THEN
						'1,2' ELSE '0,1,2' 
					END 
					);
				SET cfd = (
					CASE
							floor( rand( ) * 7 ) 
							WHEN 0 THEN
							'0' 
							WHEN 1 THEN
							'1' 
							WHEN 2 THEN
							'2' 
							WHEN 3 THEN
							'0,1' 
							WHEN 4 THEN
							'0,2' 
							WHEN 5 THEN
							'1,2' ELSE '0,1,2' 
						END 
						);
					SET rfd = ( CASE floor( rand( ) * 2 ) WHEN 0 THEN 'radio1' ELSE 'radio2' END );
					SET delflag = ( floor( rand( ) * 2 ) );
					SET asql = CONCAT(
						asql,
						'("',
						ifd,
						'","',
						vfd,
						'","',
						dfd,
						'","',
						sfd,
						'","',
						msfd,
						'","',
						cfd,
						'","',
						delflag,
						'","',
						rfd,
						'"),' 
					);
				END WHILE;
				SET asql = SUBSTRING( asql, 1, CHARACTER_LENGTH( asql ) - 1 );
				SET asql = CONCAT( asql, ';' );
				SET @SQL = asql;
				PREPARE s1 
				FROM
					@SQL;
				EXECUTE s1;
				DEALLOCATE PREPARE s1;
				SET i = i + 1;
			END WHILE;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
