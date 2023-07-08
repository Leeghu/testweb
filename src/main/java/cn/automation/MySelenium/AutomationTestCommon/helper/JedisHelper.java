package cn.automation.MySelenium.AutomationTestCommon.helper;

import cn.automation.MySelenium.AutomationTestCommon.abstr.RedisConnection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

public class JedisHelper {
    private RedisConnection RedisConn = new RedisConnection();
    Jedis jedisConn = RedisConnection.getJedisInst();

    public JedisHelper() {
        if (jedisConn == null) {
            jedisConn = RedisConn.getConnection();
        }
    }

    /**
     * 设置指定key的值
     * @param key
     * @param value
     */
    public static void set(String key, String value) {
        new JedisHelper().jedisConn.set(key, value);
    }

    /**
     * 清空redis指定db
     */
    public static void flushDB() {
        try {
            new JedisHelper().jedisConn.flushDB();
            close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取指定key的值
     * @param key
     * @return
     */
    public static String get(String key) {
        return new JedisHelper().jedisConn.get(key);
    }

    /**
     * 删除指定key
     * @param key
     */
    public static void delete(String key) {
        try {
            if (new JedisHelper().jedisConn == null || !(new JedisHelper().jedisConn.isConnected())){

            }
            new JedisHelper().jedisConn.del(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加key
     * @param key
     */
    public static void add(String key) {
        new JedisHelper().jedisConn.type(key);
    }

    /**
     * 关闭redis连接
     */
    public static void close() {
        if(new JedisHelper().jedisConn != null) {
            try {
                new JedisHelper().jedisConn.close();
            } catch (JedisException e) {
                e.printStackTrace();
            }
        }
    }
}
