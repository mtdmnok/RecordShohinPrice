package com.example.demo;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;

import com.example.demo.dto.LoginDto;

public class DemoUserDetails extends User{
	
	private final LoginDto demoUserInfo;
	
	public DemoUserDetails(LoginDto demoUserInfo, String password) {
        super(demoUserInfo.getUser_id(), password, Collections.emptyList());
        this.demoUserInfo = demoUserInfo;
    }
	
	public LoginDto getDemoUser() {
		
		return demoUserInfo;
	}

}
