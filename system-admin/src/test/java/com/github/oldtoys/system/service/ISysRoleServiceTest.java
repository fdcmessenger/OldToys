package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysRole;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统角色 服务层测试
 *
 * @author Mr.fdc
 * @date 2019-07-24T17:43:17.326+08:00
 */
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/roleTestInit.sql"})
public class ISysRoleServiceTest {

    @Autowired
    ISysRoleService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

    @Test
    @Rollback(false)
    public void testSaveNew() {
        SysRole r = new SysRole();
        r.setName("new");
//        r.setRoleKey("ROLEKEY");
        this.service.save(r);
        Assert.assertNotNull(r.getId());
    }

}
