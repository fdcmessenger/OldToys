package com.github.oldtoys.dict.service.impl;

import com.github.oldtoys.dict.mapper.SysDictMapper;
import com.github.oldtoys.dict.domain.SysDict;
import com.github.oldtoys.dict.service.ISysDictService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

/**
 * 字典 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
@Service
@CacheConfig(cacheNames = "dicts")
public class SysDictServiceImpl extends BaseServiceImple<SysDict, Integer> implements ISysDictService {

    @Autowired
    private SysDictMapper mapper;

    @PostConstruct
    public void init() {
        super.init(SysDict.class, mapper);
    }

    /**
     * 查询字典列表
     *
     * @param sysDict 字典信息
     * @return 字典集合
     */
    @Override
    public List<SysDict> selectSysDictList(SysDict sysDict) {
        this.pageAble();
        return mapper.selectSysDictList(sysDict);
    }

    @Override
    public boolean isDictTypeExist(Integer dictId, String dictType) {
        boolean res = this.isPropertyUnique(dictId, "type", dictType);
        return res;
    }

    @Override
    public boolean isDictNameExist(Integer dictId, String dictName) {
        boolean res = this.isPropertyUnique(dictId, "name", dictName);
        return res;
    }

    @Override
    @Cacheable(key = "'all'")
    public List findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @CacheEvict(allEntries = true)
    public int delete(SysDict entity) {
        return super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @CacheEvict(allEntries = true)
    public int deleteByIds(String ids) {
        return super.deleteByIds(ids); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @CacheEvict(allEntries = true)
    public int unDeleteById(Integer id) {
        return super.unDeleteById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @CacheEvict(allEntries = true)
    public int deleteById(Integer id) {
        return super.deleteById(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @CacheEvict(allEntries = true)
    public int save(SysDict entity) {
        return super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

}
