package p1.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import p1.chat.entity.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long>{
    
}
