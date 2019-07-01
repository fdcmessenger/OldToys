package com.github.oldtoys.world.mapper;

import com.github.oldtoys.world.domain.GeoType;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;	

/**
 * 区域类型 数据层
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:02:50.208+08:00
 */
public interface GeoTypeMapper extends SbbsMapper<GeoType>{
	
    /**
     * 查询区域类型列表
     * 
     * @param geoType 区域类型信息
     * @return 区域类型集合
     */
    public List<GeoType> selectGeoTypeList(GeoType geoType);
	
	
}