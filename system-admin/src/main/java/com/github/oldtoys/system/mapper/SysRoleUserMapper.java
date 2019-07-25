package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysRoleUser;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;

/**
 * 角色用户 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
public interface SysRoleUserMapper extends SbbsMapper<SysRoleUser> {

    /**
     * 查询角色用户列表
     *
     * @param sysRoleUser 角色用户信息
     * @return 角色用户集合
     */
    public List<SysRoleUser> selectSysRoleUserList(SysRoleUser sysRoleUser);

    public SysRoleUser findRoleUserByRoleUserId(Integer roleUserId);

    public List<SysRoleUser> findRoleUserListByUserId(Integer userId);

    public List<SysRoleUser> findRoleUserListByRoleId(Integer roleId);

}
