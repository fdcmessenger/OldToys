/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fdc.generator.service.impl;

import com.gitee.fdc.base.service.BaseServiceImple;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import com.github.fdc.generator.dao.GenSchemeDao;
import com.github.fdc.generator.dao.GenTableDao;
import com.github.fdc.generator.entity.GenConfig;
import com.github.fdc.generator.entity.GenScheme;
import com.github.fdc.generator.entity.GenTable;
import com.github.fdc.generator.entity.GenTemplate;
import com.github.fdc.generator.service.GenSchemeService;
import com.github.fdc.generator.service.GenTableService;
import com.github.fdc.generator.util.GenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MACHENIKE
 */
@Service
@Transactional(readOnly = true)
public class GenSchemeServiceImpl extends BaseServiceImple<GenScheme,String> implements GenSchemeService {

    @Autowired
    private GenSchemeDao genSchemeDao;
    @Autowired
    private GenTableDao genTableDao;
    @Autowired
    private GenTableService genTableService;
//    @Autowired
//    private GenDataBaseDao genDataBaseDictDao;

    @PostConstruct
    public void init() {
        super.init(GenScheme.class, genSchemeDao);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveScheme(GenScheme genScheme) {
        this.save(genScheme);
        if (genScheme.getFlag()) {
            this.generateCode(genScheme);
        }
    }

    private String generateCode(GenScheme genScheme) {

        StringBuilder result = new StringBuilder();

        // 查询主表及字段列
        GenTable genTable = genTableService.findById(genScheme.getGenTableId());
//        genTable.setColumnList(genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId()))));

        // 获取所有代码模板
        GenConfig config = GenUtils.getConfig();

        // 获取模板列表
        List<GenTemplate> templateList = GenUtils.getTemplateList(config, genScheme.getCategory(), false);
        List<GenTemplate> childTableTemplateList = GenUtils.getTemplateList(config, genScheme.getCategory(), true);

        // 如果有子表模板，则需要获取子表列表
        if (childTableTemplateList.size() > 0) {
            GenTable parentTable = new GenTable();
            parentTable.setParentTable(genTable.getName());
            genTable.setChildList(genTableDao.select(parentTable));
        }

        // 生成子表模板代码
        for (GenTable childTable : genTable.getChildList()) {
//            childTable.setColumnList(genTableColumnDao.findList(new GenTableColumn(new GenTable(childTable.getId()))));
            childTable = this.genTableService.findById(childTable.getId());
            childTable.setParent(genTable);
            genScheme.setGenTable(childTable);
            Map<String, Object> childTableModel = GenUtils.getDataModel(genScheme);
            for (GenTemplate tpl : childTableTemplateList) {
                result.append(GenUtils.generateToFile(tpl, childTableModel, genScheme.getReplaceFile()));
            }
        }

        // 生成主表模板代码
        genScheme.setGenTable(genTable);
        Map<String, Object> model = GenUtils.getDataModel(genScheme);
        for (GenTemplate tpl : templateList) {
            result.append(GenUtils.generateToFile(tpl, model, genScheme.getReplaceFile()));
        }
        return result.toString();
    }
}
