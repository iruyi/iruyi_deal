package com.faxintong.iruyi.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.Pool;

import java.io.*;
import java.util.Properties;

/**
 *
 */
public class RedisUtils {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static JedisPool pool;
    private static int expireTime = 120;

    static {
        try {
            pool = RedisConfiguration.configuration();
            String expireTimeObj = RedisConfiguration.props.getProperty("EXPIRE_TIME");
            expireTime = StringUtils.isBlank(expireTimeObj) ? expireTime : Integer.valueOf(expireTimeObj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Jedis getJedisInstance() throws IOException {
        if (null == pool) {
            pool = RedisConfiguration.configuration();
        }
        Jedis jedis = pool.getResource();
        if (RedisConfiguration.props.containsKey("DATABASE_ID")) {
            String database = RedisConfiguration.props
                    .getProperty("DATABASE_ID");
            if (database.matches("[0-9]+")) {
                jedis.select(Integer.parseInt(database));
            }
        }
        return jedis;
    }

    private static void closeJedis(Jedis jedis) {
        logger.info("关闭jedis对象"+jedis);
        if (null != jedis) {
            pool.returnResource(jedis);
            logger.info("closeJedis 返回后jedis 对象="+jedis);
        }
    }

    public static void destroyPool() {
        if (null != pool) {
            pool.destroy();
        }
    }

    /**
     * 获取Jedis 实例
     *
     * @return
     */
    private static Jedis getJedis(){
        Jedis jedis = null;
        try {
            jedis = getJedisInstance();
            return jedis;
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("从缓存中得到Jedis实例时出错,e="+e.getMessage());
            RedisUtils.closeJedis(jedis);
            return null;
        }
    }

    /**
     * Jedis set 方法
     * @param key
     * @param value
     */
    public static void set(String key,String value) {
        Jedis jedis = getJedis();
        try {
            jedis.set(key, value);
            //jedis.expire(key, expireTime);
            logger.info("向缓存中写入数据,key="+key+",value="+value);
        } catch (Exception e) {
            e.printStackTrace();
            RedisUtils.closeJedis(jedis);
            logger.info("将对象放入缓存时发生异常,key=" + key + ",value=" + value + ",e=" + e.getMessage());
        } finally {
            RedisUtils.closeJedis(jedis);
        }
    }

    public static void set(String key,String value,int expireTime) {
        Jedis jedis = getJedis();
        try {
            jedis.set(key, value);
            jedis.expire(key, expireTime);
            logger.info("向缓存中写入数据,key="+key+",value="+value);
        } catch (Exception e) {
            e.printStackTrace();
            RedisUtils.closeJedis(jedis);
            logger.info("将对象放入缓存时发生异常,key=" + key + ",value=" + value + ",e=" + e.getMessage());
        } finally {
            RedisUtils.closeJedis(jedis);
        }
    }

    /**
     * Jedis get 方法
     * @param key
     * @return
     */
    public static String get(String key) {
        Jedis jedis = getJedis();
        String value = null;
        try {
            value = jedis.get(key);
            logger.info("从缓存中获得数据nameKey="+key+",cacheValue="+value);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("从缓存中获取对象发生异常,key="+key+",e="+e.getMessage());
            RedisUtils.closeJedis(jedis);
        } finally {
            RedisUtils.closeJedis(jedis);
        }
        return value;
    } 

    public static void setSerializable(String key, Serializable serializable){
        Jedis jedis = getJedis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            jedis.set(key.getBytes(), byteArrayOutputStream.toByteArray());
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            logger.debug("序列化失败");
            closeJedis(jedis);
            e.printStackTrace();
        }finally {
            closeJedis(jedis);
        }

    }

    public static Object getSerializable(String key){
        Jedis jedis = getJedis();
        byte[] bytes = jedis.get(key.getBytes());
        ByteArrayInputStream bas = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream ois = new ObjectInputStream(bas);
            Object object = ois.readObject();
            bas.close();
            ois.close();
            return object;
        } catch (Exception e) {
            logger.debug("反序列化失败");
            e.printStackTrace();
            closeJedis(jedis);
        }finally {
            closeJedis(jedis);
        }
        Object o = jedis.get(key);
        return o;
    }

    public static boolean exists(String key){
        Jedis jedis = getJedis();
        boolean exists = jedis.exists(key);
        closeJedis(jedis);
        return exists;
    }

    public static Long del(String key){
        Jedis jedis = getJedis();
        Long delResult = jedis.del(key);
        closeJedis(jedis);
        return delResult;
    }
}
