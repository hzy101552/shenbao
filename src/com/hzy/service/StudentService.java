package com.hzy.service;

import java.util.List;

import com.hzy.pojo.Files;
import com.hzy.pojo.Page;
import com.hzy.pojo.Project;
import com.hzy.pojo.Student;


public interface StudentService {
	//通过id获取学生信息
	Student getStudentById(int id);
	//修改学生信息
	void updateStudent(Student student);
	
	//添加项目
	void addProject(Project project);
	//获取所有项目
	List<Project> getProject();
	//获取自己的所有项目
	List<Project> getmyProjects(int snumber);
	//
	Page getPage(int currentPage,int currentCount);
	//
	Project getProjectXiang(String project_name);
	//
	List<Files> getFiles();
	//
	void addFile(Files files);
}
