package com.libo.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.libo.po.Emp;
import com.libo.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;

@Action(value = "empAction", results = { @Result(name = "success", location = "/index.jsp") })
@Namespace("/")
@ParentPackage("struts-default")
public class EmpAction extends ActionSupport {
	@Resource
	private EmpService empService;
	private List<Emp> list;
	
	public String query(){
		list=empService.query();
		return SUCCESS;
	}
	
	
	
	
	
	
	
	public List<Emp> getList() {
		return list;
	}
	public void setList(List<Emp> list) {
		this.list = list;
	}

}
