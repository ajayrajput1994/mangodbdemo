package com.mongodb.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.mongodb.model.KafkaTopicConctants;

@Configuration
public class ConfigKafka {
	
	@Bean
	public NewTopic topic(){
		
		
	 return TopicBuilder.name(KafkaTopicConctants.LOCATION_TOPIC_NAME).build();			
	}

	
}
