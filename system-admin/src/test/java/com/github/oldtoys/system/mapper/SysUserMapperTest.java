package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysUser;
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
 * 用户 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/userTestInit.sql"})//delete all and insert test persons.
public class SysUserMapperTest {

    Integer initUserId = 1;
    @Autowired
    SysUserMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
    }

    @Test
    public void testFindByUserName() {
        SysUser u = dao.findByUserName("fdc");
        Assert.assertNull(u);
        u = dao.findByUserName("test1");
        Assert.assertNotNull(u);
    }

    @Test
    public void testUpdatePasswordById() {

        SysUser u = dao.selectByPrimaryKey(this.initUserId);
        u.setPassword("newPassword");
        u.setUserName(null);
        this.dao.updatePasswordById(u);
        Assert.assertNotNull(u);
        SysUser u1 = dao.selectByPrimaryKey(this.initUserId);
        Assert.assertEquals("newPassword", u1.getPassword());
    }

    @Test
    public void testUpdatePasswordByUserName() {
        SysUser u = dao.selectByPrimaryKey(this.initUserId);
        u.setPassword("newPassword1");
        u.setId(null);
        this.dao.updatePasswordByUserName(u);
        Assert.assertNotNull(u);
        SysUser u1 = dao.selectByPrimaryKey(this.initUserId);
        Assert.assertEquals("newPassword1", u1.getPassword());
    }
}
