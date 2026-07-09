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

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserAccountRepository userAccountRepository;

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

        Optional<UserAccountEntity> userOpt =
                userAccountRepository.findByUsername(userId);

        if (userOpt.isPresent()) {
            UserAccountEntity user = userOpt.get();

            if (user.getPassword().equals(password) && Boolean.TRUE.equals(user.getEnabled())) {
                LoginUser loginUser = new LoginUser(user.getUsername());
                session.setAttribute("loginUser", loginUser);
                return "redirect:/index";
            }
        }

        model.addAttribute("errorMsg", "ユーザーIDまたはパスワードが違います");
        return "index";
    }

    @GetMapping("/index")
    public String showIndex() {
        return "main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}