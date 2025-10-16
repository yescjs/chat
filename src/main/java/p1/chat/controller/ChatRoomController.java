package p1.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import p1.chat.entity.ChatRoom;
import p1.chat.service.ChatRoomService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chatrooms")
public class ChatRoomController {
    
    @Autowired
    private final ChatRoomService chatRommService;

    @PostMapping
    public ResponseEntity<ChatRoom> createRoom(@RequestParam String name) {
        return ResponseEntity.ok(chatRommService.createRoom(name));
    }

    @GetMapping
    public ResponseEntity<List<ChatRoom>> getRooms() {
        return ResponseEntity.ok(chatRommService.findAll());
    }
}
