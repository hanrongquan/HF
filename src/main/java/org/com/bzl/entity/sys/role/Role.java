package org.com.bzl.entity.sys.role;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.com.bzl.constant.AppConstant;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     角色实体类
 * </pre>
 */
@TableName("t_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 1901674495306589614L;

    /**
     *  角色ID
     */
    @TableId( type = IdType.AUTO)
    private Integer roleId;

     /**
     *  角色父类ID
     */
    private Integer roleParentId;

     /**
     *  角色名称
     */
    private String roleName;

     /**
     *  角色英文名字
     */
    private String roleEnName;

     /**
     *  是否生效
     */
    private Integer roleIsEfficient;

     /**
     *  角色排序
     */
    private Integer roleRank;

     /**
     *  角色备注
     */
    private String roleRemark;


    /**
     *  创建角色时间
     */
    private String roleCreateTime;

    public String getRoleCreateTime() {
        String timeStamp ="";
        try {
            Date date = DateUtil.parse(this.roleCreateTime);
            timeStamp = DateUtil.format(date, AppConstant.DATA_FOMAT);
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return timeStamp;
    }

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRoleParentId() {
		return roleParentId;
	}

	public void setRoleParentId(Integer roleParentId) {
		this.roleParentId = roleParentId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleEnName() {
		return roleEnName;
	}

	public void setRoleEnName(String roleEnName) {
		this.roleEnName = roleEnName;
	}

	public Integer getRoleIsEfficient() {
		return roleIsEfficient;
	}

	public void setRoleIsEfficient(Integer roleIsEfficient) {
		this.roleIsEfficient = roleIsEfficient;
	}

	public Integer getRoleRank() {
		return roleRank;
	}

	public void setRoleRank(Integer roleRank) {
		this.roleRank = roleRank;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public void setRoleCreateTime(String roleCreateTime) {
		this.roleCreateTime = roleCreateTime;
	}

	
}
