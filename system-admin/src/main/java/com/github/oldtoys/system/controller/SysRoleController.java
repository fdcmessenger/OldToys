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
import com.github.oldtoys.system.domain.SysRole;
import com.github.oldtoys.system.service.ISysRoleService;

/**
 * 系统角色 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-24T17:43:17.326+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysRole")
public class SysRoleController{
    private String prefix = "system/sysRole";
	
    @Autowired
    private ISysRoleService sysRoleService;
	
    @GetMapping()
    public String sysRole(){
        return prefix + "/sysRole";
    }
	
    /**
     * 查询系统角色列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysRole sysRole){
        List<SysRole> list = sysRoleService.selectSysRoleList(sysRole);
        return new PageInfoBT(list);
    }

    /**
     * 新增系统角色
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysRole sysRole = new SysRole();
        mmap.put("sysRole", sysRole);
        return prefix + "/form";
    }
	
    /**
     * 修改系统角色
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysRole sysRole = sysRoleService.findById(id);
	mmap.put("sysRole", sysRole);
        return prefix + "/form";
    }
	
    /**
     * 修改保存系统角色
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysRole sysRole){		
        int rs = sysRoleService.save(sysRole);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除系统角色
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysRoleService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复系统角色
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysRoleService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
