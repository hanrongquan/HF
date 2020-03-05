package org.com.bzl.service.sys.menu;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.sys.menu.Menu;
import org.com.bzl.entity.sys.menu.Menu;
import org.com.bzl.req.sys.menu.MenuReq;

/**
 * <pre>
 *     菜单业务逻辑接口
 * </pre>
 */
public interface IMenuService {
    /**
     *  新增菜单
     *
     * @param menu
     * @return
     */
    Boolean insertMenu( Menu menu );

    /**
     *  修改菜单
     *
     * @param menu
     * @return
     */
    Boolean updateMenu( Menu menu );


    /**
     * 判断菜单名称是否存在
     *
     * @param menu
     * @return
     */
    Boolean menuNameIsExist( Menu menu );

    /**
     * 根据菜单名和菜单ID获得菜单
     *
     * @param  MenuId
     * @param  MenuName
     * @return 用户
     */
    Menu findMenuByNameAndId(String MenuName , Integer MenuId  );

    /**
     * 删除菜单
     *
     * @param MenuReq 菜单Id
     */
    Boolean deleteMenu( MenuReq MenuReq );

    /**
     * 分页获取菜单
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<Menu> findAll(Page<Menu> page , MenuReq MenuReq);
}
