
```
docker-compose exec broker kafka-topics --create --bootstrap-server localhost:9092 --topic test
```


```
docker-compose exec broker kafka-console-producer --broker-list localhost:9092 --topic test --property "parse.key=true" --property "key.separator=:"
>product: apples, quantity: 5
>product: lemons, quantity: 7
```