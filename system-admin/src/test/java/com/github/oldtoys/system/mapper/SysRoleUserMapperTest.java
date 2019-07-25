package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysRoleUser;
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
 * 角色用户 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/RoleUserTestInit.sql"})//delete all and insert test data
public class SysRoleUserMapperTest {

    @Autowired
    SysRoleUserMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() == 0);
    }

    @Test
    public void testFindRoleUserByRoleUserId() {
        Integer id = 1;
        SysRoleUser r = dao.findRoleUserByRoleUserId(id);
        Assert.assertNull(r);
    }

    @Test
    public void testFindRoleUserListByUserId() {
        Integer id = 1;
        List r = dao.findRoleUserListByUserId(id);
        Assert.assertTrue(r.size() == 0);
    }

    @Test
    public void testFindRoleUserListByRoleId() {
        Integer id = 1;
        List r = dao.findRoleUserListByRoleId(id);
        Assert.assertTrue(r.size() == 0);
    }
}
