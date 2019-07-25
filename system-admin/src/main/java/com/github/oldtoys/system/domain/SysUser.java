package com.github.oldtoys.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gitee.fdc.base.entity.BaseEntity;
import javax.persistence.Table;
import lombok.Data;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户表 sys_user
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
@Data
@Table(name = "sys_user")
public class SysUser extends BaseEntity<Integer> {

    private static final long serialVersionUID = 223502860709428860L;
    // 状态-正常
    public final static Integer USER_STATUS_OK = 1;
    // 状态-锁定
    public final static Integer USER_STATUS_LOCKED = 2;
    // 状态-删除
    public final static Integer USER_STATUS_DELETED = 9;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 用户登录名
     */
    private String userName;
    /**
     * 加密过的密码
     */
    private String password;
    /**
     * 密码加密盐
     */
    private String salt;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 用户状态 (1：启用 2：冻结 9：删除）
     */
    private Integer status;
    /**
     * 性别 0:女 1:男
     */
    private Integer gender;
    /**
     * 生日
     */
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    /**
     * 这是个参考样例，以逗号分隔的字符串数据 public String[] getMultiSelectFieldArray() { String[]
     * sa = StringUtils.split(multiSelectField, ","); return sa == null ? new
     * String[0] : sa; }
     */
}
