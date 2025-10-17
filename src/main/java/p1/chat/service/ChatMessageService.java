package p1.chat.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import p1.chat.entity.ChatMessageEntity;
import p1.chat.repository.ChatMessageRepository;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    @Transactional
    public void saveMessage(Long roomId, String sender, String message) {
        ChatMessageEntity chatMessage = ChatMessageEntity.builder()
                .roomId(roomId)
                .sender(sender)
                .message(message)
                .sendAt(LocalDateTime.now())
                .build();
        chatMessageRepository.save(chatMessage);
    }

    @Transactional(readOnly = true)
    public List<ChatMessageEntity> getMessages(Long roomId) {
        return chatMessageRepository.findByRoomIdOrderBySendAtAsc(roomId);
    }
}
