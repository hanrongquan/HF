package org.com.bzl.req.sys.role;

import org.com.bzl.req.PageReq;

/**
 * <pre>
 *     角色请求类
 * </pre>
 */
public class RoleReq extends PageReq {

    /**
     *  角色ID
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
    
    
}
