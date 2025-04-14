package kr.kh.spring2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring2.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/list")
	public String listist() {
		return "/post/list";
	}
}
