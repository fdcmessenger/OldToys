package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysRole;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 系统角色 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-24T17:43:17.326+08:00
 */
public interface ISysRoleService extends DeleteLogicService<SysRole,Integer> 
{

    /**
     * 查询系统角色列表
     * 
     * @param sysRole 系统角色信息
     * @return 系统角色集合
     */
    public List<SysRole> selectSysRoleList(SysRole sysRole);
	
	
}
