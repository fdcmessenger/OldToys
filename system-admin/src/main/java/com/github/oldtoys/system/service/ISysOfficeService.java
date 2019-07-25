package com.github.oldtoys.system.service;

import com.github.oldtoys.system.domain.SysOffice;
import com.gitee.fdc.base.service.BaseTreeService;
import java.util.List;

/**
 * 组织部门 服务层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
public interface ISysOfficeService extends BaseTreeService<SysOffice, Integer> {

    /**
     * 查询组织部门列表
     *
     * @param sysOffice 组织部门信息
     * @return 组织部门集合
     */
    public List<SysOffice> selectSysOfficeList(SysOffice sysOffice);

    public boolean isOfficeNameExist(Integer officeId, String OfficeName);
}
