package com.github.oldtoys.world.mapper;

import com.github.oldtoys.world.domain.GeoRegions;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;	

/**
 * 世界区域 数据层
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:22:24.307+08:00
 */
public interface GeoRegionsMapper extends SbbsMapper<GeoRegions>{
	
    /**
     * 查询世界区域列表
     * 
     * @param geoRegions 世界区域信息
     * @return 世界区域集合
     */
    public List<GeoRegions> selectGeoRegionsList(GeoRegions geoRegions);
	
	
}