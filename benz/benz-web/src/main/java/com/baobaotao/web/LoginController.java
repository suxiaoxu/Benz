package com.baobaotao.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baobaotao.domain.User;
import com.baobaotao.service.UserService;
@Controller
public class LoginController{
	
	private static Logger logger = Logger.getLogger(LoginController.class);
	@Autowired
	private UserService userService;
    
	@RequestMapping(value = "/index.html")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
		boolean isValidUser = 
			   userService.hasMatchUser(loginCommand.getUserName(),
					                    loginCommand.getPassword());
		logger.error("log ==========");
		
		if (!isValidUser) {
			return new ModelAndView("login", "error", "用户名或密码错误�?");
		} else {
			User user = userService.findUserByUserName(loginCommand
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}