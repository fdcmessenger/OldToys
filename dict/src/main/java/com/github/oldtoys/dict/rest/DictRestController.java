package com.github.oldtoys.dict.rest;

import com.gitee.fdc.web.ajax.RestResult;
import com.github.oldtoys.dict.domain.DictItemVO;
import com.github.oldtoys.dict.domain.SysDict;
import com.github.oldtoys.dict.service.ISysDictItemService;
import com.github.oldtoys.dict.service.ISysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@Api(value = "字典Rest服务接口value",description = "字典Rest服务接口description",tags = {"字典Rest服务接口tags"})
@RestController
public class DictRestController {

    @Autowired
    ISysDictItemService itemService;
    @Autowired
    ISysDictService dictService;

    @ApiOperation("获取字典选项数据 ")
    @ApiResponses({
        @ApiResponse(code = 200, message = "data中为返回的字典选项数据", response = DictItemVO.class)
    })
    @GetMapping("/dicts/{dictType}/items")
    public RestResult<List<DictItemVO>> getDictDataByType(@ApiParam(name = "dictType", value = "", required = true, type = "String") @PathVariable String dictType) {
        List<DictItemVO> l = itemService.selectItemsByType(dictType);
        return RestResult.success(l);
    }

    @ApiOperation("获取所有的字典类型定义 ")
    @GetMapping("/dicts")
    public RestResult<List<SysDict>> getAllDict() {
        List<SysDict> l = dictService.findAll();
        return RestResult.success(l);
    }

}
