package hd.survey.service;

import hd.survey.entity.Surveys;

import java.util.List;

public interface SurveyService {
	public boolean addSurvey(String title,int userId);
	public int querySurveyId(String title,int userId);
	public void deleteSurvey();
	public void updateSurvey();
	public List<Surveys> querySurvey(int userId);
	public List<Surveys> queryAllSurvey();
}
