package com.tekcosbew.websocket.controller;

import com.tekcosbew.websocket.model.entity.Room;
import com.tekcosbew.websocket.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public String createRoomForm() {
        return "room/createForm";
    }

    @PostMapping
    public String createRoom(@RequestParam("name") String name) {

        roomService.createRoom(name);
        return "redirect:/";
    }

    @GetMapping("/{roomNo}")
    public String entryRoom(@PathVariable("roomNo") long roomNo, Model model) {
        Room room = roomService.findByRoomNo(roomNo);
        model.addAttribute("room", room);
        return "room/chatroom";
    }
}
