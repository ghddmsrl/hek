package com.hek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/login/*")
@Controller
public class LoginController {

	@GetMapping("/all")
	public void doAll(){
		log.info("모든사람이 접근 가능");
	}
	
	@GetMapping("/member")
	public void doMember(){
		log.info("로그인한 멤버만 접근 가능");
	}
	
	@GetMapping("/admin")
	public void doAdmin(){
		log.info("관리자만");
	}
}
