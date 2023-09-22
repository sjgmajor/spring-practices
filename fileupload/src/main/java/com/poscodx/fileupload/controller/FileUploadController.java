package com.poscodx.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscodx.fileupload.service.FileuploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public String upload(
						@RequestParam("e") String email,
						@RequestParam(value = "f", required=true, defaultValue="/assets/images/loopy.jpg") MultipartFile file,
						Model model) {
		System.out.println("--->" + email);
		
		/* 이미지 파일 업로드 처리 */
		String url = fileuploadService.restore(file);
		
		model.addAttribute("url", url);
		return "result";
	}
}
