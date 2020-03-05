package org.com.hrq.service.sys.user;

import com.baomidou.mybatisplus.plugins.Page;
import org.com.hrq.entity.sys.user.User;
import org.com.hrq.req.sys.user.UserReq;

/**
 * <pre>
 *     用户业务逻辑接口
 * </pre>
 */
public interface IUserService {
    /**
     * 新增用户
     *
     * @param user user
     * @return Role
     */
    Boolean insertUser(User user);

    /**
     *  通过用户ID删除用户
     *
     * @param userReq
     * @return
     */
    Boolean deleteUser( UserReq userReq );


    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    Boolean updateUser( User user );

    /**
     * 判断用户名称是否存在
     *
     * @param user
     * @return
     */
    Boolean userNameIsExist( User user );

    /**
     * 根据用户名和用户ID获得用户
     *
     * @param  userName
     * @param  userId
     * @return 用户
     */
    User findUserByNameAndId( String userName , Integer userId  );

    /**
     * 修改密码
     *
     * @param userReq
     * @return
     */
    Boolean updatePassword( UserReq userReq );

    /**
     * 判断新旧密码是否相同
     *
     * @param userReq
     * @return
     */
    Boolean isEqOldNewPassword( UserReq userReq );

    /**
     * 旧密码是否正确
     *
     * @param userReq
     * @return
     */
    Boolean isTrueOldPassword( UserReq userReq );

    /**
     * 根据用户Id获得用户
     *
     * @param userId 用户名
     * @return 用户
     */
    User findUserById(Integer userId);

    /**
     * 删除用户
     *
     * @param userId 用户Id
     */
    Boolean removeUser(Long userId);


    /**
     * 分页获取用户
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<User> findAll(Page<User> page , UserReq userReq);
}
