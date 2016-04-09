package hd.survey.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hd.survey.dao.SurveyDao;
import hd.survey.entity.Surveys;
import hd.survey.service.SurveyService;
@Service
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	SurveyDao surveyDao;
	public boolean addSurvey(String title,int userId) {
		// TODO Auto-generated method stub
		boolean pass = surveyDao.saveSurvey(title, userId);
		if(pass){
			return true;
		}else{
			return false;
		}
	}

	public void deleteSurvey() {
		// TODO Auto-generated method stub

	}

	public void updateSurvey() {
		// TODO Auto-generated method stub

	}

	public List<Surveys> querySurvey(int userId) {
		// TODO Auto-generated method stub
		List<Surveys> Surveyslist = surveyDao.querySurvey(userId);
		return Surveyslist;
	}
	public int querySurveyId(String title,int userId) {
		// TODO Auto-generated method stub
		int SurveysId = surveyDao.querySurveyId(title, userId);
		return SurveysId;
	}

	public List<Surveys> queryAllSurvey() {
		// TODO Auto-generated method stub
		List<Surveys> allSurveyslist = surveyDao.queryAllSurvey();
		return allSurveyslist;
	}

}
