package hd.survey.entity;

public class Questions {

	private Integer id;   
	private String title;   
	private Integer type; 
	private String option1;   
	private String option2;   
	private String option3;   
	private String option4;   
	private Integer answer1;   
	private Integer answer2;   
	private Integer answer3;   
	private Integer answer4;  
	private Surveys surveyId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	
	
	public Integer getAnswer1() {
		return answer1;
	}
	public void setAnswer1(Integer answer1) {
		this.answer1 = answer1;
	}
	public Integer getAnswer2() {
		return answer2;
	}
	public void setAnswer2(Integer answer2) {
		this.answer2 = answer2;
	}
	public Integer getAnswer3() {
		return answer3;
	}
	public void setAnswer3(Integer answer3) {
		this.answer3 = answer3;
	}
	public Integer getAnswer4() {
		return answer4;
	}
	public void setAnswer4(Integer answer4) {
		this.answer4 = answer4;
	}
	public Surveys getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(Surveys surveyId) {
		this.surveyId = surveyId;
	}

}
