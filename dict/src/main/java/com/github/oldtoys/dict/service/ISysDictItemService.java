package com.github.oldtoys.dict.service;

import com.github.oldtoys.dict.domain.SysDictItem;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 字典选择项 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:14.725+08:00
 */
public interface ISysDictItemService extends DeleteLogicService<SysDictItem,Integer> 
{

    /**
     * 查询字典选择项列表
     * 
     * @param sysDictItem 字典选择项信息
     * @return 字典选择项集合
     */
    public List<SysDictItem> selectSysDictItemList(SysDictItem sysDictItem);
	
	
}
