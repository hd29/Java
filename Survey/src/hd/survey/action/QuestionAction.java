package hd.survey.action;

import hd.survey.entity.Questions;
import hd.survey.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
@Controller
public class QuestionAction {
	@Autowired
	QuestionService questionServiceImpl;
	private int surveyId;
	private String title;
	private List<Questions> questionsList;

	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Questions> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String addQuestion() {
		return "success";
	}
	public String deleteQuestion() {
		return "success";
	}
	public String updateQuestion() {
		return "success";
	}
	
	public String queryQuestions(){
			ActionContext.getContext().put("title", title);
			this.setQuestionsList(questionServiceImpl.queryQuestion(surveyId));
//			 System.out.println("action:"+questionsList.get(0).getTitle());
//			this.setQuestionsList(SurveyServiceImpl.queryQuestions(surveyId));
			return "success";
	}
//	public String queryQuestions2(){
//		int userId = (Integer) ActionContext.getContext().getSession().get("userId");
//		System.out.println("biaoti:"+title+userId);
//		this.setQuestionsList(questionServiceImpl.queryQuestion2(title,userId));
////		System.out.println("action:"+questionsList.get(0).getTitle());
////			this.setQuestionsList(SurveyServiceImpl.queryQuestions(surveyId));
//		return "success";
//	}
}
