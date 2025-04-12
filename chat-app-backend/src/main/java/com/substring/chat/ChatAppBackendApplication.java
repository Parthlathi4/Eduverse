package com.substring.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Main entry point for the Chat Application backend.
 * This class initializes the Spring Boot application.
 */
public class ChatAppBackendApplication {
    
    /**
     * The main method that starts the Spring Boot application.
     * @param args command line arguments
     */

	public static void main(String[] args)	{
		SpringApplication.run(ChatAppBackendApplication.class, args);
	}

}
