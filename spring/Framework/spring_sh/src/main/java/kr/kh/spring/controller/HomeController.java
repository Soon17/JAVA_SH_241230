package kr.kh.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * @Controller
 * 	=> HandlerMapping에 URL을 등록하기 위한 어노테이션
 */
@Controller
public class HomeController {
	
	/*
	 * @RequestMapping
	 * 	=> 처리할 URL정보를 지정하는 어노테이션으로 해당 정보와 일치하는 경우 메소드를 호출하여 실행
	 * 	=> value : 처리할 URL을 지정
	 * 	=> method : 리퀘스트 메소드 처리방식을 지정. GET, POST, PUT, DELETE 등
	 * 
	 * @GetMapping
	 * 	=> @RequestMapping(method = Request.GET)인 경우 대체할 수 있는 어노테이션
	 * 
	 * @PostMapping
	 * 	=> @RequestMapping(method = Request.Post)인 경우 대체할 수 있는 어노테이션
	 */
	
	//@RequestMapping(value = "/", method = RequestMethod.GET) 아래와 동일
	@GetMapping(value = "/")
	
	public String home(Locale locale, Model model) {
		
		/*
		 * 화면에 객체를 전송하는 방법
		 * - Model 객체를 이용하여 전송
		 * - addAttribute("화면에서 쓸 이름", 데이터);
		 */
		model.addAttribute("name","홍길동");
		
		/*
		 * 컨트롤러가 Dispatcher Servlet에게 home이라는 문자열을 반환
		 * 	=> 디스패처가 View Resolver에게 home이라는 문자열을 전달
		 * 	=> 뷰 리졸버는 설정한 방법에 따라 home을 가공함
		 * 		=> 뷰 리졸버 설정은 servlet-context.xml에 있음
		 * 		=> 기본 뷰 리졸버에 의해 /WEB-INF/view/home.jsp가 완성 되어 최종적으로 해당 jsp의 결과화면을 클라이언트에 전송
		 */
		return "home";
	}
	
}