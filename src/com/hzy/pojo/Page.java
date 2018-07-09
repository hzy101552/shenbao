package com.hzy.pojo;

import java.util.List;

public class Page {
	// 当前页
	private int currentPage;
	// 当前页显示的条数
	private int currentCount;
	// 总条数
	private int totalCount;
	// 总页数
	private int totalPage;
	// 每页显示的数据
	private List<Project> productList;
	private List<Student> studentList;
	private List<Teacher> teacherList;
	private List<User> userList;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Project> getProductList() {
		return productList;
	}

	public void setProductList(List<Project> productList) {
		this.productList = productList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
