package com.ssmdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssmdemo.dao.UserDao;
import com.ssmdemo.entity.PageModel;
import com.ssmdemo.entity.User;
import com.ssmdemo.service.UserService;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public Integer add(User user) {
		userDao.add(user);
		return user.getUserid();
	}

	public void update(User user) {
		userDao.update(user);
	}
	
	public Integer findCount(PageModel<Integer> pageModel)
	{
		return userDao.findCount(pageModel);
	}
	
	/*public void check(User user) {
		userDao.check(user);
	}*/

	public void delete(Integer userid) {
		userDao.delete(userid);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	public User findByUserID(Integer userid) {
		return userDao.findByUserID(userid);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}
	
	public List<User> findUnchecked(PageModel<Integer> pageModel) {
		return userDao.findUnchecked(pageModel);
	}

	public void check(Integer id) {
		userDao.check(id);
	}
	
	public void checkdeny(Integer id) {
		userDao.checkdeny(id);
	}
}
