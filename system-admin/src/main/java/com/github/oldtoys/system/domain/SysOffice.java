package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.TreeEntity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 组织部门表 sys_office
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:33:52.234+08:00
 */
@Data
@Table(name = "sys_office")
public class SysOffice extends TreeEntity<SysOffice> {

    private static final long serialVersionUID = -4611742752772230354L;

    /**
     * 名称
     */
    private String name;

    @Override
    public void setParent(SysOffice parent) {
        this.parent = parent;
    }

    @Override
    public SysOffice getParent() {
        return this.parent;
    }

    @Override
    public String getDisplayName() {
        return this.name;
    }
    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
}
