package kr.kh.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.boot.model.vo.BoardVO;
import kr.kh.boot.model.vo.CustomUser;
import kr.kh.boot.model.vo.FileVO;
import kr.kh.boot.model.vo.MemberVO;
import kr.kh.boot.model.vo.PostVO;
import kr.kh.boot.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;

	@GetMapping("/list/{bo_num}")
	public String postList(Model model, @PathVariable int bo_num) {
		List<PostVO> postList = postService.getPostList(bo_num);
		List<BoardVO> boardList = postService.getBoardList();

		model.addAttribute("postList", postList);
		model.addAttribute("url", "/post/list");
		model.addAttribute("boardList", boardList);
		return "post/list";
	}

	@GetMapping("/detail/{po_num}")
	public String getMethodName(Model model, @PathVariable int po_num) {
		PostVO post = postService.getPost(po_num);
		List<FileVO> list = postService.getFileList(po_num);

		model.addAttribute("post", post);
		model.addAttribute("list", list);
		return "post/detail";
	}
	
	@GetMapping("/insert")
	public String postInsert(Model model) {
		List<BoardVO> list = postService.getBoardList();
		model.addAttribute("list", list);
		return "post/insert";
	}
	@PostMapping("/insert")
	public String postInsertPost(PostVO post, @AuthenticationPrincipal CustomUser customUser) {
		System.out.println(post);
		//로그인한 회원 정보를 가져옴
		if(customUser != null){
			MemberVO user = customUser.getMember();
			post.setPo_me_id(user.getMe_id());
		}
		if(postService.insertPost(post)){
			return "redirect:/post/list/" + post.getPo_bo_num();
		}
		return "redirect:/post/insert";
	}
	
}
