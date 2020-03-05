package org.com.hrq.mapper.sys.role;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.hrq.entity.sys.role.Role;
import org.com.hrq.entity.sys.user.User;
import org.com.hrq.req.sys.role.RoleReq;
import org.com.hrq.req.sys.user.UserReq;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    /**
     *  查询角色列表
     * @param pagination
     * @return
     */
    List<Role> findAll(Pagination pagination , RoleReq roleReq);

    /**
     * 按用角色和角色ID称查询角色
     * @param roleName
     * @param roleId
     * @return
     */
    Role findRoleByNameAndId(@Param( "roleName" ) String roleName , @Param( "roleId" ) Integer roleId  );
}
