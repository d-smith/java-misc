
To consume

```
java -cp target/avro-0.1-SNAPSHOT.jar demo.Consumer
```

To produce:

```
java -jar target/avro-0.1-SNAPSHOT.jar
```

or 

```
java -cp target/avro-0.1-SNAPSHOT.jar demo.Producer
```

```
curl --silent -X GET http://localhost:8081/subjects/

curl --silent -X GET http://localhost:8081/subjects/employees-value/versions/latest

curl --silent -X GET http://localhost:8081/schemas/ids/1
```

More details on schema registry [here](https://docs.confluent.io/platform/current/schema-registry/schema_registry_onprem_tutorial.html#schema-registry-onprem-tutorial)