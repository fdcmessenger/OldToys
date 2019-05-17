/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.github.fdc.generator.entity.GenTable;
import com.github.fdc.generator.entity.GenTableColumn;

/**
 * 业务表字段DAO接口
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
public interface GenDataBaseDao  {

    /**
     * 查询表列表
     *
     * @param genTable
     * @return
     */
    List<GenTable> findTableList(@Param("tableName")String name);

//    /**
//     * 获取数据表字段
//     *
//     * @param genTable
//     * @return
//     */
    List<GenTableColumn> findTableColumnList(@Param("tableName")String genTable);
//
//    /**
//     * 获取数据表主键
//     *
//     * @param genTable
//     * @return
//     */
    List<String> findTablePK(String genTable);

}
