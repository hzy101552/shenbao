package com.hzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzy.dao.AdminMapper;
import com.hzy.pojo.Page;
import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.pojo.User;
import com.hzy.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminMapper adminMapper;
	
	@Override
	public Page getPage(int currentPage, int currentCount) {
		Page page = new Page();
		// 1、当前页private int currentPage;
		page.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		page.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = adminMapper.findTotalCount();
		page.setTotalCount(totalCount);
		//总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		page.setTotalPage(totalPage);
		//索引
		int index = (currentPage-1)*currentCount;
		//每页数据
		List<Student> studentList = adminMapper.findStudentList(index,currentCount);
		page.setStudentList(studentList);
		return page;
	}

	@Override
	public void insertStudent(Student student) {
		// TODO Auto-generated method stub
		adminMapper.addStu(student);
	}

	@Override
	public Page getPageT(int currentPage, int currentCount) {
		Page page = new Page();
		// 1、当前页private int currentPage;
		page.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		page.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = adminMapper.findTotalCountT();
		page.setTotalCount(totalCount);
		//总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		page.setTotalPage(totalPage);
		//索引
		int index = (currentPage-1)*currentCount;
		//每页数据
		List<Teacher> teacherList = adminMapper.findTeacherList(index,currentCount);
		page.setTeacherList(teacherList);
		return page;
	}
	
	@Override
	public void insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		adminMapper.addTea(teacher);
	}

	@Override
	public Page getPageU(int currentPage, int currentCount) {
		// TODO Auto-generated method stub
		Page page = new Page();
		// 1、当前页private int currentPage;
		page.setCurrentPage(currentPage);
		// 2、当前页显示的条数private int currentCount;
		page.setCurrentCount(currentCount);
		// 3、总条数private int totalCount;
		int totalCount = adminMapper.findTotalCountU();
		page.setTotalCount(totalCount);
		//总页数
		int totalPage = (int) Math.ceil(1.0*totalCount/currentCount);
		page.setTotalPage(totalPage);
		//索引
		int index = (currentPage-1)*currentCount;
		//每页数据
		List<User> userList = adminMapper.findUserList(index,currentCount);
		page.setUserList(userList);
		return page;
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		adminMapper.addUser(user);
	}


	@Override
	public void deleteU(int snumber) {
		// TODO Auto-generated method stub
		adminMapper.deleteUser(snumber);
	}

	@Override
	public void deleteS(int snumber) {
		// TODO Auto-generated method stub
		adminMapper.deleteS(snumber);
	}

	@Override
	public void deleteT(int snumber) {
		// TODO Auto-generated method stub
		adminMapper.deleteT(snumber);
	}

}
