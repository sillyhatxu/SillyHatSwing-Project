package com.sillyhat.learningenglish.utils;

import com.sillyhat.learningenglish.business.message.dto.YouDaoDTO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by ${XUSHIKUAN} on 2017-03-18.
 */
public class HttpUtils {


    public static YouDaoDTO requestHttpGetToYouDao(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream inputStream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (YouDaoDTO) JsonUtils.jsonToObject(result,YouDaoDTO.class);
    }

    public static Map<String,Object> requestHttpGetToYouDaoReturnMap(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream inputStream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return JsonUtils.jsonToMap(result);
    }

    public static void main(String[] args) {
        String url = "http://fanyi.youdao.com/openapi.do";
        String params = "keyfrom=SillyHatYouDao&key=987724779&type=data&doctype=json&version=1.1&q=interface";
        //发送 GET 请求
        Map<String,Object> map = HttpUtils.requestHttpGetToYouDaoReturnMap(url, params);
        System.out.println("-------------------" + map);
        System.out.println("errorCode--------------" + map.get("errorCode"));
        System.out.println("query--------------" + map.get("query"));
        System.out.println("basic--------------" + map.get("basic"));
        System.out.println("translation--------------" + map.get("translation"));
        System.out.println("web--------------" + map.get("web"));
//        YouDaoDTO dto = HttpUtils.requestHttpGetToYouDao(url, params);
//        System.out.println("errorCode--------------" + dto.getErrorCode());
//        System.out.println("query--------------" + dto.getQuery());
//        if(dto.getBasic() != null){
//            System.out.println("basic--------------" + dto.getBasic().size());
//            for (int i = 0; i < dto.getBasic().size(); i++) {
//                Map<String,Object> basicMap = dto.getBasic().get(i);
//                System.out.println("basicDTO -- [" + i + "] --- " + basicMap.toString());
//            }
//        }
//        if(dto.getTranslation() != null){
//            System.out.println("translation--------------" + dto.getTranslation().size());
//            for (int i = 0; i < dto.getTranslation().size(); i++) {
//                String translation = dto.getTranslation().get(i);
//                System.out.println("translation  -- [" + i + "] --- " + translation);
//            }
//        }
//        if(dto.getWeb() != null){
//            System.out.println("web--------------" + dto.getWeb().size());
//            for (int i = 0; i < dto.getWeb().size(); i++) {
//                YouDaoWebDTO webDTO = dto.getWeb().get(i);
//                System.out.println("webDTO  -- [" + i + "] --- " + webDTO.toString());
//            }
//        }
    }
}
