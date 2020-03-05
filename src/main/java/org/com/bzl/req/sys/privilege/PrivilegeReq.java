package org.com.bzl.req.sys.privilege;

import org.com.bzl.req.PageReq;

/**
 * <pre>
 *     权限请求类
 * </pre>
 */
public class PrivilegeReq extends PageReq {

    /**
     *  权限ID
     */
    private Integer privilegeId;

    /**
     *  权限名称
     */
    private String privilegeName;

	public Integer getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(Integer privilegeId) {
		this.privilegeId = privilegeId;
	}

	public String getPrivilegeName() {
		return privilegeName;
	}

	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

    
}
