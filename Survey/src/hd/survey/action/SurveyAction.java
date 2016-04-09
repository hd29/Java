package hd.survey.action;

import hd.survey.entity.Surveys;
import hd.survey.service.SurveyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;

public class SurveyAction {
	
	@Autowired
	SurveyService SurveyServiceImpl ;
	private String username;
	private String title;
	private List<Surveys> surveysList;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Surveys> getSurveysList() {
		return surveysList;
	}
	public void setSurveysList(List<Surveys> surveysList) {
		this.surveysList = surveysList;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String addSurvey() {
		ActionContext ac = ActionContext.getContext();
		int userId = (Integer) ac.getSession().get("userId");
		boolean pass = SurveyServiceImpl.addSurvey(title, userId);
		if(pass){
			ActionContext.getContext().put("title",title);
		    int surveyId = SurveyServiceImpl.querySurveyId(title, userId);
		    if(surveyId!=-1){
		    	ActionContext.getContext().put("surveyId",surveyId);
		    	return "success";
		    }else{
		    	return "failed";
		    }
		}else{
			return "failed";
		}
	}
	public String deleteSurvey() {
		return "success";
	}
	public String updateSurvey() {
		return "success";
	}
	public String querySurvey() {
		 
	    int userId = (Integer) ActionContext.getContext().getSession().get("userId");
//	    System.out.println("userId:"+userId);
		this.setSurveysList(SurveyServiceImpl.querySurvey(userId));
//		System.out.println("action:"+surveysList.get(0).getState());
//		System.out.println("action:"+surveysList.get(0).getTitle());
//		System.out.println("action:"+surveysList.get(0).getId());
		return "success";
	}
	public String queryAllSurvey() {
		
		this.setSurveysList(SurveyServiceImpl.queryAllSurvey());
		return "success";
	}
	
}
