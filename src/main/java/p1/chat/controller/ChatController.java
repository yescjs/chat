package p1.chat.controller;

import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import p1.chat.dto.ChatMessage;
import p1.chat.pubsub.RedisPublisher;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final RedisPublisher redisPublisher;
    private final ChannelTopic topic = new ChannelTopic("chatroom");

    @MessageMapping("/chatroom/{roomId}")
    public void senMessage(@DestinationVariable Long roomId, ChatMessage message) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender(message.getSender());
        chatMessage.setMessage(message.getMessage());
        chatMessage.setRoomId(message.getRoomId());
        
        redisPublisher.publish(topic, message);
    }
}
