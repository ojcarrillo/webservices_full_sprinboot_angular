package com.in28minutes.rest.services.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		for(int i=1;i<=10;i++) {
			System.out.println(encoder.encode("123"));
		}
	}

}
