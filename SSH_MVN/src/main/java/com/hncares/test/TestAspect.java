package com.hncares.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hncares.aop.LogAspect;

public class TestAspect {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");  
        LogAspect service=(LogAspect) context.getBean("logAspect");  
        System.out.println(2);
		login();
		System.out.println(111111);
	}
	
	
	

	public static void login() {
		// TODO Auto-generated method stub

		System.out.println("testLogin runing");
	}
	
}
