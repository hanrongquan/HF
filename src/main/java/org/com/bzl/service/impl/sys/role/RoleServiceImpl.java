package org.com.bzl.service.impl.sys.role;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.sys.role.Role;
import org.com.bzl.mapper.sys.role.RoleMapper;
import org.com.bzl.req.sys.role.RoleReq;
import org.com.bzl.service.sys.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     角色业务逻辑实现类
 * </pre>
 *
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;
    /**
     *  新增角色
     *
     * @param role
     * @return
     */
    @Override
    public Boolean insertRole(Role role) {
        role.setRoleCreateTime(DateUtil.now());

        Integer id = roleMapper.insert(role);
        Boolean succeed = false;
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     *  修改角色
     *
     * @param role
     * @return
     */
    @Override
    public Boolean updateRole(Role role) {
        Boolean succeed = false;
        Integer id =  roleMapper.updateById( role );
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 判断角色名称是否存在
     *
     * @param role
     * @return
     */
    @Override
    public Boolean roleNameIsExist(Role role) {
        Boolean isExist = true;
        Role ro = findRoleByNameAndId(  role.getRoleName() , role.getRoleId());
        if( ro == null )  isExist = false;
        return isExist;
    }

    /**
     * 根据角色名称和角色Idc查找角色
     *
     * @param  roleName
     * @param  roleId
     * @return
     */
    @Override
    public Role findRoleByNameAndId(String roleName, Integer roleId) {
         return roleMapper.findRoleByNameAndId( roleName , roleId );
    }


    /**
     * 删除角色
     *
     * @param roleReq 角色Id
     */
    @Override
    public Boolean deleteRole(RoleReq roleReq) {
        Boolean succeed = false;
        Integer id = roleMapper.deleteById(roleReq.getRoleId());
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 分页获取角色
     *
     * @param page 分页
     * @return 分页数据
     */
    @Override
    public Page<Role> findAll(Page<Role> page, RoleReq roleReq) {
        return page.setRecords(roleMapper.findAll(page,roleReq));
    }
}
