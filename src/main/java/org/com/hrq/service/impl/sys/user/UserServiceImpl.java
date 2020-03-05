package org.com.hrq.service.impl.sys.user;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.plugins.Page;
import org.com.hrq.entity.sys.user.User;
import org.com.hrq.mapper.sys.user.UserMapper;
import org.com.hrq.req.sys.user.UserReq;
import org.com.hrq.service.sys.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * <pre>
 *     用户业务逻辑实现类
 * </pre>
 *
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     *  新增用户
     *
     * @param  user
     */
    @Override
    public Boolean insertUser( User user ) {
        user.setUserCreateTime(DateUtil.now());
        user.setUserPassword( SecureUtil.md5( user.getUserPassword() ) );
        Integer id = userMapper.insert(user);
        Boolean succeed = false;

        if( id > 0 ){
          succeed = true;
        }
        return succeed;
    }

    /**
     *  通过用户ID删除用户
     *
     * @param userReq
     * @return
     */
    @Override
    public Boolean deleteUser(UserReq userReq) {
        Boolean succeed = false;
        Integer id = userMapper.deleteById( userReq.getUserId() );
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @Override
    public Boolean updateUser( User user ) {
        Boolean succeed = false;
        Integer id =  userMapper.updateById( user );

        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 判断用户名称是否存在
     *
     * @param user
     * @return
     */
    @Override
    public Boolean userNameIsExist( User user ){
        Boolean isExist = true;
        User us  = findUserByNameAndId(  user.getUserName() , user.getUserId() );
        if( us == null )  isExist = false;
        return isExist;
    }

    /**
     * 根据用户名和用户ID获得用户
     *
     * @param  userName
     * @param userId
     * @return
     */
    @Override
    public User findUserByNameAndId( String userName , Integer userId ) {
        return userMapper.findUserByNameAndId( userName , userId );
    }

    /**
     * 修改密码
     *
     * @param userReq
     * @return
     */
    @Override
    public Boolean updatePassword(UserReq userReq) {
        User user = ReflectUtil.newInstance(User.class);
        user.setUserId( userReq.getUserId() );
        user.setUserPassword( SecureUtil.md5( userReq.getNewUserPassword() ) );
        Boolean succeed = updateUser( user );
        return succeed;
    }

    /**
     * 判断新旧密码是否相同
     *
     * @param userReq
     * @return
     */
    @Override
    public Boolean isEqOldNewPassword(UserReq userReq) {
        Boolean isEq = false;
        User user = findUserById( userReq.getUserId() );
        if( SecureUtil.md5(userReq.getNewUserPassword()).equals( user.getUserPassword() ) ){
            isEq = true;
        }
        return isEq;
    }

    /**
     * 旧密码是否正确
     *
     * @param userReq
     * @return
     */
    @Override
    public Boolean isTrueOldPassword(UserReq userReq) {
        Boolean isTrue = false;
        User user = findUserById( userReq.getUserId() );
        if( SecureUtil.md5( userReq.getUserPassword() ).equals( user.getUserPassword() ) )
            isTrue = true;
        return isTrue;
    }


    /**
     * 根据用户Id获得用户
     *
     * @param userId 用户名
     * @return 用户
     */
    @Override
    public User findUserById(Integer userId) {
        return userMapper.selectById(userId);
    }

    /**
     *  删除用户
     *
     * @param userId 用户Id
     */
    @Override
    public Boolean removeUser(Long userId) {
        Boolean succeed = false;
        Integer id = userMapper.deleteById(userId);

        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 分页获取用户
     *
     * @param page 分页
     * @return
     */
    @Override
    public Page<User> findAll(Page<User> page , UserReq userReq) {
        return page.setRecords(userMapper.findAll(page,userReq));
    }
}
