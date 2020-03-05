package org.com.hrq.mapper.sys.menu;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.hrq.entity.sys.menu.Menu;
import org.com.hrq.req.sys.menu.MenuReq;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     *  查询菜单列表
     * @param pagination
     * @return
     */
    List<Menu> findAll(Pagination pagination , MenuReq menuReq);

    
    /**
     * 按用菜单和菜单ID称查询菜单
     * @param menuName
     * @param menudId
     * @return
     */
    Menu findMenuByNameAndId(@Param( "menuName" ) String menuName , @Param( "menuId" ) Integer menudId  );
}
