package org.com.hrq.service.impl.sys.privilege;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.plugins.Page;
import org.com.hrq.entity.sys.privilege.Privilege;
import org.com.hrq.mapper.sys.privilege.PrivilegeMapper;
import org.com.hrq.req.sys.privilege.PrivilegeReq;
import org.com.hrq.service.sys.privilege.IPrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     权限业务逻辑实现类
 * </pre>
 *
 */
@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

    @Autowired(required = false)
    private PrivilegeMapper privilegeMapper;
    /**
     * 新增权限
     *
     * @param privilege
     * @return
     */
    @Override
    public Boolean insertPrivilege(Privilege privilege) {
        privilege.setPrivilegeCreateTime(DateUtil.now());
        Integer id = privilegeMapper.insert(privilege);
        Boolean succeed = false;
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 修改权限
     *
     * @param privilege
     * @return
     */
    @Override
    public Boolean updatePrivilege(Privilege privilege) {
        Boolean succeed = false;
        Integer id =  privilegeMapper.updateById( privilege );
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 判断权限名称是否存在
     *
     * @param privilege
     * @return
     */
    @Override
    public Boolean privilegeNameIsExist(Privilege privilege) {
        Boolean isExist = true;
        Privilege ro = findPrivilegeByNameAndId(  privilege.getPrivilegeName() , privilege.getPrivilegeId());
        if( ro == null )  isExist = false;
        return isExist;
    }

    /**
     * 根据权限名和权限ID获得权限
     *
     * @param privilegeName
     * @param privilegeId
     * @return 用户
     */
    @Override
    public Privilege findPrivilegeByNameAndId(String privilegeName, Integer privilegeId) {
        return privilegeMapper.findPrivilegeByNameAndId( privilegeName , privilegeId );
    }

    /**
     * 删除权限
     *
     * @param PrivilegeReq 权限Id
     */
    @Override
    public Boolean deletePrivilege(PrivilegeReq privilegeReq) {
        Boolean succeed = false;
        Integer id = privilegeMapper.deleteById(privilegeReq.getPrivilegeId());
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }

    /**
     * 分页获取权限
     *
     * @param page         分页
     * @param privilegeReq
     * @return 分页数据
     */
    @Override
    public Page<Privilege> findAll(Page<Privilege> page, PrivilegeReq privilegeReq) {
        return page.setRecords(privilegeMapper.findAll(page,privilegeReq));
    }
}
