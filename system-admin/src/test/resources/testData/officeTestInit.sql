SET FOREIGN_KEY_CHECKS=0;
delete from `sys_office` ;

-- ----------------------------
-- Records of sys_office
-- ----------------------------
INSERT INTO `sys_office` VALUES ('1',  '1', null, '0,', '1', '1', 1);
INSERT INTO `sys_office` VALUES ('2',  '2', '1', '0,1,', '2', '2', 1);
INSERT INTO `sys_office` VALUES ('3',  '3', '2', '0,1,2,', '3', '3', 1);
commit;
SET FOREIGN_KEY_CHECKS=1;