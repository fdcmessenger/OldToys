package com.github.oldtoys.dict.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * 字典选择项表 sys_dict_item
 *
 * @author Mr.fdc
 * @date 2019-07-16T13:27:14.725+08:00
 */
@Data
@Table(name = "sys_dict_item")
public class SysDictItem extends BaseEntity<Integer> {

    private static final long serialVersionUID = -3703979660550033510L;

    /**
     * @TODO 如需要，请自行重新生成
     */

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 选项值
     */
    private String value;
    /**
     * 选项标签
     */
    private String label;
    /**
     * 字典项ID
     */
    private Integer dictId;
    /**
     * 字典项关键字
     */
    private String dictType;
    /**
     * 是否已经被废弃
     */
    private Integer isDisabled;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 排序值
     */
    private Integer sortNum;
    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
}
