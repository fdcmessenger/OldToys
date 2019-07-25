package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

/**
 * 角色用户表 sys_role_user
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
@Data
@Table(name = "sys_role_user")
public class SysRoleUser extends BaseEntity<Integer> {

    private static final long serialVersionUID = -7646627152377971032L;

    /**
     * @TODO 如需要，请自行重新生成
     */

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 用户ID
     */
    private Integer userId;
    @Transient
    private SysRole role;
    @Transient
    private SysUser user;

    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
}
