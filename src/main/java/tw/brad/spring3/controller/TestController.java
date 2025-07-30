package tw.brad.spring3.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.brad.spring3.entity.MemberForm;
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
		
		String now = 
			LocalDateTime.now().format(
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		model.addAttribute("now", now);
		
		return "page1";
	}
	
	@GetMapping("/member/register")
	public String register(Model model) {
		
		MemberForm form = new MemberForm();
		form.setAccount("brad");
		
		//List<String> areas = List.of("北屯區","南屯區","西屯區","北區","西區");
		List<Map<String,String>> areas = List.of(
				Map.of("zipcode","401","name","北屯區"),
				Map.of("zipcode","402","name","南屯區"),
				Map.of("zipcode","403","name","西屯區"),
				Map.of("zipcode","404","name","北區"),
				Map.of("zipcode","405","name","西區")
				);
		
		
		model.addAttribute("areas", areas);
		
		model.addAttribute("memberForm", form);
		
		return "member/register";
	}
	@PostMapping("/member/register")
	public String addMember(Model model, 
			@ModelAttribute MemberForm form) {
		
		System.out.println(form.getAccount());
		System.out.println(form.getPasswd());
		System.out.println(form.getName());
		System.out.println(form.getArea());
		
		model.addAttribute("status", "註冊成功");
		
		return "member/register";
	}
	
}
