
## Admin API

```
# Get clusters
curl --silent -X GET http://localhost:8082/v3/clusters|jq
```

```
# Get a specific cluster
curl --silent -X GET http://localhost:8082/v3/clusters/K-IQtw3SQSiotRms8aVYeQ | jq
```

```
# Get broker configurations
curl --silent -X GET http://localhost:8082/v3/clusters/K-IQtw3SQSiotRms8aVYeQ/broker-configs
```

```
# Get brokers
curl --silent -X GET http://localhost:8082/v3/clusters/K-IQtw3SQSiotRms8aVYeQ/broker
``` 



Things to look at...
* Authorizers
