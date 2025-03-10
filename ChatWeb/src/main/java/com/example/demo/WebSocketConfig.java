package com.example.demo;

import org.apache.logging.log4j.message.Message;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompBrokerRelayMessageHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{
   @Override
   public void registerStompEndpoints(StompEndpointRegistry registry )
   {
	  registry.addEndpoint("/ws").withSockJS();
   }
   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry)
   {
	registry.setApplicationDestinationPrefixes("/app");
	registry.enableSimpleBroker("/topic");
   }
}
