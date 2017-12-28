package tech.onroad.springbootbase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tech.onroad.springbootbase.bean.StudentVO;
import tech.onroad.springbootbase.bean.UserVO;

@Controller
public class LoginController {
	
	@RequestMapping(value ="/", method = RequestMethod.GET)
	String home(Model model, UserVO user) {
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping(value ="/welcome", method = RequestMethod.GET)
	String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value ="/login", method = RequestMethod.GET)
	String login(Model model, UserVO user) {
		model.addAttribute("user", user);
		return "index";
	}
	
	/*	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, UserVO user, StudentVO student){
		System.out.println("POJO: " + user.getClass().getName() + 
				", hash code: " + user.hashCode() + ", " + user.toString());
		System.out.println("POJO: " + student.getClass().getName() + 
				", hash code: " + student.hashCode() + ", " + student.toString());
		model.addAttribute("user", user);
		return "index";
	}*/
	
	/*
	@RequestMapping(value ="/", method = RequestMethod.GET)
	String home(Model model, UserVO user) {
		model.addAttribute("user", user);
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(UserVO user, UserVO1 user1, RedirectAttributes redirect) {

		//redirect.addFlashAttribute("err_code", "invalid user");
		redirect.addFlashAttribute("user", user);
		
		if(user.getUid().equalsIgnoreCase("123"))
			return "redirect:login?logout";
		else 
			return "redirect:login?error";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
    public String hello(Model model, UserVO user, RedirectAttributes redirect,@RequestParam(value="name", required=false, defaultValue="World") String name) {
		redirect.addFlashAttribute("user", user);
		return "login";
    }*/
}
