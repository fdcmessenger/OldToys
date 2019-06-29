package com.github.oldtoys.world.service;

import com.github.oldtoys.world.domain.Continent;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 大洲 服务层
 * 
 * @author Mr.fdc
 * @date 2019-06-29T19:56:59.611+08:00
 */
public interface IContinentService extends DeleteLogicService<Continent,Integer> 
{

    /**
     * 查询大洲列表
     * 
     * @param continent 大洲信息
     * @return 大洲集合
     */
    public List<Continent> selectContinentList(Continent continent);
	
	
}
