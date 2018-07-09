package com.hzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.dao.TeacherMapper;
import com.hzy.pojo.Project;
import com.hzy.pojo.Teacher;
import com.hzy.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	TeacherMapper teacherMapper;
	
	@Override
	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherMapper.findTeacher(id);
		return teacher;
	}

	@Override
	public List<Project> getmyProjects(String tName) {
		// TODO Auto-generated method stub
		List<Project> projects = teacherMapper.findmyProjects(tName);
		return projects;
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherMapper.updateTeacherinfo(teacher);
	}

}
