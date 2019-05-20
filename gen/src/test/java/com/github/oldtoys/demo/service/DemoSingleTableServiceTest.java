package com.github.oldtoys.demo.service;

import com.github.oldtoys.gen.GenApplication;
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
 * @date 2019-05-20T08:56:53.535+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GenApplication.class)
public class DemoSingleTableServiceTest {

    @Autowired
    IDemoSingleTableService service;

    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

}
