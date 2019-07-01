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
import com.github.oldtoys.world.domain.GeoType;
import com.github.oldtoys.world.service.IGeoTypeService;

/**
 * 区域类型 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:02:50.208+08:00
 */
@Slf4j
@Controller
@RequestMapping("/world/geoType")
public class GeoTypeController{
    private String prefix = "world/geoType";
	
    @Autowired
    private IGeoTypeService geoTypeService;
	
    @GetMapping()
    public String geoType(){
        return prefix + "/geoType";
    }
	
    /**
     * 查询区域类型列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(GeoType geoType){
        List<GeoType> list = geoTypeService.selectGeoTypeList(geoType);
        return new PageInfoBT(list);
    }

    /**
     * 新增区域类型
     */
    @GetMapping("/add")
    public String add(ModelMap mmap){
        GeoType geoType = new GeoType();
        mmap.put("geoType", geoType);
        return prefix + "/form";
    }
	
    /**
     * 修改区域类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	GeoType geoType = geoTypeService.findById(id);
	mmap.put("geoType", geoType);
        return prefix + "/form";
    }
	
    /**
     * 修改保存区域类型
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(GeoType geoType){		
        int rs = geoTypeService.save(geoType);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除区域类型
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = geoTypeService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复区域类型
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = geoTypeService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
