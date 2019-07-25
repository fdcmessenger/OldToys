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
import com.github.oldtoys.system.domain.SysOfficeUser;
import com.github.oldtoys.system.service.ISysOfficeUserService;

/**
 * 部门用户 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:39:49.437+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysOfficeUser")
public class SysOfficeUserController{
    private String prefix = "system/sysOfficeUser";
	
    @Autowired
    private ISysOfficeUserService sysOfficeUserService;
	
    @GetMapping()
    public String sysOfficeUser(){
        return prefix + "/sysOfficeUser";
    }
	
    /**
     * 查询部门用户列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysOfficeUser sysOfficeUser){
        List<SysOfficeUser> list = sysOfficeUserService.selectSysOfficeUserList(sysOfficeUser);
        return new PageInfoBT(list);
    }

    /**
     * 新增部门用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysOfficeUser sysOfficeUser = new SysOfficeUser();
        mmap.put("sysOfficeUser", sysOfficeUser);
        return prefix + "/form";
    }
	
    /**
     * 修改部门用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysOfficeUser sysOfficeUser = sysOfficeUserService.findById(id);
	mmap.put("sysOfficeUser", sysOfficeUser);
        return prefix + "/form";
    }
	
    /**
     * 修改保存部门用户
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysOfficeUser sysOfficeUser){		
        int rs = sysOfficeUserService.save(sysOfficeUser);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除部门用户
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysOfficeUserService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复部门用户
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysOfficeUserService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
