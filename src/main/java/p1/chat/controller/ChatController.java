package p1.chat.controller;

import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;
import p1.chat.dto.ChatMessage;
import p1.chat.pubsub.RedisPublisher;
import p1.chat.service.ChatMessageService;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final RedisPublisher redisPublisher;
    private final ChannelTopic topic = new ChannelTopic("chatroom");
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chatroom/{roomId}")
    public void senMessage(@DestinationVariable Long roomId, @Payload ChatMessage message) {
        // Redis Pub/Sub 발행
        message.setRoomId(roomId);
        redisPublisher.publish(topic, message);

        // DB 저장
        chatMessageService.saveMessage(roomId, message.getSender(), message.getMessage());
    }
}
