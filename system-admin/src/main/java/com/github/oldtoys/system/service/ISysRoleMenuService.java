package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysRoleMenu;
import com.gitee.fdc.base.service.DeleteLogicService;
import com.github.oldtoys.system.domain.SysMenu;
import java.util.List;
import java.util.Map;

/**
 * 角色菜单 服务层
 *
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
public interface ISysRoleMenuService extends DeleteLogicService<SysRoleMenu, Integer> {

    /**
     * 查询角色菜单列表
     *
     * @param sysRoleMenu 角色菜单信息
     * @return 角色菜单集合
     */
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);

    public SysRoleMenu findRoleMenuByRoleMenuId(Integer roleMenuId);

    public List<SysRoleMenu> findRoleMenuListByRoleId(Integer roleId);

    public int saveRomeMenus(Integer roleId, Integer[] menuIds);

    public List<SysMenu> convertRM2Menu(List<SysRoleMenu> rml);

    public List<SysRoleMenu> findRoleMenuListByRoleIds(List<Integer> roleIds);

    public List<SysMenu> findMenuListByRoleIds(List<Integer> roleIds);
}
