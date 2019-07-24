package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysMenu;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 系统菜单 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
public interface ISysMenuService extends DeleteLogicService<SysMenu,Integer> 
{

    /**
     * 查询系统菜单列表
     * 
     * @param sysMenu 系统菜单信息
     * @return 系统菜单集合
     */
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu);
	
	
}
