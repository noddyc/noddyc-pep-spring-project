package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Message;

/**
 * DAO layer to interact with Message table
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

    Optional<Message> findByMessageId(int messageId);
    
    List<Message> findAllByPostedBy(int accountId);

    @Modifying
    @Query("DELETE FROM Message m WHERE m.messageId = :messageId")
    Integer deleteMessageById(@Param("messageId") int messageId);


    @Modifying
    @Query("UPDATE Message m SET m.messageText = :text WHERE m.messageId = :messageId")
    int updateMessageText(@Param("messageId") int messageId, @Param("text") String text);

}
