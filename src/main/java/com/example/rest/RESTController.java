/*****************************************************
 * Copyright (c) by Laboratory Corporation of America *
 * All Rights Reserved.                               *
 ******************************************************/

/**
 * 
 */
package com.example.rest;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.example.IService;

@RestController
public class RESTController {

	@Autowired
	IService service;

	@GetMapping("/queue/{id}")
	public DeferredResult<String> testBlockingQueue(@PathVariable("id") String id) {
		System.out.println("Request received");
		 final DeferredResult<String> deferredResult = new DeferredResult<>(); 

		service.update(id+" " + new Date().toString(), deferredResult);

		System.out.println("Response sent!");
		return deferredResult;
	}
}