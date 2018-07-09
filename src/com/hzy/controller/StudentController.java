package com.hzy.controller;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.hzy.pojo.Files;
import com.hzy.pojo.Page;
import com.hzy.pojo.Project;
import com.hzy.pojo.Student;
import com.hzy.pojo.User;
import com.hzy.service.StudentService;

@Controller
//@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/shouye")
	public String index(){
		return "student/shouye";
	}
	
	@RequestMapping("/index")
	public String shouye(){
		return "student/index";
	}
	
	@RequestMapping("/studentinfo")
	public String getStudentInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("snumber");
		Student student = studentService.getStudentById(id);
		session.setAttribute("sName", student.getName());
		session.setAttribute("student", student);
		return "student/studentinfo";
	}
	
	@RequestMapping("/applyproject")
	public String applyProject(HttpServletRequest request){
		HttpSession session = request.getSession();
		/*List<Project> projectList = studentService.getProject();
		session.setAttribute("projectList", projectList);*/
		
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		//每页显示4条
		int currentCount = 4;
		Page page = studentService.getPage(currentPage,currentCount);
		session.setAttribute("page", page);
		return "student/projectapply";
	}
	
	@RequestMapping("/myProject")
	public String myProject(HttpServletRequest request){
		HttpSession session = request.getSession();
		Integer snumber = (Integer) session.getAttribute("snumber");
		List<Project> myProjects = studentService.getmyProjects(snumber);
		session.setAttribute("myProjects", myProjects);
		return "student/myProject";
	}
	
	@RequestMapping("/projectXiang")
	public String ProjectXiang(HttpServletRequest request){
		String project_name = request.getParameter("project_name");
		Project projectXiang = studentService.getProjectXiang(project_name);
		HttpSession session = request.getSession();
		session.setAttribute("projectXiang", projectXiang);
		return "student/projectXiang";
	}
	
	@RequestMapping("/register")
	public String register(User user){
		return "student/register";
	}
	
	@RequestMapping("/update")
	public String updateStudentInfo(HttpServletRequest request){
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("snumber");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		Student student = studentService.getStudentById(id);
		student.setPhone(phone);
		student.setEmail(email);
		studentService.updateStudent(student);
		getStudentInfo(request);
		return "student/studentinfo";
	}
	
	//@SuppressWarnings("unused")
	@RequestMapping("/addProject")
	public String addProjectinfo(HttpServletRequest request){
		//HttpSession session = request.getSession();
		//int id = (int) session.getAttribute("id");
		String project_name = request.getParameter("project_name");
		String project_category = request.getParameter("project_category");
		String snumber = request.getParameter("snumber");
		String student_name = request.getParameter("student_name");
		String college = request.getParameter("college");
		String t_Name = request.getParameter("t_Name");
		String createtime = request.getParameter("createtime");
		String result = request.getParameter("result");
		String funds = request.getParameter("funds");
		String team = request.getParameter("team");
		String status = request.getParameter("status");
		String introduction = request.getParameter("introduction");
		String research_contents = request.getParameter("research_contents");
		String plan = request.getParameter("plan");
		Project project=new Project(project_name, snumber, student_name, college, project_category, createtime, result, funds, team, introduction, research_contents, plan, status, t_Name);
		studentService.addProject(project);
		applyProject(request);
		return "student/projectapply";
	}
	
	@RequestMapping("/up")
	public String up(HttpServletRequest request){
		HttpSession session = request.getSession();
		List<Files> files = studentService.getFiles();
		session.setAttribute("FileList", files);
		return "student/upload";
	}
	
	@RequestMapping("/upload")
	public String upload(Files files,MultipartFile mFile,HttpServletRequest request) throws Exception{
		//保存图片到 
				//String name = UUID.randomUUID().toString().replaceAll("-", "");
				//jpg
				//String ext = FilenameUtils.getExtension(mFile.getOriginalFilename());
				String filename = mFile.getOriginalFilename();
				mFile.transferTo(new File("E:\\upload\\" + filename));
				files.setFileName(filename);
				HttpSession session = request.getSession();
				String sName = (String) session.getAttribute("userName");
				Integer snumber = (Integer) session.getAttribute("snumber");
				files.setsName(sName);
				files.setSnumber(snumber);
				studentService.addFile(files);
				List<Files> fileList = studentService.getFiles();
				session.setAttribute("FileList", fileList);
		return "student/upload";
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    String fileName = request.getParameter("fileName");
	    System.out.println("1download +" +fileName);
		File file = new File("E:\\upload\\"+ fileName);
	    byte[] body = null;
	    
	    @SuppressWarnings("resource")
		InputStream is = new FileInputStream(file);
	    
	    body = new byte[is.available()];
	    is.read(body);
	    HttpHeaders headers = new HttpHeaders();
	    
	    //下载显示的文件名，解决中文名称乱码问题 
	    String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
	    //通知浏览器以attachment（下载方式）打开图片
	    headers.setContentDispositionFormData("attachment", downloadFielName); 
	    //application/octet-stream ： 二进制流数据（最常见的文件下载）。
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),  
	            headers, HttpStatus.CREATED);
	    return entity;
	}
	/*@RequestMapping("/download")
	public static void downFile(HttpServletRequest request, HttpServletResponse response){
		String fileUrl="E:\\upload\\";
		String fileName = request.getParameter("fileName");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		   OutputStream fos = null;
		   InputStream fis = null;
		        try {
		            fis = new FileInputStream(fileUrl);
		            bis = new BufferedInputStream(fis);
		            fos = response.getOutputStream();
		            bos = new BufferedOutputStream(fos);
		            setFileDownloadHeader(request,response, fileName);
		            int byteRead = 0;
		            byte[] buffer = new byte[8192];
		            while((byteRead=bis.read(buffer,0,8192))!=-1){
		                bos.write(buffer,0,byteRead);
		            }
		            bos.flush();
		            fis.close();
		            bis.close();
		            fos.close();
		            bos.close();
		        } catch (Exception e) {
		        }
		}*/
	
	/*public static void setFileDownloadHeader(HttpServletRequest request,HttpServletResponse response, String fileName) {
		   try {
		       //中文文件名支持
		       String encodedfileName = null;
		       String agent = request.getHeader("USER-AGENT");
		       
		       if(null != agent && -1 != agent.indexOf("MSIE")){//IE
		           encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		       }else if(null != agent && -1 != agent.indexOf("Mozilla")){
		           encodedfileName = new String (fileName.getBytes("UTF-8"),"iso-8859-1");
		       }else{
		           encodedfileName = java.net.URLEncoder.encode(fileName,"UTF-8");
		       }
		       response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
		   } catch (Exception e) {
		       e.printStackTrace();
		   }
		}*/
	
	
	
	@RequestMapping("/applyProjectT")
	public String applyProjectT(HttpServletRequest request){
		HttpSession session = request.getSession();
		/*List<Project> projectList = studentService.getProject();
		session.setAttribute("projectList", projectList);*/
		
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr==null) currentPageStr="1";
		int currentPage = Integer.parseInt(currentPageStr);
		//每页显示4条
		int currentCount = 4;
		Page page = studentService.getPage(currentPage,currentCount);
		session.setAttribute("page", page);
		return "teacher/projectapply";
	}
	
	@RequestMapping("/projectXiangT")
	public String ProjectXiangT(HttpServletRequest request){
		String project_name = request.getParameter("project_name");
		Project projectXiang = studentService.getProjectXiang(project_name);
		HttpSession session = request.getSession();
		session.setAttribute("projectXiang", projectXiang);
		return "teacher/projectXiang";
	}
	
	@RequestMapping("/tup")
	public String tup(HttpServletRequest request){
		HttpSession session = request.getSession();
		List<Files> files = studentService.getFiles();
		session.setAttribute("FileList", files);
		return "teacher/upload";
	}
	
	@RequestMapping("/tupload")
	public String tupload(Files files,MultipartFile mFile,HttpServletRequest request) throws Exception{
		//保存图片到 
				//String name = UUID.randomUUID().toString().replaceAll("-", "");
				//jpg
				//String ext = FilenameUtils.getExtension(mFile.getOriginalFilename());
				String filename = mFile.getOriginalFilename();
				mFile.transferTo(new File("E:\\upload\\" + filename));
				files.setFileName(filename);
				HttpSession session = request.getSession();
				String sName = (String) session.getAttribute("userName");
				Integer snumber = (Integer) session.getAttribute("snumber");
				files.setsName(sName);
				files.setSnumber(snumber);
				studentService.addFile(files);
				List<Files> fileList = studentService.getFiles();
				session.setAttribute("FileList", fileList);
		return "teacher/upload";
	}
}
