package org.com.hrq.controller;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.hrq.entity.User;
import org.com.hrq.enums.ErrorCodeStatus;
import org.com.hrq.service.MessageService;
import org.com.hrq.service.UserService;
import org.com.hrq.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author menoly
 * @date : 2019/2/15 下午5:08
 */

@RestController
@RequestMapping("/api/test/user")
public class UserTestController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/login")
    public Response login(@RequestParam("userName") String userName,
                          @RequestParam("userPass") String userPass,
                          HttpSession session) {
        User user = userService.findByUserName(userName);
        if (user == null) {
            return Response.no(ErrorCodeStatus.LOING_USER_NAME.getDesc());
        }
        if (!Objects.equals(user.getUserPass(), userPass)) {
            return Response.no(ErrorCodeStatus.LOGIN_USER_PASSWORD.getDesc());
        }
        session.setAttribute("user", user);
        return Response.yes(user);
    }


    @GetMapping("/logout")
    public Response logout(HttpSession session) {
        session.removeAttribute("user");
        return Response.yes();
    }

    @GetMapping("/current-user")
    public Response login(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return Response.no("用户未登录");
        }
        Integer unReadSize = messageService.getUnReadSize(user.getUserId());
        user.setUnReadSize(unReadSize);
        return Response.yes(user);
    }

    public Response<Page<User>> paging (){
        return null;
    }

//    @PostMapping("/save")
//    public Response addUser(@RequestBody User user) {
//        try {
//            userService.saveByUser(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Response.no();
//        }
//        return Response.yes();
//    }


}
