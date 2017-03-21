package com.sillyhat.learningenglish.utils;

import com.sillyhat.learningenglish.business.message.dto.YouDaoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

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
                logger.info(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream inputStream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            result = result.replaceAll("us-phonetic","usPhonetic").replaceAll("uk-phonetic","ukPhonetic");
            logger.info(result);
        } catch (Exception e) {
            logger.error("发送GET请求出现异常！",e);
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
        return JsonUtils.jsonToObject(result,YouDaoDTO.class);
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
                logger.info(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            InputStream inputStream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            result = result.replaceAll("us-phonetic","usPhonetic").replaceAll("uk-phonetic","ukPhonetic");
            logger.info(result);
        } catch (Exception e) {
            logger.error("发送GET请求出现异常！",e);
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
        return JsonUtils.jsonToObject(result,Map.class);
    }

    public static void main(String[] args) {
        String json = "{\"translation\":[\"接口\"],\"basic\":{\"us-phonetic\":\"'?nt?'fes\",\"phonetic\":\"'?nt?fe?s\",\"uk-phonetic\":\"'?nt?fe?s\",\"explains\":[\"n. 界面；<计>接口；交界面\",\"v. （使通过界面或接口）接合，连接；[计算机]使联系\",\"vi. 相互作用（或影响）；交流，交谈\"]},\"query\":\"interface\",\"errorCode\":0,\"web\":[{\"value\":[\"接口\",\"界面\",\"介面\"],\"key\":\"Interface\"},{\"value\":[\"通讯接口\",\"通信接口\",\"通信服务接口\"],\"key\":\"Communication Interface\"},{\"value\":[\"接口模式\"],\"key\":\"pattern interface\"}]}";
        logger.info(json);
        json = json.replaceAll("us-phonetic","usPhonetic").replaceAll("uk-phonetic","ukPhonetic");
        logger.info(json);
        YouDaoDTO dto = JsonUtils.jsonToObject(json,YouDaoDTO.class);
        logger.info(dto.toString());
    }
}
