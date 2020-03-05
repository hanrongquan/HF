package org.com.hrq.req.sys.user;

import org.com.hrq.req.PageReq;

/**
 * <pre>
 *     用户请求类
 * </pre>
 */
public class UserReq extends PageReq {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 管理员名称
     */
    private String	userName ;
    /**
     * 管理员昵称
     */
    private String	nickName ;

    /**
     * 密码
     */
    private String userPassword;

    /**
     *  新密码
     */
    private String newUserPassword;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNewUserPassword() {
		return newUserPassword;
	}

	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
    
    
}
