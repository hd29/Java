package hd.survey.serviceImpl;

import hd.survey.dao.QuestionsDao;
import hd.survey.entity.Questions;
import hd.survey.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionsDao questionsDao;

	public void deleteQuestion() {
		// TODO Auto-generated method stub

	}

	public void updateQuestion1(int id,String option) {
		if(option!=null){
			int option1 = Integer.parseInt(option);
		    questionsDao.updateQuestion1(id,option1);
		}
	}

	public List<Questions> queryQuestion(int surveyId) {
		List<Questions> questionList = questionsDao.queryQuestion(surveyId);
//		System.out.println("Impl:"+questionList.get(0).getTitle());
		return questionList;
	}
	public List<Questions> queryQuestion2(String title,int userId) {
		List<Questions> questionList = questionsDao.queryQuestion2(title,userId);
		return questionList;
	}

	public boolean addQuestion(String title,int optype, String Q1, String Q2, String Q3,
			String Q4, int surveyId) {
		boolean pass = questionsDao.saveQuestion(title,optype, Q1, Q2, Q3, Q4, surveyId);
		return pass;
	}

	public List<Object []> queryQuestionIdAndType(int surveyId) {
		List<Object []> QIATList = questionsDao.queryQuestionIdAndType(surveyId);
		return QIATList;
	}

}
