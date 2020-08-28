package com.aiadver.framework.microservice.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonUtils {

    public static String getString(Set<String> set) {
        return set.stream().collect(Collectors.joining(","));
    }

    public static List<String> getList(String s) {
        return Arrays.asList(s.split(","));
    }

    public static <T> List<T> getList(Collection<T> collection) {
        return collection.stream().collect(Collectors.toList());
    }

    public static Set<String> getSet(String s) {
        return Arrays.stream(s.split(",")).collect(Collectors.toSet());
    }


    public static <T> T combine(T source, T target) {
        Class sourceBeanClass = source.getClass();
        Class targetBeanClass = target.getClass();

        Field[] sourceFields = sourceBeanClass.getDeclaredFields();
        Field[] targetFields = targetBeanClass.getDeclaredFields();
        for (int i = 0; i < sourceFields.length; i++) {
            Field sourceField = sourceFields[i];
            if (Modifier.isStatic(sourceField.getModifiers())) {
                continue;
            }
            Field targetField = targetFields[i];
            if (Modifier.isStatic(targetField.getModifiers())) {
                continue;
            }
            sourceField.setAccessible(true);
            targetField.setAccessible(true);
            try {
                if (sourceField.get(source) != null && !"serialVersionUID".equals(sourceField.getName().toString())) {
                    targetField.set(target, sourceField.get(source));
                }
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return target;
    }
}
