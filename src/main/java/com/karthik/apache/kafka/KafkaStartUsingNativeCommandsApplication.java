package com.karthik.apache.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaStartUsingNativeCommandsApplication {

	public static void main(String[] args) {
//		https://github.com/akinapellikarthik/kafka.git
		
				//zookeeper-server-start.bat ..\..\config\zookeeper.properties
				//kafka-server-start.bat ..\..\config\server.properties
				//kafka-topics.bat --create --topic third_topic --replication-factor 1 --zookeeper 127.0.0.1:2181 --partitions 3 //to create topic from command line
				
				//kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic third_topic --from-beginning //to view contents in a topic
				
				
				Map<String, Object> configs = new HashMap<>();
				configs.put("bootstrap.servers", "127.0.0.1:9092");//boot starp server ip address
				configs.put("key.serializer",StringSerializer.class);//key serializer
				configs.put("value.serializer",StringSerializer.class);//value serializer
				
				configs.put("acks", "all");//for acks
				configs.put("linger.ms", 1);//for fast push
				
				KafkaProducer<String, String> kafkaProducer = new KafkaProducer<String, String>(configs);
				
				for(int i = 0 ; i< 10;i++) {
					ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>("third_topic", "Message is:"+i);
					kafkaProducer.send(producerRecord);
				}
				
				
				kafkaProducer.close();
	}
}
