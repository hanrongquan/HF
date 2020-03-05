package org.com.bzl.service.sys.role;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.sys.role.Role;
import org.com.bzl.entity.sys.user.User;
import org.com.bzl.req.sys.role.RoleReq;

/**
 * <pre>
 *     角色业务逻辑接口
 * </pre>
 */
public interface IRoleService {

    /**
     *  新增角色
     *
     * @param role
     * @return
     */
    Boolean insertRole( Role role );

    /**
     *  修改角色
     *
     * @param role
     * @return
     */
    Boolean updateRole( Role role );


    /**
     * 判断角色名称是否存在
     *
     * @param role
     * @return
     */
    Boolean roleNameIsExist( Role role );

    /**
     * 根据角色名和角色ID获得角色
     *
     * @param  roleId
     * @param  roleName
     * @return 用户
     */
    Role findRoleByNameAndId(String roleName , Integer roleId  );

    /**
     * 删除角色
     *
     * @param roleReq 角色Id
     */
    Boolean deleteRole( RoleReq roleReq );

    /**
     * 分页获取角色
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<Role> findAll(Page<Role> page , RoleReq roleReq);


}
