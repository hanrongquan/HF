package org.com.bzl.controller.sys.role;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.sys.role.Role;
import org.com.bzl.entity.sys.user.User;
import org.com.bzl.enums.ErrorCodeStatus;
import org.com.bzl.req.sys.role.RoleReq;
import org.com.bzl.req.sys.user.UserReq;
import org.com.bzl.service.sys.role.IRoleService;
import org.com.bzl.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *     角色控制层
 *     @author menoly
 *     @date : 2019/2/19 下午5:08
 * </pre>
 */
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;
    /**
     *  分页展示角色列表
     * @param roleReq
     * @return
     */
    @GetMapping("/paging")
    public Response<Page<Role>> paging(@RequestBody RoleReq roleReq) {
        Page pageable = new Page(roleReq.getPageNo(), roleReq.getPageSize());
        Page<Role> role = null;
        try {
            role = iRoleService.findAll( pageable , roleReq);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes(role);
    }

    /**
     *  添加角色
     * @param role
     * @return
     */
    @PostMapping("/addRole")
    public Response addRole( @RequestBody Role role  ){
        try{
            if( iRoleService.roleNameIsExist( role ) )
                return Response.no(ErrorCodeStatus.ROLE_NAME_EXIST.getDesc());
            iRoleService.insertRole( role );
            return Response.yes();
        }catch ( Exception e ){
            e.printStackTrace();
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
        }
    }

    /**
     *  修改角色
     *
     * @param role
     * @return
     */
    @PostMapping("/updateRole")
    public Response updateRole( @RequestBody Role role ){
        try{
            //必传参缺省
            if( role.getRoleId() == null  )
                return  Response.no( ErrorCodeStatus.PARAM_DEFAULT.getDesc() );

            if( iRoleService.roleNameIsExist( role ) )
                return  Response.no(ErrorCodeStatus.ROLE_NAME_EXIST.getDesc());
            iRoleService.updateRole( role );
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
    @PostMapping("/deleteRole")
    public Response deleteRole(  @RequestBody RoleReq roleReq  ){
        try {
            iRoleService.deleteRole(roleReq);
            return Response.yes();
        }catch ( Exception e ){
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION .getDesc());
        }
    }
}
