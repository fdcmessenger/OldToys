package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysRoleMenu;
import java.util.Arrays;
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
 * 角色菜单 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/RoleMenuTestInit.sql"})
public class SysRoleMenuMapperTest {

    @Autowired
    SysRoleMenuMapper dao;

    @Test
    public void testSelectAll() {
        List r = dao.selectAll();
        Assert.assertTrue(r.size() > 0);
    }

    @Test
    public void testfindRoleMenuByRoleMenuId() {
        SysRoleMenu rm = this.dao.findRoleMenuByRoleMenuId(1);
        Assert.assertNotNull(rm);
    }

    @Test
    public void testfindRoleMenuListByRoleId() {
        List<SysRoleMenu> rm = this.dao.findRoleMenuListByRoleId(1);
        Assert.assertNotNull(rm);
    }

    @Test
    public void testfindRoleMenuListByRoleIds() {
        Integer[] a = {1, 2};
        List<SysRoleMenu> rm = this.dao.findRoleMenuListByRoleIds(Arrays.asList(a));
        Assert.assertNotNull(rm);
    }

    @Test
    public void testdeleteUnusedRoleMenus() {

        Integer roleId = 1;
        Integer[] menuIds = {1, 2, 3, 4, 5};
        int r = this.dao.deleteUnusedRoleMenus(roleId, menuIds);
        Assert.assertEquals(0, r);
    }

    @Test
    public void testdeleteUnusedRoleMenus1() {

        Integer roleId = 1;
        Integer[] menuIds = {1, 2, 3, 5};
        int r = this.dao.deleteUnusedRoleMenus(roleId, menuIds);
        Assert.assertEquals(1, r);
    }

    @Test
    public void testinsertNewRoleMenus() {

        Integer roleId = 1;
        Integer[] menuIds = {1, 2, 3, 4, 5};
        int r = this.dao.insertNewRoleMenus(roleId, menuIds);
        Assert.assertEquals(2, r);
    }
}
