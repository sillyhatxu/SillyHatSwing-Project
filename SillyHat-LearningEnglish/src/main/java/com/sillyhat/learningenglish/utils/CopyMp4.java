package com.sillyhat.learningenglish.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/*
 * 需求：把D:\music\音乐\Beyond - 不再犹豫.mp3复制到当前项目目录下的copy.mp4中
 *
 * 字节流四种方式复制文件：
 * 基本字节流一次读写一个字节：
 * 基本字节流一次读写一个字节数组：
 * 高效字节流一次读写一个字节：
 * 高效字节流一次读写一个字节数组：
 */
public class CopyMp4 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //分别针对四种方式各创建一个方法，
        //参数列表：String 数据源  String 目的地
        //返回类型 void
//        method1("F:\\downlands\\speech.mp3","F:\\downlands\\copy.mp3");
        //method2("D:\\music\\音乐\\Beyond - 不再犹豫.mp3","copy.mp3");
        //method3("D:\\music\\音乐\\Beyond - 不再犹豫.mp3","copy.mp3");
        //method4("D:\\music\\音乐\\Beyond - 不再犹豫.mp3","copy.mp3");
//        long end = System.currentTimeMillis();
//        System.out.println(end);
//        System.out.println("一共耗时"+(end - start)+"毫秒");
        String word = "interface";
        String url = "http://dict.youdao.com/speech";
        String params = "audio=" + word;
        String filePath = "F:\\downlands\\" + word + ".mp3";
        CopyMp4.copyByYouDao(url,params,filePath);
    }

    private static void copyByYouDao(String url, String param,String filePath) throws IOException {
        InputStream inputStream = null;
        FileOutputStream fos = null;
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
            inputStream = connection.getInputStream();
            fos = new FileOutputStream(filePath);
            byte[] b = new byte[10*1024];
            while(inputStream.read(b,0,10240) != -1){
                fos.write(b,0,10240);
            }
            fos.flush();
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            inputStream.close();
        }
    }
    private static void method4(String start , String end) throws IOException {
        //高效字节流一次读写一个字节数组
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(start));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(end));
        byte[] by = new byte[1024];
        int lend = 0;
        while((lend = in.read(by)) != -1){
            out.write(by,0,lend);
        }
        in.close();
        out.close();

    }

    private static void method3(String start , String end) throws IOException {
        // 高效字节流一次读写一个字节
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(start));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(end));
        int lend = 0;
        while(( lend = in.read()) != -1){
            out.write(lend);
        }
        in.close();
        out.close();
    }

    private static void method2(String start , String end) throws IOException {
        // 基本字节流一次读写一个字节数组
        FileInputStream in = new FileInputStream(start);
        FileOutputStream out = new FileOutputStream(end);

        byte[] by = new byte[1024];
        int lend = 0;
        while((lend = in.read(by)) != -1){
            out.write(by,0,lend);
        }
        in.close();
        out.close();

    }

    private static void method1(String start , String end) throws IOException {
        // 基本字节流一次读写一个字节
        //创建基本字节输入流，以便从数据源读取文件
        FileInputStream in = new FileInputStream(start);
        //创建基本字节输出流，以便写入数据到目的地
        FileOutputStream out = new FileOutputStream(end);
        //复制目标文件
        int i = 0;
        while((i = in.read()) != -1){
            out.write(i);
        }
        in.close();
        out.close();

    }

}