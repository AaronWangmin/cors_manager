package com.shbd.cors.dao;


import java.util.List;

import com.shbd.cors.model.User;

public interface IUserDao {
	public void add(User user);
	public void update(User user);
	public User load(int id);
	public void delete(int id);	
	public List<User> list();
	public User login(String name,String password);
	
	

}
