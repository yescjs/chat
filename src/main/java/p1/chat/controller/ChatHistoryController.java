package p1.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import p1.chat.entity.ChatMessageEntity;
import p1.chat.service.ChatMessageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatHistoryController {
    private final ChatMessageService chatMessageService;

    @GetMapping("/{roomId}/messages")
    public List<ChatMessageEntity> getMessages(@PathVariable Long roomId) {
        return chatMessageService.getMessages(roomId);
    }
}
