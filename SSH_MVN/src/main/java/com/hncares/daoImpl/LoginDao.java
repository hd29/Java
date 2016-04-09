package com.hncares.daoImpl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hncares.daoI.ILoginDao;
import com.hncares.entity.Users;
@Repository
public class LoginDao implements ILoginDao{

	@Autowired
	private  SessionFactory sessionFactory;
	
	public boolean login(String username,String password){
		boolean pass;
		Session session = sessionFactory.openSession();
//		Query query = session.createQuery("from Users where username='"+username+
//				"' and password ='"+password+"'");
		Query query = session.createQuery("from Users where username=? and password =?");
		query.setString(0, username);
		query.setString(1, password);
		List<Users> list = query.list();
		
		if(list.size()>0)
			pass = true;
		else 
			pass = false;
		
		session.close();
		return pass; 
	}

	public boolean register(Integer id, String username, String password) {
		System.out.println("register dao");
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Users user = new Users();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e+"register dao !!!!!!!");
			return false;
		}
	}
}
