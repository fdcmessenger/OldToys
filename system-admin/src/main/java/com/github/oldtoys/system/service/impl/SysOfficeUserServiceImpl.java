package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysOfficeUserMapper;
import com.github.oldtoys.system.domain.SysOfficeUser;
import com.github.oldtoys.system.service.ISysOfficeUserService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 部门用户 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:39:49.437+08:00
 */
@Service
public class SysOfficeUserServiceImpl extends BaseServiceImple<SysOfficeUser, Integer> implements ISysOfficeUserService {
    @Autowired
    private SysOfficeUserMapper sysOfficeUserMapper;

    @PostConstruct
    public void init() {
        super.init(SysOfficeUser.class, sysOfficeUserMapper);
    }

	
    /**
     * 查询部门用户列表
     * 
     * @param sysOfficeUser 部门用户信息
     * @return 部门用户集合
     */
    @Override
    public List<SysOfficeUser> selectSysOfficeUserList(SysOfficeUser sysOfficeUser){
        this.pageAble();
	return sysOfficeUserMapper.selectSysOfficeUserList(sysOfficeUser);
    }
}
