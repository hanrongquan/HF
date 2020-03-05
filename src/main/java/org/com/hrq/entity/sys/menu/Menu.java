package org.com.hrq.entity.sys.menu;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.com.hrq.constant.AppConstant;

import java.io.Serializable;

/**
 * <pre>
 *     菜单实体类
 * </pre>
 */
@TableName("t_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = -3121994746681912161L;

    /**
     *  菜单ID
     */
    @TableId(type= IdType.AUTO )
    private Integer menuId;

    /**
     *  菜单父类ID
     */
    private Integer menuParentId;

    /**
     *  菜单名称
     */
    private String menuName;

    /**
     *  菜单链接地址
     */
    private String menuChainedAddress;

    /**
     *  是否显示
     */
    private Integer menuIsShow;

    /**
     *  图表地址
     */
    private String menuIcon;

    /**
     *  菜单排序
     */
    private Integer menuRank;

    /**
     *  创建菜单时间
     */
    private String menuCreateTime;

    public String getMenuCreateTime() {
        String timeStamp ="";
        try {
            Date date = DateUtil.parse(this.menuCreateTime);
            timeStamp = DateUtil.format(date, AppConstant.DATA_FOMAT);
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return timeStamp;
    }

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getMenuParentId() {
		return menuParentId;
	}

	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuChainedAddress() {
		return menuChainedAddress;
	}

	public void setMenuChainedAddress(String menuChainedAddress) {
		this.menuChainedAddress = menuChainedAddress;
	}

	public Integer getMenuIsShow() {
		return menuIsShow;
	}

	public void setMenuIsShow(Integer menuIsShow) {
		this.menuIsShow = menuIsShow;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuRank() {
		return menuRank;
	}

	public void setMenuRank(Integer menuRank) {
		this.menuRank = menuRank;
	}

	public void setMenuCreateTime(String menuCreateTime) {
		this.menuCreateTime = menuCreateTime;
	}
    
    
}
