package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysOffice;
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
 * 组织部门 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/officeTestInit.sql"})//delete all and insert test persons.
public class SysOfficeMapperTest {

    @Autowired
    SysOfficeMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
    }

    @Test
    public void testSelectOne() {
        SysOffice r = dao.selectByPrimaryKey(1);
        Assert.assertNotNull(r);
        r = dao.selectByPrimaryKey(2);
        Assert.assertNotNull(r);
//        Assert.assertNotNull(r.getParent());
    }

    @Test
    public void testSelectById() {
        SysOffice r = dao.findById(2);
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
        List<SysOffice> r = dao.findByPid(1);
        Assert.assertNotNull(r);
        r = dao.findByPid(2);
        for (SysOffice o : r) {

            Assert.assertNotNull(o.getParent().getId());
            Assert.assertNotNull(o.getParent().getName());
        }
    }

    @Test
    public void testFindByParentIdsLike() {
        SysOffice r = dao.findById(1);
        List<SysOffice> l = dao.findByParentIdsLike(r.getPids() + r.getId() + ",");
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() == 2);
    }

    @Test
    //@todo 具体查查原因，否则心里没底
    public void testBatchReplacePidsPath() {
        SysOffice r = dao.findById(1);
//        List<Role> l = dao.findByParentIdsLike(r.getPids() + r.getId() + ",");
        dao.batchReplacePidsPath(r.getPids() + r.getId() + ",", "newTestReplacePids");
        SysOffice e = new SysOffice();
        e.setPid(1);
        e.setSort(null);
        e.setUseable(null);
        List<SysOffice> l = dao.select(e);
        Assert.assertNotNull(l);
        Assert.assertTrue(l.size() > 0);
    }
}
