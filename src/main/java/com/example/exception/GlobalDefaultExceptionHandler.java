package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理.
 * 思路：
 * 1、在Class上添加注解@ControllerAdvice.
 * 2.在方法上添加@ExceptionHandler拦截相应的异常信息.
 * 3、如果返回的是View--方法的返回值是ModelAndView.
 * 4、如果返回值是String或者Json--需在方法上添加注解@ResponseBody。
 * 
 * @author PVer
 *
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String defaultExceptionHandler(HttpServletRequest req, Exception e) {
		return "对不起，服务器繁忙，请稍后在试！";
	}
}
