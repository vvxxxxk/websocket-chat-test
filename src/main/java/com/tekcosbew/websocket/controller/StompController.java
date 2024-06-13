package com.tekcosbew.websocket.controller;

import com.tekcosbew.websocket.common.constants.MessageType;
import com.tekcosbew.websocket.model.dto.MessageDto;
import com.tekcosbew.websocket.model.dto.SendMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class StompController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/user.join")
    public void addUser(SimpMessageHeaderAccessor headerAccessor) {
        System.out.println("StompController.addUser");
    }

    @MessageMapping("/chat.send")
    public void sendMessage(SimpMessageHeaderAccessor headerAccessor, MessageDto message) {
        System.out.println("StompController.sendMessage");

        Map<String, Object> data = new HashMap<>();
        data.put("sender", message.getSender());
        data.put("content", message.getContent());

        messagingTemplate.convertAndSend("/sub/" + message.getRoomNo(), SendMessageDto.builder()
                .data(data)
                .type(MessageType.USER_JOIN)
                .build());
    }
}
