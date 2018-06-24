package com.cctv.http;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;

public class JedisConnect {
public static void main(String[] args) {
		
		JedisPoolConfig poocfg = new JedisPoolConfig();
		
		
		
		Jedis jedis = new Jedis("localhost",6379);
		int i = 0;
		try {
			
			long start = System.currentTimeMillis();
			while(true){
				long end = System.currentTimeMillis();
				if(end - start >= 1000){
					break;
				}
				
				jedis.set("TESTL_"+ i, i+"");
				i++;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jedis.close();
		System.err.println("当前redis数据量为:"+jedis.dbSize());
		System.err.println("一秒钟写入次数为:"+i+"");
	}
}
