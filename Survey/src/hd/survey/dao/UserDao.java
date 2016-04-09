package hd.survey.dao;

import hd.survey.entity.Users;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDao {
	@Autowired
	SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void updateUser() {
		// TODO Auto-generated method stub
		Users user = new Users();  
//		Users user = (Users)getSession().get(Users.class, 2);
	
//		user.setId(2);  
		user.setUsername("upDatename1");  
		user.setPassword("upDatepass1");  
		getSession().update(user);
	}


	public int queryUser(String username,String password){
		Query query = getSession().createQuery(
				"select u.id from Users as u "
				+ "where u.username='"+username+ "' and u.password='"+password+"'");
		List list = query.list();
		
		if (list.size()>0) {
			int userId = (Integer) list.get(0);
			System.out.println(userId);
			return userId;
		}else{
			
			return -1;
		}
	}
	
	public boolean queryUserExist(String username){
		Query query = getSession().createQuery(
				"select u.username,u.password from Users as u "
				+ "where u.username='"+username+"'");
		List list = query.list();
		if (list.size()>0) {
			return true;
		}else{
			
			return false;
		}
	}


	public boolean saveUser(String username,String password) {
    	try {  
//			SessionFactory sf = new Configuration().configure()  
//					.buildSessionFactory();  
//			Session session = sessionFactory.openSession();  
//			Session session = sessionFactory.getCurrentSession();  
//		Transaction txManager = session.beginTransaction();  

			Users user = new Users();  
//			user.setId(2);  
			user.setUsername(username);  
			user.setPassword(password);  
			getSession().save(user); 
			
//			txManager.commit();  
//			session.close();  
			return true;

		} catch (HibernateException e) {  
			e.printStackTrace(); 
			System.out.println("±‡∫≈“—¥Ê‘⁄");
			return false;
		}  
	}
	
	public void deleteUser() {
		Users user = new Users();
		user.setId(23);
//		Users user = (Users)getSession().get(Users.class, 24);
		getSession().delete(user);
	}
}
