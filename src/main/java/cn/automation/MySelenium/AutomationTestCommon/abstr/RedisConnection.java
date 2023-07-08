package cn.automation.MySelenium.AutomationTestCommon.abstr;

import cn.automation.MySelenium.AutomationTestCommon.util.Constants;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisException;

public class RedisConnection {
    private static final ThreadLocal<Jedis> redisConnectionHolder = new ThreadLocal<>();

    public static void setJedisInst(Jedis jedisInst) { redisConnectionHolder.set(jedisInst); }
    public static Jedis getJedisInst() { return redisConnectionHolder.get(); }
    @SuppressWarnings("resource")
    public Jedis getConnection(){
        Jedis conn = null;
        try {
            JedisPoolConfig jpc = new JedisPoolConfig();
            jpc.setMaxIdle(20);
            jpc.setMaxTotal(50);
            JedisPool jp = new JedisPool(jpc, Constants.REDIS_HOST, Integer.parseInt(Constants.REDIS_PORT));
            conn = jp.getResource();
            conn.select(Integer.parseInt(Constants.REDIS_DB));
            System.out.println(conn);
            //
//            jp.returnResource(jedis);
        } catch (JedisException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取redis连接池(有线程保护)
     * @return
     */
    public Jedis getRedisConnection(){
        Jedis conn = redisConnectionHolder.get();
        try{
            if (conn == null || !(conn.isConnected())) {
                RedisConnection redis = new RedisConnection();
                Jedis con = redis.getConnection();
                setJedisInst(con);
                System.out.println("[Thread]" + Thread.currentThread().getName());
                return con;
                //
//                jp.returnResource(jedis);
            }else{
                return conn;
            }
        }catch (Exception e) {
            System.out.println("[ThreadLocal Get Connection Error]" + e.getMessage());
        }
        return null;
    }
    /**
     * 关闭redis连接
     */
    public void close(){
        Jedis conn = redisConnectionHolder.get();
        if (conn != null){
            try { conn.close(); conn = null; } catch(Exception e){ e.printStackTrace(); }
        }
    }

}
