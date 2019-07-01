package com.github.oldtoys.world.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import com.gitee.fdc.kits.StringUtils;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
/**
 * 区域类型表 ow_geo_type
 * 
 * @author Mr.fdc
 * @date 2019-07-01T17:02:50.208+08:00
 */
@Data
@Table(name = "ow_geo_type")
public class GeoType extends BaseEntity<Integer>{

    private static final long serialVersionUID = -2898535670303758338L;
     /**@TODO 如需要，请自行重新生成 */

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
	
    /** 区域类型英文名称 */
    private String typeNameEn;
    /** 区域类型中文名称 */
    private String typeNameCn;
    /** 备注 */
    private String remarks;
    /**  这是个参考样例，以逗号分隔的字符串数据
    public String[] getMultiSelectFieldArray() {
        String[] sa = StringUtils.split(multiSelectField, ",");
        return sa == null ? new String[0] : sa;
    }
     */
}
