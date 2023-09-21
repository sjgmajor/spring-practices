package com.poscodx.fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileUploadController {
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(String email, Model model) {
		System.out.println();
		
		/* 이미지 파일 업로드 처리 */
		
		String url = "";
		model.addAttribute("url", url);
		return "result";
	}
}
