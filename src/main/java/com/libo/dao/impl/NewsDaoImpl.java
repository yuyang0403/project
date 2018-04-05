package com.libo.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.libo.dao.NewsDao;
import com.libo.po.News;
import com.libo.util.Util;
@Repository("newsDao")
public class NewsDaoImpl implements NewsDao {
	//注入redisTemplate
	@Autowired
	RedisTemplate<Serializable, Serializable> reidsTemplate;
	@Override
	public Boolean saveOrUpdate(final News news) {
		//hash
		//T：返回值类型
		return reidsTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection arg0)
					throws DataAccessException {
				arg0.select(4);
				//添加
				arg0.hSet(("news:"+news.getId()).getBytes(), "id".getBytes(), news.getId().getBytes());
				arg0.hSet(("news:"+news.getId()).getBytes(), "title".getBytes(), news.getTitle().getBytes());
				arg0.hSet(("news:"+news.getId()).getBytes(), "author".getBytes(), news.getAuthor().getBytes());
				arg0.hSet(("news:"+news.getId()).getBytes(), "content".getBytes(), news.getContent().getBytes());
				arg0.hSet(("news:"+news.getId()).getBytes(), "createdate".getBytes(), news.getCreateDate().getBytes());
				//list添加ID
				arg0.lPush("newid".getBytes(), ("news:"+news.getId()).getBytes());
				return true;
			}
			
		});
	}

	@Override
	public void del(final String id) {
		reidsTemplate.execute(new RedisCallback<Boolean>() {

			@Override
			public Boolean doInRedis(RedisConnection arg0)
					throws DataAccessException {
				//删除list
				arg0.lRem("newid".getBytes(), 1, id.getBytes());
				//hash
				arg0.del(id.getBytes());
				return true;
			}
			
		});
	}

	@Override
	public List<Map<String, String>> query(final long currentPage,final long pageSize) {
		//获取ID
		return reidsTemplate.execute(new RedisCallback<List<Map<String, String>>>() {
			@Override
			public List<Map<String, String>> doInRedis(RedisConnection arg0)
					throws DataAccessException {
				arg0.select(4);
				List<Map<String, String>> maps=new ArrayList<Map<String,String>>();
				//获取list中的id
				//long count=arg0.lLen("newid".getBytes());
				//获取当前页的id
				System.out.println(currentPage);
				System.out.println(pageSize);
				List<byte[]> newids=arg0.lRange("newid".getBytes(), (currentPage-1)*pageSize, currentPage*pageSize-1);
				for (byte[] bs : newids) {
					Map<byte[], byte[]> map=arg0.hGetAll(bs);
					maps.add(Util.mapToMap(map));
				}
				return maps;
			}
			
		});
	}

}
