package com.faxintong.iruyi.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 读取redis配置（reids.properties），并建立redis 连接池
 * 
 * @author hehj
 *
 */
public class RedisConfiguration {

    public static Properties props = new Properties();

    public static  String propertyRedis = "/redis.properties";
    public static JedisPool configuration() throws IOException {
    	
    	try {
    		InputStream in = RedisConfiguration.class.getResourceAsStream(propertyRedis);
    		props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        JedisPoolConfig config = configJedisPoolParams(props);
        String host = props.getProperty("JEDIS_HOST");
        String port = props.getProperty("JEDIS_PORT");
        int ports = 6379;
        if(port!=null&&!"".equals(port)){
        	ports = Integer.valueOf(port);
        }
        JedisPool pool = new JedisPool(config,host,ports);
        return pool;
    }
    
    /**
     * 取得配置中的属性值
     * @param key
     * @return
     */
    public static String getProp(String key){
    	try {
    		InputStream in = RedisConfiguration.class.getResourceAsStream(propertyRedis);
    		props.load(in);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        String value = props.getProperty(key);
        return value;
    }

    private static JedisPoolConfig configJedisPoolParams(Properties props) {
        JedisPoolConfig config = new JedisPoolConfig();

        if (null != props) {
            if (!StringUtils.isBlank(props.getProperty("MAXIDLE"))) {
                config.setMaxIdle(Integer.parseInt(props.getProperty("MAXIDLE")));
            }
            if (!StringUtils.isBlank(props.getProperty("MINEVICTABLEIDLETIMEMILLIS"))) {
                config.setMinEvictableIdleTimeMillis(Long.parseLong(props.getProperty("MINEVICTABLEIDLETIMEMILLIS")));
            }
            if (!StringUtils.isBlank(props.getProperty("MINIDLE"))) {
                config.setMinIdle(Integer.parseInt(props.getProperty("MINIDLE")));
            }
            if (!StringUtils.isBlank(props.getProperty("NUMTESTSPEREVICTIONRUN"))) {
                config.setNumTestsPerEvictionRun(Integer.parseInt(props.getProperty("NUMTESTSPEREVICTIONRUN")));
            }
            if (!StringUtils.isBlank(props.getProperty("SOFTMINEVICTABLEIDLETIMEMILLIS"))) {
                config.setSoftMinEvictableIdleTimeMillis(Long.parseLong(props
                        .getProperty("SOFTMINEVICTABLEIDLETIMEMILLIS")));
            }
            if (!StringUtils.isBlank(props.getProperty("TESTONBORROW"))) {
                config.setTestOnBorrow(Boolean.getBoolean(props.getProperty("TESTONBORROW")));
            }
            if (!StringUtils.isBlank(props.getProperty("TESTONRETURN"))) {
                config.setTestOnReturn(Boolean.getBoolean(props.getProperty("TESTONRETURN")));
            }
            if (!StringUtils.isBlank(props.getProperty("TESTWHILEIDLE"))) {
                config.setTestWhileIdle(Boolean.getBoolean(props.getProperty("TESTWHILEIDLE")));
            }
            if (!StringUtils.isBlank(props.getProperty("TIMEBETWEENEVICTIONRUNSMILLIS"))) {
                config.setTimeBetweenEvictionRunsMillis(Long.parseLong(props
                        .getProperty("TIMEBETWEENEVICTIONRUNSMILLIS")));
            }
        }

        return config;
    }

}
