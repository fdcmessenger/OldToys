package com.github.oldtoys.dict.service;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 字典 服务层测试
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ISysDictServiceTest { 	

    @Autowired
    ISysDictService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

}