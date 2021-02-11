package demo.kafka;

import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.*;
import java.time.Duration;
import org.apache.kafka.common.PartitionInfo;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String... args) {
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        Map<String, List<PartitionInfo> > topics = consumer.listTopics();

        for(Map.Entry<String,List<PartitionInfo>> entry: topics.entrySet()) {
            System.out.println(entry.getKey());
            List<PartitionInfo> partitionInfo = entry.getValue();
            for(PartitionInfo p: partitionInfo) {
                System.out.printf("\tpartition: %d\n", p.partition());
            }
        }

        //Get some partition info directly
        //docker-compose exec broker kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 66 --topic foobar
        System.out.println("Partition info for foobar");
        List<PartitionInfo> info = consumer.partitionsFor("foobar");
        for(PartitionInfo pi: info) {
            System.out.printf("Leader for partition %d is %s\n", pi.partition(), pi.leader().host());
        }
    }
}