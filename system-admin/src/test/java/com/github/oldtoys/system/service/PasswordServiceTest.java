/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oldtoys.system.service;

import com.github.oldtoys.system.service.impl.DefaultPasswordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
@Slf4j
public class PasswordServiceTest {

    public PasswordServiceTest() {
    }

    /**
     * Test of generatePassword method, of class PasswordService.
     */
    @Test
    public void testGeneratePassword() {
        String psw = "1234567890";
        PasswordService service = new DefaultPasswordServiceImpl();
        for (int i = 0; i < 10; i++) {
            String md5psw = service.generatePassword(psw);
            log.info(psw);
            log.info(md5psw);
        }
    }

}
