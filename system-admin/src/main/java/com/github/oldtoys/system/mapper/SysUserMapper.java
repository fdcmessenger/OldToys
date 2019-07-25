package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysUser;
import com.gitee.fdc.mapper.SbbsMapper;
import com.github.oldtoys.system.domain.SysOffice;
import com.github.oldtoys.system.vo.UserSearchDto;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
public interface SysUserMapper extends SbbsMapper<SysUser> {

    /**
     * 查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    public SysUser findByUserName(String usr);

    public int updatePasswordById(SysUser user);

    public int updatePasswordByUserName(SysUser user);

    public List<SysUser> findByOffices(@Param("offices") List<SysOffice> offices, @Param("dto") UserSearchDto dto);

    public List<SysUser> findHasNoOffices(@Param("dto") UserSearchDto dto);
}
