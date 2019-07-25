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
import com.github.oldtoys.system.domain.SysRoleUser;
import com.github.oldtoys.system.service.ISysRoleUserService;

/**
 * 角色用户 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:39:41.472+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysRoleUser")
public class SysRoleUserController{
    private String prefix = "system/sysRoleUser";
	
    @Autowired
    private ISysRoleUserService sysRoleUserService;
	
    @GetMapping()
    public String sysRoleUser(){
        return prefix + "/sysRoleUser";
    }
	
    /**
     * 查询角色用户列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysRoleUser sysRoleUser){
        List<SysRoleUser> list = sysRoleUserService.selectSysRoleUserList(sysRoleUser);
        return new PageInfoBT(list);
    }

    /**
     * 新增角色用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysRoleUser sysRoleUser = new SysRoleUser();
        mmap.put("sysRoleUser", sysRoleUser);
        return prefix + "/form";
    }
	
    /**
     * 修改角色用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysRoleUser sysRoleUser = sysRoleUserService.findById(id);
	mmap.put("sysRoleUser", sysRoleUser);
        return prefix + "/form";
    }
	
    /**
     * 修改保存角色用户
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysRoleUser sysRoleUser){		
        int rs = sysRoleUserService.save(sysRoleUser);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除角色用户
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysRoleUserService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复角色用户
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysRoleUserService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
