package com.moon.mProject.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class HomeController {

	@RequestMapping(value ={"/", "/home"}, method = RequestMethod.GET)
	public String Home() {
		return "home/home";
	}
}
