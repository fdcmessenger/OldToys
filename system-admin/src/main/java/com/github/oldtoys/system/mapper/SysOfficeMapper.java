package com.github.oldtoys.system.mapper;

import com.gitee.fdc.base.dao.BaseTreeDao;
import com.github.oldtoys.system.domain.SysOffice;
import com.gitee.fdc.mapper.SbbsMapper;
import com.github.oldtoys.system.domain.SysMenu;
import java.util.List;

/**
 * 组织部门 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
public interface SysOfficeMapper extends BaseTreeDao<SysOffice, Integer> {

    /**
     * 查询组织部门列表
     *
     * @param sysOffice 组织部门信息
     * @return 组织部门集合
     */
    public List<SysOffice> selectSysOfficeList(SysOffice sysOffice);

}
