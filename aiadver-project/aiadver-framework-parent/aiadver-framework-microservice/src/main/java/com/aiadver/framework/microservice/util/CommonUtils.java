package com.aiadver.framework.microservice.util;

import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author george
 */
public class CommonUtils {

    public static final List<String> TYPES = new ArrayList<String>();

    static {
        TYPES.add("java.lang.Integer");
        TYPES.add("java.lang.Double");
        TYPES.add("java.lang.Float");
        TYPES.add("java.lang.Long");
        TYPES.add("java.lang.Short");
        TYPES.add("java.lang.Byte");
        TYPES.add("java.lang.Boolean");
        TYPES.add("java.lang.Character");
        TYPES.add("java.lang.String");
        TYPES.add("int");
        TYPES.add("double");
        TYPES.add("long");
        TYPES.add("short");
        TYPES.add("byte");
        TYPES.add("boolean");
        TYPES.add("char");
        TYPES.add("float");
    }

    public static String getString(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return "";
        }
        return set.stream().collect(Collectors.joining(","));
    }

    public static List<String> getList(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.<String>emptyList();
        }
        return Arrays.asList(s.split(","));
    }

    public static <T> List<T> getList(Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return Collections.<T>emptyList();
        }
        return collection.stream().collect(Collectors.toList());
    }

    public static Set<String> getSet(String s) {
        if (s == null || s.isEmpty()) {
            return Collections.<String>emptySet();
        }
        return Arrays.stream(s.split(",")).collect(Collectors.toSet());
    }

    /**
     * 将source对象中的非空数据更新到target中
     *
     * @param source     更新源
     * @param target     更新目标
     * @param simpleFlag 简单更新标识
     * @param <T>        对象类型
     * @return 更新完成的对象
     */
    public static <T> T combine(T source, T target, boolean simpleFlag) {
        Arrays.stream(source.getClass().getDeclaredFields()).forEach(field -> {
            if (Modifier.isStatic(field.getModifiers())) {
                return;
            }
            field.setAccessible(true);
            try {
                if (field.get(source) != null) {
                    if (!simpleFlag || TYPES.contains(field.getType().getName())) {
                        field.set(target, field.get(source));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return target;
    }

    public static String getString(List<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return list.stream().collect(Collectors.joining(","));
    }
}
