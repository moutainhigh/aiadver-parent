package com.aiadver.framework.microservice.util;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author george
 */
public class CommonUtils {

    public static String getString(Set<String> set) {
        if (set == null) {
            return null;
        }
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
        Arrays.stream(source.getClass().getDeclaredFields()).forEach(field -> {
            if (Modifier.isStatic(field.getModifiers())) {
                return;
            }
            field.setAccessible(true);
            try {
                if (field.get(source) != null) {
                    field.set(target, field.get(source));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return target;
    }
}
