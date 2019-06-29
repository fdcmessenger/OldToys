package com.github.oldtoys.world.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

/**
 * 大洲表 ow_continent
 *
 * @author Mr.fdc
 * @date 2019-06-29T19:56:59.611+08:00
 */
@Data
@Table(name = "ow_continent")
public class Continent extends BaseEntity<Integer>{
     /**@TODO 如需要，请自行重新生成 */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
	
    /** 缩写 */
    private String abbr;
    /** 英文名称 */
    private String nameEn;
    /** 中文名称 */
    private String nameCn;
    /**  这是个参考样例，以逗号分隔的字符串数据
    public String[] getMultiSelectFieldArray() {
        String[] sa = StringUtils.split(multiSelectField, ",");
        return sa == null ? new String[0] : sa;
    }
     */
}
