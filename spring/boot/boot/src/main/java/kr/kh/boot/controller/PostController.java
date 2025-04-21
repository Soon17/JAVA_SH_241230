package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping("/list/{bo_num}")
	public String postList(Model model, @PathVariable int bo_num) {
		List<PostVO> postList = postService.getPostList(bo_num);
		model.addAttribute("postList", postList);
		model.addAttribute("url", "/post/list");
		return "post/list";
	}

	@GetMapping("/detail/{po_num}")
	public String getMethodName(Model model, @PathVariable int po_num) {
		PostVO post = postService.getPost(po_num);
		model.addAttribute("post", post);
		return "post/detail";
	}
	
	
}
