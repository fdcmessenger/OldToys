package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import com.gitee.fdc.kits.StringUtils;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
/**
 * 系统角色表 sys_role
 * 
 * @author Mr.fdc
 * @date 2019-07-24T17:43:17.326+08:00
 */
@Data
@Table(name = "sys_role")
public class SysRole extends BaseEntity<Integer>{
     /**@TODO 如需要，请自行重新生成 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
	
    /** 角色名称 */
    private String name;
    /**  */
    private Integer isAdmin;
   
    /** 备注 */
    private String remarks;
    /** 是否可用 */
    private Integer useable;
    /**  这是个参考样例，以逗号分隔的字符串数据
    public String[] getMultiSelectFieldArray() {
        String[] sa = StringUtils.split(multiSelectField, ",");
        return sa == null ? new String[0] : sa;
    }
     */
}
