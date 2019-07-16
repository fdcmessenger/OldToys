package com.github.oldtoys.dict.controller;

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
import com.github.oldtoys.dict.domain.SysDict;
import com.github.oldtoys.dict.service.ISysDictService;

/**
 * 字典 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:01.055+08:00
 */
@Slf4j
@Controller
@RequestMapping("/dict/sysDict")
public class SysDictController{
    private String prefix = "dict/sysDict";
	
    @Autowired
    private ISysDictService sysDictService;
	
    @GetMapping()
    public String sysDict(){
        return prefix + "/sysDict";
    }
	
    /**
     * 查询字典列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysDict sysDict){
        List<SysDict> list = sysDictService.selectSysDictList(sysDict);
        return new PageInfoBT(list);
    }

    /**
     * 新增字典
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        SysDict sysDict = new SysDict();
        mmap.put("sysDict", sysDict);
        return prefix + "/form";
    }
	
    /**
     * 修改字典
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysDict sysDict = sysDictService.findById(id);
	mmap.put("sysDict", sysDict);
        return prefix + "/form";
    }
	
    /**
     * 修改保存字典
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysDict sysDict){		
        int rs = sysDictService.save(sysDict);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除字典
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysDictService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复字典
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysDictService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
