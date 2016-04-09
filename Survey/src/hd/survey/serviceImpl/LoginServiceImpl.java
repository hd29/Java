package hd.survey.serviceImpl;

import hd.survey.dao.UserDao;
import hd.survey.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserDao userDao;
	
	public int verifyUser(String username, String password) {
		// TODO Auto-generated method stub
		int userId = userDao.queryUser(username, password);
			return userId;
	}

	public boolean verifyUserExist(String username) {
		// TODO Auto-generated method stub
		boolean pass = userDao.queryUserExist(username);
		if (pass) {
			return true;
		}else{
			return false;
		}
	}

	public boolean addUsers(String username,String password) {
		// TODO Auto-generated method stub
		if(userDao.saveUser(username, password)){
			return true;
		}else{
			return false;
		}
	}

}
