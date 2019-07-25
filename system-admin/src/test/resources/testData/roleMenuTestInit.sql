/*
ALTER TABLE `sys_sub_system`
MODIFY COLUMN `useable`  tinyint UNSIGNED   COMMENT '是否启用';

*/

SET FOREIGN_KEY_CHECKS=0;
delete from `sys_role` ;
delete from `sys_menu` ;
delete from `sys_role_menu` ;


-- 菜单
INSERT INTO `sys_menu` VALUES ('1', '1', null, '0,', '0', null, 0, '1', '1', 0, '1');
INSERT INTO `sys_menu` VALUES ('2', '2', '1', '0,1,', '0', null, 0, '2', '2', 0, '2');
INSERT INTO `sys_menu` VALUES ('3', '3', '1', '0,1,', '0', null, 0, '3', '3', 0, '3');
INSERT INTO `sys_menu` VALUES ('4', '4', '2', '0,1,2,', '0', null, 0, '2', '2', 0, '2');
INSERT INTO `sys_menu` VALUES ('5', '5', '3', '0,1,3,', '0', null, 0, '3', '3', 0, '3');

-- 角色

INSERT INTO `sys_role` VALUES ('1', '1', 1,  '1', 1,  '1');
INSERT INTO `sys_role` VALUES ('2', '2', 1,  '2', 1,  '2');
INSERT INTO `sys_role` VALUES ('3', '3', 1, '3', 1,  '3');


INSERT INTO `sys_role_menu` (`id`, `role_id`,  `menu_id`) VALUES (1, 1,  1);
INSERT INTO `sys_role_menu` (`id`, `role_id`,  `menu_id`) VALUES (2, 1,  2);
INSERT INTO `sys_role_menu` (`id`, `role_id`,  `menu_id`) VALUES (3, 1,  4);

commit;
SET FOREIGN_KEY_CHECKS=1;