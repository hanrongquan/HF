package org.com.hrq.controller.sys.privilege;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.hrq.entity.sys.privilege.Privilege;
import org.com.hrq.enums.ErrorCodeStatus;
import org.com.hrq.req.sys.privilege.PrivilegeReq;
import org.com.hrq.service.sys.privilege.IPrivilegeService;
import org.com.hrq.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *     权限控制层
 *     @author menoly
 *     @date : 2019/2/19 下午5:08
 * </pre>
 */
@RestController
@RequestMapping("/api/privilege")
public class PrivilegeController {

    @Autowired
    private IPrivilegeService iPrivilegeService;
    /**
     *  分页展示角色列表
     * @param privilegeReq
     * @return
     */
    @GetMapping("/paging")
    public Response<Page<Privilege>> paging(@RequestBody PrivilegeReq privilegeReq) {
        Page pageable = new Page(privilegeReq.getPageNo(), privilegeReq.getPageSize());
        Page<Privilege> privilege = null;
        try {
            privilege = iPrivilegeService.findAll( pageable , privilegeReq);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes(privilege);
    }

    /**
     *  添加角色
     * @param privilege
     * @return
     */
    @PostMapping("/addPrivilege")
    public Response addPrivilege( @RequestBody Privilege privilege  ){
        try{
            if( iPrivilegeService.privilegeNameIsExist( privilege ) )
                return Response.no(ErrorCodeStatus.PRIVILEGE_NAME_EXIST.getDesc());
            iPrivilegeService.insertPrivilege( privilege );
            return Response.yes();
        }catch ( Exception e ){
            e.printStackTrace();
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
        }
    }

    /**
     *  修改角色
     *
     * @param privilege
     * @return
     */
    @PostMapping("/updatePrivilege")
    public Response updatePrivilege( @RequestBody Privilege privilege ){
        try{
            //必传参缺省
            if( privilege.getPrivilegeId() == null  )
                return  Response.no( ErrorCodeStatus.PARAM_DEFAULT.getDesc() );

            if( iPrivilegeService.privilegeNameIsExist( privilege ) )
                return  Response.no(ErrorCodeStatus.PRIVILEGE_NAME_EXIST.getDesc());

            iPrivilegeService.updatePrivilege( privilege );
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
    @PostMapping("/deletePrivilege")
    public Response deletePrivilege(  @RequestBody PrivilegeReq privilegeReq  ){
        try {
            iPrivilegeService.deletePrivilege(privilegeReq);
            return Response.yes();
        }catch ( Exception e ){
            return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION .getDesc());
        }
    }
}
