/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.entity;

import com.gitee.fdc.base.entity.BaseEntity;
import com.gitee.fdc.base.entity.UUIDGenId;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import tk.mybatis.mapper.annotation.KeySql;

/**
 * 生成方案Entity
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
@Setter
@Getter
@Table(name = "gen_scheme")
public class GenScheme extends BaseEntity<String> {

    private static final long serialVersionUID = -8374685414676895011L;
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;
    private String name; // 名称
    private String category; // 分类
    private String packageName; // 生成包路径
    private String moduleName; // 生成模块名
    private String subModuleName; // 生成子模块名
    private String functionName; // 生成功能名
    private String functionNameSimple; // 生成功能名（简写）
    private String functionAuthor; // 生成功能作者
    private String genTableId; // 业务表id
    @Transient
    private GenTable genTable;
    @Transient
    private Boolean flag;

//    private String flag; // 0：保存方案； 1：保存方案并生成代码
    @Transient
    private Boolean replaceFile; // 是否替换现有文件 0：不替换；1：替换文件

}
