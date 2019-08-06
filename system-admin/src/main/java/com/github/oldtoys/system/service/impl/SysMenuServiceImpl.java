package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysMenuMapper;
import com.github.oldtoys.system.domain.SysMenu;
import com.github.oldtoys.system.service.ISysMenuService;
import com.gitee.fdc.base.service.BaseServiceImple;
import com.gitee.fdc.base.service.BaseTreeServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 系统菜单 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
@Service
public class SysMenuServiceImpl extends BaseTreeServiceImpl<SysMenu, Integer> implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @PostConstruct
    public void init() {
        super.init(SysMenu.class, sysMenuMapper);
    }

    /**
     * 查询系统菜单列表
     *
     * @param sysMenu 系统菜单信息
     * @return 系统菜单集合
     */
    @Override
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu) {
        this.pageAble();
        return sysMenuMapper.selectSysMenuList(sysMenu);
    }

    @Override
    public boolean checkMeunLevelOk(SysMenu menu) {
        SysMenu p = this.findById(menu.getPid());
        if (p.getPid() == null || p.getPid() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<SysMenu> findAllParents() {
       return  sysMenuMapper.findAllParents();
    }
}
