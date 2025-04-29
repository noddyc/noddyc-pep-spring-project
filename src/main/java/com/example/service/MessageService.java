package com.example.service;
import com.example.entity.Message;
import java.util.List;

/**
 * Service layer for message
 */
public interface MessageService {

    /**
     * create new message
     * @param message
     * @return new message
     */
    Message createNewMessage(Message message);

    /**
     * retrieve all messages
     * @return all messages
     */
    List<Message> getAllMessages();

    /**
     * retrieve message by id
     * @param messageId
     * @return message
     */
    Message getMessageById(String messageId);

    /**
     * delete message by id
     * @param messageId
     * @return rows affected
     */
    Integer deleteMessageById(String messageId);

    /**
     * update message text by id
     * @param message
     * @param messageId
     * @return rows affected
     */
    Integer updateMessageById(Message message, String messageId);

    /**
     * get messages by posted by
     * @param accountId
     * @return messages
     */
    List<Message> getMessageByAccountId(String accountId);
}
