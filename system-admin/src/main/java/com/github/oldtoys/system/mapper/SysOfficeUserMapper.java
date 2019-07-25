package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysOfficeUser;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;

/**
 * 部门用户 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:49.437+08:00
 */
public interface SysOfficeUserMapper extends SbbsMapper<SysOfficeUser> {

    /**
     * 查询部门用户列表
     *
     * @param sysOfficeUser 部门用户信息
     * @return 部门用户集合
     */
    public List<SysOfficeUser> selectSysOfficeUserList(SysOfficeUser sysOfficeUser);

    public SysOfficeUser findOfficeUserByOfficeUserId(Integer officeUserId);

    public List<SysOfficeUser> findOfficeUserListByUserId(Integer userId);

    public List<SysOfficeUser> findOfficeUserListByUserName(String userName);
}
