package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysRoleMenu;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 角色菜单 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
public interface SysRoleMenuMapper extends SbbsMapper<SysRoleMenu> {

    /**
     * 查询角色菜单列表
     *
     * @param sysRoleMenu 角色菜单信息
     * @return 角色菜单集合
     */
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);

    public SysRoleMenu findRoleMenuByRoleMenuId(Integer roleMenuId);

    public List<SysRoleMenu> findRoleMenuListByRoleId(Integer roleId);

    public List<SysRoleMenu> findRoleMenuListByRoleIds(@Param("roleIds") List<Integer> roleIds);

    public int deleteUnusedRoleMenus(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

    public int insertNewRoleMenus(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

}
