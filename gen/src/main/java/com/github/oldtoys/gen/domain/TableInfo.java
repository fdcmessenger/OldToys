package com.github.oldtoys.gen.domain;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * ry 数据库表
 *
 * @author ruoyi
 */
@Getter
@Setter
public class TableInfo {//extends BaseEntity<String> {

    private String id;

    /**
     * 表名称
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;
    
    private Date createTime;
    private Date updateTime;
    

    /**
     * 表的主键列信息
     */
    private ColumnInfo primaryKey;

    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnInfo> columns;

    /**
     * 类名(第一个字母大写)
     */
    private String className;

    /**
     * 类名(第一个字母小写)
     */
    private String classObjName;

//    public String getClassname() {
//        return this.classname;
//    }
//
//    public void setClassname(String cn) {
//        this.classname = cn;
//    }
    public ColumnInfo getColumnsLast() {
        ColumnInfo columnInfo = null;
        if ((columns != null) && columns.size() > 0) {
            columnInfo = columns.get(0);
        }
        return columnInfo;
    }

}
