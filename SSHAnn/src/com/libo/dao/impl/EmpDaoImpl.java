package com.libo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.libo.dao.EmpDao;
import com.libo.po.Emp;
import com.libo.util.HibernateUtil;
@Repository("empDao")
public class EmpDaoImpl extends HibernateUtil implements EmpDao {

	@Override
	public List<Emp> query() {
		return this.getSessionFactory().getCurrentSession().createQuery("from Emp").list();
	}

}
