package demo;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import demo.avro.Person;
import java.util.concurrent.Future;

public class Producer {
    public static void main(String[] args) throws Exception {

        System.out.println("producer begin");
        final Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.RETRIES_CONFIG, 0);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
    
        System.out.println("create producer");
        KafkaProducer<String, Person> producer = new KafkaProducer<String, Person>(props);
        

        System.out.println("send messages");
        Person hj = new Person(000001, "Hugh", "Jass", "hj@foo.com");
        RecordMetadata x = producer.send(new ProducerRecord<String, Person>("employees", "" + hj.getId(), hj)).get();
        System.out.println(x);
        
    
        Person jp = new Person(000002, "Jim", "Pansey", "jp@bar.com");
        producer.send(new ProducerRecord<String, Person>("employees", "" + jp.getId(), jp));
        
        System.out.println("close producer");
        producer.close();

        System.out.println("done");
    }
}