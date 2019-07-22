package com.github.oldtoys.dict.service.impl;

import com.github.oldtoys.dict.mapper.SysDictMapper;
import com.github.oldtoys.dict.domain.SysDict;
import com.github.oldtoys.dict.service.ISysDictService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 字典 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
@Service
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
}
