package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysRoleUserMapper;
import com.github.oldtoys.system.domain.SysRoleUser;
import com.github.oldtoys.system.service.ISysRoleUserService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 角色用户 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
@Service
public class SysRoleUserServiceImpl extends BaseServiceImple<SysRoleUser, Integer> implements ISysRoleUserService {

    @Autowired
    private SysRoleUserMapper dao;

    @PostConstruct
    public void init() {
        super.init(SysRoleUser.class, dao);
    }

    /**
     * 查询角色用户列表
     *
     * @param sysRoleUser 角色用户信息
     * @return 角色用户集合
     */
    @Override
    public List<SysRoleUser> selectSysRoleUserList(SysRoleUser sysRoleUser) {
        this.pageAble();
        return dao.selectSysRoleUserList(sysRoleUser);
    }

    @Override
    public List<SysRoleUser> findByUserId(Integer userId) {

        return this.dao.findRoleUserListByUserId(userId);
    }

    @Override
    public List<SysRoleUser> findByRoleId(Integer roleId) {
        return this.dao.findRoleUserListByRoleId(roleId);
    }
}
