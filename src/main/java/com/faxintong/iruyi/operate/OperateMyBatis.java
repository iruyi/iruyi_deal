package com.faxintong.iruyi.operate;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by hehj on 15-1-2.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface OperateMyBatis {
    String value() default "";
}
