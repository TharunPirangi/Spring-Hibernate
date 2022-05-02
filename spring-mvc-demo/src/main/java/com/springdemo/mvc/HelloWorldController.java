package com.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
	
	// need a controller method to show the form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
		
	// need a controller method to process the form
	
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloWorld";
	}
	
	
	
	// need a controller to read the form data
	// add data to the model
	
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {
		
		theName = theName.toUpperCase();
		
		// create the message
		
		String result = "YoYo!"+theName;
		
		// add message to the model
		
		model.addAttribute("message",result);
		
		return "helloWorld";
	}
	
	
}
