package hd.survey.action;

import java.util.List;

import hd.survey.service.QuestionService;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class GetOptinAction {
	@Autowired
	QuestionService questionServiceImpl;
	private Integer surveyId;
	String option;
	String options[];
	int qId;
	int qType;
	public Integer getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}
	public String saveOptin() {
//		1、通过surveyId查出所有问题的id；和类型
		List<Object []> QIATlists = questionServiceImpl.queryQuestionIdAndType(surveyId);
		for (Object[] QIATlist:QIATlists) {
			qId = (Integer) QIATlist[0];
			qType = (Integer) QIATlist[1];
			if(qType == 1){
				option = ServletActionContext.getRequest().getParameter(String.valueOf(qId));
				questionServiceImpl.updateQuestion1(qId,option);
			}
			if(qType == 2){
				options = ServletActionContext.getRequest().getParameterValues(String.valueOf(qId));
				if(options!=null){
				for (String optV:options) {
					questionServiceImpl.updateQuestion1(qId,optV);
				}
				}
			}
		}
		
		
		return "success";
	}
}
