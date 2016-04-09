package com.hncares.daoI;

import java.util.List;

public interface IaduqDao {

	public void add(int id,String username,String password);
	public void delete(int id);
	public void update(int id,String password);
	public List query(int id);
	
}
