package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysRole;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;	

/**
 * 系统角色 数据层
 * 
 * @author Mr.fdc
 * @date 2019-07-24T17:43:17.326+08:00
 */
public interface SysRoleMapper extends SbbsMapper<SysRole>{
	
    /**
     * 查询系统角色列表
     * 
     * @param sysRole 系统角色信息
     * @return 系统角色集合
     */
    public List<SysRole> selectSysRoleList(SysRole sysRole);
	
	
}