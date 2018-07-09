package com.hzy.controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.DigestUtils;

import com.hzy.pojo.Files;
import com.hzy.pojo.Page;
import com.hzy.pojo.Student;
import com.hzy.pojo.Teacher;
import com.hzy.pojo.User;
import com.hzy.service.AdminService;
import com.hzy.service.StudentService;
import com.hzy.service.TeacherService;

@Controller
public class AdminController {

	@Autowired
	// private StudentService studentService;
	private AdminService adminService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/student")
	public String getStudent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		// 每页显示4条
		int currentCount = 2;
		Page pages = adminService.getPage(currentPage, currentCount);
		session.setAttribute("pages", pages);
		return "admin/studentinfo";
	}

	@RequestMapping("/adds")
	public String addStudent() {
		return "admin/addStudent";
	}

	@RequestMapping("/addStudent")
	public String addStudent(HttpServletRequest request) {
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String college = request.getParameter("college");
		String tutor = request.getParameter("tutor");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		Student student = new Student();
		student.setName(name);
		student.setSex(sex);
		student.setSnumber(snumber);
		student.setCollege(college);
		student.setEmail(email);
		student.setTutor(tutor);
		student.setPhone(phone);
		adminService.insertStudent(student);

		getStudent(request);
		return "admin/studentinfo";
	}

	@RequestMapping("/teacher")
	public String getTeacher(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		// 每页显示4条
		int currentCount = 2;
		Page paget = adminService.getPageT(currentPage, currentCount);
		session.setAttribute("paget", paget);
		return "admin/teacherinfo";
	}

	@RequestMapping("/addt")
	public String addTeacher() {
		return "admin/addTeacher";
	}

	@RequestMapping("/addTeacher")
	public String addTeacher(HttpServletRequest request) {
		String parameter = request.getParameter("tnumber");
		Integer tnumber = Integer.parseInt(parameter);
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String college = request.getParameter("college");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		Teacher teacher = new Teacher();
		teacher.setName(name);
		teacher.setSex(sex);
		teacher.setTnumber(tnumber);
		teacher.setCollege(college);
		teacher.setEmail(email);
		teacher.setPhone(phone);
		adminService.insertTeacher(teacher);

		getTeacher(request);
		return "admin/teacherinfo";
	}

	@RequestMapping("/userinfo")
	public String getUserInfo(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String currentPageStr = request.getParameter("currentPage");
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		// 每页显示4条
		int currentCount = 2;
		Page pageu = adminService.getPageU(currentPage, currentCount);
		session.setAttribute("pageu", pageu);
		return "admin/userinfo";
	}

	@RequestMapping("/addu")
	public String addUser() {
		return "admin/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request) {
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 对密码进行 md5 加密
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		String user_type = request.getParameter("user_type");

		User user = new User();
		user.setPassword(md5Password);
		user.setSnumber(snumber);
		user.setUserType(user_type);
		user.setUsername(username);
		adminService.insertUser(user);

		getUserInfo(request);
		return "admin/userinfo";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		adminService.deleteU(snumber);
		getUserInfo(request);
		return "admin/userinfo";
	}
	@RequestMapping("/deleteStudent")
	public String deleteStudent(HttpServletRequest request) {
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		adminService.deleteS(snumber);
		getStudent(request);
		return "admin/studentinfo";
	}
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(HttpServletRequest request) {
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		adminService.deleteT(snumber);
		getTeacher(request);
		return "admin/teacherinfo";
	}
	
	@RequestMapping("/upTeacher")
	public String upTeacher(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		Teacher teacher = teacherService.getTeacherById(snumber);
		session.setAttribute("teacher", teacher);
		return "admin/teacherapply";
	}
	@RequestMapping("/updateTeacher")
	public String updateTeacher(HttpServletRequest request){
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
		getTeacher(request);
		return "admin/teacherinfo";
	}
	
	
	@RequestMapping("/upStudent")
	public String upStudent(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String parameter = request.getParameter("snumber");
		Integer snumber = Integer.parseInt(parameter);
		Student student = studentService.getStudentById(snumber);
		session.setAttribute("student", student);
		return "admin/studentapply";
	}
	@RequestMapping("/updateStudent")
	public String updateStudent(HttpServletRequest request){
		String parameter = request.getParameter("snumber");
		System.out.println(parameter);
		Integer snumber = Integer.parseInt(parameter);
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String college = request.getParameter("college");
		String tutor = request.getParameter("tutor");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		Student student = studentService.getStudentById(snumber);
		student.setSnumber(snumber);
		student.setName(name);
		student.setSex(sex);
		student.setCollege(college);
		student.setTutor(tutor);
		student.setPhone(phone);
		student.setEmail(email);
		studentService.updateStudent(student);
		getStudent(request);
		return "admin/studentinfo";
	}
	
	
	

	@RequestMapping("/upadd")
	public String upadd(Files files, MultipartFile mFile,
			HttpServletRequest request) throws Exception {
		// 保存图片到
		// String name = UUID.randomUUID().toString().replaceAll("-", "");
		// jpg
		// String ext = FilenameUtils.getExtension(mFile.getOriginalFilename());
		String filename = mFile.getOriginalFilename();
		mFile.transferTo(new File("E:\\upload\\" + filename));
		System.out.println(filename);
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("E:\\upload\\" + filename), "GB2312"));
		String line = br.readLine();
		while (line != null) {
			parseRecord(line, request);
			line = br.readLine();

		}
		br.close();

		files.setFileName(filename);
		HttpSession session = request.getSession();
		String sName = (String) session.getAttribute("userName");
		Integer snumber = (Integer) session.getAttribute("snumber");
		files.setsName(sName);
		files.setSnumber(snumber);

		return "admin/userinfo";
	}

	public void parseRecord(String line_record, HttpServletRequest request)
			throws Exception {
		// 拆分记录
		String[] fields = line_record.split(",");
		String parameter = fields[0];
		Integer snumber = Integer.parseInt(parameter);
		String username = tranStr(fields[1]);
		String password = tranStr(fields[2]);
		String user_type = tranStr(fields[3]);
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		System.out.println(snumber + " " + username + " " + password);
		User user = new User();
		user.setPassword(md5Password);
		user.setSnumber(snumber);
		user.setUserType(user_type);
		user.setUsername(username);
		adminService.insertUser(user);

		getUserInfo(request);

	}

	public String tranStr(String oldstr) {
		String newstr = "";
		try {
			newstr = new String(oldstr.getBytes("utf-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newstr;
	}

	@RequestMapping("/upaddS")
	public String upaddS(Files files, MultipartFile mFile,
			HttpServletRequest request) throws Exception {
		String filename = mFile.getOriginalFilename();
		mFile.transferTo(new File("E:\\upload\\" + filename));
		System.out.println(filename);
		Workbook workbook = WorkbookFactory.create(new File("E:\\upload\\"
				+ filename));
		// 读取一个sheet
		Sheet sheet = workbook.getSheetAt(0);
		Row row = null;
		Map<String, Student> stuMap = new HashMap<String, Student>();
		System.out.println(sheet.getLastRowNum());
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			Student student = new Student();
			for (int j = 0; j < 7; j++) {

				student.setSnumber(Integer.valueOf((int) row.getCell(0)
						.getNumericCellValue()));
				student.setName(row.getCell(1).toString());
				student.setSex(row.getCell(3).toString());
				student.setCollege(row.getCell(3).toString());
				student.setTutor(row.getCell(4).toString());
				student.setPhone((int) row.getCell(5).getNumericCellValue()
						+ "");
				student.setEmail(row.getCell(6).toString());

			}
			stuMap.put("stu" + i, student);

		}
		for (String string : stuMap.keySet()) {
			adminService.insertStudent(stuMap.get(string));
		}

		getStudent(request);

		return "admin/studentinfo";
	}
	
	@RequestMapping("/upaddT")
	public String upaddT(Files files, MultipartFile mFile,
			HttpServletRequest request) throws Exception {
		String filename = mFile.getOriginalFilename();
		File file = new File("E:\\upload\\" + filename);
		mFile.transferTo(file);
		Workbook workbook = WorkbookFactory.create(file);
		// 读取一个sheet
		Sheet sheet = workbook.getSheetAt(0);
		Row row = null;
		Map<String, Teacher> stuMap = new HashMap<String, Teacher>();
		System.out.println(sheet.getLastRowNum());
		for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
			row = sheet.getRow(i);
			Teacher teacher = new Teacher();
			for (int j = 0; j < 6; j++) {
				
				teacher.setTnumber(Integer.valueOf((int) row.getCell(0)
						.getNumericCellValue()));
				teacher.setName(row.getCell(1).toString());
				teacher.setSex(row.getCell(2).toString());
				teacher.setCollege(row.getCell(3).toString());
				teacher.setPhone((int) row.getCell(4).getNumericCellValue()
						+ "");
				teacher.setEmail(row.getCell(5).toString());
			}
			stuMap.put("stu" + i, teacher);
			
			
		}
		for (String string : stuMap.keySet()) {
			adminService.insertTeacher(stuMap.get(string));
		}
		file.delete();
        
		getTeacher(request);
		
		return "admin/teacherinfo";
	}
}
