package com.hncares.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.hncares.serviceI.Account;


public class AccountAction {
	
//	ApplicationContext context =
//		new ClassPathXmlApplicationContext("application.xml");
//	Account accountImpl = (Account) ADUQAction.context.getBean("accountImpl");
	@Autowired
	private Account accountImpl;
	private Integer userid;
	private String username;
	private String password;
	private String password1;


	

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String login(){
		System.out.println("accountImpl");
		System.out.println(username+password);
		if(accountImpl.login(username, password))
			return "success";
		else 
			return "failed";
			
	}
	
	public String register(){
	
		if(accountImpl.register(userid,username, password,password1))
			return "success";
		else 
			return "failed";
		
	}


}
