package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysOfficeRole;
import com.gitee.fdc.base.service.DeleteLogicService;
import com.github.oldtoys.system.domain.SysRole;
import java.util.List;

/**
 * 部门角色 服务层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:53.989+08:00
 */
public interface ISysOfficeRoleService extends DeleteLogicService<SysOfficeRole, Integer> {

    /**
     * 查询部门角色列表
     *
     * @param sysOfficeRole 部门角色信息
     * @return 部门角色集合
     */
    public List<SysOfficeRole> selectSysOfficeRoleList(SysOfficeRole sysOfficeRole);

    public List<SysOfficeRole> findOfficeRoleListByOfficeId(Integer officeId);

    public List<SysRole> findRoleListByOfficeId(Integer officeId);

    public List<SysRole> findRoleListByOfficeIds(List<Integer> officeIds);

    public List<SysRole> findDefaultRoleListByOfficeIds(List<Integer> officeIds);

    public int saveOfficeRoles(Integer officeId, Integer[] roleIds);

    public int deleteOfficeRoles(Integer officeId, Integer[] roleIds);

    public int updateOfficeRoleDefault(Integer[] officeRoleIds, Boolean isDefault);
}
