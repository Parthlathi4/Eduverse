package com.substring.chat.controllers;

import com.substring.chat.entities.Message;
import com.substring.chat.entities.Room;
import com.substring.chat.playload.MessageRequest;
import com.substring.chat.repositories.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("http://localhost:5173")
/**
 * Controller for handling chat-related functionalities.
 * This class manages sending and receiving messages in chat rooms.
 */
public class ChatController {
    
    /**
     * Repository for accessing room data.
     */
    private RoomRepository roomRepository; 

    /**
     * Constructor for ChatController.
     * @param roomRepository the repository for accessing room data
     */
    public ChatController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //for sending and receiving messages
    @MessageMapping("/sendMessage/{roomId}")// /app/sendMessage/roomId
    @SendTo("/topic/room/{roomId}")//subscribe
    /**
     * Handles sending a message to a specific chat room.
     * @param roomId the ID of the room to send the message to
     * @param request the message request containing sender and content
     * @return the sent Message object
     */
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    ) {
        // Retrieve the room using the provided room ID
        Room room = roomRepository.findByRoomId(request.getRoomId());
        // Create a new message object
        Message message = new Message();
        message.setContent(request.getContent());
        message.setSender(request.getSender());
        message.setTimeStamp(LocalDateTime.now());
        // Check if the room exists
        if (room != null) {
            // Add the message to the room's message list
            room.getMessages().add(message);
            roomRepository.save(room);
        } else {
            // If the room is not found, throw an exception
            throw new RuntimeException("Room not found!!");
        }

        return message;
    }
}
