package com.myproject.myproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/Hellow-World")
	public String helloworld() {
		return "Hello";
	}
	
	@GetMapping(path="/Hellow-World-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello");
	}
	
	@GetMapping(path="/Hellow-World-bean/path-variable/{name}")
	public HelloWorldBean helloworldbeanpath(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hellow-World, %s",name));
	}

}
