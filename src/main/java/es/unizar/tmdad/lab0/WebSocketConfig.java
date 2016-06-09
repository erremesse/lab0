package es.unizar.tmdad.lab0;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.ByteArrayMessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/queue"); //Enable a simple message broker and configure one or more prefixes to filter destinations targeting the broker
		config.setApplicationDestinationPrefixes("/app");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/twitter").withSockJS();
	}
	
	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
	    messageConverters.add(new StringMessageConverter());
	    messageConverters.add(new ByteArrayMessageConverter());
	    return false;
	}

}