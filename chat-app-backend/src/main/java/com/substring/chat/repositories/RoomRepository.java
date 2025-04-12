package com.substring.chat.repositories;


import com.substring.chat.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository interface for managing Room entities in the MongoDB database.
 * Extends MongoRepository to provide CRUD operations for Room entities.
 */
public interface RoomRepository extends MongoRepository<Room, String> {
    
    /**
     * Retrieves a Room entity by its room ID.
     * @param roomId the ID of the room to retrieve
     * @return the Room entity associated with the given room ID
     */
    //get room using room id
    Room findByRoomId(String roomId);
}
