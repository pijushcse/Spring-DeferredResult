/*****************************************************
 * Copyright (c) by Laboratory Corporation of America *
 * All Rights Reserved.                               *
 ******************************************************/

/**
 * 
 */
package com.example;

import java.util.concurrent.BlockingQueue;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Component
public class ServiceImpl implements Runnable, IService {

	@Autowired
	BlockingQueue<String> bQueue;
	
	DeferredResult<String> deferredResult = null;
	
	@PostConstruct
	private void init() {
		new Thread(this).start(); 
	}

	@Override
	public void run() {
		String msg;
		while (true) {
			try {
				msg = bQueue.take();				
				System.out.println("Message Received from Queue " + msg);
				deferredResult.setResult(msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

	@Override
	public void update(String msg, DeferredResult<String> deferredResult) {
		try {
			this.deferredResult = deferredResult;
			this.bQueue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}