package com.github.oldtoys.world.service.impl;

import com.github.oldtoys.world.mapper.GeoRegionsMapper;
import com.github.oldtoys.world.domain.GeoRegions;
import com.github.oldtoys.world.service.IGeoRegionsService;
import com.gitee.fdc.base.service.BaseServiceImple;
import com.github.oldtoys.world.vo.RegionSVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 世界区域 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:22:24.307+08:00
 */
@Service
public class GeoRegionsServiceImpl extends BaseServiceImple<GeoRegions, Integer> implements IGeoRegionsService {
    @Autowired
    private GeoRegionsMapper geoRegionsMapper;

    @PostConstruct
    public void init() {
        super.init(GeoRegions.class, geoRegionsMapper);
    }

	
    /**
     * 查询世界区域列表
     * 
     * @param geoRegions 世界区域信息
     * @return 世界区域集合
     */
    @Override
    public List<GeoRegions> selectGeoRegionsList(RegionSVO region){
        this.pageAble();
	return geoRegionsMapper.selectGeoRegionsList(region);
    }
}
