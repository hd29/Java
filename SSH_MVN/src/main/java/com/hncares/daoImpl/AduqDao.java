package com.hncares.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hncares.daoI.IaduqDao;
import com.hncares.entity.Users;
//@Repository
public class AduqDao extends HibernateDaoSupport implements IaduqDao{
//		 @Autowired
//		 private  SessionFactory sessionFactory;
	
	public void add(int id,String username,String password){
		try {
			Session session = getSession();
//			session.beginTransaction();
			Users user = new Users();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			session.save(user);
//			session.getTransaction().commit(); 
//			session.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		Session session = getSession();
//		session.beginTransaction();
		Users user = new Users();
		user.setId(id);
		session.delete(user);
//		session.beginTransaction().commit();
//		session.close();
	}
	public void update(int id,String password){
		Session session = getSession();
//		session.beginTransaction();
		Users user = (Users) session.get(Users.class, id);
		user.setPassword(password);
		session.update(user);
//		session.getTransaction().commit(); 
//		session.close();
	}
	public List query(int id){
		Session session = getSession();
		Query query = session.createQuery("from Users where id="+id);
//		query.setCacheable(true);
		return  query.list(); 

	}
}
