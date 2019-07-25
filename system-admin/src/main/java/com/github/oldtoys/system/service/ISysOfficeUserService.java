package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysOfficeUser;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 部门用户 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:39:49.437+08:00
 */
public interface ISysOfficeUserService extends DeleteLogicService<SysOfficeUser,Integer> 
{

    /**
     * 查询部门用户列表
     * 
     * @param sysOfficeUser 部门用户信息
     * @return 部门用户集合
     */
    public List<SysOfficeUser> selectSysOfficeUserList(SysOfficeUser sysOfficeUser);
	
	
}
