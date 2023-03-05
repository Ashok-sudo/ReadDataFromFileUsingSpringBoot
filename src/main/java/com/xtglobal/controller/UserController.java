package com.xtglobal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.xtglobal.entity.User;
import com.xtglobal.service.UserService;

@Controller
public class UserController 
{
	
	@Autowired
	private UserService service;
	
	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("user", new User());
		
		List<User> users = service.findAll();
		model.addAttribute("users", users);
		return "view/users";
	}
	
	@PostMapping(value="/fileupload")
	public String uploadFile(@ModelAttribute User user,RedirectAttributes redirectAttributes)
	{
		
		boolean isFlag = service.saveDataFromUploadfile(user.getFile());
		if(isFlag)
		{
			redirectAttributes.addFlashAttribute("successmessage","File Upload Successfully");
			
		}
		else
		{
			System.out.println("hello");
			redirectAttributes.addFlashAttribute("errormessage","File Upload not done, Please try again!");
		}
		
		
		
		return "redirect:/";
		
	}
	
	
	
	
	

}
