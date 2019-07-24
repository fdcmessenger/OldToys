package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysMenu;
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
 * 系统菜单 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/menuTestInit.sql"})//delete all and insert test persons.
public class SysMenuMapperTest {

    @Autowired
    SysMenuMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
    }

    @Test
    public void testSelectOne() {
        SysMenu r = dao.selectByPrimaryKey(1);
        Assert.assertNotNull(r);
        r = dao.selectByPrimaryKey(2);
        Assert.assertNotNull(r);
//        Assert.assertNotNull(r.getParent());
    }

    @Test
    public void testSelectById() {
        SysMenu r = dao.findById(2);
        Assert.assertNotNull(r);
        Assert.assertNotNull(r.getParent());
        Assert.assertNotNull(r.getParent().getName());
        Assert.assertNotNull(r.getParent().getId());
        r = dao.findById(3);
        Assert.assertNotNull(r);
        Assert.assertNotNull(r.getParent());
        Assert.assertNotNull(r.getParent().getName());
        Assert.assertNotNull(r.getParent().getId());
    }

    @Test
    public void testSelectByPid() {
        List<SysMenu> r = dao.findByPid(1);
        Assert.assertNotNull(r);
        r = dao.findByPid(2);
        Assert.assertTrue(r.size() == 1);
    }

    @Test
    public void testFindByParentIdsLike() {
        SysMenu r = dao.findById(1);
        List<SysMenu> l = dao.findByParentIdsLike(r.getPids() + r.getId() + ",");
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() == 4);
    }

    @Test
    public void testBatchReplacePidsPath() {
        SysMenu r = dao.findById(1);
//        List<Role> l = dao.findByParentIdsLike(r.getPids() + r.getId() + ",");
        dao.batchReplacePidsPath(r.getPids() + r.getId() + ",", "newTestReplacePids");
        SysMenu e = new SysMenu();
        e.setPid(1);
        e.setSort(null);
        List<SysMenu> l = dao.select(e);
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() > 0);
    }

}
