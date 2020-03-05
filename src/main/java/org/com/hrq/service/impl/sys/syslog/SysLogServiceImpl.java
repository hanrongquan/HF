package org.com.hrq.service.impl.sys.syslog;

import org.com.hrq.entity.sys.syslog.SysLog;
import org.com.hrq.mapper.sys.syslog.SysLogMapper;
import org.com.hrq.service.sys.syslog.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *     操作业务逻辑实现类
 * </pre>
 *
 */
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired(required = false)
    private SysLogMapper sysLogMapper;
    /**
     * 新增用户
     *
     * @param sysLog
     * @return Role
     */
    @Override
    public Boolean insertSysLog(SysLog sysLog) {
        Integer id = sysLogMapper.insert(sysLog);
        Boolean succeed = false;
        if( id > 0 ){
            succeed = true;
        }
        return succeed;
    }
}
