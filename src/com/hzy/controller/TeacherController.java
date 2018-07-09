package com.hzy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hzy.pojo.Project;
import com.hzy.pojo.Teacher;
import com.hzy.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("/t_shouye")
	public String index(){
		return "teacher/shouye";
	}
	
	@RequestMapping("/myProjectT")
	public String myProject(HttpServletRequest request){
		HttpSession session = request.getSession();
		String tName = (String) session.getAttribute("userName");
		List<Project> myProjests = teacherService.getmyProjects(tName);
		session.setAttribute("myProjects", myProjests);
		return "teacher/myProject";
	}
	
	@RequestMapping("/teacherinfo")
	public String getStudentInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("snumber");
		Teacher teacher = teacherService.getTeacherById(id);
		session.setAttribute("teacher", teacher);
		return "teacher/teacherinfo";
	}
	
	@RequestMapping("/updateT")
	public String updateTeacher(HttpServletRequest request){
		HttpSession session = request.getSession();
		String parameter = request.getParameter("snumber");
		System.out.println(parameter);
		Integer snumber = Integer.parseInt(parameter);
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String college = request.getParameter("college");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		Teacher teacher = teacherService.getTeacherById(snumber);
		teacher.setTnumber(snumber);
		teacher.setName(name);
		teacher.setSex(sex);
		teacher.setCollege(college);
		teacher.setPhone(phone);
		teacher.setEmail(email);
		teacherService.updateTeacher(teacher);
		session.setAttribute("teacher", teacher);
		return "teacher/teacherinfo";
	}
}
