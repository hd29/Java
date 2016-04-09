package com.hncares.serviceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hncares.daoI.ILoginDao;
import com.hncares.serviceI.Account;
import com.opensymphony.xwork2.ActionContext;
@Service
public class AccountImpl implements Account {
	@Autowired
	private ILoginDao loginDao;
	public boolean login(String username, String password) {
		boolean ok =  false;
		ok = loginDao.login(username,password);
		if(ok){
			
			ActionContext.getContext().getSession().put("user", username);;

//			HttpSession session = (HttpSession) ActionContext.getContext().getSession();
		}
		return ok;
	}

	public boolean register(Integer id,String username, String password, String password2) {
		// TODO Auto-generated method stub
		if(password.equals(password2))
		    return loginDao.register(id,username,password);
		else
			return false;
	}

}
