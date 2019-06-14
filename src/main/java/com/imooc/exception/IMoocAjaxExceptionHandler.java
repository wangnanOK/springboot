package com.imooc.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.imooc.pojo.IMoocJSONResult;

/**
 * AJAX 请求形式
 * @author ADMIN
 *
 */
@RestControllerAdvice
public class IMoocAjaxExceptionHandler {

//	@ExceptionHandler(value = Exception.class)
//	public IMoocJSONResult defaultErrorHandler(HttpServletRequest req, 
//			Exception e) throws Exception {
//
//		e.printStackTrace();
//		return IMoocJSONResult.errorException(e.getMessage());
//	}
}
