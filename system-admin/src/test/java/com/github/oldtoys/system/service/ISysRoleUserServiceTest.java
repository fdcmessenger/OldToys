package com.github.oldtoys.system.service;

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
 * 角色用户 服务层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/RoleUserTestInit.sql"})
public class ISysRoleUserServiceTest {

    @Autowired
    ISysRoleUserService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() == 0);
    }

}
