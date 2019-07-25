package com.github.oldtoys.system.mapper;

import com.github.oldtoys.system.domain.SysOfficeRole;
import com.gitee.fdc.mapper.SbbsMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 部门角色 数据层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:39:53.989+08:00
 */
public interface SysOfficeRoleMapper extends SbbsMapper<SysOfficeRole> {

    /**
     * 查询部门角色列表
     *
     * @param sysOfficeRole 部门角色信息
     * @return 部门角色集合
     */
    public List<SysOfficeRole> selectSysOfficeRoleList(SysOfficeRole sysOfficeRole);

    public SysOfficeRole findOfficeRoleByOfficeRoleId(Integer officeRoleId);

    public List<SysOfficeRole> findOfficeRoleListByRoleId(Integer roleId);

    public List<SysOfficeRole> findOfficeRoleListByOfficeId(Integer officeId);

    public List<SysOfficeRole> findOfficeRoleListByOfficeIds(@Param("officeIds") List<Integer> officeIds);
//    public List<SysOfficeRole> findOfficeRoleListByRoleName(String userName);

    public int deleteUnusedOfficeRoles(@Param("officeId") Integer officeId, @Param("roleIds") Integer[] roleIds);

    public int insertNewOfficeRoles(@Param("officeId") Integer officeId, @Param("roleIds") Integer[] roleIds);

}
