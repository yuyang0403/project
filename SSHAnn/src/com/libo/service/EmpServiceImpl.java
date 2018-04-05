package com.libo.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.libo.dao.EmpDao;
import com.libo.po.Emp;
@Service("empService")
@Transactional
public class EmpServiceImpl implements EmpService {
	@Resource
	private EmpDao empDao;
	@Override
	public List<Emp> query() {
		return empDao.query();
	}

}
