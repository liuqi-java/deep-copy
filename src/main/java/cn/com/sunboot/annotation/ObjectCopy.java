package cn.com.sunboot.annotation;

import java.lang.annotation.*;

/**
 * 说明该对象是自定义copy对象
 * @author: liuqi
 * @date: 2020/4/17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ObjectCopy {
}
