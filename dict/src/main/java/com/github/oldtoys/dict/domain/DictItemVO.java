/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.oldtoys.dict.domain;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author Administrator
 */
@Data
@ApiModel(value = "DictItemVO", description = "")
public class DictItemVO implements Serializable {

    private static final long serialVersionUID = -7036877482715163764L;

    private String label;
    private String value;

    public static DictItemVO convert(SysDictItem s) {
        DictItemVO n = new DictItemVO();
        BeanUtils.copyProperties(s, n);
        return n;
    }

    public static List<DictItemVO> convert(List<SysDictItem> sl) {
        List<DictItemVO> l = new ArrayList();
        for (Iterator<SysDictItem> iterator = sl.iterator(); iterator.hasNext();) {
            SysDictItem next = iterator.next();
            l.add(convert(next));
        }
        return l;
    }
}
