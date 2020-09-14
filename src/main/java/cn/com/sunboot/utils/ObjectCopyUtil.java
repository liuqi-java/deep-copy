package cn.com.sunboot.utils;

import cn.com.sunboot.annotation.FieldCopy;
import cn.com.sunboot.annotation.ObjectCopy;
import org.springframework.core.CollectionFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * @author: liuqi
 * @date: 2020/4/14
 */
public class ObjectCopyUtil {


    public static <View> View deepCopy(Object source, Class<View> v) throws Exception{
        return (View)ObjectCopyUtil.deepCopy(source,v.newInstance());
    }

    /**
     * 反射 深copy
     * 支持类型：基本类型, Collection, 自定义对象
     * @param source 源
     * @param target 目标
     * @return target
     * @throws Exception
     */
    public static Object deepCopy(Object source,Object target) throws Exception{
        if(null == source){
            return null;
        }
        //源数据
        Class<?> sourceClassType = source.getClass();
        //复制目标数据
        Class<?> targetClassType = target.getClass();
        //源数据Map
        Map<String,Object> sourceMap = new HashMap<>(sourceClassType.getDeclaredFields().length);

        //获取源数据
        for(Field field : getAllFields(sourceClassType)){
            if(Modifier.isFinal(field.getModifiers())){
                continue;
            }
            field.setAccessible(true);
            Object value = field.get(source);
            if(value != null){
                sourceMap.put(field.getName(),value);
            }
        }

        //赋值目标数据
        for(Field field : getAllFields(targetClassType)){
            field.setAccessible(true);
            String fieldName = field.getName();
            Object targetValue;
            //获取注解
            FieldCopy[] fieldCopiesArry = field.getAnnotationsByType(FieldCopy.class);
            for (FieldCopy fieldCopy : fieldCopiesArry) {
                if(fieldCopy.source().equals(sourceClassType)){
                    if(!fieldCopy.name().isEmpty()){
                        fieldName = fieldCopy.name();
                    }
                    break;
                }
            }
            Object value = sourceMap.get(fieldName);
            if(value == null){
                continue;
            }
            if(field.getType().isAnnotationPresent(ObjectCopy.class)){
                //自定义对象
                targetValue = deepCopy(value,field.getType().newInstance());
            }else if(CollectionFactory.isApproximableCollectionType(value.getClass())
                    && CollectionFactory.isApproximableCollectionType(field.getType())){
                //获取数组里面的泛型
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Class<?> actualTypeArgument = (Class<?>)parameterizedType.getActualTypeArguments()[0];
                //获取源Collection
                Collection list = (Collection)value;
                //创建Collection
                Collection targetList = CollectionFactory.createCollection(field.getType(),list.size());
                Iterator iterator = list.iterator();
                while (iterator.hasNext()){
                    Object targetItem;
                    Object item = iterator.next();
                    if(actualTypeArgument.isAnnotationPresent(ObjectCopy.class)){
                        targetItem = deepCopy(item,actualTypeArgument.newInstance());
                    }else{
                        targetItem = item;
                    }
                    targetList.add(targetItem);
                }
                targetValue = targetList;
            }else {
                targetValue = value;
            }
            field.set(target,targetValue);
        }
        return target;
    }

    public static Field[] getAllFields(Object object){
        Class clazz = object.getClass();
        return getAllFields(clazz);
    }

    public static Field[] getAllFields(Class clazz){
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
