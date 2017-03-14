package com.sillyhat.learningenglish.utils.cache;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//Description: 管理缓存 
//可扩展的功能：当chche到内存溢出时必须清除掉最早期的一些缓存对象，这就要求对每个缓存对象保存创建时间 
public class CacheManager {
	
	private static Logger logger = Logger.getLogger(CacheManager.class);
	
	private static HashMap<String,Object> cacheMap = new HashMap<String,Object>();

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>单实例构造方法
	 */
	private CacheManager() {
		super();
	}

	/**
	 * <p>Title: hasCache</p>
	 * <p>Description: </p>判断是否存在一个缓存
	 * @param key
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	private synchronized static boolean hasCache(String key) {
		return cacheMap.containsKey(key);
	}
		
	/**
	 * <p>Title: getCache</p>
	 * <p>Description: </p>得到缓存。同步静态方法
	 * @param key
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	private synchronized static Cache getCache(String key) {
		return (Cache) cacheMap.get(key);
	}
	
	/**
	 * <p>Title: getSimpleFlag</p>
	 * <p>Description: </p>获取布尔值的缓存
	 * @param key
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static boolean getSimpleFlag(String key) {
		try {
			return (Boolean) cacheMap.get(key);
		} catch (NullPointerException e) {
			logger.error("key no exist:" + key,e);
			return false;
		}
	}
	
	public static String getString(String key) {
		try {
			return (String) cacheMap.get(key);
		} catch (NullPointerException e) {
			logger.error("key no exist:" + key,e);
			return "";
		}
	}

	/**
	 * <p>Title: getServerStartdt</p>
	 * <p>Description: </p>获得Long的缓存
	 * @param key
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static long getServerStartdt(String key) {
		try {
			return (Long) cacheMap.get(key);
		} catch (Exception e) {
			logger.error("key no exist:" + key,e);
			return 0;
		}
	}
	
	/**
	 * <p>Title: getCacheInstance</p>
	 * <p>Description: </p>获取缓存信息
	 * @param key
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static Cache getCacheInstance(String key) {
		if (hasCache(key)) {
			Cache cache = getCache(key);
			if (cacheExpired(cache)) {
				//调用判断是否终止方法
				cache.setExpired(true);
			}
			return cache;
		} else
			return null;
	}

	/**
	 * <p>Title: setSimpleFlag</p>
	 * <p>Description: </p>设置布尔值的缓存
	 * @param key
	 * @param flag
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public synchronized static boolean setSimpleFlag(String key,boolean flag){ 
       if (flag && getSimpleFlag(key)) {//假如为真不允许被覆盖
    	   logger.info("key exist");
           return false; 
       }else{ 
           cacheMap.put(key, flag); 
           return true; 
       } 
    }
	
	public synchronized static boolean setString(String key,String value){ 
		String cacheValue = getString(key);
		if(null != null && !"".equals(cacheValue)){
			logger.info("key exist");
			return false; 
		}else{
			cacheMap.put(key, value); 
			return true;
		}
	}
	
	public synchronized static boolean setSimpleFlag(String key,long serverbegrundt) {
		if (cacheMap.get(key) == null) {
			cacheMap.put(key, serverbegrundt);
			return true;
		} else {
			return false;
		}
	}


	// 清除某一类特定缓存,通过遍历HASHMAP下的所有对象，来判断它的KEY与传入的TYPE是否匹配
	public synchronized static void clearAll(String type) {
		Iterator i = cacheMap.entrySet().iterator();
		String key;
		ArrayList arr = new ArrayList();
		try {
			while (i.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
				key = (String) entry.getKey();
				if (key.startsWith(type)) { // 如果匹配则删除掉
					arr.add(key);
				}
			}
			for (int k = 0; k > arr.size(); k++) {
				clearOnly(arr.get(k));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * <p>Title: clearAll</p>
	 * <p>Description: </p>清除所有缓存
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public synchronized static void clearAll() {
		cacheMap.clear();
	}
	
	/**
	 * <p>Title: clearOnly</p>
	 * <p>Description: </p>清除指定的缓存
	 * @param object
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public synchronized static void clearOnly(Object object) {
		cacheMap.remove(object);
	}

	/**
	 * <p>Title: putCache</p>
	 * <p>Description: </p>载入缓存
	 * @param key
	 * @param obj
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public synchronized static void putCache(String key, Cache obj) {
		cacheMap.put(key, obj);
	}


	/**
	 * <p>Title: putCacheInfo</p>
	 * <p>Description: </p>载入缓存信息
	 * @param key
	 * @param obj
	 * @param dt
	 * @param expired
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static void putCacheInfo(String key, Cache obj, long dt,boolean expired) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt + System.currentTimeMillis()); // 设置多久后更新缓存
		cache.setValue(obj);
		cache.setExpired(expired); // 缓存默认载入时，终止状态为FALSE
		cacheMap.put(key, cache);
	}

	/**
	 * <p>Title: putCacheInfo</p>
	 * <p>Description: </p>重写载入缓存信息方法
	 * @param key
	 * @param obj
	 * @param dt
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static void putCacheInfo(String key, Cache obj, long dt) {
		Cache cache = new Cache();
		cache.setKey(key);
		cache.setTimeOut(dt + System.currentTimeMillis());
		cache.setValue(obj);
		cache.setExpired(false);
		cacheMap.put(key, cache);
	}

	/**
	 * <p>Title: cacheExpired</p>
	 * <p>Description: </p>判断缓存是否终止
	 * @param cache
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static boolean cacheExpired(Cache cache) { 
       if (null == cache) { //传入的缓存不存在 
           return false; 
       } 
       long nowDt = System.currentTimeMillis(); //系统当前的毫秒数 
       long cacheDt = cache.getTimeOut(); //缓存内的过期毫秒数 
       if (cacheDt <= 0||cacheDt >= nowDt) { //过期时间小于等于零时,或者过期时间大于当前时间时，则为FALSE 
           return false; 
       } else { //大于过期时间 即过期 
           return true; 
       } 
   }
	//获取缓存中的大小
	public static int getCacheSize() {
		return cacheMap.size();
	}

	// 获取指定的类型的大小
	public static int getCacheSize(String type) {
		int k = 0;
		Iterator i = cacheMap.entrySet().iterator();
		String key;
		try {
			while (i.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
				key = (String) entry.getKey();
				if (key.indexOf(type) != -1) { // 如果匹配则删除掉
					k++;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return k;
	}

	/**
	 * <p>Title: getCacheAllkey</p>
	 * <p>Description: </p>获取缓存对象中的所有键值名称
	 * @return
	 * @author XUSHIKUAN642
	 * @date 2016-11-17
	 */
	public static ArrayList<String> getCacheAllkey() {
		ArrayList<String> a = new ArrayList<String>();
		try {
			Iterator i = cacheMap.entrySet().iterator();
			while (i.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
				a.add((String) entry.getKey());
			}
		} catch (Exception e) {
			logger.error("getCacheAllkey error",e);
		} finally {
			return a;
		}
	}

	// 获取缓存对象中指定类型 的键值名称
	public static ArrayList getCacheListkey(String type) {
		ArrayList a = new ArrayList();
		String key;
		try {
			Iterator i = cacheMap.entrySet().iterator();
			while (i.hasNext()) {
				java.util.Map.Entry entry = (java.util.Map.Entry) i.next();
				key = (String) entry.getKey();
				if (key.indexOf(type) != -1) {
					a.add(key);
				}
			}
		} catch (Exception e) {
			logger.error("getCacheListkey error",e);
		} finally {
			return a;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(CacheManager.setString("test", "hahhahahhah"));
		System.out.println(CacheManager.getString("test"));
	}

}