package com.example.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Device;
import com.example.model.Devices;

@Controller

public class MainController {
	
	@Autowired
	private RestTemplate rs;
	
	
	
	@RequestMapping("/home")
	public String home() {
		return "home.html";
	}
	
	@RequestMapping("/samsung")
	public ModelAndView samsung() {
		
		ModelAndView mv=new ModelAndView("/samsung");
//		rs=new RestTemplate();
		Devices deviceList=rs.getForObject("http://Samsung/samsung", Devices.class); //devices object data
		
//		Devices deviceList= new Devices(myList, "samsung");
		mv.addObject("samsung", deviceList);
		return mv;
	}

	@RequestMapping("/apple")
	public String apple() {
		return "apple.html";
	}


}
