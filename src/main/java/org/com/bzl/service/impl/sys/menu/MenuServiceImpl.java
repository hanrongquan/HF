package org.com.bzl.service.impl.sys.menu;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.sys.menu.Menu;
import org.com.bzl.mapper.sys.menu.MenuMapper;
import org.com.bzl.req.sys.menu.MenuReq;
import org.com.bzl.service.sys.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     菜单业务逻辑实现类
 * </pre>
 *
 */
@Service
public class MenuServiceImpl implements IMenuService {

   @Autowired( required = false)
   private MenuMapper menuMapper;
    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    @Override
    public Boolean insertMenu(Menu menu) {
       // menu.setMenuCreateTime(DateUtil.now());
        Integer id = menuMapper.insert(menu);
        Boolean succeed = false;
        if( id > 0 ){
            succeed = true;
        }
        return  succeed;
    }

    /**
     * 修改菜单
     *
     * @param menu
     * @return
     */
    @Override
    public Boolean updateMenu(Menu menu) {
        Boolean succeed = false;
        Integer id =  menuMapper.updateById( menu );
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 判断菜单名称是否存在
     *
     * @param menu
     * @return
     */
    @Override
    public Boolean menuNameIsExist(Menu menu) {
        Boolean isExist = true;
        Menu ro = findMenuByNameAndId(  menu.getMenuName() , menu.getMenuId());
        if( ro == null )  isExist = false;
        return isExist;
    }

    /**
     * 根据菜单名和菜单ID获得菜单
     *
     * @param menuName
     * @param menuId
     * @return 用户
     */
    @Override
    public Menu findMenuByNameAndId(String menuName, Integer menuId) {
        return menuMapper.findMenuByNameAndId( menuName , menuId );
    }

    /**
     * 删除菜单
     *
     * @param MenuReq 菜单Id
     */
    @Override
    public Boolean deleteMenu(MenuReq MenuReq) {
        Boolean succeed = false;
        Integer id = menuMapper.deleteById(MenuReq.getMenuId());
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 分页获取菜单
     *
     * @param page    分页
     * @param menuReq
     * @return 分页数据
     */
    @Override
    public Page<Menu> findAll(Page<Menu> page, MenuReq menuReq) {
        return page.setRecords(menuMapper.findAll(page,menuReq));
    }
}
