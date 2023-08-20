package com.app.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of " + getClass());
	}
	@GetMapping("/")
	 public String home() {
        return "index"; // Return the name of the HTML or Thymeleaf template for the home page
    }
}
