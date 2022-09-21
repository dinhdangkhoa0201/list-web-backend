package com.cms.listwebbackend.utils;

import com.google.gson.Gson;

public class GsonParserUtils {
    public static String parseObjectToString(Object o) {
        return new Gson().toJson(o);
    }

    public static <T> T parseStringToObject(String json, Class<T> classObject) {
        try {
            return new Gson().fromJson(json, classObject);
        } catch (Exception e) {
            return null;
        }
    }
}
