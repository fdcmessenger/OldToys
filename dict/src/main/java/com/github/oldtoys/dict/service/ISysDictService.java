package com.github.oldtoys.dict.service;

import com.github.oldtoys.dict.domain.SysDict;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 字典 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
public interface ISysDictService extends DeleteLogicService<SysDict,Integer> 
{

    /**
     * 查询字典列表
     * 
     * @param sysDict 字典信息
     * @return 字典集合
     */
    public List<SysDict> selectSysDictList(SysDict sysDict);
	
	
}
