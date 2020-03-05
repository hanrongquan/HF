package org.com.hrq.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * <pre>
 *  操作日志注解类
 * </pre>
 */
@Retention( RetentionPolicy.RUNTIME )
@Documented
@Target( ElementType.METHOD )
@Mapping
public @interface Log {
    String value() default "";
}
