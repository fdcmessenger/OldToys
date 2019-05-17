/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.service.impl;

import com.gitee.fdc.base.service.BaseServiceImple;
import com.gitee.fdc.kits.StringUtils;
import java.util.List;
import javax.annotation.PostConstruct;
import com.github.fdc.generator.dao.GenDataBaseDao;
import com.github.fdc.generator.dao.GenTableColumnDao;
import com.github.fdc.generator.dao.GenTableDao;
import com.github.fdc.generator.entity.GenTable;
import com.github.fdc.generator.entity.GenTableColumn;
import com.github.fdc.generator.service.GenTableService;
import com.github.fdc.generator.util.GenUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 业务表Service
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
@Service
@Transactional(readOnly = true)
public class GenTableServiceImpl extends BaseServiceImple<GenTable,String> implements GenTableService {

    @Autowired
    private GenTableDao genTableDao;
    @Autowired
    private GenTableColumnDao genTableColumnDao;
    @Autowired
    private GenDataBaseDao genDataBaseDictDao;

    @PostConstruct
    public void init() {
        super.init(GenTable.class, genTableDao);
    }

    public GenTable findById(String tid) {
        GenTable genTable = genTableDao.selectByPrimaryKey(tid);
        if (genTable == null) {
            return null;

        } else {
            GenTableColumn genTableColumn = new GenTableColumn();
            genTableColumn.setGenTable(genTable);
            genTable.setColumnList(genTableColumnDao.findByTableId(tid));
            return genTable;
        }
    }

    /**
     * TODO 有分页，由查询条件的需要后续处理
     *
     * @return
     */
    public List<GenTable> find() {
        this.pageAble();
        return this.genTableDao.selectAll();
    }

    public List<GenTable> findAll() {
        return genTableDao.selectAll();
    }

    /**
     * 获取物理数据表列表
     *
     * @param genTable
     * @return
     */
    public List<GenTable> findTableListFormDb() {
        return genDataBaseDictDao.findTableList(null);
    }

    /**
     * 验证表名是否可用，如果已存在，则返回false
     *
     * @todo 怎么都觉得别扭呢
     * @param genTable
     * @return
     */
    public boolean checkTableName(String tableName) {
        if (StringUtils.isEmpty(tableName)) {
            return true;
        }
        GenTable genTable = new GenTable();
        genTable.setName(tableName);
        List<GenTable> list = genTableDao.select(genTable);
        return list.size() == 0;
    }

    public GenTable getGenTableDefine(GenTable table) {
        GenTable iniTb = null;
        if (table.getId() == null) {
            iniTb = this.getTableFormDb(table.getName());
        } else {
            iniTb = this.findById(table.getId());
        }

        // 添加新列
        List<GenTableColumn> columnList = genDataBaseDictDao.findTableColumnList(iniTb.getName());
        for (GenTableColumn column : columnList) {
            boolean b = false;
            for (GenTableColumn e : iniTb.getColumnList()) {
                if (e.getName().equals(column.getName())) {
                    b = true;
                }
            }
            if (!b) {
                iniTb.getColumnList().add(column);
            }
        }

        // 删除已删除的列
        for (GenTableColumn e : iniTb.getColumnList()) {
            boolean b = false;
            for (GenTableColumn column : columnList) {
                if (column.getName().equals(e.getName())) {
                    b = true;
                }
            }

            /**
             * @TODO 已经在数据库中删除的字段需要从定义中清除出去
             */
            if (!b) {
                e.setIsDbFieldExists(false);
            }
        }

        // 获取主键
        iniTb.setPkList(genDataBaseDictDao.findTablePK(iniTb.getName()));

        // 初始化列属性字段
        GenUtils.initColumnField(iniTb);

        return iniTb;
    }

    /**
     * 获取物理数据表列表
     *
     * @param genTable
     * @return
     */
    public GenTable getTableFormDb(String tname) {
        GenTable genTable = new GenTable();

        // 如果有表名，则获取物理表
        List<GenTable> list = genDataBaseDictDao.findTableList(tname);
        if (list.size() > 0) {

            // 如果是新增，初始化表属性
//                if (StringUtils.isEmpty(genTable.getId())) {
            genTable = list.get(0);
            // 设置字段说明
            if (StringUtils.isEmpty(genTable.getComments())) {
                genTable.setComments(genTable.getName());
            }
            genTable.setClassName(StringUtils.toCapitalizeCamelCase(genTable.getName()));
//                }

        }
        return genTable;
    }
//

    @Transactional(readOnly = false)
    public void saveTable(GenTable genTable) {

        this.save(genTable);
        // 保存列
        for (GenTableColumn column : genTable.getColumnList()) {
            if (!column.getIsDbFieldExists()) {
                genTableColumnDao.delete(column);
            }

            column.setGenTable(genTable);
            if (column.getId() == null) {
                column.setGenTableId(genTable.getId());
                genTableColumnDao.insert(column);
            } else {
                column.setGenTableId(genTable.getId());
                genTableColumnDao.updateByPrimaryKey(column);
            }
        }
    }
//

    @Transactional(readOnly = false)
    @Override
    public int delete(GenTable genTable) {
        int r = genTableDao.delete(genTable);
        genTableColumnDao.deleteByGenTableId(genTable.getId());
        return r;
    }
}
