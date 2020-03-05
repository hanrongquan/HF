package org.com.hrq.mapper.sys.syslog;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.com.hrq.entity.sys.syslog.SysLog;

import java.util.List;

@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {
    /**
     *  查询日志列表
     * @param pagination
     * @return
     */
    List<SysLog> findAll(Pagination pagination);
    
    public Boolean insertSysLog(SysLog sysLog);
}
