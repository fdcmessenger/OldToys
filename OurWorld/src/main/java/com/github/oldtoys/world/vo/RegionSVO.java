package com.github.oldtoys.world.vo;

import com.github.oldtoys.world.domain.*;
import com.gitee.fdc.base.entity.TreeEntity;
import com.gitee.fdc.kits.StringUtils;
import java.io.Serializable;
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
