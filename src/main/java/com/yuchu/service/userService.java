package com.yuchu.service;

import java.util.List;

import com.yuchu.pojo.User;

public interface userService {
	
	public User checkUser(String username,String password);
	
	public void addUser(User user);
	
	public List<User> getAll();
	
	public void setValid(int id);
}
