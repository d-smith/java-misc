package demo.kafka;

import java.util.Properties;

import org.apache.kafka.clients.admin.*;

public class AdminMain {
    public static void main(String... args) throws java.lang.Exception{


        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        AdminClient client = AdminClient.create(props);
        DescribeClusterResult description = client.describeCluster();
        System.out.println(description.clusterId().get());

    }
}