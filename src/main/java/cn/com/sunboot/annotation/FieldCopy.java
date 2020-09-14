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
@Repeatable(FieldCopys.class)
public @interface FieldCopy {
    //对应源对象字段名，默认与源对象字段名一致
    String name() default "";
    //对象源数据的Class
    Class<?> source();
}
