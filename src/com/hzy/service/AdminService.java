package com.hzy.service;

import com.hzy.pojo.Page;
import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.pojo.User;

public interface AdminService {

	Page getPage(int currentPage,int currentCount);
	
	void insertStudent(Student student);
	
	Page getPageT(int currentPage,int currentCount);
	
	void insertTeacher(Teacher teacher);
	
	Page getPageU(int currentPage,int currentCount);
	
	void insertUser(User user);
	
	void deleteU(int snumber);
	void deleteS(int snumber);
	void deleteT(int snumber);
}
