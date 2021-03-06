package org.com.hrq.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.com.hrq.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTestMapper extends BaseMapper<User> {


    List<User> findAll(Pagination pagination);

    User findByUserName(String userName);
}

