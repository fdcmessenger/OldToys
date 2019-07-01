package com.github.oldtoys.world.service;

import com.github.oldtoys.world.domain.GeoType;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import java.util.List;

/**
 * 区域类型 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:02:50.208+08:00
 */
public interface IGeoTypeService extends DeleteLogicService<GeoType,Integer> 
{

    /**
     * 查询区域类型列表
     * 
     * @param geoType 区域类型信息
     * @return 区域类型集合
     */
    public List<GeoType> selectGeoTypeList(GeoType geoType);
	
	
}
