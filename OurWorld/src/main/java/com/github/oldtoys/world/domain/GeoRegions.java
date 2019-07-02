package com.github.oldtoys.world.domain;

import com.gitee.fdc.base.entity.TreeEntity;
import com.gitee.fdc.kits.StringUtils;
import javax.persistence.Column;
import javax.persistence.Table;
import lombok.Data;

/**
 * 世界区域表 ow_geo_regions
 *
 * @author Mr.fdc
 * @date 2019-07-01T17:22:24.307+08:00
 */
@Data
@Table(name = "ow_geo_regions")
public class GeoRegions extends TreeEntity<GeoRegions> {

    private static final long serialVersionUID = -3743130280951079878L;
    /**
     * @TODO 如需要，请自行重新生成
     */

    /**
     * 地理区域类型
     */
    private Integer geoType;
    /**
     * 英文名称
     */
    private String nameEn;
    /**
     * 中文名称
     */
    private String nameCn;
    /**
     * M49编码
     */
    @Column(name = "m49_code")
    private String m49Code;
    /**
     * ISO二字符编码
     */
    @Column(name = "iso_2_code")
    private String iso2Code;
    /**
     * ISO三字符编码
     */
    @Column(name = "iso_3_code")
    private String iso3Code;

    @Override
    public void setParent(GeoRegions parent) {
        this.parent = parent;
    }

    @Override
    public GeoRegions getParent() {
        return this.parent;
    }

    /**
     * 这是个参考样例，以逗号分隔的字符串数据
     */
    public String[] getPidsArray() {
        String[] sa = StringUtils.split(this.getPids(), ",");
        return sa == null ? new String[0] : sa;
    }

    @Override
    public String getDisplayName() {
        return this.nameCn;
    }

}
