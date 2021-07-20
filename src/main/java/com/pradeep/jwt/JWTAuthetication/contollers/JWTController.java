package com.pradeep.jwt.JWTAuthetication.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.jwt.JWTAuthetication.domain.JWTRequest;
import com.pradeep.jwt.JWTAuthetication.domain.JWTResponse;
import com.pradeep.jwt.JWTAuthetication.services.CustomUserDetailService;
import com.pradeep.jwt.JWTAuthetication.util.JWTUtil;


@RestController
public class JWTController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	JWTUtil jWTUtil;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JWTRequest jWTRequest) throws Exception {
		System.out.println(jWTRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jWTRequest.getUsername(), jWTRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad credential");
		}
		
		UserDetails userDetails=this.customUserDetailService.loadUserByUsername(jWTRequest.getUsername());
		String token=this.jWTUtil.generateToken(userDetails);
		System.out.println("JWT : "+token);
		return ResponseEntity.ok(new JWTResponse(token));
	}
}
