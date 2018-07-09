package com.hzy.dao;

import java.util.List;

import com.hzy.pojo.Project;
import com.hzy.pojo.Teacher;

public interface TeacherMapper {

	Teacher findTeacher(int id);
	
	List<Project> findmyProjects(String tName);
	
	void updateTeacherinfo(Teacher teacher);
}
