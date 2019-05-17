/**
 * Copyright &copy; 2012-2016
 * <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights
 * reserved.
 */
package com.github.fdc.generator.entity;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

/**
 * 字典Entity
 *
 * @author ThinkGem
 * @version 2013-05-15
 */
@Setter
@Getter
public class Dict extends BaseEntity<String> {

    private String id;
    private String value; // 数据值
    private String label; // 标签名
    private String type; // 类型
    private String description;// 描述
    private Integer sort; // 排序
    private String parentId;// 父Id

}
