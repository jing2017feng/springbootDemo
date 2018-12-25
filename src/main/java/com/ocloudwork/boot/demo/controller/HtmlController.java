package com.ocloudwork.boot.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ocloudwork.boot.demo.annotation.RuntimeLog;

@Controller
public class HtmlController {
	/**
	 * 跳转到指定html页面
	 * @param page 页面
	 * @return
	 */
	@RuntimeLog
	@RequestMapping(path = "/html/route/{page}", method = RequestMethod.GET)
	public String route(@PathVariable("page") String page,HttpServletRequest request,Model model) {
		model.addAllAttributes(request.getParameterMap());
		return page;
	}
	
	/**
	 * 跳转到指定html页面,html在子文件夹中
	 * @param path
	 * @param page
	 * @return
	 */
	@RuntimeLog
	@RequestMapping(path = "/html/path/{path}/{page}", method = RequestMethod.GET)
	public String path(@PathVariable("path") String path,@PathVariable("page") String page,HttpServletRequest request,Model model) {
		model.addAllAttributes(request.getParameterMap());
		return path+"/"+page;
	}
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 */
	@RuntimeLog
	@RequestMapping(path = {"/index","/"}, method = RequestMethod.GET)
	public String path(HttpServletRequest request,Model model) {
		model.addAllAttributes(request.getParameterMap());
		return "index";
	}
}
