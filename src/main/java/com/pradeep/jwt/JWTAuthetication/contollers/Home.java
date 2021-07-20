package com.pradeep.jwt.JWTAuthetication.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

	@GetMapping("/welcome")
	public String test() {
		String s="This is a private page";
		return s;
		
	}
}
