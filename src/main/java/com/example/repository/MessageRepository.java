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

    /**
     * find message by message id
     * @param messageId
     * @return message
     */
    Optional<Message> findByMessageId(int messageId);

    /**
     * find all messages by posted by
     * @param accountId
     * @return message
     */
    List<Message> findAllByPostedBy(int accountId);

    /**
     * delete message by id
     * @param messageId
     * @return rows affected
     */
    @Modifying
    @Query("DELETE FROM Message m WHERE m.messageId = :messageId")
    Integer deleteMessageById(@Param("messageId") int messageId);


    /**
     * update message by id
     * @param messageId
     * @param text
     * @return rows affected
     */
    @Modifying
    @Query("UPDATE Message m SET m.messageText = :text WHERE m.messageId = :messageId")
    Integer updateMessageText(@Param("messageId") int messageId, @Param("text") String text);

}
