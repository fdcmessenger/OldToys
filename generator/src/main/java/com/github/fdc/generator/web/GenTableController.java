/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fdc.generator.web;

import com.gitee.fdc.web.ajax.ResultGenerator;
import com.gitee.fdc.web.page.PageInfoBT;
import com.gitee.fdc.web.page.PageKit;
import java.util.List;
import com.github.fdc.generator.entity.GenTable;
import com.github.fdc.generator.service.GenTableService;
import com.github.fdc.generator.util.GenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author qskj
 */
@Controller
@RequestMapping(value = "/gen/genTable")
public class GenTableController {

    @Autowired
    private GenTableService service;

    @RequestMapping(value = {"list", ""})
    public String genTableList() {
        return "gen/genTableList";
    }

    @ResponseBody
    @RequestMapping(value = "listData")
    public PageInfoBT<GenTable> listData() {
        List<GenTable> l = this.service.findAll();
        return PageKit.packForBT(l);
    }

    @RequestMapping(value = {"selectDbTable"})
    public String selectDbTable(GenTable genTable, Model model) {
        List<GenTable> tableList = this.service.findTableListFormDb();
        model.addAttribute("tableList", tableList);
        model.addAttribute("genTable", genTable);
        return "gen/selectDbTable";
    }

    @RequestMapping(value = "tableNameCheck")
    @ResponseBody
    public Object tableNameCheck(@RequestParam(value = "tableName") String tableName) {
        return this.service.checkTableName(tableName);
    }

    @RequestMapping(value = "genTableForm")
    public String form(GenTable genTable, Model model) {
// 获取物理表列表
        List<GenTable> tableList = service.findTableListFormDb();
        model.addAttribute("tableList", tableList);
        if (genTable.getId() == null) {
            genTable = service.getTableFormDb(genTable.getName());
        } else {
            genTable = service.findById(genTable.getId());
        }
        genTable = this.service.getGenTableDefine(genTable);
        model.addAttribute("genTable", genTable);
        model.addAttribute("config", GenUtils.getConfig());
        return "gen/genTableForm";
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public Object save(GenTable genTable) {
        this.service.saveTable(genTable);
        return ResultGenerator.genSuccessResult("业务表配置保存成功");
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public Object delete(@RequestParam(name = "genTableId") String sysId) {
        this.service.deleteById(sysId);
        return ResultGenerator.genSuccessResult("业务表配置信息删除成功");
    }
}
