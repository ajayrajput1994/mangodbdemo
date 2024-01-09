package com.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.model.KafkaTopicConctants;

@Service
public class KafakService {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate ;
	
	public boolean updateNewTopic(String location) {
		this.kafkaTemplate.send(KafkaTopicConctants.LOCATION_TOPIC_NAME,location);
		return true;
	}
 
}
