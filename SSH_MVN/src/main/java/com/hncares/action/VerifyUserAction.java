package com.hncares.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.hncares.entity.Users;
import com.hncares.serviceI.ADUQService;

public class VerifyUserAction implements ServletRequestAware{
	
	@Autowired
	ADUQService aduqServiceImpl ;
	
	private int userid;
	private String username;
	private HttpServletRequest request;
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String msg() {

		List<Users> list = aduqServiceImpl.query(userid);
		System.out.println(userid);
		if(list.size()>0)
			request.setAttribute("msg", "ID不可用");
		else
			request.setAttribute("msg", "ID可用!");
			
		return "success";
	}
	
}
