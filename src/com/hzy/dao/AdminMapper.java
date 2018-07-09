package com.hzy.dao;

import java.util.List;

import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.pojo.User;

public interface AdminMapper {

	int findTotalCount();
	
	int findTotalCountT();
	
	int findTotalCountU();
	
	List<Student> findStudentList(int index,int currentCount);
	
	List<Teacher> findTeacherList(int index,int currentCount);
	
	List<User> findUserList(int index,int currentCount);
	
	void addStu(Student student);
	
	void addTea(Teacher teacher);
	
	void addUser(User user);
	
	void deleteUser(int snumber);
	void deleteS(int snumber);
	void deleteT(int tnumber);
}
