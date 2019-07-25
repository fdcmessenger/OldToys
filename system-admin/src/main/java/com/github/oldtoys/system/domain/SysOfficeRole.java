package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import com.gitee.fdc.kits.StringUtils;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

/**
 * 部门角色表 sys_office_role
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:53.989+08:00
 */
@Data
@Table(name = "sys_office_role")
public class SysOfficeRole extends BaseEntity<Integer> {

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
     * 角色ID
     */
    private Integer roleId;
    @Transient
    private SysOffice office;
    @Transient
    private SysRole role;

    private Boolean isDefault;//是否部门默认角色

}
