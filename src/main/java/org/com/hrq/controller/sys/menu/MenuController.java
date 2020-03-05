package org.com.hrq.controller.sys.menu;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.hrq.entity.sys.menu.Menu;
import org.com.hrq.enums.ErrorCodeStatus;
import org.com.hrq.req.sys.menu.MenuReq;
import org.com.hrq.service.sys.menu.IMenuService;
import org.com.hrq.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *     菜单控制层
 *     @author menoly
 *     @date : 2019/2/19 下午5:08
 * </pre>
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private IMenuService iMenuService;
    /**
     *  分页展示角色列表
     * @param menuReq
     * @return
     */
    @GetMapping("/paging")
    public Response<Page<Menu>> paging(@RequestBody MenuReq menuReq) {
        Page pageable = new Page(menuReq.getPageNo(), menuReq.getPageSize());
        Page<Menu> menu = null;
        try {
            menu = iMenuService.findAll( pageable , menuReq);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes(menu);
    }

    /**
     *  添加角色
     * @param menu
     * @return
     */
    @PostMapping("/addMenu")
    public Response addMenu( @RequestBody Menu menu  ){
        try{
            if( iMenuService.menuNameIsExist( menu ) )
                return Response.no(ErrorCodeStatus.MENU_NAME_EXIST.getDesc());
            iMenuService.insertMenu( menu );
            return Response.yes();
        }catch ( Exception e ){
            e.printStackTrace();
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
        }
    }

    /**
     *  修改角色
     *
     * @param menu
     * @return
     */
    @PostMapping("/updateMenu")
    public Response updateMenu( @RequestBody Menu menu ){
        try{
            //必传参缺省
            if( menu.getMenuId() == null  )
                return  Response.no( ErrorCodeStatus.PARAM_DEFAULT.getDesc() );

            if( iMenuService.menuNameIsExist( menu ) )
                return  Response.no(ErrorCodeStatus.PRIVILEGE_NAME_EXIST.getDesc());

            iMenuService.updateMenu( menu );
            return Response.yes();
        }catch ( Exception e ){
            e.printStackTrace();
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
        }
    }

    /**
     *  删除角色
     *
     * @return
     */
    @PostMapping("/deleteMenu")
    public Response deleteMenu(  @RequestBody MenuReq menuReq  ){
        try {
            iMenuService.deleteMenu(menuReq);
            return Response.yes();
        }catch ( Exception e ){
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION .getDesc());
        }
    }
}
