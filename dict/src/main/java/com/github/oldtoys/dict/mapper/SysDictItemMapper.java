package com.github.oldtoys.dict.mapper;

import com.github.oldtoys.dict.domain.SysDictItem;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;	

/**
 * 字典选择项 数据层
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:14.725+08:00
 */
public interface SysDictItemMapper extends SbbsMapper<SysDictItem>{
	
    /**
     * 查询字典选择项列表
     * 
     * @param sysDictItem 字典选择项信息
     * @return 字典选择项集合
     */
    public List<SysDictItem> selectSysDictItemList(SysDictItem sysDictItem);
	
	
}