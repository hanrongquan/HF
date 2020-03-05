package org.com.hrq.service.sys.syslog;

import org.com.hrq.entity.sys.syslog.SysLog;

/**
 * <pre>
 *     操作日志业务逻辑接口
 * </pre>
 */
public interface ISysLogService {

	Boolean insertSysLog(SysLog sysLog);
}
