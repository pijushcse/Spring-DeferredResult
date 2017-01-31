/*****************************************************
* Copyright (c) by Laboratory Corporation of America *
* All Rights Reserved.                               *
******************************************************/

/**
 * 
 */
package com.example;

import org.springframework.web.context.request.async.DeferredResult;

public interface IService {
	public void update(String msg, DeferredResult<String> deferredResult) ;
}
