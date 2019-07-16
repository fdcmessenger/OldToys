package com.github.oldtoys.dict.mapper;

import com.github.oldtoys.dict.domain.SysDict;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;	

/**
 * 字典 数据层
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
public interface SysDictMapper extends SbbsMapper<SysDict>{
	
    /**
     * 查询字典列表
     * 
     * @param sysDict 字典信息
     * @return 字典集合
     */
    public List<SysDict> selectSysDictList(SysDict sysDict);
	
	
}