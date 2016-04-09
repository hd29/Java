package hd.survey.dao;

import hd.survey.entity.Surveys;
import hd.survey.entity.Users;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class SurveyDao {
	@Autowired
	SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
/*
 * 修改调查
 */
	public void updateSurvey(String title,String userId) {
//		Users user = new Users();  
//		user.setUsername("upDatename1");  
//		user.setPassword("upDatepass1");  
//		getSession().update(user);
	}


	public List<Surveys> querySurvey(int userId){
		Query query = getSession().createQuery(
				"from Surveys as s "
				+ "where s.userId="+userId);
		List<Surveys> list = query.list();
//		System.out.println(list.get(0).getState());
//		System.out.println(list.get(0).getUserId());
		return list;
		
	}
	public List<Surveys> queryAllSurvey(){
		Query query = getSession().createQuery(
				"from Surveys ");
		List<Surveys> allSurveyList = query.list();
//		System.out.println(list.get(0).getState());
//		System.out.println(list.get(0).getUserId());
		return allSurveyList;
		
	}
	public int querySurveyId(String title,int userId){
		Query query = getSession().createQuery(
				"select s.id from Surveys as s "
				+ "where s.userId="+userId+"and s.title='"+title+"'");
		List list = query.list();
		if (list.size()>0) {
			int surveyId = (Integer) list.get(0);
//			System.out.println(userId);
			return surveyId;
		}else{
			
			return -1;
		}
		
	}


	public boolean saveSurvey(String title,int userId) {
    	try {  

			Users user = new Users();
			user.setId(userId);
			System.out.println(userId);
			Surveys surveys = new Surveys();
			surveys.setTitle(title);
			surveys.setUserId(user);
			surveys.setState("开放");
//			surveys.setQuestions(questions);
			
			getSession().save(surveys); 
			return true;
//			return true;

		} catch (HibernateException e) {  
			e.printStackTrace(); 
			System.out.println("异常====异常====异常====异常====");
			return false;
		}  
	}
	
	public void deleteSurvey(String title,String userId) {
//		Users user = new Users();
//		user.setId(23);
//		getSession().delete(user);
	}
}
