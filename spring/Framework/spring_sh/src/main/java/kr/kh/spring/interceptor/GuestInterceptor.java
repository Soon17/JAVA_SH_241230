package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MessageService;

public class GuestInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MessageService messageService;
	
	@Override
	public void postHandle(
						    HttpServletRequest request, 
						    HttpServletResponse response, 
						    Object handler, 
						    ModelAndView modelAndView)
	    throws Exception {
		
	}
	
	@Override
	public boolean preHandle(
							HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler)
							throws Exception {
		//세션에 있는 회원 정보를 가져옴
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		//로그인되지 않은 상태이면
		if(user == null)
			return true;
		
		messageService.sendMessage(response, request, "로그인 한 회원은 갈 수 없는 페이지입니다.", "/");
		//아니면 메인 페이지로 보냄
		return false;
	}
}