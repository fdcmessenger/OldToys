package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysOfficeMapper;
import com.github.oldtoys.system.domain.SysOffice;
import com.github.oldtoys.system.service.ISysOfficeService;
import com.gitee.fdc.base.service.BaseTreeServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 组织部门 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
@Service
public class SysOfficeServiceImpl extends BaseTreeServiceImpl<SysOffice, Integer> implements ISysOfficeService {

    @Autowired
    private SysOfficeMapper sysOfficeMapper;

    @PostConstruct
    public void init() {
        super.init(SysOffice.class, sysOfficeMapper);
    }

    /**
     * 查询组织部门列表
     *
     * @param sysOffice 组织部门信息
     * @return 组织部门集合
     */
    @Override
    public List<SysOffice> selectSysOfficeList(SysOffice sysOffice) {
        this.pageAble();
        return sysOfficeMapper.selectSysOfficeList(sysOffice);
    }

    @Override
    public boolean isOfficeNameExist(Integer officeId, String OfficeName) {
        boolean res = this.isPropertyUnique(officeId, "name", OfficeName);
        return res;
    }
}
