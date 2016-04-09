package hd.survey.action;

import hd.survey.service.LoginService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
@Controller
public class UserAction {
	
	@Autowired
	LoginService loginServiceImpl;
	
	private String username;
	private String password;
	private String password1;
	private Map<String, Object> userSessionmap;
	public String getPassword1() {
		return password1;
	}


	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String login() {
//		 ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");//读取bean.xml中的内容
//		 LoginService ls = (LoginService) ctx.getBean("loginServiceImpl");//创建bean的引用对象
		int userId =loginServiceImpl.verifyUser(username, password);
//		boolean pass =ls.verifyUser(username, password);
		if (userId!=-1) {
			ActionContext ac = ActionContext.getContext();
			userSessionmap = ac.getSession();
//			userRequestmap = ac.get("Request");
			userSessionmap.put("username", username);
			userSessionmap.put("userId", userId);
			return "success";
		}else{
			return "failed";
		}
	}
	
	public String register() {
		
		if (!password.equals(password1)) {
			return "failed";
		}else {
			boolean pass =loginServiceImpl.verifyUserExist(username);
			if(pass){
				return "failed";
			}else{
//				如果不存在insert
				if(loginServiceImpl.addUsers(username, password)){
					return "success";
				}else {
					return "failed";
				}
			}
		}
	}
	public String exit() {
//		ActionContext.getContext().getSession().put("userId", null);
//		ActionContext.getContext().getSession().put("username", null);
		ActionContext.getContext().getSession().remove("userId");
		ActionContext.getContext().getSession().remove("username");
//		System.out.println(ActionContext.getContext().getSession());
		return "success";
	}
//	public static void main(String[] args) {
//		System.out.println(login());
//	}
	
}
