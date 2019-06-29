package com.github.oldtoys.world.service.impl;

import com.github.oldtoys.world.mapper.ContinentMapper;
import com.github.oldtoys.world.domain.Continent;
import com.github.oldtoys.world.service.IContinentService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 大洲 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-06-29T19:56:59.611+08:00
 */
@Service
public class ContinentServiceImpl extends BaseServiceImple<Continent, Integer> implements IContinentService {
    @Autowired
    private ContinentMapper continentMapper;

    @PostConstruct
    public void init() {
        super.init(Continent.class, continentMapper);
    }

	
    /**
     * 查询大洲列表
     * 
     * @param continent 大洲信息
     * @return 大洲集合
     */
    @Override
    public List<Continent> selectContinentList(Continent continent){
        this.pageAble();
	return continentMapper.selectContinentList(continent);
    }
}
