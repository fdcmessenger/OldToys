package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysUser;
import com.github.oldtoys.system.vo.UserSearchDto;
import java.util.Date;
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
 * 用户 服务层测试
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
@Transactional(readOnly = false)
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql({"classpath:/testData/userTestInit.sql"})
public class ISysUserServiceTest {
    
    @Autowired
    ISysUserService service;
    
    @Test
    public void testSelectAll() {
        List l = service.findAll();
        Assert.assertNotNull(l);
    }

    /**
     * Test of findByUserName method, of class UserService.
     */
    @Test
    public void testFindByUserName() {
        String usr = "test1";
        
        SysUser result = service.findByUserName(usr);
        Assert.assertNotNull(result);
    }

    /**
     * Test of updatePasswordById method, of class UserService.
     */
    @Test
    public void testUpdatePasswordById() {
        Integer id = 1;
        String newPassword = "newPassword";
        int result = service.updatePasswordById(id, newPassword);
        Assert.assertEquals(1, result);
    }

    /**
     * Test of updatePasswordByUserName method, of class UserService.
     */
    @Test
    public void testUpdatePasswordByUserName() {
        String loginName = "test1";
        String newPassword = "fdc";
        int result = service.updatePasswordByUserName(loginName, newPassword);
        Assert.assertTrue(result > 0);
        
    }
    
    @Test
    public void testFindByOfficeId() {
        Integer oid = 1;
        List ul = null;
        UserSearchDto dto = new UserSearchDto();
        dto.setOfficeId(oid);
        dto.setIncludeChildren(false);
        ul = this.service.findByOfficeId(dto);
        Assert.assertEquals(1, ul.size());
        dto.setIncludeChildren(true);
        ul = this.service.findByOfficeId(dto);
        Assert.assertEquals(3, ul.size());
        
    }
    
    @Test
    public void testInsertUser() {
        SysUser u = new SysUser();
        u.setBirthday(new Date());
        u.setEmail("fdc@123.com");
        u.setGender(1);
        u.setMobile("13366528500");
        u.setName("fdc");
        u.setPassword("psw");
        u.setSalt("salt");
        u.setUserName("fc");
        u.setStatus(SysUser.USER_STATUS_DELETED);
        this.service.save(u);
        Assert.assertNotNull(u.getId());
    }
    
}
