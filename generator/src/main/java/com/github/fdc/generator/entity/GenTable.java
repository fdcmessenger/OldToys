/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.entity;

import com.gitee.fdc.base.entity.BaseEntity;
import com.gitee.fdc.base.entity.UUIDGenId;
import com.gitee.fdc.kits.StringUtils;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 业务表Entity
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
@Setter
@Getter
@Table(name = "gen_table")
public class GenTable extends BaseEntity<String> {

    private static final long serialVersionUID = 9009789595757181719L;
     @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;
    private String name; // 名称
    private String comments; // 描述
    private String className; // 实体类名称
    private String parentTable; // 关联父表
    private String parentTableFk; // 关联父表外键
    private String remarks;
    private List<GenTableColumn> columnList = Lists.newArrayList(); // 表列

//    private String nameLike; // 按名称模糊查询
    private List<String> pkList; // 当前表主键列表

    private GenTable parent; // 父表对象
    private List<GenTable> childList = Lists.newArrayList(); // 子表列表

    @Length(min = 1, max = 200)
    public String getName() {
        return StringUtils.lowerCase(name);
    }

    /**
     * 获取列名和说明
     *
     * @return
     */
    public String getNameAndComments() {
        return getName() + (comments == null ? " : " + getName() : "  :  " + comments);
    }

    /**
     * 获取导入依赖包字符串
     *
     * @return
     */
    public List<String> getImportList() {
        List<String> importList = Lists.newArrayList(); // 引用列表
        for (GenTableColumn column : getColumnList()) {
            if (column.getIsNotBaseField()
                    || ("1".equals(column.getIsQuery()) && "between".equals(column.getQueryType()) && ("createDate"
                    .equals(column.getSimpleJavaField()) || "updateDate".equals(column.getSimpleJavaField())))) {
                // 导入类型依赖包， 如果类型中包含“.”，则需要导入引用。
                if (StringUtils.indexOf(column.getJavaType(), ".") != -1 && !importList.contains(column.getJavaType())) {
                    importList.add(column.getJavaType());
                }
            }
            if (column.getIsNotBaseField()) {
                // 导入JSR303、Json等依赖包
                for (String ann : column.getAnnotationList()) {
                    if (!importList.contains(StringUtils.substringBeforeLast(ann, "("))) {
                        importList.add(StringUtils.substringBeforeLast(ann, "("));
                    }
                }
            }
        }
        // 如果有子表，则需要导入List相关引用
        if (getChildList() != null && getChildList().size() > 0) {
            if (!importList.contains("java.util.List")) {
                importList.add("java.util.List");
            }
            if (!importList.contains("com.google.common.collect.Lists")) {
                importList.add("com.google.common.collect.Lists");
            }
        }
        return importList;
    }

    /**
     * 是否存在父类
     *
     * @return
     */
    public Boolean getParentExists() {
        return parent != null && StringUtils.isNotBlank(parentTable) && StringUtils.isNotBlank(parentTableFk);
    }

    /**
     * 是否存在create_date列
     *
     * @return
     */
    public Boolean getCreateDateExists() {
        for (GenTableColumn c : columnList) {
            if ("create_date".equals(c.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否存在update_date列
     *
     * @return
     */
    public Boolean getUpdateDateExists() {
        for (GenTableColumn c : columnList) {
            if ("update_date".equals(c.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否存在del_flag列
     *
     * @return
     */
    public Boolean getDelFlagExists() {
        for (GenTableColumn c : columnList) {
            if ("del_flag".equals(c.getName())) {
                return true;
            }
        }
        return false;
    }
}
