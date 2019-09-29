package com.cdxyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ReputationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReputationApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "index";
	}
	@GetMapping("/index")
	public String index1(){
		return "index";
	}
	@GetMapping("/archive")
	public String archive(){
		return "archive";
	}
	@GetMapping("/single")
	public String single(){
		return "single";
	}
	@GetMapping("/contact")
	public String contact(){
		return "contact";
	}
	@GetMapping("/admin")
	public String admin(){
		return "admin/login1";
	}
}
