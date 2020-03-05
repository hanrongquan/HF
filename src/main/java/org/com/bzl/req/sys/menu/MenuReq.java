package org.com.bzl.req.sys.menu;

import org.com.bzl.req.PageReq;

/**
 * <pre>
 *     菜单请求类
 * </pre>
 */
public class MenuReq  extends PageReq {

    /**
     *  角色ID
     */
    private Integer menuId;

    /**
     *  角色名称
     */
    private String menuName;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
    
    
}
