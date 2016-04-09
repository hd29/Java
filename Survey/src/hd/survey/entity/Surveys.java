package hd.survey.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Surveys {

	private Integer id;   
	private String title;   
	private String state;   
	private Date createTime;
	@ManyToOne
	private Users userId;
	@OneToMany
	private Set<Questions> questions;
	
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	public Set<Questions> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}
}
