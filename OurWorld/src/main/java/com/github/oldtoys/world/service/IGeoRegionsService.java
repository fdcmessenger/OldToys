package com.github.oldtoys.world.service;

import com.github.oldtoys.world.domain.GeoRegions;
import com.gitee.fdc.base.service.BaseService;
import com.gitee.fdc.base.service.DeleteLogicService;
import com.github.oldtoys.world.vo.RegionSVO;
import java.util.List;

/**
 * 世界区域 服务层
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:22:24.307+08:00
 */
public interface IGeoRegionsService extends DeleteLogicService<GeoRegions,Integer> 
{

    /**
     * 查询世界区域列表
     * 
     * @param geoRegions 世界区域信息
     * @return 世界区域集合
     */
    public List<GeoRegions> selectGeoRegionsList(RegionSVO region);
	
	
}
