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
import com.github.oldtoys.system.domain.SysOfficeRole;
import com.github.oldtoys.system.service.ISysOfficeRoleService;

/**
 * 部门角色 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:39:53.989+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysOfficeRole")
public class SysOfficeRoleController{
    private String prefix = "system/sysOfficeRole";
	
    @Autowired
    private ISysOfficeRoleService sysOfficeRoleService;
	
    @GetMapping()
    public String sysOfficeRole(){
        return prefix + "/sysOfficeRole";
    }
	
    /**
     * 查询部门角色列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysOfficeRole sysOfficeRole){
        List<SysOfficeRole> list = sysOfficeRoleService.selectSysOfficeRoleList(sysOfficeRole);
        return new PageInfoBT(list);
    }

    /**
     * 新增部门角色
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysOfficeRole sysOfficeRole = new SysOfficeRole();
        mmap.put("sysOfficeRole", sysOfficeRole);
        return prefix + "/form";
    }
	
    /**
     * 修改部门角色
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysOfficeRole sysOfficeRole = sysOfficeRoleService.findById(id);
	mmap.put("sysOfficeRole", sysOfficeRole);
        return prefix + "/form";
    }
	
    /**
     * 修改保存部门角色
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysOfficeRole sysOfficeRole){		
        int rs = sysOfficeRoleService.save(sysOfficeRole);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除部门角色
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysOfficeRoleService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复部门角色
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysOfficeRoleService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
