package com.github.oldtoys.world.controller;

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
import com.github.oldtoys.world.domain.Continent;
import com.github.oldtoys.world.service.IContinentService;

/**
 * 大洲 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-06-29T21:48:34.664+08:00
 */
@Slf4j
@Controller
@RequestMapping("/world/continent")
public class ContinentController{
    private String prefix = "world/continent";
	
    @Autowired
    private IContinentService continentService;
	
    @GetMapping()
    public String continent(){
        return prefix + "/continent";
    }
	
    /**
     * 查询大洲列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(Continent continent){
        List<Continent> list = continentService.selectContinentList(continent);
        return new PageInfoBT(list);
    }

    /**
     * 新增大洲
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        Continent continent = new Continent();
        mmap.put("continent", continent);
        return prefix + "/form";
    }
	
    /**
     * 修改大洲
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	Continent continent = continentService.findById(id);
	mmap.put("continent", continent);
        return prefix + "/form";
    }
	
    /**
     * 修改保存大洲
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(Continent continent){		
        int rs = continentService.save(continent);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除大洲
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = continentService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复大洲
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = continentService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
