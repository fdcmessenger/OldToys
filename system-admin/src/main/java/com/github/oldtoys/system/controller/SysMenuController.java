package com.github.oldtoys.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gitee.fdc.web.ajax.Result;
import com.gitee.fdc.web.ajax.ResultGenerator;
import com.gitee.fdc.web.page.PageInfoBT;
import lombok.extern.slf4j.Slf4j;
import com.github.oldtoys.system.domain.SysMenu;
import com.github.oldtoys.system.service.ISysMenuService;

/**
 * 系统菜单 信息操作处理
 *
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysMenu")
public class SysMenuController {

    private String prefix = "system/sysMenu";

    @Autowired
    private ISysMenuService sysMenuService;

    @GetMapping()
    public String sysMenu() {
        return prefix + "/sysMenu";
    }

    /**
     * 查询系统菜单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysMenu sysMenu) {
        List<SysMenu> list = sysMenuService.selectSysMenuList(sysMenu);
        return new PageInfoBT(list);
    }

    /**
     * 新增系统菜单
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SysMenu sysMenu = new SysMenu();
        mmap.put("sysMenu", sysMenu);
        return prefix + "/form";
    }

    /**
     * 修改系统菜单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        SysMenu sysMenu = sysMenuService.findById(id);
        mmap.put("sysMenu", sysMenu);
        return prefix + "/form";
    }

    /**
     * 修改保存系统菜单
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysMenu sysMenu) {
        int rs = sysMenuService.save(sysMenu);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }

    /**
     * 删除系统菜单
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids) {
        int rs = sysMenuService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }

    /**
     * 恢复系统菜单
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {
        int rs = sysMenuService.unDeleteById(id);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }

    @PostMapping("/enable")
    @ResponseBody
    public Result enable(@RequestParam Integer menuId) {
        SysMenu m = new SysMenu();
        m.setId(menuId);
        m.setUseable(true);
        int rs = sysMenuService.updateByPrimaryKeySelective(m);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("启用失败");
    }

    @PostMapping("/disable")
    @ResponseBody
    public Result disable(@RequestParam Integer menuId) {
        SysMenu m = new SysMenu();
        m.setId(menuId);
        m.setUseable(false);
        int rs = sysMenuService.updateByPrimaryKeySelective(m);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("停用失败");
    }
    @PostMapping("/show")
    @ResponseBody
    public Result show(@RequestParam Integer menuId) {
        SysMenu m = new SysMenu();
        m.setId(menuId);
        m.setIsShow(true);
        int rs = sysMenuService.updateByPrimaryKeySelective(m);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("设置显示失败");
    }

    @PostMapping("/hide")
    @ResponseBody
    public Result hide(@RequestParam Integer menuId) {
        SysMenu m = new SysMenu();
        m.setId(menuId);
        m.setIsShow(false);
        int rs = sysMenuService.updateByPrimaryKeySelective(m);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("设置隐藏失败");
    }
}
