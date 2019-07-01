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
import com.github.oldtoys.world.domain.GeoRegions;
import com.github.oldtoys.world.service.IGeoRegionsService;

/**
 * 世界区域 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:22:24.307+08:00
 */
@Slf4j
@Controller
@RequestMapping("/world/geoRegions")
public class GeoRegionsController{
    private String prefix = "world/geoRegions";
	
    @Autowired
    private IGeoRegionsService geoRegionsService;
	
    @GetMapping()
    public String geoRegions(){
        return prefix + "/geoRegions";
    }
	
    /**
     * 查询世界区域列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(GeoRegions geoRegions){
        List<GeoRegions> list = geoRegionsService.selectGeoRegionsList(geoRegions);
        return new PageInfoBT(list);
    }

    /**
     * 新增世界区域
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        GeoRegions geoRegions = new GeoRegions();
        mmap.put("geoRegions", geoRegions);
        return prefix + "/form";
    }
	
    /**
     * 修改世界区域
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	GeoRegions geoRegions = geoRegionsService.findById(id);
	mmap.put("geoRegions", geoRegions);
        return prefix + "/form";
    }
	
    /**
     * 修改保存世界区域
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(GeoRegions geoRegions){		
        int rs = geoRegionsService.save(geoRegions);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除世界区域
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = geoRegionsService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复世界区域
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = geoRegionsService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
