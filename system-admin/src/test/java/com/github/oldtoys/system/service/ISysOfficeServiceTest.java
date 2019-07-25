package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysOffice;
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
 * 组织部门 服务层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/roleTestInit.sql"})
public class ISysOfficeServiceTest {

    @Autowired
    ISysOfficeService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

    @Test
    @Rollback(false)
    public void testSaveNew() {
        SysOffice r = new SysOffice();
        r.setName("new");
        this.service.save(r);
        Assert.assertNotNull(r.getId());
    }

    @Test
//    @Rollback(false)
    public void testSaveChangeParent() {
        SysOffice r = this.service.findById(3);
        r.setPid(1);
        this.service.save(r);
        SysOffice r1 = this.service.findById(3);
        Assert.assertTrue(r1.getPid() == 1);
        Assert.assertEquals("0,1,", r1.getPids());
    }

    @Test
    public void testFindByParentIdIncludeParent() {
        List l = this.service.findByParentIdIncludeParent(1);
        Assert.assertTrue(l.size() == 3);
    }

    @Test
    public void testFindByParentIdExcludeParent() {
        List l = this.service.findByParentIdExcludeParent(1);
        Assert.assertTrue(l.size() == 2);
    }
}
