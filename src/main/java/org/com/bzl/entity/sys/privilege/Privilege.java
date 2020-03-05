package org.com.bzl.entity.sys.privilege;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.com.bzl.constant.AppConstant;
import org.omg.CORBA.IDLType;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     权限实体类
 * </pre>
 */
@TableName("t_privilege")
public class Privilege implements Serializable {

    private static final long serialVersionUID = 2087237590331698910L;

    /**
     *  权限ID
     */
    @TableId(type = IdType.AUTO)
    private Integer privilegeId;

    /**
     * 权限名称
     */
    private String privilegeName;

    /**
     *  权限链接地址
     */
    private String privilegeAddress;

    /**
     *  权限类型
     */
    private Integer privilegeType;

    /**
     *  是否生效
     */
    private Integer privilegeIsEfficient;

    /**
     * 权限排序
     */
    private Integer privilegeRank;

    /**
     * 权限备注
     */
    private String privilegeRemark;

    /**
     * 创建权限时间
     */
    private String privilegeCreateTime;

    public String getPrivilegeCreateTime() {
        String timeStamp ="";
        try {
            Date date = DateUtil.parse(this.privilegeCreateTime);
            timeStamp= DateUtil.format(date, AppConstant.DATA_FOMAT);
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return timeStamp;
    }

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

	public String getPrivilegeAddress() {
		return privilegeAddress;
	}

	public void setPrivilegeAddress(String privilegeAddress) {
		this.privilegeAddress = privilegeAddress;
	}

	public Integer getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(Integer privilegeType) {
		this.privilegeType = privilegeType;
	}

	public Integer getPrivilegeIsEfficient() {
		return privilegeIsEfficient;
	}

	public void setPrivilegeIsEfficient(Integer privilegeIsEfficient) {
		this.privilegeIsEfficient = privilegeIsEfficient;
	}

	public Integer getPrivilegeRank() {
		return privilegeRank;
	}

	public void setPrivilegeRank(Integer privilegeRank) {
		this.privilegeRank = privilegeRank;
	}

	public String getPrivilegeRemark() {
		return privilegeRemark;
	}

	public void setPrivilegeRemark(String privilegeRemark) {
		this.privilegeRemark = privilegeRemark;
	}

	public void setPrivilegeCreateTime(String privilegeCreateTime) {
		this.privilegeCreateTime = privilegeCreateTime;
	}
    
}
