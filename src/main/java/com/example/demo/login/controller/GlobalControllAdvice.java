package com.example.demo.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalControllAdvice {
	
	// userDetailでユーザーIDを指定しないリクエストを投げた際の例外はdataAccessExceptionではなく、以下
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public String dataAccessExceptionHandler(HttpRequestMethodNotSupportedException e, Model model) {
		
		model.addAttribute("error", "不当なリクエスト:GlobalControllAdvice");
		model.addAttribute("message", "HttpRequestMethodNotSupportedExceptionが発生しました");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {

		model.addAttribute("error", "内部サーバーエラー:GlobalControllAdvice");
		model.addAttribute("message", "Exceptionが発生しました");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

		return "error";
	}
}
