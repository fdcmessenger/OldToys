package com.github.oldtoys.system.mapper;

import com.gitee.fdc.base.dao.BaseTreeDao;
import com.github.oldtoys.system.domain.SysMenu;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;

/**
 * 系统菜单 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
public interface SysMenuMapper extends BaseTreeDao<SysMenu, Integer> {

    /**
     * 查询系统菜单列表
     *
     * @param sysMenu 系统菜单信息
     * @return 系统菜单集合
     */
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    public List<SysMenu> findAllParents();

}
