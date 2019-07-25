SET FOREIGN_KEY_CHECKS=0;
delete from `sys_role` ;

INSERT INTO `sys_role` VALUES ('1', '1', 1,  '1', 1,  '1');
INSERT INTO `sys_role` VALUES ('2', '2', 1,  '2', 1,  '2');
INSERT INTO `sys_role` VALUES ('3', '3', 1, '3', 1,  '3');
commit;
SET FOREIGN_KEY_CHECKS=1;