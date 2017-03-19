package com.sillyhat.learningenglish.utils;

import net.sf.json.JSONObject;

import java.util.Map;

/**
 * Created by ${XUSHIKUAN} on 2017-03-18.
 */
public class JsonUtils {

    public static Object jsonToObject(String jsonStr,Class _class){
        JSONObject jsonBean = JSONObject.fromObject(jsonStr);
        return JSONObject.toBean(jsonBean, _class);
    }

    public static Map<String,Object> jsonToMap(String jsonStr){
        return (Map<String, Object>) jsonToObject(jsonStr,Map.class);
    }
}
