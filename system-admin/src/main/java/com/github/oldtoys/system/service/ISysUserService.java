package com.github.oldtoys.system.service;

import com.gitee.fdc.base.service.DeleteLogicService;
import com.github.oldtoys.system.domain.SysUser;
import com.github.oldtoys.system.vo.UserSearchDto;
import java.util.List;

/**
 * 用户 服务层
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
public interface ISysUserService extends DeleteLogicService<SysUser, Integer> {

    /**
     * 查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    public SysUser findByUserName(String usr);

    public int updatePasswordById(Integer id, String newPassword);

    public int updatePasswordByUserName(String loginName, String newPassword);

//    /**
//     * 生成安全的密码，传入16位salt并经过1024次 sha-1 hash
//     */
//    public String entryptPassword(String salt, String plainPassword);
//
//    public boolean validatePassword(String plainPassword, String salts, String password);
    public boolean isUserNameExist(Integer userId, String userName);

    public boolean isMobileExist(Integer userId, String mobile);

//    public int save(SysUser user);
    /**
     * 根据部门ID查找部门下的所有用户 // * @param officeId 部门ID // * @param
     * includeChildrenOffice 是否包括子部门的用户 // * @return
     */
    public List<SysUser> findByOfficeId(UserSearchDto dto);

    public int save(SysUser user, Integer deptId);

    public int lockUser(String userName);
}
