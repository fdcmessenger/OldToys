package com.github.oldtoys.demo.controller;

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
import com.github.oldtoys.demo.domain.DemoSingleTable;
import com.github.oldtoys.demo.service.IDemoSingleTableService;

/**
 * 单样例 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-06-28T09:25:20.581+08:00
 */
@Slf4j
@Controller
@RequestMapping("/demo/demoSingleTable")
public class DemoSingleTableController{
    private final String prefix = "demo/demoSingleTable";
	
    @Autowired
    private IDemoSingleTableService service;
	
    @GetMapping()
    public String demoSingleTable(){
        return prefix + "/demoSingleTable";
    }
	
    /**
     * 查询单样例列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(DemoSingleTable demoSingleTable){
        List<DemoSingleTable> list = service.selectDemoSingleTableList(demoSingleTable);
        return new PageInfoBT(list);
    }

    /**
     * 新增单样例
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        DemoSingleTable demoSingleTable = new DemoSingleTable();
        mmap.put("demoSingleTable", demoSingleTable);
        return prefix + "/form";
    }
	
    /**
     * 修改单样例
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap){
	DemoSingleTable demoSingleTable = service.findById(id);
	mmap.put("demoSingleTable", demoSingleTable);
        return prefix + "/form";
    }
	
    /**
     * 修改保存单样例
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(DemoSingleTable demoSingleTable){		
        int rs = service.save(demoSingleTable);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除单样例
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = service.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复单样例
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Long id) {        
      int rs = service.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
