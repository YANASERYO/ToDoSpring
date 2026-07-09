package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.form.ReservationForm;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.model.LoginUser;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;

@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    public ReservationController(
            ReservationService reservationService,
            ReservationMapper reservationMapper
    ) {
        this.reservationService = reservationService;
        this.reservationMapper = reservationMapper;
    }

    // ToDoタスク一覧
    @GetMapping("/reservations")
    public String showReservationList(HttpSession session, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            model.addAttribute("errorMsg", "セッションが切れていますので、再度ログインして下さい。");
            return "index";
        }

        String userId = String.valueOf(loginUser.getUserId());

        List<ReservationEntity> reservations =
                reservationService.findReservationsByUserId(userId);

        model.addAttribute("reservations", reservations);
        model.addAttribute("loginUser", loginUser);

        return "todolist";
    }

    // ToDoタスク新規登録画面
    @GetMapping("/reservations/new")
    public String showReservationForm(HttpSession session, Model model) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            model.addAttribute("errorMsg", "セッションが切れていますので、再度ログインして下さい。");
            return "index";
        }

        ReservationForm reservationForm = new ReservationForm();

        // 担当者にログインユーザー名を初期表示
        reservationForm.setTaskUser(loginUser.getStaffName());

        // 初期値：未着手
        reservationForm.setTaskStatus(0);

        model.addAttribute("reservationForm", reservationForm);
        model.addAttribute("loginUser", loginUser);

        return "todoform";
    }

    // ToDoタスク新規登録処理
    @PostMapping("/reservations")
    public String createReservation(
            @Valid @ModelAttribute ReservationForm reservationForm,
            BindingResult bindingResult,
            HttpSession session,
            Model model
    ) {
        LoginUser loginUser = (LoginUser) session.getAttribute("loginUser");

        if (loginUser == null) {
            model.addAttribute("errorMsg", "セッションが切れていますので、再度ログインして下さい。");
            return "index";
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("loginUser", loginUser);
            return "todoform";
        }

        String userId = String.valueOf(loginUser.getUserId());

        Reservation reservation = reservationMapper.toModel(reservationForm, userId);
        reservationService.createReservation(reservation);

        return "redirect:/reservations";
    }
}