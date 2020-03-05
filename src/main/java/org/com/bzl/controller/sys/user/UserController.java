package org.com.bzl.controller.sys.user;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.bzl.entity.Message;
import org.com.bzl.entity.sys.user.User;
import org.com.bzl.enums.ErrorCodeStatus;
import org.com.bzl.req.sys.user.UserReq;
import org.com.bzl.service.sys.user.IUserService;
import org.com.bzl.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <pre>
 *   用户管理控制层
 *   @author menoly
 *   @date : 2019/2/19 下午5:08
 * </pre>
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param userReq
     * @param session
     * @return
     */
   @PostMapping("/login")
   public Response login(@RequestBody UserReq userReq , HttpSession session){
       return Response.yes();
   }

    /**
     * 添加用户
     * @param user
     * @return
     */
   @PostMapping("/addUser")
   public Response addUser(  @RequestBody User user ){
       try{
           if( iUserService.userNameIsExist( user ) )
               return Response.no(ErrorCodeStatus.USER_NAME_EXIST.getDesc());
           iUserService.insertUser( user );
               return Response.yes();
       }catch ( Exception e ){
           e.printStackTrace();
           return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
       }
   }

    /**
     * 修改用户
     * @param user
     * @return
     */
   @PostMapping("/updateUser")
   public Response updateUer( @RequestBody User user ){
       try{
           //必传参缺省
           if( user.getUserId() == null  )
               return  Response.no( ErrorCodeStatus.PARAM_DEFAULT.getDesc() );

           if( iUserService.userNameIsExist( user ) )
               return  Response.no(ErrorCodeStatus.USER_NAME_EXIST.getDesc());
           iUserService.updateUser( user );
               return Response.yes();
       }catch ( Exception e ){
           e.printStackTrace();
           return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
       }
   }

    /**
     * 删除用户
     *
     * @param userReq
     * @return
     */
   @PostMapping("/deleteUser")
   public Response deleteUser( @RequestBody UserReq userReq ){
      try {
            iUserService.deleteUser(userReq);
            return Response.yes();
      }catch ( Exception e ){
          return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION .getDesc());
      }
   }

    /**
     * 用户修改自己的密码
     *
     * @param userReq
     * @return
     */
   @PostMapping("/updatePassword")
   public Response updatePassword( @RequestBody UserReq userReq){
     try{
         //必传参缺省
         if( userReq.getUserId() == null  )
             return  Response.no( ErrorCodeStatus.PARAM_DEFAULT.getDesc() );

         //旧密码不能空
         if( userReq.getUserPassword() == null || userReq.getUserPassword().length() == 0 )
             return Response.no(ErrorCodeStatus.USER_UPDATE_PASSWORD.getDesc());

         //新密码不能空
         if( userReq.getNewUserPassword() == null || userReq.getNewUserPassword().length() == 0 ) {
             return Response.no(ErrorCodeStatus.USER_UPDATE_NEWPASSWORD.getDesc());
         }

         //旧密码是否正确
         if( !iUserService.isTrueOldPassword( userReq ) )
             return Response.no( ErrorCodeStatus.USER_UPDATE_ISTRUE_PASSWORD.getDesc() );

         //判断新旧密码不能一致
         if( iUserService.isEqOldNewPassword( userReq ) )
             return Response.no( ErrorCodeStatus.USER_UPDATE_EQ_PASSWORD.getDesc());

         iUserService.updatePassword( userReq );
         return Response.yes();
     }catch ( Exception e ){
         e.printStackTrace();
         return Response.no( ErrorCodeStatus.SYSTEM_EXCEPTION.getDesc() );
     }
   }
    /**
     *  分页展示用户列表
     * @param userReq
     * @return
     */
   @GetMapping("/paging")
   public Response<Page<User>> paging (@RequestBody UserReq userReq ){

       Page pageable = new Page(userReq.getPageNo(), userReq.getPageSize());
       Page<User> user = null;
       try {
           user = iUserService.findAll( pageable , userReq);
       } catch (Exception e) {
           return Response.no();
       }
       return Response.yes(user);
   }

    /**
     * 用户退出
     * @param session
     * @return
     */
    @GetMapping("/loginOut")
   public Response loginOut( HttpSession session ){
       session.removeAttribute("user");
       return Response.yes();
   }
}
