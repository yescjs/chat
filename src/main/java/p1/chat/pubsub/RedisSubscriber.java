package p1.chat.pubsub;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import p1.chat.dto.ChatMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubscriber {
    private final ObjectMapper objectMapper;
    private final SimpMessageSendingOperations messagingTemplate;

    public void handleMessage(String message) {
        try {
            // Redis에서 발행된 메시지를 ChatMessage 객체로 변환
            ChatMessage chatMessage = objectMapper.readValue(message, ChatMessage.class);

            // WebSocket 구독자에게 메시지 전달
            messagingTemplate.convertAndSend("/topic/chatroom/" + chatMessage.getRoomId(), chatMessage);
        } catch (Exception e) {
            log.error("Error processing message from Redis", e);
        }
    }
}
