package com.github.oldtoys.dict.service.impl;

import com.github.oldtoys.dict.mapper.SysDictItemMapper;
import com.github.oldtoys.dict.domain.SysDictItem;
import com.github.oldtoys.dict.service.ISysDictItemService;
import com.gitee.fdc.base.service.BaseServiceImple;
import com.gitee.fdc.mapper.entity.SbbsExample;
import com.github.oldtoys.dict.domain.DictItemVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import tk.mybatis.mapper.entity.Example;

/**
 * 字典选择项 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-16T13:27:14.725+08:00
 */
@Service
@CacheConfig(cacheNames = "dictItems")
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
    public List<SysDictItem> selectSysDictItemList(SysDictItem sysDictItem) {
        this.pageAble();
        return sysDictItemMapper.selectSysDictItemList(sysDictItem);
    }

    @Override
    @Cacheable(key = "#p0")
    public List<DictItemVO> selectItemsByType(String type) {
        Example e = new SbbsExample(this.getEntityClass());
        e.createCriteria().andEqualTo("dictType", type).andEqualTo("isDisabled", 0);
        return DictItemVO.convert(this.sysDictItemMapper.selectByExample(e));
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
    public int save(SysDictItem entity) {
        return super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

}
