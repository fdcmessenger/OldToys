package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysOfficeUser;
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
 * 部门用户 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:49.437+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/userTestInit.sql"})//delete all and insert test persons.
public class SysOfficeUserMapperTest {

    @Autowired
    SysOfficeUserMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() > 0);
    }

    @Test
    public void testSelectByUserId() {
        Integer uid = 1;
        List<SysOfficeUser> r = dao.findOfficeUserListByUserId(uid);
        Assert.assertTrue(r.size() > 0);
    }

    @Test
    public void testSelectByUserName() {
        String uid = "test1";
        List<SysOfficeUser> r = dao.findOfficeUserListByUserName(uid);
        Assert.assertTrue(r.size() > 0);
    }
}
