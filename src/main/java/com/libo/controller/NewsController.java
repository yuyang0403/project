package com.libo.controller;

import java.util.Map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.libo.po.News;
import com.libo.service.NewsService;
import com.libo.util.Util;

@Controller
@RequestMapping("news")
public class NewsController {
	@Autowired
	NewsService newsService;
	@RequestMapping("query")
	public String query(Long current,Model m){
		current=current==null?1:current;
		List<Map<String, String>> maps=newsService.query(current, Util.pageSize);
		m.addAttribute("list", maps);
		return "/index.jsp";
	}
	@RequestMapping("save")
	public String save(News news){
		boolean flag=newsService.saveOrUpdate(news);
		return "redirect:/mvc/news/query";
	}
}
