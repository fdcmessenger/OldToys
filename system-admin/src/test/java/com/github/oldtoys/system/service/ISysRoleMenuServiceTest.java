package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysRoleMenu;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色菜单 服务层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/roleMenuTestInit.sql"})//delete all and insert test data
public class ISysRoleMenuServiceTest {

    @Autowired
    ISysRoleMenuService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

    @Test
    public void testfindRoleMenuByRoleMenuId() {
        SysRoleMenu rm = this.service.findRoleMenuByRoleMenuId(1);
        Assert.assertNotNull(rm);
    }

    @Test
    public void testfindRoleMenuListByRoleId() {
        List<SysRoleMenu> rm = this.service.findRoleMenuListByRoleId(1);
        Assert.assertNotNull(rm);
    }



    @Test
//    @Rollback(false)
    public void testsaveRomeMenus() {
        Integer roleId = 1;
        Integer[] menuIds = {1, 2, 4, 3, 5};
        int r = this.service.saveRomeMenus(roleId, menuIds);
        Assert.assertEquals(2, r);
    }
}
