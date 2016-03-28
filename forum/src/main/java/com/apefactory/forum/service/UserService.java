package com.apefactory.forum.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apefactory.forum.dao.UserDao;
import com.apefactory.forum.entity.User;

@Service
public class UserService {
	@Resource
	private UserDao userDao;

	public User getByUserId(int id){
		return userDao.getById(id);
	}
	
	public User getByUserName(String userName) {
		return userDao.getByName(userName);
	}

	public List<User> getAllUser() {
		return userDao.getALL();
	}
	
	public void updateUser(User user){
		userDao.update(user);
	}
	
	public void saveUser(User user){
		userDao.save(user);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	public void deleteByUserId(int userId){
		User user=userDao.getById(userId);
		userDao.delete(user);
	}
}
