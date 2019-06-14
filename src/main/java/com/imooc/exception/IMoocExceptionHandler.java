package com.imooc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.imooc.pojo.IMoocJSONResult;
/**
 * Request 请求的形式
 * @author ADMIN
 *
 */
@ControllerAdvice						//表示一个注入类 当请求发生异常时
public class IMoocExceptionHandler {	//<<<<<<会被此类进行捕获

	public static final String IMOOC_ERROR_VIEW = "error";

//	@ExceptionHandler(value = Exception.class)					//在这里配置 只捕获 Exception 的异常 不捕获 reqest ，response
//    public Object errorHandler(HttpServletRequest reqest, 		//需要实现 errorHandler 
//    		HttpServletResponse response, Exception e) throws Exception {
//    	
//    	e.printStackTrace();									//后台打印异常
//    	//捕获异常后提供跳转的页面
//		ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);							//错误信息
//        mav.addObject("url", reqest.getRequestURL());			//错误信息地址
//        mav.setViewName(IMOOC_ERROR_VIEW);						//此处是自定义的一个跳转页面
//        return mav;
//    }
	
	
	
	
	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	
    	if (isAjax(reqest)) {			//如果方法返回的是 true 则 直接返回 response  ajax 形式返回
    		return IMoocJSONResult.errorException(e.getMessage());
    	} else {						//以 web mvc 形式返回
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
    	}
    }
	
	/**
	 * 
	 * @Title: IMoocExceptionHandler.java
	 * @Package com.imooc.exception
	 * @Description: 判断是否是ajax请求
	 * Copyright: Copyright (c) 2017
	 * Company:FURUIBOKE.SCIENCE.AND.TECHNOLOGY
	 * 
	 * @author leechenxiang
	 * @date 2017年12月3日 下午1:40:39
	 * @version V1.0
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) ); //通过getHeader 来获取请求 并判断请求是否是ajax 如果是返回true
	}																					  //此方法为固定写法
}
