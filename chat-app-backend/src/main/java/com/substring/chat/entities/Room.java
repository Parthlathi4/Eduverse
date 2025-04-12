package com.substring.chat.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Represents a chat room in the application.
 * Contains information about the room ID and the messages associated with the room.
 */
public class Room {
    
    /**
     * Unique identifier for the room in MongoDB.
     */
    @Id
    private String id;//Mongo db : unique identifier
    /**
     * The ID of the room.
     */
    private String roomId;
    /**
     * List of messages associated with the room.
     */
    private List<Message> messages = new ArrayList<>();


}
