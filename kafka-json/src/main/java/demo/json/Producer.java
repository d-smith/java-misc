package demo.json;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class Producer {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
  "org.apache.kafka.common.serialization.StringSerializer");
props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
  "io.confluent.kafka.serializers.KafkaJsonSerializer");
props.put("schema.registry.url", "http://localhost:8081");

KafkaProducer<String, User> producer = new KafkaProducer<String, User>(props);

String topic = "testjsonschema";
String key = "testkey";
User user = new User("John", "Doe", 33);

ProducerRecord<String, User> record
      = new ProducerRecord<String, User>(topic, key, user);
producer.send(record).get();
producer.close();
    }
}