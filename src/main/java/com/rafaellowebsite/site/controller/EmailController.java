package com.rafaellowebsite.site.controller;

import java.io.IOException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaellowebsite.site.entity.Email;
import com.rafaellowebsite.site.service.EmailService;

import jakarta.mail.MessagingException;


@RestController
@RequestMapping("/email")
public class EmailController {
    
	private final EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> testConnect() {
		System.out.println("Connected");
		return new ResponseEntity<>("Connected", HttpStatus.OK);
	}
	
	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody Email email) throws MessagingException, IOException {
		try {
			emailService.sendEmail(email);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>("Sent", HttpStatus.OK);
	}
}
