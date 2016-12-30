package com.ssmdemo.service;

import java.util.List;

import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.User;

public interface UserService {

	public Integer add(User user);
	
	public void update(User user);
	
	public void delete(Integer userid);
	
	//public void check(User user);
	
	public Integer findCount(PageModel<Integer> pageModel);
	
	public void check(Integer userid);
	
	public void checkdeny(Integer userid);
	
	public User findByUserID(Integer userid);
	
	public List<User> findUnchecked(PageModel<Integer> pageModel);
	
	public List<User> findAll();
}
