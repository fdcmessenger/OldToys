package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysOfficeRoleMapper;
import com.github.oldtoys.system.domain.SysOfficeRole;
import com.github.oldtoys.system.service.ISysOfficeRoleService;
import com.gitee.fdc.base.service.BaseServiceImple;
import com.gitee.fdc.mapper.entity.SbbsExample;
import com.github.oldtoys.system.domain.SysRole;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * 部门角色 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:53.989+08:00
 */
@Service
public class SysOfficeRoleServiceImpl extends BaseServiceImple<SysOfficeRole, Integer> implements ISysOfficeRoleService {

    @Autowired
    private SysOfficeRoleMapper dao;

    @PostConstruct
    public void init() {
        super.init(SysOfficeRole.class, dao);
    }

    /**
     * 查询部门角色列表
     *
     * @param sysOfficeRole 部门角色信息
     * @return 部门角色集合
     */
    @Override
    public List<SysOfficeRole> selectSysOfficeRoleList(SysOfficeRole sysOfficeRole) {
        this.pageAble();
        return dao.selectSysOfficeRoleList(sysOfficeRole);
    }

    @Override
    public List<SysOfficeRole> findOfficeRoleListByOfficeId(Integer officeId) {
        return this.dao.findOfficeRoleListByOfficeId(officeId);
    }

    @Override
    public List<SysRole> findRoleListByOfficeId(Integer officeId) {
        List<SysOfficeRole> orl = this.findOfficeRoleListByOfficeId(officeId);
        List<SysRole> l = new ArrayList();
        for (SysOfficeRole or : orl) {
            l.add(or.getRole());
        }
        return l;
    }

    @Override
    @Transactional(readOnly = false)
    public int saveOfficeRoles(Integer officeId, Integer[] roleIds) {

        int d = this.dao.deleteUnusedOfficeRoles(officeId, roleIds);
        int i = 0;
        if (roleIds != null && roleIds.length > 0) {
            i = this.dao.insertNewOfficeRoles(officeId, roleIds);
        }
        return d + i;
    }

    @Override
    public List<SysRole> findRoleListByOfficeIds(List<Integer> officeIds) {
        List<SysOfficeRole> orl = this.dao.findOfficeRoleListByOfficeIds(officeIds);
        Map<Integer, SysRole> rm = new HashMap();
        for (SysOfficeRole or : orl) {
            rm.put(or.getRoleId(), or.getRole());
        }
        return Lists.newArrayList(rm.values());
    }

    @Override
    public List<SysRole> findDefaultRoleListByOfficeIds(List<Integer> officeIds) {
        List<SysOfficeRole> orl = this.dao.findOfficeRoleListByOfficeIds(officeIds);
        Map<Integer, SysRole> rm = new HashMap();
        for (SysOfficeRole or : orl) {
            if (or.getIsDefault()) {
                rm.put(or.getRoleId(), or.getRole());
            }
        }
        return Lists.newArrayList(rm.values());
    }

    @Override
    @Transactional(readOnly = false)
    public int deleteOfficeRoles(Integer officeId, Integer[] roleIds) {
        Example e = new SbbsExample(SysOfficeRole.class);
        e.createCriteria().andEqualTo("officeId", officeId).andIn("roleId", Arrays.asList(roleIds));
        return this.dao.deleteByExample(e);
    }

    @Override
    @Transactional(readOnly = false)
    public int updateOfficeRoleDefault(Integer[] officeRoleIds, Boolean isDefault) {
        Example e = new SbbsExample(SysOfficeRole.class);
        e.createCriteria().andIn("id", Arrays.asList(officeRoleIds));
        SysOfficeRole bean = new SysOfficeRole();
        bean.setIsDefault(isDefault);
        return this.dao.updateByExampleSelective(bean, e);
    }
}
