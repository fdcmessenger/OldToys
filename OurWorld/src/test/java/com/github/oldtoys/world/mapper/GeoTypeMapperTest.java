package com.github.oldtoys.world.mapper;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 区域类型 数据层测试
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:02:50.208+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
public class GeoTypeMapperTest { 	

    @Autowired
    GeoTypeMapper dao;

    @Test
    public void testSelectAll() {
        List l = dao.selectAll();
        Assert.assertNotNull(l);
    }

}