package com.hzy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.dao.UserMapper;
import com.hzy.pojo.User;
import com.hzy.service.UserService;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;

	@Override
	public User getUser(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User getUser(Integer snumber, String password) {
		User user = userMapper.selectUserByName(snumber);
		//System.out.println(userList.getUsername());
		/*if(null == userList){
			return null;
		}*/
		/*
		for (User user : userList) {
			
			if (user.getPassword().equals(password)) {
				return user;
			}else {
				return null;
			}
		}*/
		
		return user;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUserPassword(user);
	}

	

}