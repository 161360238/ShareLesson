/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.pdsu.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "JeeSite接口测试" })
@RequestMapping(value = "/api-basic")
public class APIController {

	@ResponseBody
	@RequestMapping(value = "hello", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ApiOperation(value = "hello", notes = "hello world", response = String.class)
	public String hello() {
		return "接口测试成功:Hello World";

	}

}