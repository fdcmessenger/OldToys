package com.github.oldtoys.system.service.impl;

import com.github.oldtoys.system.mapper.SysUserMapper;
import com.github.oldtoys.system.domain.SysUser;
import com.github.oldtoys.system.service.ISysUserService;
import com.gitee.fdc.base.service.BaseServiceImple;
import com.gitee.fdc.mapper.entity.SbbsExample;
import com.github.oldtoys.system.domain.SysOffice;
import com.github.oldtoys.system.domain.SysOfficeUser;
import com.github.oldtoys.system.service.ISysOfficeService;
import com.github.oldtoys.system.service.ISysOfficeUserService;
import com.github.oldtoys.system.service.PasswordService;
import com.github.oldtoys.system.vo.UserSearchDto;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * 用户 服务层实现
 *
 * @author Mr.fdc
 * @date 2019-07-25T11:34:07.324+08:00
 */
@Service
public class SysUserServiceImpl extends BaseServiceImple<SysUser, Integer> implements ISysUserService {

    @Autowired
    private SysUserMapper dao;

    @Autowired
    ISysOfficeService officeService;
    @Autowired
    ISysOfficeUserService officeUserService;
    @Autowired
    PasswordService passwordService;

    @PostConstruct
    public void init() {
        super.init(SysUser.class, dao);
    }

    /**
     * 查询用户列表
     *
     * @param sysUser 用户信息
     * @return 用户集合
     */
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser) {
        this.pageAble();
        return dao.selectSysUserList(sysUser);
    }

    @Override
    public SysUser findByUserName(String usr) {
        return this.dao.findByUserName(usr);
    }

    @Override
    @Transactional(readOnly = false)
    public int updatePasswordById(Integer id, String newPassword) {
        SysUser user = this.dao.selectByPrimaryKey(id);
        user.setPassword(passwordService.generatePassword(newPassword));
        int n = this.dao.updatePasswordById(user);
        return n;
    }

    @Override
    @Transactional(readOnly = false)
    public int updatePasswordByUserName(String loginName, String newPassword) {
        SysUser user = this.dao.findByUserName(loginName);
        user.setPassword(passwordService.generatePassword(newPassword));
        int n = this.dao.updatePasswordByUserName(user);
        return n;
    }

    @Override
    public boolean isUserNameExist(Integer userId, String userName) {
        SysUser s = new SysUser();
        s.setUserName(userName);
        SysUser l = this.dao.selectOne(s);
        if (l == null) {
            return false;
        }
        if (userId == null) {
            return l != null;
        } else {
            if (userId.equals(l.getId())) {
                return false;
            } else {
                return true;
            }
        }
    }

    @Override
    public boolean isMobileExist(Integer userId, String mobile) {
        SysUser s = new SysUser();
        s.setMobile(mobile);
        SysUser l = this.dao.selectOne(s);
        if (l == null) {
            return false;
        }
        if (userId == null) {
            return l != null;
        } else {
            if (userId.equals(l.getId())) {
                return false;
            } else {
                return true;
            }
        }
    }

//@TODO 加上分页能力
    @Override
    public List<SysUser> findByOfficeId(UserSearchDto dto) {
        if (dto.getHasNoOffice() != null && dto.getHasNoOffice()) {
            this.pageAble();
            return this.dao.findHasNoOffices(dto);
        } else {
            List<SysOffice> ol = null;
            if (dto.getOfficeId() == null || dto.getOfficeId() == 0) {
                dto.setOfficeId(0);
            }
            if (dto.getIncludeChildren() != null && dto.getIncludeChildren()) {
                ol = this.officeService.findByParentIdIncludeParent(dto.getOfficeId());
            } else {
                ol = Lists.newArrayList();
                ol.add(this.officeService.findById(dto.getOfficeId()));
            }
            this.pageAble();
            return this.dao.findByOffices(ol, dto);

        }

    }

    @Override
    @Transactional(readOnly = false)
    public int save(SysUser user, Integer deptId) {
        if (user.getPassword() != null) {
//            String salt = Digests.generateSaltString(URPM_Constants.SALT_SIZE);
            String enPsw = passwordService.generatePassword(user.getPassword());
//            user.setSalt(salt);
            user.setPassword(enPsw);
        }
        if (user.getId() == null) {
            user.setStatus(1);
            int r = super.save(user);
            if (deptId != null) {
                SysOfficeUser ou = new SysOfficeUser();
                ou.setUserId(user.getId());
                ou.setOfficeId(deptId);
                this.officeUserService.save(ou);
            }
            return r;
        } else {
            return super.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public int lockUser(String userName) {
        Example e = new SbbsExample(SysUser.class);
        e.createCriteria().andEqualTo("userName", userName);
        SysUser u = new SysUser();
        u.setStatus(SysUser.USER_STATUS_LOCKED);
        return this.dao.updateByExampleSelective(u, e);
    }
}
