package com.sillyhat.learningenglish.utils.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sillyhat.learningenglish.business.system.dto.UserDTO;
import com.sillyhat.learningenglish.business.system.service.UserService;
import com.sillyhat.learningenglish.utils.Constants;
import com.sillyhat.learningenglish.utils.SpringUtils;
import org.apache.log4j.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * UserCache
 *
 * @author 徐士宽
 * @date 2017/3/15 16:41
 */
public class UserCache {

    private static Logger logger = Logger.getLogger(UserCache.class);

    private static UserService userService = (UserService) SpringUtils.getInstance().getContext().getBean(UserService.class);

    public static LoadingCache<String, UserDTO> cache = CacheBuilder.newBuilder()
//        .refreshAfterWrite(10, TimeUnit.SECONDS)// 给定时间内没有被读/写访问，则回收。
//        .expireAfterAccess(10, TimeUnit.SECONDS)//设置过期时间
        .refreshAfterWrite(1, TimeUnit.HOURS)// 给定时间内没有被读/写访问，则回收。
        .expireAfterAccess(1, TimeUnit.HOURS)//设置过期时间
        .maximumSize(1000).// 设置缓存个数
        build(new CacheLoader<String, UserDTO>() {
            @Override
            /** 当本地缓存命没有中时，调用load方法获取结果并将结果缓存 **/
            public UserDTO load(String key) throws Exception {
                return getCurrentUser(key);
            }

            /** 数据库进行查询 **/
            private UserDTO getCurrentUser(String key) throws Exception {
                return userService.getUserById(Constants.ADMINISTRATOR_ID);
            }
        }
    );

    public static UserDTO getCache(){
        try {
            return cache.get(Constants.CURRENT_USER);
        } catch (ExecutionException e) {
            logger.error("过去缓存内容异常",e);
            return null;
        }
    }

    public static void putCache(){
        cache.put(Constants.CURRENT_USER,null);
    }
}
