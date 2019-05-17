/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.service;

import com.gitee.fdc.base.service.BaseService;
import java.util.List;
import com.github.fdc.generator.entity.GenTable;

/**
 * 业务表Service
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
public interface GenTableService extends BaseService<GenTable, String> {

    public GenTable findById(String id);

    public List<GenTable> find();
//    public List<GenTable> find(GenTable genTable);

    public List<GenTable> findAll();

    /**
     * 获取物理数据表列表
     *
     * @param genTable
     * @return
     */
    public List<GenTable> findTableListFormDb();

    public GenTable getGenTableDefine(GenTable table);

    /**
     * 验证表名是否可用，如果已存在，则返回false
     *
     * @param genTable
     * @return
     */
    public boolean checkTableName(String tableName);

    /**
     * 获取物理数据表列表
     *
     * @param genTable
     * @return
     */
    public GenTable getTableFormDb(String tname);

    public void saveTable(GenTable genTable);

//    public void delete(GenTable genTable);
}
