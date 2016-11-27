package com.baobaotao.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class SpringMVCControllerXml implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndview = new ModelAndView();
		modelAndview.addObject("result", 123);
		modelAndview.addObject("tn",234);
		modelAndview.setViewName("welcomexp");
		return modelAndview;
	}

}
