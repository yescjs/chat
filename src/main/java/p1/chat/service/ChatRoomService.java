package p1.chat.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import p1.chat.entity.ChatRoom;
import p1.chat.repository.ChatRoomRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoom createRoom(String name) {
        return chatRoomRepository.save(new ChatRoom(name));
    }

    @Transactional(readOnly = true)
    public List<ChatRoom> findAll() {
        return chatRoomRepository.findAll();
    }
}
