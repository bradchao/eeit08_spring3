package tw.brad.spring3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.brad.spring3.entity.User;

/*
 * request -> Controller (Model) -> Model 網頁需要的資料
 * -> View(Resolver) -> Thymeleaf -> HTML -> Response
 * 
 * RestController(return => String(Web Page) => JSON) -> Controller(JSP, Thymeleaf)
 */
@Controller
@RequestMapping("/")
public class TestController {

	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}
	
	@GetMapping("/member/index")
	public String indexMember(Model model) {
		return "member/index";
	}
	
	@GetMapping("/page1")
	public String page1(Model model) {
		model.addAttribute("name", "Brad");
		model.addAttribute("companyName", "Brad Big Company");
		model.addAttribute("companyTel", "04-23265860");
		
		User user = new User();
		user.setName("Brad");
		user.setAge(17);
		user.setGender(false);
		model.addAttribute("user", user);
		
		
		return "page1";
	}
	
}
