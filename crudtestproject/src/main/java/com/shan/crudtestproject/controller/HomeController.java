package com.shan.crudtestproject.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
class HomeController {//

	  String index(Model model) {
	        model.addAttribute("now", LocalDateTime.now());
	        return "index";
	    }

}