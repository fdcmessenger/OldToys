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
import com.github.oldtoys.system.domain.SysRoleMenu;
import com.github.oldtoys.system.service.ISysRoleMenuService;

/**
 * 角色菜单 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-25T08:57:07.671+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysRoleMenu")
public class SysRoleMenuController{
    private String prefix = "system/sysRoleMenu";
	
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;
	
    @GetMapping()
    public String sysRoleMenu(){
        return prefix + "/sysRoleMenu";
    }
	
    /**
     * 查询角色菜单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysRoleMenu sysRoleMenu){
        List<SysRoleMenu> list = sysRoleMenuService.selectSysRoleMenuList(sysRoleMenu);
        return new PageInfoBT(list);
    }

    /**
     * 新增角色菜单
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        mmap.put("sysRoleMenu", sysRoleMenu);
        return prefix + "/form";
    }
	
    /**
     * 修改角色菜单
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysRoleMenu sysRoleMenu = sysRoleMenuService.findById(id);
	mmap.put("sysRoleMenu", sysRoleMenu);
        return prefix + "/form";
    }
	
    /**
     * 修改保存角色菜单
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysRoleMenu sysRoleMenu){		
        int rs = sysRoleMenuService.save(sysRoleMenu);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除角色菜单
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysRoleMenuService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复角色菜单
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysRoleMenuService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
