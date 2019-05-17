/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.fdc.generator.web;

import com.gitee.fdc.kits.StringUtils;
import com.gitee.fdc.web.ajax.ResultGenerator;
import com.gitee.fdc.web.page.PageInfoBT;
import com.gitee.fdc.web.page.PageKit;
import java.util.List;
import com.github.fdc.generator.entity.GenScheme;
import com.github.fdc.generator.service.GenSchemeService;
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
 * @author MACHENIKE
 */
@Controller
@RequestMapping(value = "/gen/genScheme")
public class GenSchemeController {

    @Autowired
    private GenSchemeService service;

    @Autowired
    private GenTableService genTableService;

    @RequestMapping(value = {"list", ""})
    public String genSchemeList() {
        return "modules/gen/genSchemeList";
    }

    @ResponseBody
    @RequestMapping(value = "listData")
    public PageInfoBT<GenScheme> listData() {
        List<GenScheme> l = this.service.findAll();
        return PageKit.packForBT(l);
    }

    @RequestMapping(value = "genSchemeForm")
    public String form(GenScheme genScheme, Model model) {
        if (genScheme.getId() != null) {
            genScheme = this.service.findById(genScheme.getId());
        }
        if (genScheme.getId() == null && StringUtils.isBlank(genScheme.getPackageName())) {
            genScheme.setPackageName("org.sbbs.urpm");
        }

        model.addAttribute("genScheme", genScheme);
        model.addAttribute("config", GenUtils.getConfig());
        model.addAttribute("tableList", genTableService.findAll());
        return "modules/gen/genSchemeForm";
    }

    @RequestMapping(value = "save")
    @ResponseBody
    public Object save(GenScheme genScheme) {
        this.service.saveScheme(genScheme);
        return ResultGenerator.genSuccessResult("业务表生成方案保存成功");
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public Object delete(@RequestParam(name = "genSchemeId") String sysId) {
        this.service.deleteById(sysId);
        return ResultGenerator.genSuccessResult("业务表生成方案删除成功");
    }
}
