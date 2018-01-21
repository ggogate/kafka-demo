package demo;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class Application {

	public static void main(String[] args) {

		Properties configProperties = new Properties();
        configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        //configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        //configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.connect.json.JsonSerializer");
        //configProperties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        		IntegerSerializer.class.getName());
        configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                                    StringSerializer.class.getName());
        
        Producer producer = new KafkaProducer(configProperties);
        ProducerRecord<Integer, String> message = new ProducerRecord<Integer, String>("test", new Integer(1), "HelloAgain");
        for (int i = 0; i < 10; i++)
        	producer.send(message);
        producer.close();
	}
}
