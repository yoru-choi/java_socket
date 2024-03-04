package com.websocket.socket;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class WebSocketSessionListener {

    private static final int MAX_CONNECTIONS = 1;
    private Set<String> sessions = Collections.synchronizedSet(new HashSet<>());

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        System.out.println("진행중"+sessions.size());
        if (sessions.size() > MAX_CONNECTIONS) {
            System.out.println("문제 발생"+sessions.size());
        }else{
            sessions.add(headers.getSessionId());
        }
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headers = StompHeaderAccessor.wrap(event.getMessage());
        sessions.remove(headers.getSessionId());
    }
}