package hd.survey.service;

import hd.survey.entity.Questions;

import java.util.List;

import org.springframework.stereotype.Service;
@Service
public interface QuestionService {
	public boolean addQuestion(String title,int optype,String Q1,String Q2,String Q3,String Q4,int surveyId);
	public void deleteQuestion();
	public void updateQuestion1(int id,String option);
	public List<Questions> queryQuestion(int surveyId);
	public List<Object []> queryQuestionIdAndType(int surveyId);
	public List<Questions> queryQuestion2(String title,int userId);
}
