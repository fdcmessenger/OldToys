/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.entity;

import com.gitee.fdc.base.entity.BaseEntity;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

/**
 * 生成方案Entity
 *
 * @author ThinkGem
 * @version 2013-10-15
 */
@Setter
@Getter
@XmlRootElement(name = "template")
public class GenTemplate extends BaseEntity<String> {

    private String id;
    private String name; // 名称
    private String category; // 分类
    private String filePath; // 生成文件路径
    private String fileName; // 文件名
    private String content; // 内容

    @XmlTransient
    public List<String> getCategoryList() {
        if (category == null) {
            return Lists.newArrayList();
        } else {
            return Lists.newArrayList(StringUtils.split(category, ","));
        }
    }

    public void setCategoryList(List<String> categoryList) {
        if (categoryList == null) {
            this.category = "";
        } else {
            this.category = "," + StringUtils.join(categoryList, ",") + ",";
        }
    }

}
