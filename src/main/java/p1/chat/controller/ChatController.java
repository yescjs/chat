package p1.chat.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import p1.chat.dto.ChatMessage;

@Controller
public class ChatController {

    @MessageMapping("/chatroom/{roomId}")
    @SendTo("/topic/chatroom/{roomId}")
    public ChatMessage senMessage(@DestinationVariable Long roomId, ChatMessage message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender(message.getSender());
        chatMessage.setMessage(message.getMessage());
        chatMessage.setRoomId(message.getRoomId());

        return chatMessage;
    }
}
