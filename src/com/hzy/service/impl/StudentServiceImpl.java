package com.hzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.dao.StudentMapper;
import com.hzy.pojo.Files;
import com.hzy.pojo.Page;
import com.hzy.pojo.Project;
import com.hzy.pojo.Student;
import com.hzy.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentMapper studentMapper;

	public Student getStudentById(int id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateStudentinfo(student);
	}

	@Override
	public void addProject(Project project) {
		// TODO Auto-generated method stub
		studentMapper.addProjectinfo(project);
	}

	@Override
	public List<Project> getProject() {
		// TODO Auto-generated method stub
		List<Project> projects = studentMapper.findProject();
		return projects;
	}

	@Override
	public List<Project> getmyProjects(int snumber) {
		// TODO Auto-generated method stub
		List<Project> myProjects = studentMapper.findmyProjects(snumber);
		return myProjects;
	}

	@Override
	public Page getPage(int currentPage, int currentCount) {
		Page page = new Page();
		// 1、当前页private int currentPage;
		page.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		page.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = studentMapper.findTotalCount();
		page.setTotalCount(totalCount);
		//总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		page.setTotalPage(totalPage);
		//索引
		int index = (currentPage-1)*currentCount;
		//每页数据
		List<Project> productList = studentMapper.findProductList(index,currentCount);
		page.setProductList(productList);
		return page;
	}

	@Override
	public Project getProjectXiang(String project_name) {
		// TODO Auto-generated method stub
		Project xiang = studentMapper.findProjectXiang(project_name);
		return xiang;
	}

	@Override
	public List<Files> getFiles() {
		// TODO Auto-generated method stub
		List<Files> findFiles = studentMapper.findFiles();
		return findFiles;
	}

	@Override
	public void addFile(Files files) {
		// TODO Auto-generated method stub
		studentMapper.insertFile(files);
	}

}
