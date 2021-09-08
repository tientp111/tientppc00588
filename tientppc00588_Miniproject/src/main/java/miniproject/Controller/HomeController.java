package miniproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home/about")
	public String about() {
		return "layout/about";
	}
	
	@RequestMapping("/home/contact")
	public String contact() {
		return "layout/contact";
	}
	
	@RequestMapping("/home/editprofile")
	public String editprofile() {
		return "user/editProfile";
	}
	
	@RequestMapping("/home/registration")
	public String registration() {
		return "user/registration";
	}
	
	//============================
	
	@RequestMapping({"/", "/home/index"})
	public String home() {
		return "redirect:/product/list";
	}
	
	@RequestMapping({"/admin/**", "/admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
}
