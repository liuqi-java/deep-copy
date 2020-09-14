package cn.com.sunboot.annotation;

import java.lang.annotation.*;

/**
 * 深度复制对象需要用到，可以自定义字段名和数据源
 * @author: liuqi
 * @date: 2020/4/17
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FieldCopys {
    FieldCopy[] value() default {};
}
