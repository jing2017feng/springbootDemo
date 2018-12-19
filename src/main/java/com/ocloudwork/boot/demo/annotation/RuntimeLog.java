package com.ocloudwork.boot.demo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解，用于在类或方法，打印方法执行时长
 *
 * @author minghui
 */
@Target(value = { ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RuntimeLog {

}
