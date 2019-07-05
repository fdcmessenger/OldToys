package com.github.oldtoys.world.vo;

import java.io.Serializable;
import lombok.Data;

/**
 * 世界区域表 ow_geo_regions
 *
 * @author Mr.fdc
 * @date 2019-07-01T17:22:24.307+08:00
 */
@Data
public class RegionSVO implements Serializable {

    private static final long serialVersionUID = -6675522054849299685L;

    private Integer pid;
    /**
     * 地理区域类型
     */
    private Integer geoType;

    private String keywords;
    private String continent;

}
