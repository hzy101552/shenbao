package com.hzy.service;

import com.hzy.pojo.User;

public interface UserService {
	User getUser(int id);

	User getUser(Integer snumber, String password);

	void updateUser(User user);
}
