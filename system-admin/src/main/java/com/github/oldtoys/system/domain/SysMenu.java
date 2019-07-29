package com.github.oldtoys.system.domain;

import com.gitee.fdc.base.entity.TreeEntity;
import javax.persistence.Table;
import lombok.Data;

/**
 * 系统菜单表 sys_menu
 *
 * @author Mr.fdc
 * @date 2019-07-24T16:52:47.753+08:00
 */
@Data
@Table(name = "sys_menu")
public class SysMenu extends TreeEntity<SysMenu> {

    private static final long serialVersionUID = 7437467930929390845L;

    /**
     * 名称
     */
    private String name;
    /**
     * 网址链接
     */
    private String href;
    /**
     * 图标
     */
    private String icon;
    /**
     * 是否显示
     */
    private Boolean isShow;
    /**
     * 权限标识
     */
    private String permission;

    @Override
    public void setParent(SysMenu parent) {
        this.parent = parent;
    }

    @Override
    public SysMenu getParent() {
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
