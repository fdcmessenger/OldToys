package com.github.oldtoys.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.fdc.base.entity.BaseEntity;
import com.gitee.fdc.base.mapper.logicdelete.DeleteLogic;
import java.sql.Timestamp;
import javax.persistence.Table;
import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

/**
 * 单样例表 demo_single_table
 *
 * @author Mr.fdc
 * @date 2019-06-28T09:01:26.332+08:00
 */
@Data
@Table(name = "demo_single_table")
public class DemoSingleTable extends BaseEntity<Long> {

    /**
     * @TODO 如需要，请自行重新生成
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 整形字段
     */
    private Integer intField;
    /**
     * 字符串字段
     */
    private String varcharField;
    /**
     * 日期字段
     */
    private Date dateField;
    /**
     * 下拉字段
     */
    private String selectDictField;
    /**
     * 下拉多选字段
     */
    private String multiSelectField;
    /**
     * CHECK多选字段
     */
    private String checkDictField;
    /**
     * REDIO字段
     */
    private String redioDictField;
    /**
     * 变化时间戳
     */
    @Transient
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss SSS",timezone = "GMT+8")
    private Timestamp lastModifyTimestamp;

    @DeleteLogic
    protected Integer delFlag = 0;
    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
    
}
