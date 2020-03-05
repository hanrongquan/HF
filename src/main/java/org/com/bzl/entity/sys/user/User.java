package org.com.bzl.entity.sys.user;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.com.bzl.constant.AppConstant;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     用户信息
 * </pre>
 */
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 8612208768190422684L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户密码
     */
    //private String userPass;

    /**
     * 用户昵称
     */
    private String userNickName;

    /**
     * 用户上次登录时间
     */
    private Date userLastTime;

    /**
     * 用户禁用状态
     */
    private Integer userForbiddenStatus;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户头像
     */
    private String userAvtor;

    /**
     *  用户关联的角色id
     */
    private Integer userRoleId;

    /**
     * 创建用户时间
     */
    private String userCreateTime;

    public String getUserCreateTime() {
        String timeStamp ="";
        try {
            Date date = DateUtil.parse(this.userCreateTime);
            timeStamp = DateUtil.format(date, AppConstant.DATA_FOMAT);
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return timeStamp;
    }

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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public Date getUserLastTime() {
		return userLastTime;
	}

	public void setUserLastTime(Date userLastTime) {
		this.userLastTime = userLastTime;
	}

	public Integer getUserForbiddenStatus() {
		return userForbiddenStatus;
	}

	public void setUserForbiddenStatus(Integer userForbiddenStatus) {
		this.userForbiddenStatus = userForbiddenStatus;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAvtor() {
		return userAvtor;
	}

	public void setUserAvtor(String userAvtor) {
		this.userAvtor = userAvtor;
	}

	public Integer getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}
    
    
}
