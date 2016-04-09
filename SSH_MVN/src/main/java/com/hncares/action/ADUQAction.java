package com.hncares.action;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.hncares.entity.Users;
import com.hncares.serviceI.ADUQService;

public class ADUQAction {

	@Autowired
	ADUQService aduqServiceImpl ;

	private int id;
	private String username;
	private String password;

	public String execute() {
		try {
			aduqServiceImpl.add(id,username, password);
			return "success";
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(1111111);
			return "failed";
		}
	}
	
	public String delete(){
		try {
			System.out.println("shifuoweinull"+aduqServiceImpl);
			aduqServiceImpl.delete(id);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	public String update(){
		try {
			aduqServiceImpl.update(id,password);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failed";
		}
	}
	
	public String query(){
		List<Users> list = aduqServiceImpl.query(id);
		if(list.size()>0){
			for(int i=0;i<list.size();i++)
			{
				System.out.println("\nID号："+list.get(i).getId()+"\n"
						+"密码："+list.get(i).getPassword()+"\n"
						+"账号："+list.get(i).getUsername()
				);
			}
			return "success";
		}else {
			System.out.println("没有数据");
			return "failed";
		}
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


}
