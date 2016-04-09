package com.hncares.daoI;

public interface ILoginDao {
	public boolean login(String username,String password);
	public boolean register(Integer id,String username,String password);
}
