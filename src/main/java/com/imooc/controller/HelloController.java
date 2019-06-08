package com.imooc.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.pojo.IMoocJSONResult;
import com.imooc.pojo.Resource;

/**
 * 
 * @author ADMIN
 * @RestController 表示所有以字符串的形式去访问数据
 */

@RestController
public class HelloController {
	
	@Autowired
	private Resource resource;
	

	@RequestMapping("/hello")
	public Object hello() {
		return "Hello Spring Boot~~";
	}
	
	@RequestMapping("/getResource")
	public IMoocJSONResult getResource() {
		
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		
		return IMoocJSONResult.ok(bean);
	}

}
