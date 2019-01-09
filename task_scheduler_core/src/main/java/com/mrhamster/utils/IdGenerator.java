package com.mrhamster.utils;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static Map<Class<?>, Integer> idMap = new HashMap<>();

    public static Integer generateId(Class<?> clazz){
        Integer id = idMap.getOrDefault(clazz, -1);
        idMap.put(clazz, ++id);
        return id;
    }
}
