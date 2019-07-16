package com.github.oldtoys.dict.service.impl;

import com.github.oldtoys.dict.mapper.SysDictItemMapper;
import com.github.oldtoys.dict.domain.SysDictItem;
import com.github.oldtoys.dict.service.ISysDictItemService;
import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
 * 字典选择项 服务层实现
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:14.725+08:00
 */
@Service
public class SysDictItemServiceImpl extends BaseServiceImple<SysDictItem, Integer> implements ISysDictItemService {
    @Autowired
    private SysDictItemMapper sysDictItemMapper;

    @PostConstruct
    public void init() {
        super.init(SysDictItem.class, sysDictItemMapper);
    }

	
    /**
     * 查询字典选择项列表
     * 
     * @param sysDictItem 字典选择项信息
     * @return 字典选择项集合
     */
    @Override
    public List<SysDictItem> selectSysDictItemList(SysDictItem sysDictItem){
        this.pageAble();
	return sysDictItemMapper.selectSysDictItemList(sysDictItem);
    }
}
