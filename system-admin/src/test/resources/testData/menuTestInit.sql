SET FOREIGN_KEY_CHECKS=0;
delete from `sys_menu` ;

INSERT INTO `sys_menu` VALUES ('1', '1', null, '0,', '0', null, 0, '1', '1', 0, '1');
INSERT INTO `sys_menu` VALUES ('2', '2', '1', '0,1,', '0', null, 0, '2', '2', 0, '2');
INSERT INTO `sys_menu` VALUES ('3', '3', '1', '0,1,', '0', null, 0, '3', '3', 0, '3');
INSERT INTO `sys_menu` VALUES ('4', '4', '2', '0,1,2,', '0', null, 0, '2', '2', 0, '2');
INSERT INTO `sys_menu` VALUES ('5', '5', '3', '0,1,3,', '0', null, 0, '3', '3', 0, '3');

commit;
SET FOREIGN_KEY_CHECKS=1;