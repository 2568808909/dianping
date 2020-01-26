package com.ccb.dianping.common.util;

import com.ccb.dianping.common.annotation.FieldMapping;

import java.lang.reflect.Field;
import java.util.Optional;

public class ReflectUtils {

    /**
     * 将一个对象转换为另一个指定类型对象，通过FieldMapping注解来给目标对象赋值
     * @param source 源对象
     * @param targetClass 目标对象的类型
     * @param <T> 目标对象泛型
     * @return 返回目标对象
     * @throws IllegalAccessException 目标对象创建失败时抛出
     * @throws InstantiationException 目标对象创建失败时抛出
     * @throws NoSuchFieldException 目标对象中没有指定属性时抛出该异常
     */
    public static <T> T convertTo(Object source, Class<T> targetClass)
            throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> sourceClass = source.getClass();
        Field[] fields = sourceClass.getDeclaredFields();
        T t = targetClass.newInstance();
        for (Field field : fields) {
            FieldMapping fieldMapping = field.getAnnotation(FieldMapping.class);
            String fieldName = Optional.ofNullable(fieldMapping)
                    .map(FieldMapping::value)
                    .orElse(field.getName());
            Field targetFiled = targetClass.getDeclaredField(fieldName);
            targetFiled.setAccessible(true);
            field.setAccessible(true);
            targetFiled.set(t, field.get(source));
        }
        return t;
    }
}
