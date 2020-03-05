package org.com.bzl.service.sys.privilege;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.sys.privilege.Privilege;
import org.com.bzl.req.sys.privilege.PrivilegeReq;

/**
 * <pre>
 *     权限业务逻辑接口
 * </pre>
 */
public interface IPrivilegeService {
    /**
     *  新增权限
     *
     * @param privilege
     * @return
     */
    Boolean insertPrivilege( Privilege privilege );

    /**
     *  修改权限
     *
     * @param privilege
     * @return
     */
    Boolean updatePrivilege( Privilege privilege );


    /**
     * 判断权限名称是否存在
     *
     * @param privilege
     * @return
     */
    Boolean privilegeNameIsExist( Privilege privilege );

    /**
     * 根据权限名和权限ID获得权限
     *
     * @param  PrivilegeId
     * @param  PrivilegeName
     * @return 用户
     */
    Privilege findPrivilegeByNameAndId(String PrivilegeName , Integer PrivilegeId  );

    /**
     * 删除权限
     *
     * @param PrivilegeReq 权限Id
     */
    Boolean deletePrivilege( PrivilegeReq PrivilegeReq );

    /**
     * 分页获取权限
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<Privilege> findAll(Page<Privilege> page , PrivilegeReq PrivilegeReq);
}

