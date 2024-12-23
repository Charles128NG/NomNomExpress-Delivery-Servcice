package com.Negi.NomNomExpress.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	String TOPIC1 = "food-picked-up";
	String TOPIC2 = "food-delivered";
	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage1(Object message) {
        kafkaTemplate.send(TOPIC1, message);
        System.out.println("Message sent: " + message);
    }
    public void sendMessage2(Object message) {
        kafkaTemplate.send(TOPIC2, message);
        System.out.println("Message sent: " + message);
    }
}
