package com.hek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hek.service.ReportService;
import com.hek.vo.Criteria;
import com.hek.vo.PageDTO;
import com.hek.vo.ReportVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/report/*")
@AllArgsConstructor
public class ReportController {

	private ReportService service;
	
	@GetMapping("/register")
	public String register(ReportVO report, RedirectAttributes rttr) {
		
		log.info("===================");
		
		log.info("register: "+ report);
		
		if(report.getAttachList() != null){
			report.getAttachList().forEach(attach -> log.info(attach));
		}
		
		log.info("===================");
		
		service.register(report);
		
		rttr.addFlashAttribute("result", report.getBno());
		
		return "redirect:/report/list";
	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		
		model.addAttribute("list", service.getList(cri));
		
		int total =service.getTotal(cri);
		
		log.info("total " + total );
		
		model.addAttribute("pageMapker" , new PageDTO(cri, total));
	}
}
