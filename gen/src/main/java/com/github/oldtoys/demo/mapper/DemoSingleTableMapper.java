package com.github.oldtoys.demo.mapper;

import com.github.oldtoys.demo.domain.DemoSingleTable;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;	

/**
 * 单样例 数据层
 * 
 * @author Mr.fdc
 * @date 2019-05-20T08:56:53.535+08:00
 */
public interface DemoSingleTableMapper extends SbbsMapper<DemoSingleTable>{
	
	/**
     * 查询单样例列表
     * 
     * @param demoSingleTable 单样例信息
     * @return 单样例集合
     */
	public List<DemoSingleTable> selectDemoSingleTableList(DemoSingleTable demoSingleTable);
	
	
}