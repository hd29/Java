package hd.survey.dao;

import hd.survey.entity.Questions;
import hd.survey.entity.Surveys;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class QuestionsDao {
	@Autowired
	SessionFactory sessionFactory;
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void updateQuestion1(int id,int option) {
//		Users user = new Users();  
//		user.setUsername("upDatename1");  
//		user.setPassword("upDatepass1");  
//		getSession().update(user);
		if(option==1){
			System.out.println("gengxinchenggong");
			Query query = getSession().createQuery("update Questions q set q.answer1 = q.answer1 + 1 where id = "+id); 
			query.executeUpdate();
		}
		if(option==2){
			Query query = getSession().createQuery(
					"update Questions q set q.answer2 = q.answer2 + 1 where id = "+id); 
			query.executeUpdate();
		}
		if(option==3){
			Query query = getSession().createQuery(
					"update Questions q set q.answer3 = q.answer3 + 1 where id = "+id); 
			query.executeUpdate();
		}
		if(option==4){
		Query query = getSession().createQuery(
				"update Questions q set q.answer4 = q.answer4 + 1 where id = "+id); 
		query.executeUpdate();
		}
	}


	public List<Questions> queryQuestion(int surveyId){
		Query query = getSession().createQuery(
				"from Questions as q "
				+ "where q.surveyId="+surveyId);
		   List<Questions> list = query.list();
//		   System.out.println("dao:"+list.get(0).getTitle());
		   return list;
	}
	public List<Object []> queryQuestionIdAndType(int surveyId){
		Query query = getSession().createQuery(
				"select q.id, q.type from Questions as q "
						+ "where q.surveyId="+surveyId);
		List<Object []> IATlist = query.list();
//		   System.out.println("dao:"+list.get(0).getTitle());
		return IATlist;
	}
	public List<Questions> queryQuestion2(String title,int userId){
		Query query = getSession().createQuery(
				"from Questions as q "
						+ "where q.title='"+title+"' and q.userId="+userId);
		List<Questions> list = query.list();
	
		return list;
	}
	


	public boolean saveQuestion(String title,int optype, String Q1, String Q2, String Q3,
			String Q4, int surveyId) {
    	try {  

    		Surveys surveys = new Surveys();
    		surveys.setId(surveyId);
    		Questions questions = new Questions();
    		questions.setTitle(title);
    		questions.setType(optype);
    		questions.setOption1(Q1);
    		questions.setOption2(Q2);
    		questions.setOption3(Q3);
    		questions.setOption4(Q4);
    		questions.setAnswer1(0);
    		questions.setAnswer2(0);
    		questions.setAnswer3(0);
    		questions.setAnswer4(0);
    		questions.setSurveyId(surveys);
    		getSession().save(questions); 
			return true;

		} catch (HibernateException e) {  
			e.printStackTrace(); 
			System.out.println("±‡∫≈“—¥Ê‘⁄");
			return false;
		}  
	}
	
	public void deleteQuestion(String title,String userId) {
//		Users user = new Users();
//		user.setId(23);
//		getSession().delete(user);
	}
}
