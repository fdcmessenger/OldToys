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
import com.github.oldtoys.dict.domain.SysDict;
import lombok.extern.slf4j.Slf4j;
import com.github.oldtoys.dict.domain.SysDictItem;
import com.github.oldtoys.dict.service.ISysDictItemService;
import com.github.oldtoys.dict.service.ISysDictService;

/**
 * 字典选择项 信息操作处理
 * 
 * @author Mr.fdc
 * @date 2019-07-16T13:27:14.725+08:00
 */
@Slf4j
@Controller
@RequestMapping("/dict/sysDictItem")
public class SysDictItemController{
    private String prefix = "dict/sysDictItem";
	
    @Autowired
    private ISysDictService dictService;
    @Autowired
    private ISysDictItemService sysDictItemService;
	
    @GetMapping()
    public String sysDictItem(){
        return prefix + "/sysDictItem";
    }
	
    /**
     * 查询字典选择项列表
     */
    @PostMapping("/list")
    @ResponseBody
    public PageInfoBT list(SysDictItem sysDictItem){
        List<SysDictItem> list = sysDictItemService.selectSysDictItemList(sysDictItem);
        return new PageInfoBT(list);
    }

    /**
     * 新增字典选择项
     */
    @GetMapping("/add/{dictId}")
    public String add(@PathVariable("dictId") Integer dictId,ModelMap mmap){
        SysDict dict =dictService.findById(dictId);
        SysDictItem item = new SysDictItem();
        item.setDictId(dict.getId());
        item.setDictType(dict.getType());
        mmap.put("sysDictItem", item);
        return prefix + "/form";
    }
	
    /**
     * 修改字典选择项
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap){
	SysDictItem sysDictItem = sysDictItemService.findById(id);
	mmap.put("sysDictItem", sysDictItem);
        return prefix + "/form";
    }
	
    /**
     * 修改保存字典选择项
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(SysDictItem sysDictItem){		
        int rs = sysDictItemService.save(sysDictItem);
        Result rt = rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("保存失败");
        return rt;
    }
	
    /**
     * 删除字典选择项
     */
    @PostMapping( "/delete")
    @ResponseBody
    public Result remove(@RequestParam String ids){		
        int rs = sysDictItemService.deleteByIds(ids);
        return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("删除失败");
    }
    /**
     * 恢复字典选择项
     */
    @PostMapping("/undelete")
    @ResponseBody
    public Result unDelete(@RequestParam Integer id) {        
      int rs = sysDictItemService.unDeleteById(id);
      return rs > 0 ? ResultGenerator.genSuccessResult() : ResultGenerator.genFailResult("恢复失败");
    }
}
