package com.github.oldtoys.demo.mapper;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单样例 数据层测试
 *
 * @author Mr.fdc
 * @date 2019-06-28T09:25:20.581+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSingleTableMapperTest {

    @Autowired
    DemoSingleTableMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
    }

}
