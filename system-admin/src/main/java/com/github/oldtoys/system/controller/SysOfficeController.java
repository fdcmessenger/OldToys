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
import com.github.oldtoys.system.domain.SysOffice;
import com.github.oldtoys.system.service.ISysOfficeService;

/**
 * 组织部门 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
@Slf4j
@Controller
@RequestMapping("/system/sysOffice")
public class SysOfficeController{
    private String prefix = "system/sysOffice";
	
    @Autowired
    private ISysOfficeService sysOfficeService;
	
    @GetMapping()
    public String sysOffice(){
        return prefix + "/sysOffice";
    }
	
    /**
     * 查询组织部门列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysOffice sysOffice){
        List<SysOffice> list = sysOfficeService.selectSysOfficeList(sysOffice);
        return new PageInfoBT(list);
    }

    /**
     * 新增组织部门
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysOffice sysOffice = new SysOffice();
        mmap.put("sysOffice", sysOffice);
        return prefix + "/form";
    }
	
    /**
     * 修改组织部门
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysOffice sysOffice = sysOfficeService.findById(id);
	mmap.put("sysOffice", sysOffice);
        return prefix + "/form";
    }
	
    /**
     * 修改保存组织部门
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysOffice sysOffice){		
        int rs = sysOfficeService.save(sysOffice);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除组织部门
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysOfficeService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复组织部门
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysOfficeService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
