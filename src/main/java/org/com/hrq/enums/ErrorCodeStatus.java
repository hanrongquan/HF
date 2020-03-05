package org.com.hrq.enums;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * <pre>
 *
 *   错误码枚举类
 *   @author menoly
 *   @date : 2019/2/18 下午5:08
 *
 * </pre>
 *
 */
public enum ErrorCodeStatus {

    /**########################用户模块#########################*/
    LOING_USER( "用户名或密码错误!" ),

    LOING_USER_NAME("用户名不存在!"),

    LOGIN_USER_PASSWORD( "用户密码错误!" ),

    USER_NAME_EXIST( "用户名称已存在!" ),

    USER_UPDATE_PASSWORD( "旧密码不能为空!" ),

    USER_UPDATE_NEWPASSWORD( "新密码不能为空!"),

    USER_UPDATE_EQ_PASSWORD( "新旧密码不能一致!" ),

    USER_UPDATE_ISTRUE_PASSWORD( "旧密码不正确!" ),

    /**########################角色模块#########################*/
    ROLE_NAME_EXIST( "角色名称已存在!" ),

    /**########################角色模块#########################*/
    PRIVILEGE_NAME_EXIST( "权限名称已存在!" ),

    /**########################菜单模块#########################*/
    MENU_NAME_EXIST( "菜单名称已存在!" ),

    PARAM_DEFAULT( "必传参数缺省!" ),

    SYSTEM_EXCEPTION("系统繁忙，请稍后重试!");

    private String desc;

    ErrorCodeStatus(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
