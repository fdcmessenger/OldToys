package com.github.oldtoys.system.mapper;

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
 * 部门角色 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:53.989+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/officeRoleTestInit.sql"})
public class SysOfficeRoleMapperTest {

    @Autowired
    SysOfficeRoleMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
    }

    @Test
    public void testfindOfficeRoleListByOfficeId() {
        Integer oid = 1;
        List r = dao.findOfficeRoleListByOfficeId(oid);
        Assert.assertTrue(r.size() == 0);
    }
}
