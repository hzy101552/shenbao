package com.hzy.service;


import java.util.List;

import com.hzy.pojo.Project;
import com.hzy.pojo.Teacher;

public interface TeacherService {

	Teacher getTeacherById(int id);
	
	List<Project> getmyProjects(String tName);
	
	void updateTeacher(Teacher teacher);
}
