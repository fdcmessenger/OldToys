package com.github.oldtoys.world.service.impl;

import com.github.oldtoys.world.mapper.GeoTypeMapper;
import com.github.oldtoys.world.domain.GeoType;
import com.github.oldtoys.world.service.IGeoTypeService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 区域类型 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:02:50.208+08:00
 */
@Service
public class GeoTypeServiceImpl extends BaseServiceImple<GeoType, Integer> implements IGeoTypeService {
    @Autowired
    private GeoTypeMapper geoTypeMapper;

    @PostConstruct
    public void init() {
        super.init(GeoType.class, geoTypeMapper);
    }

	
    /**
     * 查询区域类型列表
     * 
     * @param geoType 区域类型信息
     * @return 区域类型集合
     */
    @Override
    public List<GeoType> selectGeoTypeList(GeoType geoType){
        this.pageAble();
	return geoTypeMapper.selectGeoTypeList(geoType);
    }
}
