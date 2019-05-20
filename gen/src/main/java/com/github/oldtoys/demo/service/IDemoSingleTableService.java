package com.github.oldtoys.demo.service;

import com.github.oldtoys.demo.domain.DemoSingleTable;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 单样例 服务层
 *
 * @author Mr.fdc
 * @date 2019-05-20T08:56:53.535+08:00
 */
public interface IDemoSingleTableService extends DeleteLogicService<DemoSingleTable, String> {

    /**
     * 查询单样例列表
     *
     * @param demoSingleTable 单样例信息
     * @return 单样例集合
     */
    public List<DemoSingleTable> selectDemoSingleTableList(DemoSingleTable demoSingleTable);

}
