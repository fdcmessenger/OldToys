package com.github.oldtoys.demo.service.impl;

import com.github.oldtoys.demo.mapper.DemoSingleTableMapper;
import com.github.oldtoys.demo.domain.DemoSingleTable;
import com.github.oldtoys.demo.service.IDemoSingleTableService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 单样例 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-05-20T08:56:53.535+08:00
 */
@Service
public class DemoSingleTableServiceImpl extends BaseServiceImple<DemoSingleTable, String> implements IDemoSingleTableService 
{
	@Autowired
	private DemoSingleTableMapper demoSingleTableMapper;

    @PostConstruct
    public void init() {
        super.init(DemoSingleTable.class, demoSingleTableMapper);
    }

	
	/**
     * 查询单样例列表
     * 
     * @param demoSingleTable 单样例信息
     * @return 单样例集合
     */
	@Override
	public List<DemoSingleTable> selectDemoSingleTableList(DemoSingleTable demoSingleTable)
	{
	    return demoSingleTableMapper.selectDemoSingleTableList(demoSingleTable);
	}
	
}
