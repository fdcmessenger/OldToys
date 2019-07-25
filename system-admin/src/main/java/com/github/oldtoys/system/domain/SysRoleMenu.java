package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

/**
 * 角色菜单表 sys_role_menu
 *
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
@Data
@Table(name = "sys_role_menu")
public class SysRoleMenu extends BaseEntity<Integer> {

    private static final long serialVersionUID = -3082508284672290081L;

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
     * 菜单ID
     */
    private Integer menuId;

    @Transient
    private SysRole role;
    @Transient
    private SysMenu menu;

    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
}
