package org.com.hrq.mapper.sys.user;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.hrq.entity.sys.user.User;
import org.com.hrq.req.sys.user.UserReq;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    /**
     *  查询用户列表
     * @param pagination
     * @return
     */
    List<User> findAll(Pagination pagination , UserReq userReq);

    /**
     * 按用户名和用用户ID称查询用户
     * @param userName
     * @param userId
     * @return
     */
    User findUserByNameAndId(@Param( "userName" ) String userName , @Param( "userId" ) Integer userId  );
}

