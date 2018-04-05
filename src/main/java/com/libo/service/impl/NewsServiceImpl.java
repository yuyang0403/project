package com.libo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libo.dao.NewsDao;
import com.libo.po.News;
import com.libo.service.NewsService;
@Service("newsService")
public class NewsServiceImpl implements NewsService {
	@Autowired
	NewsDao newsDao;
	@Override
	public Boolean saveOrUpdate(News news) {
		news.setCreateDate(new Date().toString());
		return newsDao.saveOrUpdate(news);
	}

	@Override
	public void del(String id) {
		newsDao.del(id);
	}

	@Override
	public List<Map<String, String>> query(long currentPage, long pageSize) {
		return newsDao.query(currentPage, pageSize);
	}

}
