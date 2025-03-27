package kr.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.service.CommentService;

@RestController	//컨트롤러 안의 모든 메소드에 @ResponseBody가 붙는 경우에 사용
public class CommentController {

	@Autowired
	CommentService commentService;
}
