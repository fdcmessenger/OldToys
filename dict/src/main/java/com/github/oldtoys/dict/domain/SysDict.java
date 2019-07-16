package com.github.oldtoys.dict.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import com.gitee.fdc.kits.StringUtils;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
/**
 * 字典表 sys_dict
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
@Data
@Table(name = "sys_dict")
public class SysDict extends BaseEntity<Integer>{

    private static final long serialVersionUID = -7642505224758279849L;
     /**@TODO 如需要，请自行重新生成 */

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
	
    /** 字典项名称 */
    private String name;
    /** 字典项关键字 */
    private String type;
    /** 备注 */
    private String remarks;
    /**  这是个参考样例，以逗号分隔的字符串数据
    public String[] getMultiSelectFieldArray() {
        String[] sa = StringUtils.split(multiSelectField, ",");
        return sa == null ? new String[0] : sa;
    }
     */
}
