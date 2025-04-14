package kr.kh.spring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring2.model.vo.BoardVO;
import kr.kh.spring2.model.vo.PostVO;
import kr.kh.spring2.pagination.PageMaker;
import kr.kh.spring2.pagination.PostCriteria;
import kr.kh.spring2.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@GetMapping("/list")
	public String list(Model model) {
		//게시판 목록을 서비스에게 요청하여 가져온 후 화면에 전송
		
		List<BoardVO> boardList = postService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "/post/list";
	}
	
	@PostMapping("/list")
	//@ResponseBody 가 있으면 문자열 그대로 전송, 없으면 뷰 리졸버를 통해 화면을 출력
	public String listPost(Model model, @RequestBody PostCriteria cri) { //object일땐 RequestParam, json일 땐 RequestBody
		cri.setPerPageNum(2);
		//num을 서비스에게 주면서 게시판 번호에 맞는 게시글 목록 중 두개를 가져오라고 요청
		List<PostVO> postList = postService.getPostList(cri);
		//서비스에게 현재 페이지 정보를 주고 페이지메이커 객체를 달라고 요청
		PageMaker pm = postService.getPageMaker(cri);
		
		
		//가져온 게시글 목록을 화면에 전송
		model.addAttribute("postList", postList);
		model.addAttribute("pm", pm);
		return "post/sub";
	}
}
