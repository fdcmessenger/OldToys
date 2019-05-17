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

import com.google.common.collect.Lists;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 业务表字段Entity
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
@Setter
@Getter
@Table(name = "gen_table_column")
public class GenTableColumn extends BaseEntity<String> {

    private static final long serialVersionUID = -3099855095494744018L;
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;
    @Transient
    private GenTable genTable; // 归属表
    private String genTableId;
    private String name; // 列名
    private String comments; // 描述
    private String jdbcType; // JDBC类型
    private String javaType; // JAVA类型
    private String javaField; // JAVA字段名
    private Boolean isPk; // 是否主键（1：主键）
    private Boolean isNull; // 是否可为空（1：可为空；0：不为空）
    private Boolean isInsert; // 是否为插入字段（1：插入字段）
    private Boolean isEdit; // 是否编辑字段（1：编辑字段）
    private Boolean isList; // 是否列表字段（1：列表字段）
    private Boolean isQuery; // 是否查询字段（1：查询字段）
    private String queryType; // 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
    private String showType; // 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
    private String dictType; // 字典类型
    private Integer sort; // 排序（升序）
    @Transient
    private Boolean isDbFieldExists = true;

    /**
     * 获取列名和说明
     *
     * @return
     */
    public String getNameAndComments() {
        return getName() + (comments == null ? "" : "  :  " + comments);
    }

    /**
     * 获取字符串长度
     *
     * @return
     */
    public String getDataLength() {
        String[] ss = StringUtils.split(StringUtils.substringBetween(getJdbcType(), "(", ")"), ",");
        if (ss != null && ss.length == 1) {// &&
            // "String".equals(getJavaType())){
            return ss[0];
        }
        return "0";
    }

    /**
     * 获取简写Java类型
     *
     * @return
     */
    public String getSimpleJavaType() {
        if ("This".equals(getJavaType())) {
            return StringUtils.capitalize(genTable.getClassName());
        }
        return StringUtils.indexOf(getJavaType(), ".") != -1 ? StringUtils.substringAfterLast(getJavaType(), ".")
                : getJavaType();
    }

    /**
     * 获取简写Java字段
     *
     * @return
     */
    public String getSimpleJavaField() {
        return StringUtils.substringBefore(getJavaField(), ".");
    }

    /**
     * 获取Java字段，如果是对象，则获取对象.附加属性1
     *
     * @return
     */
    public String getJavaFieldId() {
        return StringUtils.substringBefore(getJavaField(), "|");
    }

    /**
     * 获取Java字段，如果是对象，则获取对象.附加属性2
     *
     * @return
     */
    public String getJavaFieldName() {
        String[][] ss = getJavaFieldAttrs();
        return ss.length > 0 ? getSimpleJavaField() + "." + ss[0][0] : "";
    }

    /**
     * 获取Java字段，所有属性名
     *
     * @return
     */
    public String[][] getJavaFieldAttrs() {
        String[] ss = StringUtils.split(StringUtils.substringAfter(getJavaField(), "|"), "|");
        String[][] sss = new String[ss.length][2];
        if (ss != null) {
            for (int i = 0; i < ss.length; i++) {
                sss[i][0] = ss[i];
                sss[i][1] = StringUtils.toUnderScoreCase(ss[i]);
            }
        }
        return sss;
    }

    /**
     * 获取列注解列表
     *
     * @return
     */
    public List<String> getAnnotationList() {
        List<String> list = Lists.newArrayList();
        // 导入Jackson注解
        if ("This".equals(getJavaType())) {
//            list.add("com.fasterxml.jackson.annotation.JsonBackReference");
        }
        if ("java.util.Date".equals(getJavaType())) {
//            list.add("com.fasterxml.jackson.annotation.JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
            if (this.getJdbcType().toLowerCase().startsWith("timestamp")) {

                list.add("com.fasterxml.jackson.annotation.JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
                list.add("org.springframework.format.annotation.DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
            } else if (this.getJdbcType().toLowerCase().startsWith("datetime")) {

                list.add("com.fasterxml.jackson.annotation.JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
                list.add("org.springframework.format.annotation.DateTimeFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
            } else {
                list.add("com.fasterxml.jackson.annotation.JsonFormat(pattern = \"yyyy-MM-dd\")");
                list.add("org.springframework.format.annotation.DateTimeFormat(pattern = \"yyyy-MM-dd\")");
            }
        }
        // 导入JSR303验证依赖包

        if (getIsNull() != null && !getIsNull()
                && !"String".equals(getJavaType())) {
//            list.add("javax.validation.constraints.NotNull(message=\"" + getComments() + "不能为空\")");
        } else if (getIsNull() != null && !getIsNull()
                && "String".equals(getJavaType()) && !"0".equals(getDataLength())) {
//            list.add("org.hibernate.validator.constraints.Length(min=1, max=" + getDataLength() + ", message=\"" + getComments() + "长度必须介于 1 和 " + getDataLength() + " 之间\")");
        } else if ("String".equals(getJavaType()) && !"0".equals(getDataLength())) {
//            list.add("org.hibernate.validator.constraints.Length(min=0, max=" + getDataLength() + ", message=\"" + getComments() + "长度必须介于 0 和 " + getDataLength() + " 之间\")");
        }
        return list;
    }

    /**
     * 获取简写列注解列表
     *
     * @return
     */
    public List<String> getSimpleAnnotationList() {
        List<String> list = Lists.newArrayList();
        for (String ann : getAnnotationList()) {
            list.add(StringUtils.substringAfterLast(ann, "."));
        }
        return list;
    }

    /**
     * 是否是基类字段
     *
     * @return
     */
    public Boolean getIsNotBaseField() {
        return !StringUtils.equals(getSimpleJavaField(), "id") && !StringUtils.equals(getSimpleJavaField(), "remarks")
                && !StringUtils.equals(getSimpleJavaField(), "createBy")
                && !StringUtils.equals(getSimpleJavaField(), "createDate")
                && !StringUtils.equals(getSimpleJavaField(), "updateBy")
                && !StringUtils.equals(getSimpleJavaField(), "updateDate")
                && !StringUtils.equals(getSimpleJavaField(), "delFlag");
    }

}
