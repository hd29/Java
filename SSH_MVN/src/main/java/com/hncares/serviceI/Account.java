package com.hncares.serviceI;



public interface Account {
public boolean login(String username,String password);
public boolean register(Integer id,String username,String password,String password2);
}
