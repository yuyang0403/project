package com.libo.demo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

public class DemoTest {

	public void save(){
		Jedis j = new Jedis("192.168.247.131", 6379);
		j.select(3);
		String id=new Random().nextInt(1000)+"";
		String name=id+"张三";
		j.hset("user:"+id, "id", id);
		j.hset("user:"+id,"name",name);
		j.hset("user:"+id, "age", new Random().nextInt(100)+"");
		j.lpush("userid",id);
	}
	@Test
	public void test(){
		Jedis j = new Jedis("192.168.247.131", 6379);
		j.select(3);
		//先拿到数量
		long count=j.llen("userid");
		//定义每页显示10条
		int pageSize=10;
		int currentPage=5;
		long pageCount=count%10==0?count/10:count/10+1;
		//获取list中的数据
		List<String> userids=j.lrange("userid", (currentPage-1)*pageSize, pageSize*currentPage-1);
		for (String string : userids) {
			Map<String, String> map=get("user:"+string);
			Iterator<Entry<String, String>> i=map.entrySet().iterator();
			while(i.hasNext()){
				Entry<String, String> en=i.next();
				System.out.print(en.getKey()+"\t"+en.getValue()+"--");
			}
			System.out.println();
		}
		
	}
	@Test
	public void test2(){
		Jedis j = new Jedis("192.168.247.131", 6379);
		j.select(3);
		Transaction tx=j.multi();
		Response<String> res1=tx.set("name1", "张三");
		Response<String> res2=tx.set("name2", "李四");
		List<Object> objects=tx.exec();
		System.out.println("res1:"+res1.get());
		System.out.println("res2:"+res2.get());
		for (Object object : objects) {
			System.out.println(object);
		}
	}
	//hash根据key找map
	public Map<String, String> get(String id){
		Jedis j = new Jedis("192.168.247.131", 6379);
		j.select(3);
		Map<String, String> maps=j.hgetAll(id);
		return maps;
	}
	//查询所有的list  userid
	@Test
	public void test1(){
		Jedis j = new Jedis("192.168.247.131", 6379);
		j.select(3);
		List<String> list=j.lrange("userid", 0, 50);
		System.out.println(list.size());
		for (String string : list) {
			int count=0;
			System.out.println(string);
			for (String string2 : list) {
				if(string2.equals(string)){
					count++;
				}
			}
			System.out.println("\t"+count);
		}
	}
}
