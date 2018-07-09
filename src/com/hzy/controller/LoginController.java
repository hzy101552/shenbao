package com.hzy.controller;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.DigestUtils;

import com.hzy.pojo.Student;
import com.hzy.pojo.User;
import com.hzy.service.StudentService;
import com.hzy.service.UserService;
import com.hzy.utils.HttpUtils;

@Controller
public class LoginController {
	private String str="";
	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/login")
	public String login(Integer snumber, String password, HttpServletRequest request,HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		
		//对密码进行 md5 加密
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		String checkPassword = checkPassword(request, response);
		System.out.println(checkPassword);
		if (checkPassword.equals("flase")) {
			session.setAttribute("error", "验证码错误！");
			return "../../login";
		}
		User user = userService.getUser(snumber,md5Password);
		if (null == user) {
			session.setAttribute("error", "用户名错误！");
			return "../../login";
		}
		session.setAttribute("userName", user.getUsername());
		session.setAttribute("snumber", user.getSnumber());
			if (user.getPassword().equals(md5Password)){
				if(user.getUserType().equals("学生")){
					return "student/shouye";
				}else if (user.getUserType().equals("教师")) {
					return "teacher/shouye";
				}else {
					return "admin/index";
				}
			}
			session.setAttribute("error", "密码错误！");
			return "../../login";
		
	}
	
	@RequestMapping("/checkAuthCode")
	public String checkPassword(HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession seesion = request.getSession();
		String authCode = request.getParameter("authCode");
		String sauthCode = (String) seesion.getAttribute("authCode");
		if (authCode==""||authCode==null) {
			out.println("验证码不能为空");
			return "flase";
		}
		if (!authCode.toLowerCase().equals(sauthCode.toLowerCase())) {
			out.println("验证码不同");
			return "flase";
		}else {
			out.println("验证码通过");
			return "true";
		}
	}
	
	@RequestMapping("/user")
	public String getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("snumber");
		User user = userService.getUser(id);
		session.setAttribute("user", user);
		if (user.getUserType().equals("学生")) {
			return "student/user";
		}
		return "teacher/user";
	}
	
	@RequestMapping("/updatePw")
	public String updatePassword(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("snumber");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String code = request.getParameter("code");
		if(code.toLowerCase().equals(str.toLowerCase())){
			User user = userService.getUser(id);
			if (password.equals(password2)) {
				String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
				user.setPassword(md5Password);
			}
			userService.updateUser(user);
			session.setAttribute("user", user);
		
			return "../../login";
		
		}else{
			User user = userService.getUser(id);
			/*userService.updateUser(user);
			session.setAttribute("user", user);*/
		
			if (user.getUserType().equals("学生")) {
				return "student/user";
			}
			return "teacher/user";
		}
		
	}
	@SuppressWarnings("static-access")
	@RequestMapping("/code")
	public String code(HttpServletRequest request){
		String phone = request.getParameter("phone");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("snumber");
		Student student = studentService.getStudentById(id);
		str="";
		if (!student.getPhone().equals(phone)) {
			return "student/user";
		}
		str=mondelCode();
		//System.out.println(str);
		this.codeAndPhone(phone, str);
		return phone;
	}
	
	public static void codeAndPhone(String phone,String code) {
	    String host = "http://dxyzm.market.alicloudapi.com";
	    String path = "/chuangxin/dxjk";
	    String method = "GET";
	    String appcode = "c378534bcd9a4eb4a9d49b235b27bf99";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("content", "【成都创信信息】验证码为："+code+",欢迎注册平台！");
	    querys.put("mobile", phone);


	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	public String mondelCode(){
		  String str="abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
	        Random r=new Random();
	        String arr[]=new String [4];
	        String b="";
	        for(int i=0;i<4;i++)
	        {
	            int n=r.nextInt(62);
	        
	            arr[i]=str.substring(n,n+1);
	            b+=arr[i];
	            
	        }
	        return b;
	}
}