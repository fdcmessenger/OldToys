/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.service.PasswordService;
import org.springframework.util.DigestUtils;

/**
 *
 * @author MACHENIKE
 */
public class DefaultPasswordServiceImpl implements PasswordService {

    @Override
    public String generatePassword(String plaintext) {
//        return new SimpleHash(URPM_Constants.DEFAULT_HASH_ALGORITHM_NAME,
//                 plaintext,
//                 URPM_Constants.DEFAULT_HASH_SALT,
//                 URPM_Constants.DEFAULT_HASH_ITERATIONS
//        ).toHex();
        return DigestUtils.md5DigestAsHex(plaintext.getBytes());
    }

}
