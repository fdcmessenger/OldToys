package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysMenu;
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
 * 系统菜单 服务层测试
 *
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/menuTestInit.sql"})
public class ISysMenuServiceTest {

    @Autowired
    ISysMenuService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

    @Test
    @Rollback(false)
    public void testSaveNew() {
        SysMenu r = new SysMenu();
        r.setName("new");
        this.service.save(r);
        Assert.assertNotNull(r.getId());
    }

    @Test
//    @Rollback(false)
    public void testSaveChangeParent() {
        SysMenu r = this.service.findById(3);
        r.setPid(1);
        this.service.save(r);
        SysMenu r1 = this.service.findById(3);
        Assert.assertTrue(r1.getPid() == 1);
        Assert.assertEquals("0,1,", r1.getPids());
    }

    @Test
    public void testFindByParentIdIncludeParent() {
        List<SysMenu> l = this.service.findByParentIdIncludeParent(1);
        Assert.assertTrue(l.size() == 5);
    }

    @Test
    public void testFindByParentIdExcludeParent() {
        List<SysMenu> l = this.service.findByParentIdExcludeParent(1);
        Assert.assertTrue(l.size() == 4);
    }
}
