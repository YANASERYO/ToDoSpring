package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.model.LoginUser;



@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
    		@RequestParam String userId,
    		@RequestParam String password,
    		HttpSession session,
    		Model model) {


    	Optional<UserAccountEntity> staffOpt = userAccountRepository.findByUsername(userId);

    	if (userOpt.isPresent()) {
    		UserAccountEntity staff = staffOpt.get();

    		if (staff.getPassword().equals(password) && staff.getEnabled()) {
    			LoginUser loginUser = new LoginUser(staff.getUsername(), "STAFF");
    			session.setAttribute("loginUser", loginUser);
    			return "redirect:/staff";
    		}
    	}
    	model.addAttribute("errorMsg", "IDまたはパスワードが違います");
    	return "login";
    }
	
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}