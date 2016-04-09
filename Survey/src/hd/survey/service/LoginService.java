package hd.survey.service;

import org.springframework.stereotype.Service;


public interface LoginService {

	public int verifyUser(String username,String password);
	public boolean verifyUserExist(String username);
	public boolean addUsers(String username,String password);
}
