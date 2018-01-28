package demo;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.connect.json.JsonSerializer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import demo.vo.Transaction;

public class JSONProducer {

	public static void main(String[] args) {

		Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,LongSerializer.class.getName());
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class.getName());

        Producer producer = new KafkaProducer(configProperties);
        ObjectMapper objectMapper = new ObjectMapper();
        Transaction txn = TransactionGenerator.getRandomTransaction();
        JsonNode txnJson = objectMapper.valueToTree(txn);
        
        System.out.println(txnJson);
        ProducerRecord<Long, JsonNode> message = new ProducerRecord<Long, JsonNode>("test", txn.getId(), txnJson);
        producer.send(message);            
        producer.close();
	}

}
