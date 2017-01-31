/*****************************************************
* Copyright (c) by Laboratory Corporation of America *
* All Rights Reserved.                               *
******************************************************/

/**
 * 
 */
package com.example.config;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.IService;
import com.example.ServiceImpl;

@Configuration
public class AppConfig {
	

	@Bean 
	public BlockingQueue<String> createQueue() {
		 BlockingQueue<String> lqueue = new LinkedBlockingQueue<>();	
		return lqueue;
	}
	
	@Bean
	public IService service() {
		IService svc = new ServiceImpl();
		return svc;
	}
}
