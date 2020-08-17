爱因智能java微服务技术框架

#### sonar配置

```
mvn sonar:sonar \
  -Dsonar.projectKey=csg-parent \
  -Dsonar.host.url=http://192.168.20.3:9002 \
  -Dsonar.login=73aa6622d9c0ce8dcafd17c6e96fc3c03a1ae688
```

#### skywalking配置

```
-javaagent:E:\Java\apache-skywalking-apm-bin\agent\skywalking-agent.jar \
  -Dskywalking.agent.service_name=${spring.applicaiton.name} \
  -Dskywalking.collector.backend_service=192.168.20.3:11800
```