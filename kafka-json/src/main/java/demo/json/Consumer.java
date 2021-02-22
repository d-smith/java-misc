package demo.json;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import java.util.Properties;
import java.util.Arrays;

public class Consumer{
    public static void main(String[] args) {
        System.out.println("consumer live");
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaJsonDeserializer");
        props.put("schema.registry.url", "http://localhost:8081");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(io.confluent.kafka.serializers.KafkaJsonDeserializerConfig.JSON_VALUE_TYPE, User.class.getName());

        String topic = "testjsonschema";
        final KafkaConsumer<String, User> consumer = new KafkaConsumer<String, User>(props);
        consumer.subscribe(Arrays.asList(topic));

        try {
        while (true) {
            ConsumerRecords<String, User> records = consumer.poll(100);
            for (ConsumerRecord<String, User> record : records) {
            System.out.printf("offset = %d, key = %s, value = %s \n", record.offset(), record.key(), record.value());
            System.out.printf("class is %s\n", record.value().getClass().getName());
            }
        }
        } finally {
        consumer.close();
        }
    }
}