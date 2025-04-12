package com.substring.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
/**
 * Represents a message in the chat application.
 * Contains information about the sender, content, and timestamp.
 */
public class Message {

    private String sender;
    private String content;
    private LocalDateTime timeStamp;

    /**
     * Constructor for creating a new message.
     * @param sender the sender of the message
     * @param content the content of the message
     */
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timeStamp = LocalDateTime.now();
    }
}
