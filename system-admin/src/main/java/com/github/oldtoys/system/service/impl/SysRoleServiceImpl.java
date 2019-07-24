package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysRoleMapper;
import com.github.oldtoys.system.domain.SysRole;
import com.github.oldtoys.system.service.ISysRoleService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 系统角色 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-07-24T17:43:17.326+08:00
 */
@Service
public class SysRoleServiceImpl extends BaseServiceImple<SysRole, Integer> implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @PostConstruct
    public void init() {
        super.init(SysRole.class, sysRoleMapper);
    }

	
    /**
     * 查询系统角色列表
     * 
     * @param sysRole 系统角色信息
     * @return 系统角色集合
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole){
        this.pageAble();
	return sysRoleMapper.selectSysRoleList(sysRole);
    }
}
