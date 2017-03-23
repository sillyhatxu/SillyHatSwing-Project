package com.sillyhat.learningenglish.utils.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sillyhat.learningenglish.business.learningplan.dto.TodayPlanDetailDTO;
import com.sillyhat.learningenglish.business.personalinformation.dto.UserDTO;
import com.sillyhat.learningenglish.business.personalinformation.service.UserService;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;

/**
 * UserCache
 *
 * @author 徐士宽
 * @date 2017/3/15 16:41
 */
public class SystemCache {

    private static Logger logger = Logger.getLogger(SystemCache.class);

    private static UserService userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);

    /**************************** 登录用户session    begin ********************************/
    public static LoadingCache<String, UserDTO> userCache = CacheBuilder.newBuilder()
//        .refreshAfterWrite(10, TimeUnit.SECONDS)// 给定时间内没有被读/写访问，则回收。
//        .expireAfterAccess(10, TimeUnit.SECONDS)//设置过期时间
//        .refreshAfterWrite(1, TimeUnit.HOURS)// 给定时间内没有被读/写访问，则回收。
//        .expireAfterAccess(1, TimeUnit.HOURS)//设置过期时间
        .maximumSize(10).// 设置缓存个数
        build(new CacheLoader<String, UserDTO>() {
            @Override
            /** 当本地缓存命没有中时，调用load方法获取结果并将结果缓存 **/
            public UserDTO load(String key) throws Exception {
                return null;//取消加载，同时取消过期时间
//                return getCurrentUser(key);
            }

            /** 数据库进行查询 **/
//            private UserDTO getCurrentUser(String key) throws Exception {
//                return userService.getUserById(Constants.ADMINISTRATOR_ID);
////                return userService.getUserById(key);
//            }
        }
    );

    public static UserDTO getUserCache(){
        try {
            return userCache.get(Constants.CURRENT_USER);
        } catch (ExecutionException e) {
            logger.error("过去缓存内容异常",e);
            return null;
        }
    }

    public static void putUserCache(String key,UserDTO dto){
        userCache.put(key,dto);
    }

    /**************************** 登录用户session    end ********************************/


    /**************************** 计数器    begin ********************************/
    public static LoadingCache<String, Integer> countCache = CacheBuilder.newBuilder().maximumSize(10).// 设置缓存个数
        build(new CacheLoader<String, Integer>() {
            @Override
            /** 当本地缓存命没有中时，调用load方法获取结果并将结果缓存 **/
            public Integer load(String key) throws Exception {
                return null;//取消加载，同时取消过期时间
            }
        }
    );

    public static Integer getCountCache(String key){
        try {
            return countCache.get(key);
        } catch (ExecutionException e) {
            logger.error("过去缓存内容异常",e);
            return null;
        }
    }

    public static void putCountCache(String key,int value){
        countCache.put(key,value);
    }
    /**************************** 计数器    begin ********************************/


    /**************************** 今日计划    begin ********************************/
    public static LoadingCache<String, TodayPlanDetailDTO> todayPlanDetailCache = CacheBuilder.newBuilder().// 设置缓存个数
        build(new CacheLoader<String, TodayPlanDetailDTO>() {
            @Override
            /** 当本地缓存命没有中时，调用load方法获取结果并将结果缓存 **/
            public TodayPlanDetailDTO load(String key) throws Exception {
                return null;//取消加载，同时取消过期时间
            }
        }
    );

    public static TodayPlanDetailDTO getTodayPlanDetailCache(String key){
        try {
            return todayPlanDetailCache.get(key);
        } catch (ExecutionException e) {
            logger.error("过去缓存内容异常",e);
            return null;
        }
    }

    public static void putTodayPlanDetailCache(String key,TodayPlanDetailDTO value){
        todayPlanDetailCache.put(key,value);
    }

    /**************************** 今日计划    end ********************************/

}
