package com.example.demo.controller;

import java.util.Optional;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.UserAccountEntity;
import com.example.demo.model.LoginUser;
import com.example.demo.repository.UserAccountRepository;


@Controller
public class LoginController {
	
	private final UserAccountRepository userAccountRepository;
	
	public LoginController(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

	@GetMapping("/")
	public String showLoginForm() {
	    return "index";
	}

    @PostMapping("/login")
    public String login(
    		@RequestParam String userId,
    		@RequestParam String password,
    		HttpSession session,
    		Model model) {


    	Optional<UserAccountEntity> userOpt = userAccountRepository.findByUsername(userId);

    	if (userOpt.isPresent()) {
    	    UserAccountEntity user = userOpt.get();

    	    if (user.getPassword().equals(password)) {
    	        LoginUser loginUser = new LoginUser(user.getId(), user.getUsername(), "STAFF");
    	        session.setAttribute("loginUser", loginUser);
    	        return "redirect:/menu";
    	    }
    	}
    	model.addAttribute("errorMsg", "IDまたはパスワードが違います");
    	return "index";
    }
	
    @PostMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
    @GetMapping("/menu")
    public String showMenu(HttpSession session,Model model) {
    	LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/";
        }

        model.addAttribute("loginUser", loginUser);

        return "menu";
    }
}