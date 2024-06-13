package com.tekcosbew.websocket.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker   // 웹 소켓 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 웹 소켓 엔드포인트 등록
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // 엔드포인트를 /ws로 등록하고 모든 출처 경로 허용
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("/*")
                .withSockJS();
    }

    // 메시지 브로커 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        config.enableSimpleBroker("/sub");  // 클라이언트는 토픽 구독 시 /sub 경로로 요청
        config.setApplicationDestinationPrefixes("/pub");    // 클라이언트는 메시지 발생 시 /pub 경로로 요청
    }
}