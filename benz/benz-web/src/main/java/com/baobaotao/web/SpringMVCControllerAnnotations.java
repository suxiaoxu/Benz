package com.baobaotao.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.UserT;


@Controller
public class SpringMVCControllerAnnotations {

	@RequestMapping(value = "/welcomex")
	public String welcomeX1(){
		return "welcomex";
	}
	
	@RequestMapping(value = "/welcomexp")
	public ModelAndView welcomeXP2(){
		ModelAndView sn = new ModelAndView();
		sn.addObject("result", 123);
		sn.addObject("tn",234);
		sn.setViewName("welcomexp");
		return sn;
	}
	
	@RequestMapping(value = "welcomexp1")
	public String welcomeX1(HttpServletRequest request){
		request.setAttribute("result", 123);
		request.setAttribute("tn", 888);
		return "welcomexp";
	}
	
	@RequestMapping("/addUser")
	public String addUser(UserT user,HttpServletRequest request){
		request.setAttribute("userName", user.getUserName());
		request.setAttribute("age", user.getAge());
		return "/userManager";
	}
	
	@RequestMapping("/add")
	public String view(){
		return "addUser";
	}
	
	@RequestMapping("/addUserJson")
	public void addUserJson(UserT user,HttpServletRequest request,HttpServletResponse response){
		String result = "{\"userName\":\" "+ user.getUserName() +" \",\"age\":\" "+ user.getAge()+" \"}";
		PrintWriter out = null;
		response.setContentType("application/json");
		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
