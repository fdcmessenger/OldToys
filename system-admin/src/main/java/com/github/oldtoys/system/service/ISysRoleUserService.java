package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysRoleUser;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 角色用户 服务层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
public interface ISysRoleUserService extends DeleteLogicService<SysRoleUser, Integer> {

    /**
     * 查询角色用户列表
     *
     * @param sysRoleUser 角色用户信息
     * @return 角色用户集合
     */
    public List<SysRoleUser> selectSysRoleUserList(SysRoleUser sysRoleUser);

    public List<SysRoleUser> findByUserId(Integer userId);

    public List<SysRoleUser> findByRoleId(Integer roleId);

}
