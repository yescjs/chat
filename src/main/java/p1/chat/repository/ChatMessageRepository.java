package p1.chat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import p1.chat.entity.ChatMessageEntity;

public interface ChatMessageRepository extends JpaRepository<ChatMessageEntity, Long>{
    List<ChatMessageEntity> findByRoomIdOrderBySendAtAsc(Long roomId);
}
