package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysRoleMenuMapper;
import com.github.oldtoys.system.domain.SysRoleMenu;
import com.github.oldtoys.system.service.ISysRoleMenuService;
import com.gitee.fdc.base.service.BaseServiceImple;
import com.github.oldtoys.system.domain.SysMenu;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色菜单 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
@Service
public class SysRoleMenuServiceImpl extends BaseServiceImple<SysRoleMenu, Integer> implements ISysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper dao;

    @PostConstruct
    public void init() {
        super.init(SysRoleMenu.class, dao);
    }

    /**
     * 查询角色菜单列表
     *
     * @param sysRoleMenu 角色菜单信息
     * @return 角色菜单集合
     */
    @Override
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu) {
        this.pageAble();
        return dao.selectSysRoleMenuList(sysRoleMenu);
    }

    @Override
    public SysRoleMenu findRoleMenuByRoleMenuId(Integer roleMenuId) {
        return this.dao.findRoleMenuByRoleMenuId(roleMenuId);
    }

    @Override
    public List<SysRoleMenu> findRoleMenuListByRoleId(Integer roleId) {
        return this.dao.findRoleMenuListByRoleId(roleId);
    }

    @Override
    @Transactional(readOnly = false)
    public int saveRomeMenus(Integer roleId, Integer[] menuIds) {
        int d = this.dao.deleteUnusedRoleMenus(roleId, menuIds);
        int i = 0;
        if (menuIds != null && menuIds.length > 0) {
            i = this.dao.insertNewRoleMenus(roleId, menuIds);
        }
        return d + i;
    }

    @Override
    public List<SysMenu> convertRM2Menu(List<SysRoleMenu> rml) {
        Map<Integer, SysMenu> mmap = new HashMap();
        for (SysRoleMenu rm : rml) {
            mmap.put(rm.getMenuId(), rm.getMenu());
        }
        List l = Lists.newArrayList(mmap.values());
        return l;
    }

    @Override
    public List<SysRoleMenu> findRoleMenuListByRoleIds(List<Integer> roleIds) {
        return this.dao.findRoleMenuListByRoleIds(roleIds);
    }

    @Override
    public List<SysMenu> findMenuListByRoleIds(List<Integer> roleIds) {
        if (roleIds != null && roleIds.size() > 0) {
            List<SysRoleMenu> rml = this.dao.findRoleMenuListByRoleIds(roleIds);
            return this.convertRM2Menu(rml);
        } else {
            return Lists.newArrayList();
        }
    }
}
