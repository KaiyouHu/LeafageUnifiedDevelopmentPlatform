package com.cqu.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@SpringBootApplication(scanBasePackages="com.cqu")
@RestController
@CrossOrigin
@RequestMapping("/home")
@Api(value = "LeafageUnifiedDevelopmentPlatformApplication|leafage后端")
public class LeafageUnifiedDevelopmentPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeafageUnifiedDevelopmentPlatformApplication.class, args);
	}
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	@ApiOperation(value="Hello World", notes="test: none")
    public String home() {
        return "Hello World";
    }
}
