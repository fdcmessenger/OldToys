/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fdc.generator.dao;

import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;
import com.github.fdc.generator.entity.GenTableColumn;

/**
 *
 * @author qskj
 */
public interface GenTableColumnDao extends SbbsMapper<GenTableColumn> {

    List<GenTableColumn> findByTableId(String tid);

    int deleteByGenTableId(String tid);
}
