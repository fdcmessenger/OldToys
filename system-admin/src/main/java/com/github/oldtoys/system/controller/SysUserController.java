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
import com.github.oldtoys.system.domain.SysUser;
import com.github.oldtoys.system.service.ISysUserService;

/**
 * 用户 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysUser")
public class SysUserController{
    private String prefix = "system/sysUser";
	
    @Autowired
    private ISysUserService sysUserService;
	
    @GetMapping()
    public String sysUser(){
        return prefix + "/sysUser";
    }
	
    /**
     * 查询用户列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysUser sysUser){
        List<SysUser> list = sysUserService.selectSysUserList(sysUser);
        return new PageInfoBT(list);
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysUser sysUser = new SysUser();
        mmap.put("sysUser", sysUser);
        return prefix + "/form";
    }
	
    /**
     * 修改用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysUser sysUser = sysUserService.findById(id);
	mmap.put("sysUser", sysUser);
        return prefix + "/form";
    }
	
    /**
     * 修改保存用户
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysUser sysUser){		
        int rs = sysUserService.save(sysUser);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除用户
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysUserService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复用户
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysUserService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
