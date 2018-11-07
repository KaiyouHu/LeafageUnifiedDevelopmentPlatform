package com.cqu.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cqu.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 一个用来测试swagger注解的控制器
 * 
 * @author love_paeonia
 */
@RestController
@RequestMapping("/SoftwareArchitectureDesign")
@Api(value = "SoftwareArchitectureDesign|软件架构设计")
public class SoftwareArchitectureDesign {

	@ResponseBody
	@RequestMapping(value = "/login")
	@ApiOperation(value="用户名和密码登录", notes="test: admin 123456",produces = "application/json")
    public User login(@RequestBody User user) {
		if(user.getUsername().equals("admin")&&user.getPassword().equals("123456")) {
			user.setUuid("admin-uuid");
			user.setToken("d787syv8dys8cas80d9s0a0d8f79ads56f7s4d56f879a8as89fd980s7dg");
			return user;
		} else {
			return user;
		}
    }
	
	@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
	@RequestMapping(value = "/formlogin",method = RequestMethod.POST)
	@ApiOperation(value="用户名和密码登录", notes="test: admin 123456",consumes = "application/x-www-form-urlencoded")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String")
	})
    public String formlogin(@RequestParam("username") String username, @RequestParam("password") String password) {
		if(username.equals("admin")) {
			return username;
		} else {
			return "guest";
		}
    }
	
	@RequestMapping(value = "/check",method = RequestMethod.POST)
	@ApiOperation(value="用户名和密码登录", notes="test: 100001 token",consumes = "application/x-www-form-urlencoded")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userid", value = "用户id", required = true, paramType = "query", dataType = "String"),
		@ApiImplicitParam(name = "token", value = "用户token", required = true, paramType = "query", dataType = "String")
	})
    public String check(@RequestParam("userid") String userid, @RequestParam(required = true) String token) {
		if(userid.equals("admin")) {
			return userid;
		} else {
			return "guest";
		}
    }
}