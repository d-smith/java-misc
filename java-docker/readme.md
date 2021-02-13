# java docker

Make a jar and run it:

```
mvn clean package
java -jar target/docker-packaging-demo-0.1-SNAPSHOT.jar
```

Package it as a docker container and run it:

```
mvn clean install
docker run docker-packaging-demo:0.1-SNAPSHOT
```


