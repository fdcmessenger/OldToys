package com.github.oldtoys.demo.domain;

import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * 单样例表 demo_single_table
 * 
 * @author Mr.fdc
 * @date 2019-05-20T08:56:53.535+08:00
 */
@Data
@Table(name = "demo_single_table")
public class DemoSingleTable extends BaseEntity<Long>
{
	private static final long serialVersionUID = 1L;

        @Id
   @GeneratedValue(generator = "JDBC")
	private Long id;
	
	/** 整形字段 */
	private Integer intField;
	/** 大整形字段 */
	private Long bigintField;
	/** 一位比特字段 */
	private Integer bitOneField;
	/** 长浮点数 */
	private Double realField;
	/** 十进制字段 */
	private BigDecimal decimalField;
	/** 字符字段 */
	private String charField;
	/** 字符串字段 */
	private String varcharField;
	/** 日期字段 */
	private Date dateField;
	/** 时间戳 */
	private Date timestampField;
	/** 日期时间字段 */
	private Date datetimeField;
	/** 下拉字典字段 */
	private String selectDictField;
	/** CHECK字典字段 */
	private String checkDictField;
	/** REDIO字典字段 */
	private String redioDictField;

}
