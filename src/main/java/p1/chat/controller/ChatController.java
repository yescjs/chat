package p1.chat.controller;

import p1.chat.dto.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // /app/chat 로 메시지를 보내면 /topic/messages로 브로드캐스트
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage broadcast(ChatMessage message) {
        return message;
    }
}
