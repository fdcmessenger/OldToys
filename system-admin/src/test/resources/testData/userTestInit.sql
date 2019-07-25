/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  qskj
 * Created: 2018-3-19
 */
SET FOREIGN_KEY_CHECKS=0;
delete from `sys_office_user`;
delete from `sys_user`;
delete from `sys_office`;

INSERT INTO `sys_office` VALUES ('1',  '1', null, '0,', '1', '1', 1);
INSERT INTO `sys_office` VALUES ('2',  '2', '1', '0,1,', '2', '2', 1);
INSERT INTO `sys_office` VALUES ('3',  '3', '2', '0,1,2,', '3', '3', 1);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'test1', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name1', 'mobile1', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('2', 'test2', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name2', 'mobile2', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('3', 'test3', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name3', 'mobile3', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('4', 'test4', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name4', 'mobile4', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('5', 'test5', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name5', 'mobile5', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('6', 'test6', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name6', 'mobile6', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('7', 'test7', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name7', 'mobile7', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('8', 'test8', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name8', 'mobile8', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('9', 'test9', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name9', 'mobile9', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('10', 'test10', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name10', 'mobile10', 'email', '1', '1', '2018-03-19 13:02:18');
INSERT INTO `sys_user` VALUES ('11', 'test11', 'd2c21fd4c4fc786107e32b0235e162cc', 'bca6bf03ebb6402a', 'name', 'mobile11', 'email', '1', '1', '2018-03-19 13:02:18');

INSERT INTO `sys_office_user` VALUES ('1', '1', '1',1);
INSERT INTO `sys_office_user` VALUES ('2', '2', '2',1);
INSERT INTO `sys_office_user` VALUES ('3', '3', '3',1);
commit;
SET FOREIGN_KEY_CHECKS=0;