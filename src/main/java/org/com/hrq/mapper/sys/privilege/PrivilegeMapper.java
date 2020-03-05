package org.com.hrq.mapper.sys.privilege;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.com.hrq.entity.sys.privilege.Privilege;
import org.com.hrq.entity.sys.role.Role;
import org.com.hrq.req.sys.privilege.PrivilegeReq;
import org.com.hrq.req.sys.role.RoleReq;

import java.util.List;

@Mapper
public interface PrivilegeMapper extends BaseMapper<Privilege> {
    /**
     *  查询权限列表
     * @param pagination
     * @return
     */
    List<Privilege> findAll(Pagination pagination , PrivilegeReq privilegeReq);

    /**
     * 按用权限和权限ID称查询权限
     * @param privilegeName
     * @param privileged
     * @return
     */
    Privilege findPrivilegeByNameAndId(@Param( "privilegeName" ) String privilegeName , @Param( "privilegeId" ) Integer privileged  );
}
