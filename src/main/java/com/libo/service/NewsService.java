package com.libo.service;

import java.util.List;
import java.util.Map;

import com.libo.po.News;

public interface NewsService {
	public Boolean saveOrUpdate(News news);
	public void del(String id);
	public List<Map<String, String>> query(long currentPage,long pageSize);
}
