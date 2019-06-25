package com.github.oldtoys.demo.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
/**
 * 单样例表 demo_single_table
 * 
 * @author Mr.fdc
 * @date 2019-06-25T09:21:35.536+08:00
 */
@Data
@Table(name = "demo_single_table")
public class DemoSingleTable extends BaseEntity<Long>{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
	
    /** 整形字段 */
    private Integer intField;
    /** 字符串字段 */
    private String varcharField;
    /** 日期字段 */
    private Date dateField;
    /** 下拉字段 */
    private String selectDictField;
    /** 下拉多选字段 */
    private String multiSelectField;
    /** CHECK多选字段 */
    private String checkDictField;
    /** REDIO字段 */
    private String redioDictField;
    /** 变化时间戳 */
    private Date lastModifyTimestamp;

}
