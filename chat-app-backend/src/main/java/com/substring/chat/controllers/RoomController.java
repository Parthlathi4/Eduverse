package com.substring.chat.controllers;

import com.substring.chat.entities.Message;
import com.substring.chat.entities.Room;
import com.substring.chat.repositories.RoomRepository;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:5173")
/**
 * Controller for managing chat rooms.
 * This class handles room creation, joining, and retrieving messages.
 */
public class RoomController {
    

    private RoomRepository roomRepository;


    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //create room
    @PostMapping
    /**
     * Creates a new chat room.
     * @param roomId the ID of the room to create
     * @return a ResponseEntity indicating the result of the operation
     */
    public ResponseEntity<?> createRoom(@RequestBody String roomId) {

        if (roomRepository.findByRoomId(roomId) != null) {
            //room is already there
            return ResponseEntity.badRequest().body("Room already exists!");

        }


        //create new room
        Room room = new Room();
        room.setRoomId(roomId);
        Room savedRoom = roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(room);


    }


    //get room: join
    @GetMapping("/{roomId}")
    /**
     * Joins an existing chat room.
     * @param roomId the ID of the room to join
     * @return a ResponseEntity containing the room if found, or an error message
     */
    public ResponseEntity<?> joinRoom(
            @PathVariable String roomId
    ) {

        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.badRequest()
                    .body("Room not found!!");
        }
        return ResponseEntity.ok(room);
    }


    //get messages of room

    @GetMapping("/{roomId}/messages")
    /**
     * Retrieves messages from a specific chat room.
     * Supports pagination through query parameters.
     * @param roomId the ID of the room to retrieve messages from
     * @param page the page number for pagination
     * @param size the number of messages per page
     * @return a ResponseEntity containing a list of messages
     */
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0", required = false) int page,
            @RequestParam(value = "size", defaultValue = "20", required = false) int size
    ) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room == null) {
            return ResponseEntity.badRequest().build()
                    ;
        }
        //get messages :
        //pagination
        List<Message> messages = room.getMessages();
        int start = Math.max(0, messages.size() - (page + 1) * size);
        int end = Math.min(messages.size(), start + size);
        List<Message> paginatedMessages = messages.subList(start, end);
        return ResponseEntity.ok(paginatedMessages);

    }


}
