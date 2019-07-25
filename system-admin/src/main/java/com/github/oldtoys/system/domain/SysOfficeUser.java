package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

/**
 * 部门用户表 sys_office_user
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:49.437+08:00
 */
@Data
@Table(name = "sys_office_user")
public class SysOfficeUser extends BaseEntity<Integer> {

    /**
     * @TODO 如需要，请自行重新生成
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 部门ID
     */
    private Integer officeId;
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 是否继承部门角色
     */
    private Integer inheritRole;

    @Transient
    private SysOffice office;
    @Transient
    private SysUser user;

    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
}
