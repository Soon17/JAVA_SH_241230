package kr.kh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.model.dto.PersonDTO;

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
	
	public String home(Model model, String name, Integer age) {
		System.out.println("화면에서 보낸 이름 : " + name);
		System.out.println("화면에서 보낸 나이 : " + age);
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
	
	/*
	 * 메소드의 매개변수에 객체를 넣어주면, 매핑이 되던 안되던 기본 생성자를 이용해서 객체를 만듦
	 * 	=> 화면에서 보낸 변수의 이름과 같은 필드가 있으면 자동으로 맵핑이 되어 값이 변경됨.
	 * 		이때 setter를 호출
	 */
	
	//@GetMapping과 @PostMapping에서 처리하는 내용이 같은 경우 @RequestMapping으로 묶을 수 있다.
	@RequestMapping("/send")
	public String send(Model model, PersonDTO person) {
		System.out.println("화면에서 보낸 이름과 나이 : " + person);
		//서버에서 화면으로 객체를 전송
		model.addAttribute("person", person);
		return "sample/send";
	}
	
//	@GetMapping("/send")
//	public String send(Model model, PersonDTO person) {
//		System.out.println("화면에서 보낸 이름과 나이 : " + person);
//		/*서버에서 화면으로 전송*/
//		model.addAttribute("person",person);
//		return "sample/send";
//	}
//	
//	@PostMapping("/send")
//	public String send(Model model, PersonDTO person) {
//		System.out.println("화면에서 보낸 이름과 나이 : " + person);
//		/*서버에서 화면으로 전송*/
//		model.addAttribute("person",person);
//		return "sample/send";
//	}
	
	@GetMapping("/{name}/{age}")
	public String nameAge(@PathVariable("name")String name1, @PathVariable("age")int age1) {
		System.out.println("화면에서 전송한 이름 : " + name1);
		System.out.println("화면에서 전송한 이름 : " + age1);
		return "sample/send";
	}
	
	@GetMapping("/redirect")
	public String redirect( PersonDTO person) {
		System.out.println(person);
		/* redirect 방식
		 * - URL 변경
		 * - 해당 URL를 처리하는 메소드를 호출
		 * - 기존 request 정보는 전송하지 않음.
		 * */
		return "redirect:/send";
	}
	
	@GetMapping("/forward")
	public String forward( PersonDTO person) {
		System.out.println(person);
		/* forward 방식
		 * - URL 변경되지 않음
		 * - 해당 URL를 처리하는 메소드를 호출
		 * - 기존 request 정보도 같이 전송 => 매개변수로 받은 데이터들도 함께 전송
		 * 
		 * */
		return "forward:/send";
	}
}