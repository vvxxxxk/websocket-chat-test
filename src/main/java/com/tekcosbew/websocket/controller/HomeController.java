package com.tekcosbew.websocket.controller;

import com.tekcosbew.websocket.model.entity.Room;
import com.tekcosbew.websocket.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RoomService roomService;

    @GetMapping("/")
    public String home(Model model) {

        List<Room> rooms = roomService.findAll();
        model.addAttribute("rooms", rooms);
        return "/home";
    }
}
