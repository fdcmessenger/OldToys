/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fdc.generator.service;

import com.gitee.fdc.base.service.BaseService;
import com.github.fdc.generator.entity.GenScheme;

/**
 *
 * @author MACHENIKE
 */
public interface GenSchemeService extends BaseService<GenScheme, String> {

    public void saveScheme(GenScheme genScheme);
}
