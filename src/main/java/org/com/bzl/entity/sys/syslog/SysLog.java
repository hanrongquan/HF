package org.com.bzl.entity.sys.syslog;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.com.bzl.constant.AppConstant;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 *     操作日志实体类
 * </pre>
 */
@TableName( "t_sys_log" )
public class SysLog implements Serializable {

    private static final long serialVersionUID = 284953822236997679L;

    /**
     *  操作日志ID
     */
    @TableId(type = IdType.AUTO)
    private Integer operationId;

    /**
     * 管理员操作的模块或功能
     */
    private String operationModuleOrFunction;

    /**
     * 管理员的ID
     */
    private Integer operationPersonnelId;

    /**
     * 操作的ID地址
     */
    private Integer operationIp;

    /**
     * 操作结果
     */
    private Integer operationResult;

    /**
     *  操作异常
     */
    private String operationException;

    /**
     *  操作时间
     */
    private String operationTime;

    public String getOperationTime() {
        String timeStamp ="";
        try {
            Date date = DateUtil.parse(this.operationTime);
            timeStamp = DateUtil.format(date, AppConstant.DATA_FOMAT);
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return timeStamp;
    }
}
